import api.steps.ClientSteps;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pojo.User;

public abstract class Base {

    WebDriver driver;
    ClientSteps clientSteps = new ClientSteps();
    private static final String YANDEX_DRIVER = "src/main/resources/yandexdriver";
    private static final String BASE_URL = "https://stellarburgers.nomoreparties.site";

    @Step("Инициализация драйвера")
    public void initDriver(String browserName) {
        switch (browserName) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "yandex":
                System.setProperty("webdriver.chrome.driver", YANDEX_DRIVER);
                driver = new ChromeDriver();
                break;
        }
    }

    @Step("Удаление юзера")
    public void deleteUser(User user) {
        ValidatableResponse response = clientSteps.loginUser(user);
        String accessToken = clientSteps.extractAccessToken(response);
        clientSteps.deleteUser(user, accessToken);
    }

    @Step("Регистрация юзера")
    public void registerUser(User user) {
        ValidatableResponse response = clientSteps.registerUser(user);
    }

    @Step("Генерация модели юзера с рандомными данными")
    public User generateRandomUser() {
        return new User(
                RandomStringUtils.randomAlphabetic(8) + "@yndx.ru",
                RandomStringUtils.randomAlphabetic(7),
                RandomStringUtils.randomAlphabetic(8)
        );
    }

    @Before
    public void setUp() {
        initDriver("chrome");
        driver.get(BASE_URL);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}