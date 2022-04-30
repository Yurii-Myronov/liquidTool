package com.liquidtool.test.platform.base;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


public class BasePageObject {

    protected static WebDriver driver;
    protected static Logger log;

    public BasePageObject(WebDriver driver, Logger log) {
        this.driver = driver;
        this.log = log;

    }

    /**
     * Open page with given URL
     */
    protected void openUrl(String url) {
        driver.get(url);
    }

    /**
     * Find element using given locator
     */
    protected static WebElement find(By locator) {
        return driver.findElement(locator);
    }

    /**
     * Click on element with given locator when its visible
     */
    protected static void click(By locator) {
        waitForVisibilityOf(locator, 10);
        find(locator).click();
    }

    /**
     * Type given text into element with given locator
     */
    protected static void type(String text, By locator) {
        waitForVisibilityOf(locator, 5);
        find(locator).sendKeys(text);
    }

    /**
     * Get URL of current page from browser
     */
    public static String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    /**
     * Get current page title
     */
    public static String getCurrentPageTitle() {
        return driver.getTitle();
    }

    /**
     * Get source of current page
     */
    public static String getCurrentPageSource() {
        return driver.getPageSource();
    }

    /**
     * Wait for specific ExpectedCondition for the given amount of time in seconds
     */
    private static void waitFor(ExpectedCondition<WebElement> condition, Integer timeOutInSeconds) {
        timeOutInSeconds = timeOutInSeconds != null ? timeOutInSeconds : 30;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(condition);
    }

    /**
     * Wait for given number of seconds for element with given locator to be visible
     * on the page
     */
    protected static void waitForVisibilityOf(By locator, Integer... timeOutInSeconds) {
        int attempts = 0;
        while (attempts < 2) {
            try {
                waitFor(ExpectedConditions.visibilityOfElementLocated(locator),
                        (timeOutInSeconds.length > 0 ? timeOutInSeconds[0] : null));
                break;
            } catch (StaleElementReferenceException e) {
            }
            attempts++;
        }
    }

    public static void switchToWindowWithTitle(String expectedTitle) {
        //Switch to new window
        String firstWindow = driver.getWindowHandle();

        Set<String> allWindows = driver.getWindowHandles();
        Iterator<String> windowIterator = allWindows.iterator();

        while (windowIterator.hasNext()) {
            String windowHandle = windowIterator.next().toString();
            if (!windowHandle.equals(firstWindow)) {
                driver.switchTo().window(windowHandle);
                if (getCurrentPageTitle().equals(expectedTitle)) {
                    break;
                }
            }
        }
    }

    /** Find all elements using given locator */
    protected static List<WebElement> findAll(By locator) {
        return driver.findElements(locator);

    }
}