package com.gene.screenshots.selenium.accesssolutions;

import com.gene.screenshots.selenium.ChromeDriverManager;
import com.gene.screenshots.selenium.SeleniumHeadless;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

import static com.gene.screenshots.selenium.Constants.*;

// custom functionality to get links and automate GATCF, fade in divs, and assistance tool for Access Solution brands
// removed all thread sleep calls and use WebDriverWait to determine when items are loaded.
// provides default mobile and desktop automation functions
public class AccessSolutionsBase extends SeleniumHeadless {

    // keep track of pages that have their own tabs, not to override other tab screenshots from other pages
    private int []desktopNumOfPagesWithTabs = null;
    private int []mobileNumOfPagesWithTabs = null;

    public AccessSolutionsBase(){ brandName = getPdfName().toLowerCase(); }

    public AccessSolutionsBase(String pdfName){
        this.brandName = pdfName.toLowerCase();
        setPdfName(pdfName);
    }

    private String brandName;

    // custom AccessSolutionBase classes can use the name of the class itself for the pdf name
    protected String getBrandName() {
        return brandName;
    }

    @Override
    public String getSiteMapUrl() {
        return "/patient/brands/" + getBrandName() + "/site-map.html";
    }

    @Override
    protected List<String> getLinksFromSiteMap(WebDriver driver) {
        List<String> links = new ArrayList<String>();
        goToUrl(driver, getSiteMapUrl());
        List<WebElement> linkElements = driver.findElements(By.cssSelector(getSiteMapSelector()));
        for (WebElement element : linkElements)
            links.add(element.findElement(By.tagName("a")).getAttribute("href").replaceAll(domain.toString(), ""));
        links.add("/patient/brands/" + getBrandName() + ".html");
        links.add(getSiteMapUrl());
        links.add("/patient/brands/" + getBrandName() + "/patient-assistance-tool-page.html");
        links.add("/patient/brands/" + getBrandName() + "/search.html");
        return links;
    }


    @Override
    public String getSiteMapSelector() {
        return ".link";
    }

    @Override
    public List<Thread> createScreenCaptureThreads(String savePath, boolean isDesktop){
        List<Thread> threads = new ArrayList<>();
        List<String> links = new ArrayList<>();

        WebDriver driver = ChromeDriverManager.requestDriver(isDesktop);
        try {
            links = getLinksFromSiteMap(driver);
            if(isDesktop)
                desktopNumOfPagesWithTabs = new int[links.size()];
            else
                mobileNumOfPagesWithTabs = new int[links.size()];
        } catch (Exception e) {
            e.printStackTrace();
        }
        ChromeDriverManager.releaseDriver(driver, isDesktop);

        int pageNumber = 1;

        // create a thread per link
        for (String currentPage : links) {
            final int threadPageNumber = pageNumber++;
            threads.add(new Thread(() -> {

                // current thread has its own chrome driver
                WebDriver threadDriver =  ChromeDriverManager.requestDriver(isDesktop);
                try {
                    goToUrl(threadDriver, currentPage);
                    full(threadDriver, isDesktop, savePath, String.valueOf(threadPageNumber));
                    getGATCFscreenshots(threadDriver, isDesktop, savePath, threadPageNumber);
                    getThreeStepDialogs(threadDriver, isDesktop, savePath, threadPageNumber);
                    getFormsDocInfo(threadDriver, isDesktop, savePath, threadPageNumber);
                    getScreenshotForAccordion(threadDriver, isDesktop, savePath, threadPageNumber);
                    getScreenshotForPAT(threadDriver, savePath, new Actions(threadDriver), isDesktop, threadPageNumber);
                } catch (Exception e) {
                    System.out.println("Issue at " + threadDriver.getCurrentUrl() + " for " + (isDesktop ? "desktop" : "mobile"));
                    e.printStackTrace();
                }
                ChromeDriverManager.releaseDriver(threadDriver, isDesktop);
            }));
        }

        return threads;
    }


