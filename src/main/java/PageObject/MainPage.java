package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;

    private String url = "https://qa-scooter.praktikum-services.ru/";
    private By btnOrderInHeader = By.xpath("//div[starts-with(@class,'Header')]//button[text()='Заказать']");
    private By btnOrderInBody = By.xpath("//div[starts-with(@class,'Home_FinishButton')]//button[text()='Заказать']");
    private By btnAgreeCookies = By.xpath("//button[text()='да все привыкли']");

    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    public void open(){
        driver.get(url);
    }
    public void clickQuestion(String textHeader){
        driver.findElement(By.xpath("//*[text()='" + textHeader + "']")).click();
    }
    public String getQuestion(String textHeader){
        return driver.findElement(By.xpath("//*[text()='" + textHeader + "']")).getText();
    }
    public String getAnswer(String textBody){
        return driver.findElement(By.xpath("//*[text()='" + textBody + "']")).getText();
    }
    public void clickBtnInHeader() {
        driver.findElement(btnOrderInHeader).click();
    }
    public void clickBtnInBody() {
        driver.findElement(btnOrderInBody).click();
    }
    public void clickAgreeCookies() {
        driver.findElement(btnAgreeCookies).click();
    }
}