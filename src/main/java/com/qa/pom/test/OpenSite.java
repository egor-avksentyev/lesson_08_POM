package com.qa.pom.test;

import com.qa.pom.base.BaseTest;
import com.qa.pom.pages.Home;
import com.qa.pom.pages.Login;
import com.qa.pom.pages.MyAccount;
import java.io.IOException;
import org.junit.Test;

public class OpenSite extends BaseTest {

    /** Open site and log in. Verify name. Log put and check the log in page. */
    @Test
    public void testOpenSiteAndClickPythonLinkTest() throws IOException {

        // Initialize HomePage
        Home home = openSite();

        // Click on log in Link
        Login login = home.clickLoginLink();

        // Log in
        MyAccount myAccountPage = login.logIn();

        // Verify name
        myAccountPage.verifyName();

        // Sign out
        login = myAccountPage.signOut();

        // Verify log in page loaded again
        login.verifyLoginPage();

        // CLose site
        closeSite();
    }
}
