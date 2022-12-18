package com.testinium.pages;

import com.testinium.methods.Method;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class ProductPage {

    Method method;

    Logger logger = LogManager.getLogger(ProductPage.class);

    public ProductPage() {
        method = new Method();
    }

    public void searchProduct() {
        method.sendKeys(By.xpath("//input[@id='search-input']"), "Oyuncak");
        method.click(By.cssSelector(".common-sprite.button-search"));
        method.waitBySeconds(2);
    }

    public void scrollToSeventhProduct() {
        method.scrollWithAction(By.cssSelector(".product-list>.product-cr:nth-child(7)"));
        method.waitBySeconds(1);

        for (int i = 2; i <= 5; i++) {
            method.click(By.cssSelector(".product-list>.product-cr:nth-child(" + i + ")>.grid_2.alpha.omega.relative>.hover-menu>.add-to-favorites"));
            method.waitBySeconds(1);
        }

    }

    public void checkFavoriteList() {
        method.click(By.cssSelector(".menu.top.login>ul>li>.common-sprite"));
        method.waitBySeconds(1);
        method.click(By.cssSelector(".highlight-links-wr>:nth-child(5)>span"));
        method.waitBySeconds(2);

        Assertions.assertEquals("4", method.getText(By.cssSelector(".favorite-tag.active>span")), "Seçilen Ürünler Favori Listesine Eklenmemiş!");
        method.waitBySeconds(2);

        logger.info("Favori Listesi Kontrolü: TRUE");
    }

    public void goBackToMainPage() {
        method.click(By.cssSelector(".logo-text"));
        method.waitBySeconds(2);
    }


}
