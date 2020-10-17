package ru.anf;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginTest {
   public void Setup(){
       WebDriver driver = new ChromeDriver();
       System.setProperty("webdriver.chrome.driver", "C:/Users/anferovaav/IdeaProjects");
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       driver.get("https://www.citilink.ru/login/");
   }
}
