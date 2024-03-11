package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Header {

    private WebDriver driver;

    private By constructorLink = By.xpath(".//p[text()='Конструктор']");
    private By personalAccountLink = By.xpath(".//a[*[text()='Личный Кабинет']]");
    private By logoLink = By.xpath("(.//a[@href='/'])[2]");

    public Header(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Нажать на ссылку 'Личный кабинет'")
    public void clickPersonalAccountLink() {
        driver.findElement(personalAccountLink).click();
    }

    @Step("Нажать на ссылку 'Конструктор'")
    public void clickConstructorLink() {
        driver.findElement(constructorLink).click();
    }

    @Step("Нажать на логотип")
    public void clickLogoLink() {
        driver.findElement(logoLink).click();
    }

}