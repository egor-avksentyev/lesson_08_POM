package com.qa.pom.pages;

import com.qa.pom.base.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;

public class MyAccount extends AbstractPage {

    private String REG_NAME = "test testw";
    private String NAME_XPATH = "//a[contains(@class,'account')]/span";

    /**
     * Constructor
     *
     * @param testClass the instance of account page
     */
    public MyAccount(BaseTest testClass) {
        super(testClass);
        testClass.waitTillElementIsVisible(pageDiv);
    }

    /** Verify the name */
    public void verifyName() {
        Assert.assertEquals(
                "Name is not the same",
                REG_NAME,
                testClass.getDriver().findElement(By.xpath(NAME_XPATH)).getText());
    }
}
