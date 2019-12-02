package com.qa.pom.pages;

import com.qa.pom.base.BaseTest;
import com.qa.pom.utils.YamlParser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class Login extends AbstractPage {

    @FindBy(xpath = "//input[contains(@id,'email')and @name='email']")
    private
    WebElement email;

    @FindBy(xpath = "//input[contains(@id,'passwd')]")
    private
    WebElement password;

    /**
     * Constructor
     *
     * @param testClass the instance of login page
     */
    Login(BaseTest testClass) {
        super(testClass);
        testClass.waitTillElementIsVisible(pageDiv);
    }

    /**
     * Log in using email and password form configuration.yaml
     *
     * @return next page
     */
    public MyAccount logIn() throws IOException {
        email.sendKeys(YamlParser.getYamlData().getEmail());
        password.sendKeys(YamlParser.getYamlData().getPassword());
        submitButton.click();
        return new MyAccount(testClass);
    }

    /** Wait till Submit button become visible */
    public void verifyLoginPage() {
        testClass.waitTillElementIsVisible(submitButton);
    }
}
