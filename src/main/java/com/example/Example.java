package com.example;

import com.microsoft.playwright.*;
import org.apache.logging.log4j.*;

public class Example {

    private static final Logger logger = LogManager.getLogger(Example.class);

    public static void main(String[] args) {

        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch();
            Page page = browser.newPage();
            page.navigate("http://playwright.dev");

            logger.debug("page.title: {}", page.title());
        }
    }
}
