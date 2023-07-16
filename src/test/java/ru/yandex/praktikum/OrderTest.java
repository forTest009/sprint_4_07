package ru.yandex.praktikum;

import PageObject.MainPage;
import PageObject.OrderPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Parameterized.class)

public class OrderTest {
    private final String nameUser;
    private final String surnameUser;

    private final String addressUser;

    private final String telUser;

    private final String dateOrder;

    private final String commentsUser;

    public OrderTest(String nameUser, String surnameUser, String addressUser, String telUser, String dateOrder, String commentsUser) {
        this.nameUser = nameUser;
        this.surnameUser = surnameUser;
        this.addressUser = addressUser;
        this.telUser = telUser;
        this.dateOrder = dateOrder;
        this.commentsUser = commentsUser;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {"Имя", "Фамилия", "Адрес", "+79090000000", "22.12.2023","неа"},
                {"ёёёёёёёёё", "ёёёёёёёёё", "ёёёёёёёёё", "+79090000000", "22.12.2023","ёёёёёёёёё"},
        };
    }
    private WebDriver driver;
    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }
    @Test
    public void newCheckActivityOrderInBody() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.open();
        objMainPage.clickAgreeCookies();
        objMainPage.clickBtnInBody();
        OrderPage objOrderPage = new OrderPage(driver);
        objOrderPage.fillFirstStep(nameUser, surnameUser, addressUser, telUser);
        objOrderPage.fillSecondStep(dateOrder, commentsUser);
    }
    @Test
    public void newCheckActivityOrderInHeader() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.open();
        objMainPage.clickAgreeCookies();
        objMainPage.clickBtnInHeader();
        OrderPage objOrderPage = new OrderPage(driver);
        objOrderPage.fillFirstStep(nameUser, surnameUser, addressUser, telUser);
        objOrderPage.fillSecondStep(dateOrder, commentsUser);
    }
    @After
    public void teardown(){
        driver.quit();
    }
}