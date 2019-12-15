package com.qa.pom.base;

import com.qa.pom.pages.Home;
import com.qa.pom.utils.YamlParser;
import org.junit.Rule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;

public class BaseTest {

    private WebDriver driver;
    private WebDriverWait wait;

    // Logger

    private Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    // Rule
    @Rule
    public RunTestRules runTestRules = new RunTestRules(this);



    /** Constructor */
    public BaseTest() {
        // If you want to disable infobars please use this code
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption(
                "excludeSwitches", Collections.singletonList("enable-automation"));
        options.setExperimentalOption("useAutomationExtension", false);

        // Initialize path to ChromeDriver
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        // Initialize instance of ChromeDriver and add options
        driver = new ChromeDriver(options);

        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, 10);
    }

    /**
     * Open site and get instance of HomePage
     *
     * @return the instance of HomePage
     */
    protected Home openSite() {
        try {
            driver.get(YamlParser.getYamlData().getUrl());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Home(this);
    }

    /** Close site and make driver quit */
    protected void closeSite() {
        driver.quit();
    }

    /**
     * Get instance of driver
     *
     * @return driver
     */
    public WebDriver getDriver() {
        return driver;
    }

    /**
     * Wait till element is visible
     *
     * @param element element which test is waiting to appear on the page
     */
    public void waitTillElementIsVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    /**

     * Write down info message

     *

     * @param message

     */

    public void log(String message) {

        logger.info(message);

    }



    /**

     * Write down error message

     *

     * @param error

     */

    public void error(String error) {

        logger.error(error);

    }



    /**

     * Get date and time

     *

     * @return

     */

    public String getDateTime() {

        return new SimpleDateFormat("YYYY-MM-dd_HH-mm-ss").format(Calendar.getInstance().getTime());

    }

}
