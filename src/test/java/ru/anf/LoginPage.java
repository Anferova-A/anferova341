package ru.anf;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    /**
     * конструктор класса, занимающийся инициализацией полей класса
     */
    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    /**
     * определение локаторв
     */
    @FindBy(xpath = "//*[contains(text(), \\\"Перейти на старую версию сайта\\\")]")
    private WebElement oldversion;

    @FindBy(xpath = "//*[@id=\"content\"]/div/form/fieldset/div[1]/div/input")
    private WebElement loginField;

    @FindBy(xpath = "//*[@id=\"content\"]/div/form/fieldset/div[2]/div/input")
    private WebElement passwdField;

    @FindBy(xpath = "//*[@id=\"formSubmit\"]")
    private WebElement loginBtn;

    @FindBy(xpath = "//*[@id=\"captcha_login\"]")
    private WebElement captcha;

    /**
     * методы
     */
    public void inputLogin(String login) {
        loginField.sendKeys(login);
    }

    public void inputPasswd(String passwd) {
        passwdField.sendKeys(passwd);
    }

    public void clickLoginBtn() {
        loginBtn.click();
    }

    public void goToOldVersion() {
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), \"Перейти на старую версию сайта\")]"))).click();
    }

    public  void clickCaptcha(){
        captcha.click();
    }


}
