package com.example;

import com.microsoft.playwright.*;
import java.nio.file.Paths;
import org.apache.logging.log4j.*;

public class GoogleSearch {

    private static final Logger logger = LogManager.getLogger(GoogleSearch.class);

    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch();
            // Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
            BrowserContext context = browser.newContext();

            Page page = context.newPage();

            page.navigate("https://www.google.com/?gws_rd=ssl");

            page.locator("[aria-label=\"ค้นหา\"]").click();
            page.locator("[aria-label=\"ค้นหา\"]").fill("playwright");
            page.waitForNavigation(() -> {
                page.locator("[aria-label=\"ค้นหา\"]").press("Enter");
            });

            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("target/screennsot/google.png")));
            // assertThat(page).hasURL("https://www.google.com/search?q=playwright");

            logger.debug("Google Search !!!");
        }
    }
}
