package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PersonalAccountPage {

    private WebDriver driver;

    private By profileMenu = By.xpath(".//a[text()='Профиль']");
    private By logoutButton = By.xpath(".//button[text()='Выход']");

    public PersonalAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Ожидание загрузки личного кабинета")
    public void waitForLoadPersonalAccountPage() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(profileMenu));
    }

    @Step("Нажать на кнопку 'Выход'")
    public void clickLogoutButton() {
        driver.findElement(logoutButton).click();
    }

}