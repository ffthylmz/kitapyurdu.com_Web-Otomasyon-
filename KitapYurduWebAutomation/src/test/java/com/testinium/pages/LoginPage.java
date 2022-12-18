package com.testinium.pages;

import com.testinium.methods.Method;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;

public class LoginPage {
    Method method;
    Logger logger = LogManager.getLogger(LoginPage.class);

    public LoginPage() {
        method = new Method();
    }

    public void login() {
        method.click(By.cssSelector(".menu-top-button.login>a"));
        method.waitBySeconds(1);

        method.sendKeys(By.cssSelector("#login-email"), "fffthylmz@gmail.com");
        method.sendKeys(By.xpath("//input[@id='login-password']"), "Fatih123.");
        method.waitBySeconds(1);

        method.click(By.cssSelector(".ky-btn.ky-btn-orange.w-100.ky-login-btn"));
        method.waitBySeconds(3);

        logger.info("Giriş Başarılı!");
    }

    public void loginControl() {
        Assert.assertTrue(method.isElementVisible(By.cssSelector(".common-sprite>b")));
    }


}
