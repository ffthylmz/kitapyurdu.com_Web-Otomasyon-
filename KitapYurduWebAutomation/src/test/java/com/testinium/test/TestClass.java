package com.testinium.test;

import com.testinium.driver.BaseTest;
import com.testinium.pages.LoginPage;
import com.testinium.pages.PointsCatalogPage;
import com.testinium.pages.ProductPage;
import org.junit.jupiter.api.*;

@TestClassOrder(ClassOrderer.OrderAnnotation.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)


@Order(1)
public class TestClass extends BaseTest {

    LoginPage loginPage;
    ProductPage productPage;
    PointsCatalogPage pointsCatalogPage;


    @Test
    @Order(1)
    public void loginTest() {
        loginPage = new LoginPage();
        loginPage.login();
    }

    @Test
    @Order(2)
    public void loginCheckTest() {
        loginPage = new LoginPage();
        loginPage.loginControl();
    }


    @Test
    @Order(3)
    public void searchProductTest() {
        productPage = new ProductPage();
        productPage.searchProduct();
    }

    @Test
    @Order(4)
    public void scrollAndAddProduct() {
        productPage = new ProductPage();
        productPage.scrollToSeventhProduct();
    }

    @Test
    @Order(5)
    public void checkFavoriteListTest() {
        productPage = new ProductPage();
        productPage.checkFavoriteList();
    }

    @Test
    @Order(6)
    public void goToMainPage() {
        productPage = new ProductPage();
        productPage.goBackToMainPage();
    }

    @Test
    @Order(7)
    public void goToCatalogOfPoints() {
        pointsCatalogPage = new PointsCatalogPage();
        pointsCatalogPage.goToCatalogOfPoints();
    }

    @Test
    @Order(8)
    public void selectTheWorldClassics() {
        pointsCatalogPage = new PointsCatalogPage();
        pointsCatalogPage.selectToWorldClassics();
    }

    @Test
    @Order(9)
    public void filterTest() {
        pointsCatalogPage = new PointsCatalogPage();
        pointsCatalogPage.filter();
    }

    @Test
    @Order(10)
    public void clickToHobbyTest() {
        pointsCatalogPage = new PointsCatalogPage();
        pointsCatalogPage.clickTypeOfHobby();
    }

    @Test
    @Order(11)
    public void AddToCartRandomProduct() {
        pointsCatalogPage = new PointsCatalogPage();
        pointsCatalogPage.selectRandomProduct();
    }

    @Test
    @Order(12)
    public void goToMyFavoritesTest() {
        pointsCatalogPage = new PointsCatalogPage();
        pointsCatalogPage.goToMyFavorites();
    }

    @Test
    @Order(13)
    public void removeTheBookTest() {
        pointsCatalogPage = new PointsCatalogPage();
        pointsCatalogPage.removeTheProductInMyFavorites();
    }

    @Test
    @Order(14)
    public void goToCart() {
        pointsCatalogPage = new PointsCatalogPage();
        pointsCatalogPage.goToCart();
    }

    @Test
    @Order(15)
    public void addBookQuantity() {
        pointsCatalogPage = new PointsCatalogPage();
        pointsCatalogPage.moreBookQuantity();
    }

    @Test
    @Order(16)
    public void fillTheInformation() {
        pointsCatalogPage = new PointsCatalogPage();
        pointsCatalogPage.fillTheAddress();
    }

    @Test
    @Order(17)
    public void checkMessage() {
        pointsCatalogPage = new PointsCatalogPage();
        pointsCatalogPage.errorMessageControl();
    }

    @Test
    @Order(18)
    public void logOutTest(){
        pointsCatalogPage = new PointsCatalogPage();
        pointsCatalogPage.logOut();
    }

}
