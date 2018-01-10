package com.gene.screenshots.authentication;

import com.gene.screenshots.selenium.Screenshots;
import com.gene.screenshots.selenium.SeleniumHeadless;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
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
            String authenticationUrl = host + "/libs/cq/core/content/login.html/j_security_check";

            String stringParams = String.format("_charset_=utf8&j_password=%s&j_username=%s&j_validate=true", password, username);
            byte [] params = stringParams.getBytes(StandardCharsets.UTF_8);

            HttpURLConnection connection = (HttpURLConnection) new URL(authenticationUrl).openConnection();
            connection.setDoOutput(true);
            connection.setInstanceFollowRedirects(false);
            connection.setRequestMethod("POST");
            connection.setRequestProperty( "Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestProperty( "charset", "utf-8");
            connection.setRequestProperty( "Content-Length", Integer.toString(params.length));
            connection.setUseCaches(false);

            DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream());
            outputStream.write(params);
            outputStream.close();

            List<String> cookies = connection.getHeaderFields().get("Set-Cookie");
            for (String cookie : cookies)
                if (cookie.contains("login-token=")) {
                    token = cookie.substring(12, cookie.length() - 18);
                    break;
                }

            driver.get(host + "/libs/cq/core/content/login.html");
            driver.manage().addCookie(new Cookie("login-token", token));
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

}
