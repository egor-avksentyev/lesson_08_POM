package com.qa.pom.test;

import com.qa.pom.base.BaseTest;
import com.qa.pom.pages.Home;
import com.qa.pom.pages.Login;
import com.qa.pom.pages.MyAccount;
import org.junit.Test;

import java.io.IOException;

public class OpenSite extends BaseTest {

    /** Open site and log in. Verify name. Log put and check the log in page. */
    @Test
    public void testOpenSiteAndClickPythonLinkTest() throws IOException {

        // Initialize HomePage
        Home home = openSite();
        log("Initialize HomePage");
        // Click on log in Link
        Login login = home.clickLoginLink();
        log("Click on log in Link");
        // Log in
        MyAccount myAccountPage = login.logIn();
        log("Log in");
        // Verify name
        myAccountPage.verifyName();
        log("Verify name");
        // Sign out
        login = myAccountPage.signOut();
        log("Sign out");
        // Verify log in page loaded again
        login.verifyLoginPage();
        log("Verify log in page loaded again");
        // CLose site
        closeSite();
    }
}
