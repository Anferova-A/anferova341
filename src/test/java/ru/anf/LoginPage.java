package ru.anf;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy(xpath = "//*[@id=\"content\"]/div/form/fieldset/div[1]/div/input")
    private WebElement loginField;

    @FindBy(xpath = "//*[@id=\"formSubmit\"]")
    private WebElement loginBtn;

    @FindBy(xpath = "//*[@id=\"content\"]/div/form/fieldset/div[2]/div/input")
    private WebElement passwdField;
}
