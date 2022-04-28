package com.example;

import com.microsoft.playwright.*;
import java.nio.file.Paths;
import org.apache.logging.log4j.*;

public class WebKitScreenshot {

    private static final Logger logger = LogManager.getLogger(WebKitScreenshot.class);

    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            // Browser browser = playwright.webkit().launch();

            Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
            Page page = browser.newPage();
            page.navigate("http://whatsmyuseragent.org/");
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("target/screennsot/example.png")));
            
            logger.debug("Cheese !!!");
        }
    }
}
