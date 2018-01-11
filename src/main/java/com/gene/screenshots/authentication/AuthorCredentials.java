package com.gene.screenshots.authentication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

public class AuthorCredentials {

    private String username;
    private String password;
    private String token = null;
    private String authorHost;
    private List<Cookie> cookies;

    public AuthorCredentials(String username, String password, String url) throws AuthorAuthenticationException {
        this.username = username;
        this.password = password;
        authorHost = striptUrl(url);
        String authenticationUrl = authorHost + "/libs/cq/core/content/login.html/j_security_check";
        try {
            BasicCookieStore cookieStore = new BasicCookieStore();
            CloseableHttpClient client = HttpClients.custom()
                .setDefaultCookieStore(cookieStore)
                .build();
            HttpPost httpPost = new HttpPost(authenticationUrl);

            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("j_username", username));
            params.add(new BasicNameValuePair("j_password", password));

            httpPost.setEntity(new UrlEncodedFormEntity(params));

            client.execute(httpPost);

            this.cookies = cookieStore.getCookies();
            client.close();
        } catch (IOException e) {
            throw new AuthorAuthenticationException("author authentication failed, connection failed");
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
    
    public List<Cookie> getCookies() {
        return this.cookies;
    }

}
