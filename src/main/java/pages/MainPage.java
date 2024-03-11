package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {

    private WebDriver driver;

    private By loginButton = By.xpath(".//button[text()='Войти в аккаунт']");
    private By personalAccountButton = By.xpath(".//a[*[text()='Личный Кабинет']]");
    private By createOrderButton = By.xpath(".//button[text()='Оформить заказ']");
    private By assembleBurgerHeader = By.xpath(".//*[text()='Соберите бургер']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Ожидание загрузки главной страницы")
    public void waitForLoadMainPage() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(assembleBurgerHeader));
    }

    @Step("Нажать на кнопку 'Войти в аккаунт'")
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    @Step("Нажать на кнопку 'Личный кабинет'")
    public void clickPersonalAccountButton() {
        driver.findElement(personalAccountButton).click();
    }

    @Step("Проверка что отобразилась кнопка 'Оформить заказ'")
    public boolean createOrderButtonDisplayed() {
        return driver.findElement(createOrderButton).isDisplayed();
    }

}