import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.MainPage;
import utils.TabName;

import static org.junit.Assert.assertTrue;
import static utils.TabName.*;

@RunWith(Parameterized.class)
public class ConstructorTest extends Base {

    private TabName tabName;

    public ConstructorTest(TabName tabName) {
        this.tabName = tabName;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][] {
                {BUNS},
                {SAUCES},
                {FILLINGS}
        };
    }

    @Test
    @DisplayName("Проверка корректного перехода на вкладку конструктора")
    public void openTabTest() {

        MainPage mainPage = new MainPage(driver);
        mainPage.waitForLoadMainPage();

        mainPage.openConstructorTab(tabName);

        assertTrue(mainPage.getConstructorTab(tabName));

    }

}