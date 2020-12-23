package ru.anf;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
public class LoginTest {

    public static WebDriver driver;
    public static ProfilePage profilePage;
    /**
     * осуществление первоначальной настройки
     */
    @BeforeClass
    public static void setup() {
        //определение пути до драйвера и его настройка
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        //создание экземпляра драйвера
        driver = new ChromeDriver();
        profilePage = new ProfilePage(driver);
        //окно разворачивается на полный экран
        driver.manage().window().maximize();
        //задержка на выполнение теста = 10 сек.
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //получение ссылки на страницу входа из файла настроек
        driver.get(ConfProperties.getProperty("loginpage"));
    }

    @Test
    public void loginTest() throws InterruptedException {
        //значение login/password берутся из файла настроек по аналогии с chromedriver
//и loginpage
//вводим логин
        profilePage.clickFirstLoginBtn();
        profilePage.inputLogin(ConfProperties.getProperty("login"));
        profilePage.inputPasswd(ConfProperties.getProperty("password"));

        Thread.sleep(10000);
        profilePage.clickSecondLoginBtn();
        String user = profilePage.getUserName();
        Assert.assertEquals(ConfProperties.getProperty("name"), user); }

    @AfterClass
    public static void tearDown() {
        profilePage.logout();
        driver.quit(); }
}
