package techproed.tests.smoketest.logintests;

import junit.framework.Assert;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import techproed.pages.HomePage;
import techproed.pages.LogInPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class Day19_NegativeLoginTest {

    HomePage homePage;
    LogInPage logInPage;
    @Test
    public void US100208_Negative_Login(){
        //going blue rental car home page
        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));
//        click on home page login link
        homePage = new HomePage();
        logInPage= new LogInPage();
        ReusableMethods.waitFor(3);
        homePage.homePageLoginLink.click();
//        sending credentials and clicking on login button
        ReusableMethods.waitFor(3);
        logInPage.userName.sendKeys("fake@bluerentalcars.com");
        ReusableMethods.waitFor(3);
        logInPage.password.sendKeys("fakepass");
        ReusableMethods.waitFor(3);
        logInPage.loginButton.click();
        ReusableMethods.waitFor(3);
        //verify error is successful
        String errorMessage=logInPage.errorMessage.getText();
        Assert.assertEquals(errorMessage,"User with email fake@bluerentalcars.com not found");

    }
}
