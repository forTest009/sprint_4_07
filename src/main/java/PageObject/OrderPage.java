package PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage {
    private WebDriver driver;
    //Поле ввода имени
    private By name = By.xpath("//input[@placeholder='* Имя']");
    //Поле ввода фамилии
    private By surname = By.xpath("//input[@placeholder='* Фамилия']");
    //Поле ввода адреса
    private By adress = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    //Поле ввода телефона
    private By telephone = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    //Поле выбора станции метро
    private By metro = By.xpath("//input[@placeholder='* Станция метро']");
    //Вариант выбора странции метро
    private By metroItem = By.xpath(" //ul//li[@role='menuitem']");
    //Кнопка для перехода на второй шаг оформления заказа
    private By nextFirstStep = By.xpath("//div[starts-with(@class,'Order')]//button[text()='Далее']");

    //Второй шаг заказа: про аренду
    //Поле ввода даты
    private By dateOrder = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    //Поле выбора срока аренды самоката
    private By countDays = By.xpath("//div[text()='* Срок аренды']");
    //Поле выбора варианта срока аренды самоката
    private By valueCountDays = By.xpath("//div[starts-with(@class,'Dropdown') and text()='сутки']");
    //Поле выбора цвета самоката черного
    private By valueColorBlack = By.xpath("//input[@id='black']");
    //Поле выбора цвета самоката серого
    private By valueColorGrey = By.xpath("//input[@id='grey']");
    //Поле ввода комментария
    private By comments = By.xpath("//input[@placeholder='Комментарий для курьера']");
    //Кнопка заказа во втором шаге оформления
    private By btnOrderSecondSteps = By.xpath("//div[starts-with(@class,'Order')]//button[text()='Заказать']");
    //Кнопка отмены во втором шаге оформления
    private By btnOrderBack = By.xpath("//div[starts-with(@class,'Order')]//button[text()='Назад']");

    //Модальное окно подтверждения заказа
    //Кнопка подтвержения заказа
    private By btnOrderAgree = By.xpath("//div[starts-with(@class,'Order_Modal')]//button[text()='Да']");
    //Кнопка отмены заказа

    private By btnOrderCancel = By.xpath("//div[starts-with(@class,'Order_Modal')]//button[text()='Нет']");

    //Модальное окно оформленного заказа
    private By btnCheckStatus= By.xpath("//div[starts-with(@class,'Order')]//button[text()='Посмотреть статус']");

    public OrderPage(WebDriver driver){
        this.driver = driver;
    }
    public void setUsername(String username) {
        driver.findElement(name).sendKeys(username);
    }
    public void setSurname(String usersurname) {
        driver.findElement(surname).sendKeys(usersurname);
    }
    public void setAdress(String useradress) {
        driver.findElement(adress).sendKeys(useradress);
    }
    public void setTelephone(String usertelephone) {
        driver.findElement(telephone).sendKeys(usertelephone);
    }
    public void clickSelectMetro() {
        driver.findElement(metro).click();
    }
    public void clicKMetroItem() {
        driver.findElement(metroItem).click();
    }
    public void clickBtnNext() {
        driver.findElement(nextFirstStep).click();
    }
    public void clickBtnNextSecondStep() {
        driver.findElement(btnOrderSecondSteps).click();
    }
    public void clickBtnAgree() {
        driver.findElement(btnOrderAgree).click();
    }
    public void choosenStation(){
        clickSelectMetro();
        driver.findElement(metroItem);
        clicKMetroItem();
    }
    public void setDate(String userdateOrder) {
        driver.findElement(dateOrder).sendKeys(userdateOrder);
    }
    public void setComments(String userComment) {
        driver.findElement(comments).sendKeys(userComment);
    }

    public void choosenCountDays() {
        driver.findElement(countDays).click();
        driver.findElement(valueCountDays).click();
    }
    public void choosenColorBlack(){
        driver.findElement(valueColorBlack).click();
    }
    public void choosenColorGrey(){
        driver.findElement(valueColorGrey).click();
    }

    public void clickBtnCheckStatus(){
        driver.findElement(btnCheckStatus).click();
    }
    public void fillFirstStep(String username, String usersurname,String useradress,String usertelephone){
        setUsername(username);
        setSurname(usersurname);
        setAdress(useradress);
        setTelephone(usertelephone);
        choosenStation();
        clickBtnNext();
    }
    public void fillSecondStep(String dateOrder, String comments){
        choosenCountDays();
        setDate(dateOrder);
        choosenColorBlack();
        setComments(comments);
        clickBtnNextSecondStep();
        clickBtnAgree();
        clickBtnCheckStatus();
    }
}