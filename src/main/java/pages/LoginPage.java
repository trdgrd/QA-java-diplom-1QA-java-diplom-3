package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;

    private By emailInput = By.xpath(".//*[text()='Email']/following-sibling::input");
    private By passwordInput = By.xpath(".//*[text()='Пароль']/following-sibling::input");
    private By loginButton = By.xpath(".//button[text()='Войти']");
    private By registerLink = By.xpath(".//a[text()='Зарегистрироваться']");
    private By restorePasswordLink = By.xpath(".//a[text()='Восстановить пароль']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Ожидание загрузки страницы логина")
    public void waitForLoadLoginPage() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(loginButton));
    }

    @Step("Заполнить поле 'email'")
    public void fillEmailField(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    @Step("Заполнить поле 'Пароль'")
    public void fillPasswordField(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    @Step("Нажать на ссылку 'Зарегистрироваться'")
    public void clickRegisterLink() {
        driver.findElement(registerLink).click();
    }

    @Step("Нажать на кнопку 'Войти'")
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    @Step("Нажать на ссылку 'Восстановить пароль'")
    public void clickRestorePasswordLink() {
        driver.findElement(restorePasswordLink).click();
    }

}