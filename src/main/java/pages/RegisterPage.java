package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {
    private WebDriver driver;

    private By registerButton = By.xpath(".//button[text()='Зарегистрироваться']");
    private By nameInput = By.xpath(".//*[text()='Имя']/following-sibling::input");
    private By emailInput = By.xpath(".//*[text()='Email']/following-sibling::input");
    private By passwordInput = By.xpath(".//*[text()='Пароль']/following-sibling::input");
    private By invalidPasswordMessage = By.xpath(".//p[text()='Некорректный пароль']");
    private By loginLink = By.xpath(".//a[text()='Войти']");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Ожидание загрузки страницы регистрации")
    public void waitForLoadRegisterPage() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(registerButton));
    }

    @Step("Заполнить поле 'Имя'")
    public void fillNameField(String name) {
        driver.findElement(nameInput).sendKeys(name);
    }

    @Step("Заполнить поле 'email'")
    public void fillEmailField(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    @Step("Заполнить поле 'Пароль'")
    public void fillPasswordField(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    @Step("Нажать на кнопку 'Зарегистрироваться'")
    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }

    @Step("Проверка что отобразилось сообщение 'Некорректный пароль'")
    public boolean invalidPasswordMessageDisplayed() {
        return driver.findElement(invalidPasswordMessage).isDisplayed();
    }

    @Step("Нажать на ссылку 'Войти'")
    public void clickLoginLink() {
        driver.findElement(loginLink).click();
    }

}