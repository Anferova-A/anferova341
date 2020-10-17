package ru.anf;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    /**
     * конструктор класса, занимающийся инициализацией полей класса
     */
    public WebDriver driver;
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    /**
     * определение локаторв
     */
    @FindBy(xpath = "//*[@id=\"content\"]/div/form/fieldset/div[1]/div/input")
    private WebElement loginField;

    @FindBy(xpath = "//*[@id=\"formSubmit\"]")
    private WebElement loginBtn;

    @FindBy(xpath = "//*[@id=\"content\"]/div/form/fieldset/div[2]/div/input")
    private WebElement passwdField;

    /**
     * методы
     */
    public void inputLogin(String login) {
        loginField.sendKeys(login); }

    public void inputPasswd(String passwd) {
        passwdField.sendKeys(passwd); }

    public void clickLoginBtn() {
        loginBtn.click(); }




}
