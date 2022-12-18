package com.testinium.methods;

import com.testinium.driver.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Method {

    WebDriver driver;
    FluentWait<WebDriver> wait;
    Logger logger = LogManager.getLogger(Method.class);


    public Method() {
        driver = BaseTest.driver;
        wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofMillis(300)).ignoring(NoSuchElementException.class);

    }

    public WebElement findElement(By by) {

        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void click(By by) {
        findElement(by).click();
    }

    public void waitBySeconds(long seconds) {

        try {
            Thread.sleep(seconds * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void sendKeys(By by, String text) {
        findElement(by).sendKeys(text);
    }

    public boolean isElementVisible(By by) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            logger.info("Login Control: TRUE");
            return true;
        } catch (Exception e) {
            logger.info("FALSE" + e.getMessage());
            return false;
        }
    }

    public void scrollWithAction(By by) {
        Actions action = new Actions(driver);
        action.moveToElement(findElement(by)).build().perform();
    }


    public Select getSelect(By by) {
        return new Select(findElement(by));
    }


    public String getText(By by) {
        return findElement(by).getText();
    }


    public void hoverToElement(By by) {
        Actions action = new Actions(driver);
        action.moveToElement(findElement(by)).perform();
    }
}
