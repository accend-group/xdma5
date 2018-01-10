package com.gene.screenshots.authentication;

import com.gene.screenshots.selenium.Screenshots;
import com.gene.screenshots.selenium.SeleniumHeadless;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.List;

public class Credentials {


    private String username;
    private String password;
    private String token;

    public Credentials(String username, String password, String url, WebDriver driver) {
        try {
            this.username = username;
            this.password = password;
            int endHostIndex = 0;
            // get third '/' index position
            for (int i = 0, count = 0; i < url.length() && count < 3; ++i)
                if (url.charAt(i) == '/') {
                    count++;
                    endHostIndex = i;
                }
            String host = url.substring(0, endHostIndex);
            System.out.println(host);
            String authenticationUrl = host +
                    "/libs/cq/core/content/login.html/j_security_check?_charset_=utf8&j_password=" +
                    username + "&j_username=" +
                    password + "&j_validate=true";
            HttpURLConnection connection = (HttpURLConnection) new URL(authenticationUrl).openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            List<String> cookies = connection.getHeaderFields().get("Set-Cookie");
            for (String cookie : cookies) {
                if (cookie.contains("login-token")) {
                    token = cookie.substring(11, cookie.length() - 18);
                    break;
                }
            }
            driver.get(host + "/libs/cq/core/content/login.html");
            ((JavascriptExecutor)driver).executeScript("document.cookie = arguments[0];", "login-token=" + token);

            //driver.manage().addCookie(new Cookie("login-token", token));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getToken() {
        return token;
    }

    @Override
    public String toString(){
        return token;
    }


}
