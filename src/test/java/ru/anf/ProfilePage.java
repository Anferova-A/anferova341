package ru.anf;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {
    /**
     * конструктор класса, занимающийся инициализацией полей класса
     */
    public WebDriver driver;
    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }
    /**
     * определение локатора меню пользователя
     */
    @FindBy(className = "AuthPopup")
    private WebElement firstLoginBtn;
    @FindBy(className = "SignIn__action")
    private WebElement secondLoginBtn;
    @FindBy(name = "login")
    private WebElement loginField;
    @FindBy(name = "pass")
    private WebElement passwdField;
    @FindBy(className = "HeaderUserName")
    private WebElement userMenu;
    @FindBy (partialLinkText = "Мой профиль")
    private WebElement myProfile;
    @FindBy (partialLinkText = "Выйти")
    private WebElement exit;
    @FindBy (className = " InputBox__input js--InputBox__input  __input-captcha__container-input")
    private WebElement captcha;


    public void inputLogin(String login) {
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.name("login")));
        loginField.sendKeys(login);
    }
    public void inputPasswd(String passwd) {
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.name("pass")));
        passwdField.sendKeys(passwd);
    }
    public void clickFirstLoginBtn() {
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("AuthPopup")));
        firstLoginBtn.click();
    }
    public void clickSecondLoginBtn() {
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("SignIn__action")));
        secondLoginBtn.click();
    }
    public String getUserName() {
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("HeaderUserName")));
        return userMenu.getText();
    }
    public void clickUserMenu() {
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("HeaderUserName")));
        userMenu.click();
    }
    public void clickMyProfile() {
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Мой профиль")));
        myProfile.click();
    }
    public void logout(){
        userMenu.click();
        exit.click();
    }
    public void captcha_click(){
        captcha.click();
    }
}
