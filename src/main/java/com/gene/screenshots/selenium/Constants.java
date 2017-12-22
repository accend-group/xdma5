package com.gene.screenshots.selenium;

public interface Constants {

    // viewport size of desktop browser
    int DESKTOP_WIDTH = 1200;
    int DESKTOP_HEIGHT = 680;

    // viewport size of mobile browser
    int MOBILE_WIDTH = 320;
    int MOBILE_HEIGHT = 720;

    // viewport height limitation in chrome
    // https://groups.google.com/a/chromium.org/forum/#!msg/headless-dev/DqaAEXyzvR0/P9zmTLMvDQAJ
    int CHROME_HEIGHT_CAP = 16384;
}
