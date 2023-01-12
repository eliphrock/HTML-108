package techproed.tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import techproed.pages.XYZBankPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

import static junit.framework.Assert.assertEquals;

public class XYZBankTest {

    @Test
    public void xyzBankTest(){
        XYZBankPage xyzBankPage = new XYZBankPage();
//        Go to url https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login
        Driver.getDriver().get(ConfigReader.getProperty("xyzBank_URL"));

//        Click on "Bank Manager Login" button
        xyzBankPage.bankManagerLoginButton.click();

//        Click on "Add Customer" button
        xyzBankPage.addCustomerButton.click();

//        Fill inputs and click on "Add Customer" submit button
        Faker faker = new Faker();

        for (int i = 0; i < 5; i++) {

            xyzBankPage.firstnameInput.sendKeys(faker.name().firstName());
            xyzBankPage.lastnameInput.sendKeys(faker.name().lastName());
            xyzBankPage.postCodeInput.sendKeys(faker.address().zipCode());
            xyzBankPage.addCustomerSubmitButton.click();
//        Accept alert
            try {
                Driver.getDriver().switchTo().alert().accept();
            } catch (Exception ignored) {
            }

//        Add 4 more customers

        }

//        Click on "Open Account"  button
        xyzBankPage.openAccountButton.click();

//        Click on "Customer" dropdown
//        Select customer name
        Select customerDD = new Select(xyzBankPage.customerDropdown);
        Select currencyDD = new Select(xyzBankPage.currencyDropdown);

        for (int i=6; i<11; i++){
//        Click on "Currency" dropdown
            customerDD.selectByIndex(i);
//        Select "Dollar"
            currencyDD.selectByIndex(1);
//        Click on "Process" button
            xyzBankPage.processButton.click();
//        Accept alert
            try {
                Driver.getDriver().switchTo().alert().accept();
            }catch (Exception ignored){
            }
//        Open 4 more accounts
        }

//        Click on "Customers" button
        xyzBankPage.customersButton.click();

//        Count table row numbers
        int numberOfCustomerRows = xyzBankPage.numberOfCustomerRows.size();

//        Assert that you created 5 customers
        assertEquals(10,numberOfCustomerRows);

//        Click on "Home" button
        xyzBankPage.homeButton.click();

//        Click on "Customer Login" button

        xyzBankPage.customerLoginButton.click();

//    Count table row numbers

//    Assert that you created 5 customers

//    Click on "Home" button

//    Click on "Customer Login" button

//    Click on "Your Name" dropdown

//    Select the any name you created

//    Click on "Login" button

//    Click on "Deposit" button

//    Type 100 into "Amount to be Deposited" input

//    Assert that "Deposit Successful" is displayed

//    Click on "Deposit"(Submit) button

//    Click on "Withdrawal" button

//    Type 100 into "Amount to be Withdrawn" input

//    Click on "Withdraw"(Submit) button

//    Assert that "Transaction  Successful" is displayed

//    Click on "Logout" button

//    Click on "Home" button

//    Click on "Bank Manager Login" button

//    Click on "Customers" button

//    Click on each "Delete" button

//    Count table row numbers

//    Assert that number of customers is 0


    }
}
