package com.testinium.pages;

import com.testinium.methods.Method;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import java.util.Random;

public class PointsCatalogPage {

    Method method;
    Random rnd = new Random();
    Integer random = rnd.nextInt(8);

    Logger logger = LogManager.getLogger(ProductPage.class);

    public PointsCatalogPage() {
        method = new Method();
    }

    public void goToCatalogOfPoints() {
        method.click(By.cssSelector(".lvl1catalog>.common-sprite"));
        method.waitBySeconds(2);
    }

    public void selectToWorldClassics() {
        method.click(By.xpath("//img[@title='Puan Kataloğundaki Türk Klasikleri']"));
        method.waitBySeconds(2);
    }

    public void filter() {
        method.click(By.cssSelector(".sort>select>option:nth-child(10)"));
        method.waitBySeconds(2);
    }

    public void clickTypeOfHobby() {
        method.hoverToElement(By.xpath("(//li[@class='has-open-menu'])[3]"));
        method.waitBySeconds(1);
        method.click(By.cssSelector(".open-menu-ct.bookAllCategories>.subCategories>:nth-child(3)>:nth-child(14)>.mn-icon.icon-angleRight"));
        method.waitBySeconds(2);
    }

    public void selectRandomProduct() {
        method.hoverToElement(By.cssSelector(".product-grid.jcarousel-skin-opencart>:nth-child(" + random + ")"));
        method.waitBySeconds(1);
        method.click(By.cssSelector(".product-grid.jcarousel-skin-opencart>:nth-child(" + random + ")>.product-cr>.hover-menu>.add-to-cart>.fa.fa-shopping-cart"));
        method.waitBySeconds(1);

        logger.info("Random Ürün Sepete Ekleme: TRUE");

    }

    public void goToMyFavorites() {
        method.hoverToElement(By.cssSelector(".menu.top.my-list"));
        method.click(By.xpath("//a[@href='https://www.kitapyurdu.com/index.php?route=account/favorite&selected_tags=0']"));
        method.click(By.cssSelector(".display-item.sprite.sprite-icon-list-selected"));
        method.waitBySeconds(2);
    }

    public void removeTheProductInMyFavorites() {
        method.click(By.cssSelector(".product-list>:nth-child(3)>.grid_2.alpha.omega.relative>.hover-menu>:nth-child(3)"));
        method.waitBySeconds(1);
    }

    public void goToCart() {
        method.click(By.cssSelector("#cart-items"));
        method.click(By.cssSelector("#js-cart"));
        method.waitBySeconds(3);
    }

    public void moreBookQuantity() {
        //method.findElement(By.xpath("//input[@name='quantity'])")).clear();
        method.sendKeys(By.xpath("//input[@name='quantity']"), "");
        method.click(By.cssSelector(".fa.fa-refresh.green-icon"));
        method.waitBySeconds(3);
        method.click(By.xpath("//input[@class='cart-select']"));
        method.click(By.xpath("(//a[@class='button red'])[1]"));
    }

    public void fillTheAddress() {
        method.click(By.xpath("//a[@class='button']"));

        method.sendKeys(By.xpath("//input[@name='firstname_companyname']"), "Fatih");
        method.sendKeys(By.xpath("//input[@name='lastname_title']"), "YILMAZ");
        method.click(By.cssSelector("#address-zone-id>:nth-child(41)"));
        method.click(By.cssSelector("#address-county-id>:nth-child(4)"));
        method.sendKeys(By.xpath("//input[@id='district']"), "Merkez");
        method.sendKeys(By.xpath("//textarea[@id='address-address-text']"), "Atasehir/Istanbul");
        method.sendKeys(By.xpath("//input[@id='address-postcode']"), "34000");
        //method.sendKeys(By.xpath("//input[@id='address-mobile-telephone']"), "5555555555");
        method.waitBySeconds(3);
        method.click(By.xpath("//input[@class='button']"));

        method.click(By.xpath("//button[@id='button-checkout-continue']"));
        method.waitBySeconds(1);
        method.click(By.xpath("//button[@id='button-checkout-continue']"));
        method.waitBySeconds(1);

        method.sendKeys(By.xpath("//input[@id='credit-card-owner']"), "Fatih YILMAZ");

        method.sendKeys(By.xpath("//input[@id='credit_card_number_1']"), "1111");
        method.sendKeys(By.xpath("//input[@id='credit_card_number_2']"), "2222");
        method.sendKeys(By.xpath("//input[@id='credit_card_number_3']"), "3333");
        method.sendKeys(By.xpath("//input[@id='credit_card_number_4']"), "4444");

        method.click(By.cssSelector("#credit-card-expire-date-month>:nth-child(3)"));
        method.click(By.cssSelector("#credit-card-expire-date-year>:nth-child(3)"));

        method.sendKeys(By.xpath("//input[@id='credit-card-security-code']"), "123");
        method.waitBySeconds(2);
        method.click(By.xpath("//button[@id='button-checkout-continue']"));
        method.waitBySeconds(2);
        method.click(By.xpath("//input[@type='checkbox']"));
        method.waitBySeconds(2);
        method.click(By.xpath("//input[@class='button']"));

    }

    public void errorMessageControl() {
        Assertions.assertEquals("Kart bilgileriniz doğrulanamadı, lütfen tekrar deneyiniz.", method.getText(By.xpath("//div[@class='warning']")), "Hata Mesajı Yanlış!");
        logger.info("Error Message Control: TRUE");

        method.click(By.xpath("//a[@class='checkout-logo']"));

    }

    public void logOut() {
        method.hoverToElement(By.cssSelector(".menu.top.login"));
        method.click(By.xpath("//a[@href='https://www.kitapyurdu.com/index.php?route=account/logout']"));

        Assertions.assertEquals("Giriş Yap", method.getText(By.cssSelector(".menu-top-button.login>a")), "Çıkış İşlemi Başarısız!");
        logger.info("Logout Control: TRUE");
    }
}
