package com.gene.screenshots.authentication;




import javax.net.ssl.HttpsURLConnection;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

import com.amazonaws.services.dynamodbv2.xspec.S;
import org.apache.commons.lang3.StringUtils;

public class AuthorCredentials {

    private String username;
    private String password;
    private String token = null;
    private String authorHost;

    public AuthorCredentials(String username, String password, String url) throws AuthorAuthenticationException {
        this.username = username;
        this.password = password;
        authorHost = striptUrl(url);
        String protocol = url.substring(0, url.indexOf('/') - 1);
        String authenticationUrl = authorHost + "/libs/cq/core/content/login.html/j_security_check";
        String stringParams = String.format("_charset_=utf8&j_password=%s&j_username=%s&j_validate=true", password, username);
        byte[] params = stringParams.getBytes(StandardCharsets.UTF_8);
        HttpURLConnection connection = null;
        try {
            if(protocol.equals("http"))
                connection = (HttpURLConnection) new URL(authenticationUrl).openConnection();
            else
                connection = (HttpsURLConnection) new URL(authenticationUrl).openConnection();
            connection.setDoOutput(true);
            connection.setInstanceFollowRedirects(false);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestProperty("charset", "utf-8");
            connection.setRequestProperty("Content-Length", Integer.toString(params.length));
            connection.setUseCaches(false);
            DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream());
            outputStream.write(params);
            outputStream.close();
        } catch (IOException e) {
            throw new AuthorAuthenticationException("author authentication failed, connection failed");
        }

        try {
            String cookie = connection.getHeaderField("Set-Cookie");
            String[] split = cookie.split(";");
            for (int i = 0; i < split.length; ++i) {
                if (split[i].contains("login-token=")) {
                    token = cookie.substring(12, split[i].length());
                    break;
                }
            }
        } catch (NullPointerException e) {
            throw new AuthorAuthenticationException("author authentication failed, check username/password");
        }

        if (token == null || token.equals(""))
            throw new AuthorAuthenticationException("author authentication failed, no token found");
    }

    private String striptUrl(String url){
        if(StringUtils.countMatches(url, "/") < 3)
            return url;
        return url.substring(0, StringUtils.ordinalIndexOf(url, "/", 3));
    }

    public String getHost(){
        return authorHost;
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
