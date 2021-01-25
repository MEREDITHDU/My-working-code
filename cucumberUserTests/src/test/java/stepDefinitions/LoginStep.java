package stepDefinitions;

import cucumber.api.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObject.LoginPage;

public class LoginStep {
        private WebDriver driver;
        LoginPage loginpage;

    @Given("I click login link text at home page")
    public void I_click_login_link_text_at_home_page () throws InterruptedException{
		loginpage.findLoginLink();
                loginpage.LoginToPage();
		Thread.sleep(3000);
		Assert.assertEquals(driver.getTitle(), "nopCommerce demo store. Login");
    }
    
    
}
