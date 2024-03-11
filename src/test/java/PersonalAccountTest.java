import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.Header;
import pages.LoginPage;
import pages.MainPage;
import pages.PersonalAccountPage;
import pojo.User;

import static org.junit.Assert.assertEquals;

public class PersonalAccountTest extends Base {

    private User user;

    @Test
    @DisplayName("Проверка перехода в личный кабинет по клику на кнопку 'Личный кабинет' на главной странице")
    public void goToPersonalAccountTest() {
        try {
            user = generateRandomUser();
            registerUser(user);

            MainPage mainPage = new MainPage(driver);
            mainPage.waitForLoadMainPage();

            Header header = new Header(driver);
            header.clickPersonalAccountLink();

            LoginPage loginPage = new LoginPage(driver);
            loginPage.waitForLoadLoginPage();

            loginPage.fillEmailField(user.getEmail());
            loginPage.fillPasswordField(user.getPassword());
            loginPage.clickLoginButton();

            mainPage.waitForLoadMainPage();

            header.clickPersonalAccountLink();

            PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
            personalAccountPage.waitForLoadPersonalAccountPage();

            String expectedUrl = "https://stellarburgers.nomoreparties.site/account/profile";
            String actualUrl = driver.getCurrentUrl();

            assertEquals(expectedUrl, actualUrl);
        } finally {
            deleteUser(user);
        }
    }

    @Test
    @DisplayName("Проверка перехода в конструктор по клику на ссылку 'Конструктор' из личного кабинета")
    public void goToConstructorOnConstructorLinkTest() {
        try {
            user = generateRandomUser();
            registerUser(user);

            MainPage mainPage = new MainPage(driver);
            mainPage.waitForLoadMainPage();

            Header header = new Header(driver);
            header.clickPersonalAccountLink();

            LoginPage loginPage = new LoginPage(driver);
            loginPage.waitForLoadLoginPage();

            loginPage.fillEmailField(user.getEmail());
            loginPage.fillPasswordField(user.getPassword());
            loginPage.clickLoginButton();

            mainPage.waitForLoadMainPage();

            header.clickPersonalAccountLink();

            PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
            personalAccountPage.waitForLoadPersonalAccountPage();

            header.clickConstructorLink();

            mainPage.waitForLoadMainPage();

            String expectedUrl = "https://stellarburgers.nomoreparties.site/";
            String actualUrl = driver.getCurrentUrl();

            assertEquals(expectedUrl, actualUrl);
        } finally {
            deleteUser(user);
        }
    }

    @Test
    @DisplayName("Проверка перехода в конструктор по клику на логотип из личного кабинета")
    public void goToConstructorOnLogoTest() {
        try {
            user = generateRandomUser();
            registerUser(user);

            MainPage mainPage = new MainPage(driver);
            mainPage.waitForLoadMainPage();

            Header header = new Header(driver);
            header.clickPersonalAccountLink();

            LoginPage loginPage = new LoginPage(driver);
            loginPage.waitForLoadLoginPage();

            loginPage.fillEmailField(user.getEmail());
            loginPage.fillPasswordField(user.getPassword());
            loginPage.clickLoginButton();

            mainPage.waitForLoadMainPage();

            header.clickPersonalAccountLink();

            PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
            personalAccountPage.waitForLoadPersonalAccountPage();

            header.clickLogoLink();

            mainPage.waitForLoadMainPage();

            String expectedUrl = "https://stellarburgers.nomoreparties.site/";
            String actualUrl = driver.getCurrentUrl();

            assertEquals(expectedUrl, actualUrl);
        } finally {
            deleteUser(user);
        }
    }

    @Test
    @DisplayName("Проверка выхода из личного кабинета")
    public void successfulLogoutTest() {
        try {
            user = generateRandomUser();
            registerUser(user);

            MainPage mainPage = new MainPage(driver);
            mainPage.waitForLoadMainPage();

            Header header = new Header(driver);
            header.clickPersonalAccountLink();

            LoginPage loginPage = new LoginPage(driver);
            loginPage.waitForLoadLoginPage();

            loginPage.fillEmailField(user.getEmail());
            loginPage.fillPasswordField(user.getPassword());
            loginPage.clickLoginButton();

            mainPage.waitForLoadMainPage();

            header.clickPersonalAccountLink();

            PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
            personalAccountPage.waitForLoadPersonalAccountPage();

            personalAccountPage.clickLogoutButton();

            loginPage.waitForLoadLoginPage();

            String expectedUrl = "https://stellarburgers.nomoreparties.site/login";
            String actualUrl = driver.getCurrentUrl();

            assertEquals(expectedUrl, actualUrl);
        } finally {
            deleteUser(user);
        }
    }

}