package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.TabName;

import java.time.Duration;

public class MainPage {

    private WebDriver driver;

    private By loginButton = By.xpath(".//button[text()='Войти в аккаунт']");
    private By createOrderButton = By.xpath(".//button[text()='Оформить заказ']");
    private By assembleBurgerHeader = By.xpath(".//*[text()='Соберите бургер']");

    private By bunsTab = By.xpath(".//div[span[text()='Булки']]");
    private By saucesTab = By.xpath(".//div[span[text()='Соусы']]");
    private By fillingsTab = By.xpath(".//div[span[text()='Начинки']]");

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

    @Step("Проверка что отобразилась кнопка 'Оформить заказ'")
    public boolean createOrderButtonDisplayed() {
        return driver.findElement(createOrderButton).isDisplayed();
    }

    @Step("Открыть вкладку в конструкторе")
    public void openConstructorTab(TabName tabName) {
        switch (tabName) {
            case BUNS:
                driver.findElement(saucesTab).click();
                driver.findElement(bunsTab).click();
                break;
            case SAUCES:
                driver.findElement(saucesTab).click();
                break;
            case FILLINGS:
                driver.findElement(fillingsTab).click();
                break;
        }
    }

    @Step("Получить активную вкладку в конструкторе")
    public boolean getConstructorTab(TabName tabName) {
        switch (tabName) {
            case BUNS:
                return driver.findElement(bunsTab).getAttribute("class").contains("current");
            case SAUCES:
                return driver.findElement(saucesTab).getAttribute("class").contains("current");
            case FILLINGS:
                return driver.findElement(fillingsTab).getAttribute("class").contains("current");
            default:
                throw new RuntimeException("unknown name");
        }
    }

}