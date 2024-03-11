import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import pages.MainPage;
import pages.RegisterPage;
import pojo.User;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RegisterTest extends Base {

    private User user;

    @Test
    @DisplayName("Проверка успешной регистрации")
    public void successfulRegistrationTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.waitForLoadMainPage();
        mainPage.clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.waitForLoadLoginPage();
        loginPage.clickRegisterLink();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.waitForLoadRegisterPage();

        user = generateRandomUser();

        registerPage.fillNameField(user.getName());
        registerPage.fillEmailField(user.getEmail());
        registerPage.fillPasswordField(user.getPassword());
        registerPage.clickRegisterButton();

        loginPage.waitForLoadLoginPage();

        String expectedUrl = "https://stellarburgers.nomoreparties.site/login";
        String actualUrl = driver.getCurrentUrl();

        assertEquals(expectedUrl, actualUrl);

        deleteUser(user);
    }

    @Test
    @DisplayName("Проверка неуспешной регистрации с некорректным паролем")
    public void unsuccessfulRegistrationTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.waitForLoadMainPage();
        mainPage.clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.waitForLoadLoginPage();
        loginPage.clickRegisterLink();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.waitForLoadRegisterPage();

        user = generateRandomUser();
        user.setPassword(RandomStringUtils.randomAlphabetic(5));

        registerPage.fillNameField(user.getName());
        registerPage.fillEmailField(user.getEmail());
        registerPage.fillPasswordField(user.getPassword());
        registerPage.clickRegisterButton();

        new WebDriverWait(driver, Duration.ofSeconds(3));

        assertTrue(registerPage.invalidPasswordMessageDisplayed());
    }

}