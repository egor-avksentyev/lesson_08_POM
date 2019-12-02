package com.qa.pom.pages;

import com.qa.pom.base.BaseTest;

public class Home extends AbstractPage {

    /**
     * Constructor
     *
     * @param testClass the instance of home page
     */
    public Home(BaseTest testClass) {
        super(testClass);
        testClass.waitTillElementIsVisible(pageDiv);
    }
}
