package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ForgotPasswordPage {

    private WebDriver driver;

    private By loginLink = By.xpath(".//a[text()='Войти']");
    private By restoreButton = By.xpath(".//button[text()='Восстановить']");

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Ожидание загрузки страницы восстановления пароля")
    public void waitForLoadForgotPasswordPage() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(restoreButton));
    }

    @Step("Нажать на ссылку 'Войти'")
    public void clickLoginLink() {
        driver.findElement(loginLink).click();
    }

}