    protected void getScreenshotForAccordion(WebDriver driver, boolean isDesktop, String savePath, int pageVisitNumber) {
        List<WebElement> tabs = driver.findElements(By.cssSelector(".gene-component--accordionTabs__item:not(.is-open) .gene-component--accordionTabs__header, .panel-heading"));
        if (tabs.size() > 0) {
            for (int i = 0; i < tabs.size(); i++) {
                forceClick(driver, tabs.get(i));
                // wait for class .in to exist in DOM
                waitForElementVisible(driver, ".in");
                // waitForElementVisible(driver, driver.findElement(By.cssSelector(".in")));
                // accordion animation
                try {
                    Thread.sleep(450);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String screenshotName = String.format("%d_%s%d-tab%d", pageVisitNumber, getBrandName(), isDesktop ? desktopNumOfPagesWithTabs[pageVisitNumber - 1] : mobileNumOfPagesWithTabs[pageVisitNumber - 1], i + 1);
                full(driver, isDesktop, savePath, screenshotName);
                forceClick(driver, tabs.get(i));
            }
            if (isDesktop)
                desktopNumOfPagesWithTabs[pageVisitNumber - 1]++;
            else
                mobileNumOfPagesWithTabs[pageVisitNumber - 1]++;
        }
    }


    public void getGATCFscreenshots(WebDriver driver, boolean ifDesktop, String savePath, int pageVisitNumber) {
        String url = driver.getCurrentUrl();
        if (!url.contains("how-we-help-you.html"))
            return;
        List<WebElement> container = driver.findElements(By.cssSelector(".assistance-tool"));// .assistance-tool-v2"));
        if(container.size() == 0)
            return;
        List<Object> contents = getChildrenElements(driver, container.get(0));

        // get every possible result and screenshot button mouse hover?
        /*List<WebElement> qualifyOutcomes = driver.findElements(By.cssSelector("button[data-action='result_noteligible']"));
        List<WebElement> notEligibleOutcomes = driver.findElements(By.cssSelector("button[data-action='result_qualify']"));*/

        WebElement gatcf1 = null;
        WebElement gatcf2 = null;
        WebElement main = null;
        for (Object element : contents) {
            if (element instanceof WebElement) {
                WebElement content = (WebElement) element;
                if (content.getAttribute("class").equals("main"))
                    main = content;
                if (content.getAttribute("class").equals("result result_qualify"))
                    gatcf1 = content;
                if (content.getAttribute("class").equals("result result_noteligible"))
                    gatcf2 = content;
            }
        }
        setStyle(driver, "display: none;", main);

        WebElement startOver = driver.findElement(By.className("start-over"));
        WebElement updateResponse = driver.findElement(By.className("update-response"));


        setStyle(driver, "display: block;", startOver);
        setStyle(driver, "display: block;", updateResponse);

        setStyle(driver, "display: block;", gatcf1);
        full(driver, ifDesktop, savePath, pageVisitNumber+ "-GATCF-1");
        setStyle(driver, "display: none;", gatcf1);

        setStyle(driver, "display: block;", gatcf2);
        full(driver, ifDesktop, savePath, pageVisitNumber+ "-GATCF-2");
        setStyle(driver, "display: none;", gatcf2);

        forceClick(driver, startOver);
        setStyle(driver, "display: block;", main);

    }


    // fade in divs from popover links
    protected void getScreenshotsFromFadeInDiv(WebDriver driver, boolean ifDesktop, String savePath, String cssString, String imageName) {

        int currentLink = 1;
        List<WebElement> links = driver.findElements(By.cssSelector(cssString));
        if (links.size() == 0)
            return;
        int height = ifDesktop ? DESKTOP_HEIGHT : MOBILE_HEIGHT;
        int width = ifDesktop ? DESKTOP_WIDTH : MOBILE_WIDTH;
        driver.manage().window().setSize(new Dimension(width, getDocHeight(driver)));
        for (WebElement link : links) {
            if (!link.isDisplayed()) // on mobile some links are not visible?
                continue;

            Actions builder = new Actions(driver);
            builder.moveToElement(link, 5, 5).click().build().perform();

            waitForElementVisible(driver, ".popover");

            // wait for fade in animation
            try {
                Thread.sleep(450);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            visible(driver, ifDesktop, savePath, String.format("%s-%d", imageName, currentLink++));
        }
        driver.manage().window().setSize(new Dimension(width, height));
    }

    // issue? forceClick not working with link web element!
    public void getThreeStepDialogs(WebDriver driver, boolean ifDesktop, String savePath, int pageVisitNumber) {
        getScreenshotsFromFadeInDiv(driver, ifDesktop, savePath, "a[data-toggle][data-html]", pageVisitNumber+"_step");
    }


    // fade in divs from 3 links, e submit link and 2 more info links
    // a[data-toggle][role=button] - old css selector,
    public void getFormsDocInfo(WebDriver driver, boolean ifDesktop, String savePath, int pageVisitNumber) {
        if(driver.getCurrentUrl().contains("forms-and-documents.html"))
            getScreenshotsFromFadeInDiv(driver, ifDesktop, savePath, ".e-submit-popover, .more-info", pageVisitNumber+"_form-and-doc-fade-popover");
    }


    protected void getScreenshotForPAT(WebDriver driver, String savePath, Actions action, boolean isDesktop, int pageVisitNumber) {
        if (driver.findElements(By.cssSelector(".patient-assistance-tool-page")).size() == 0)
            return;

        List<WebElement> questions = driver.findElements(By.cssSelector(".questions li"));
        if (isDesktop) {

            for (int i = 2; i < questions.size(); i += 2) {
                action.moveToElement(questions.get(i == questions.size() - 1 ? i : i + 1)).build().perform();
                waitForElementVisible(driver, questions.get(i == questions.size() - 1 ? i : i + 1));
                full(driver, isDesktop, savePath, pageVisitNumber+"-pat0-part" + Integer.toString(i));
            }
        }

        setStyle(driver, "display: none;", ".assistance-tool .main");
        setStyle(driver, "display: inline-block;", ".footer .start-over");
        setStyle(driver, "display: inline-block;", ".footer .update-response");
        List<WebElement> results = driver.findElements(By.cssSelector(".assistance-tool .result"));
        for (int i = 0; i < results.size(); i++) {
            setStyle(driver, "display: block;", results.get(i));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            full(driver, isDesktop, savePath, pageVisitNumber + "_pat" + Integer.toString(i + 1) + "-part1");
            if (isDesktop) {
                action.moveToElement(driver.findElement(By.cssSelector(".result[style='display: block;'] p:last-child"))).build().perform();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                full(driver, isDesktop, savePath, pageVisitNumber + "_pat" + Integer.toString(i + 1) + "-part2");
            }
            setStyle(driver, "display: none;", results.get(i));
        }

        setStyle(driver, "display: block;", ".assistance-tool .main");
        setStyle(driver, "display: none;", ".footer .start-over");
        setStyle(driver, "display: none;", ".footer .update-response");
        for (int j = 0; j < questions.size(); j++) {
            WebElement question = questions.get(j);
            String clazzName = question.getAttribute("class");
            clazzName = clazzName.replaceAll("(active|disabled)", "active");
            setClass(driver, clazzName, question);
            action.moveToElement(questions.get(j == questions.size() - 1 ? j : j + 1)).build().perform();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // capture divs by resizing and waiting for the div to exist
            List<WebElement> moreInfo = question.findElements(By.cssSelector(".more-info"));
            if (moreInfo.size() > 0) {
                int height = isDesktop ? DESKTOP_HEIGHT : MOBILE_HEIGHT;
                int width = isDesktop ? DESKTOP_WIDTH : MOBILE_WIDTH;
                driver.manage().window().setSize(new Dimension(width, getDocHeight(driver)));

                Actions builder = new Actions(driver);
                builder.moveToElement(moreInfo.get(0), 5, 5).click().build().perform();
                waitForElementVisible(driver, ".popover");
                // fade in animation
                try {
                    Thread.sleep(450);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                visible(driver, isDesktop, savePath,  pageVisitNumber+"_pat-q" + Integer.toString(j + 1));
                driver.manage().window().setSize(new Dimension(width, height));
            }

            List<WebElement> options = driver.findElements(By.cssSelector(".assistance-tool .active:not(.disabled) button[data-action^='question_']"));
            if (options.size() > 0) {
                String buttonClazzName = options.get(0).getAttribute("class");
                setClass(driver, buttonClazzName + " active", options.get(0));
            }
            clazzName = question.getAttribute("class");
            clazzName = clazzName.replaceAll("(active)", "disabled");
            ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('class', '" + clazzName + "')", question);
            if (j == 0) {
                setStyle(driver , "display: inline-block;", ".footer .start-over");
                setStyle(driver,  "display: inline-block;", ".footer .update-response");
            }
        }
        driver.navigate().refresh();
    }

}