package com.pages;

import com.config.ChromeBrowser;
import org.openqa.selenium.WebDriver;

public class Page {

    private static WebDriver driver;

    static WebDriver getBrowser() throws Throwable {
        if(driver == null) {
            driver = ChromeBrowser.buildChromeBrowser();
        }
        return driver;
    }

    public static void clearAllCookies() {
        driver.manage().deleteAllCookies();
    }
}
