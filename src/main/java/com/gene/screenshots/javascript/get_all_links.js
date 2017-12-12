// gets all links related to the perjeta site that point to a html page
var currentPageURL = window.location.href;
var links = new Set();
var aTags = document.getElementsByTagName("a");
for (var i = 0; i < aTags.length; ++i) {
    var url = aTags[i].href;
    if (url[0] == '/')
        url = curentPageURL + url;
    if (url.includes("www.perjeta.com") && !url.includes("#"))
        links.add(aTags[i].href);
}

// Selenium JavascriptExecutor runs the code in an anonymous function, returned array is used in Java
return Array.from(links);