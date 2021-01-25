package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterationPage {
    private WebDriver driver;
    
    private By RegisterLinkLocator = By.linkText("Register");
    private By FirstNameLocator = By.id("FirstName");
    private By LastNameLocator = By.id("LastName");
    private By EmailLocator = By.id("Email");
    private By PasswordLocator = By.id("Password");
    private By ConfirmPasswordLocator = By.id("ConfirmPassword");
    private By RegisterButtonLocator = By.xpath("//*[@id=\"register-button\"]");

    public RegisterationPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public WebDriver findRegisterLink(){
        driver.findElement(RegisterLinkLocator).click();
        return driver;    
    }
    
    public WebDriver fillandRegister(){
                driver.findElement(FirstNameLocator).sendKeys("Pitor");
                driver.findElement(LastNameLocator).sendKeys("Kielbasa");
                driver.findElement(EmailLocator).sendKeys("avaaz@avaaz.org");
                driver.findElement(PasswordLocator).sendKeys("Test123");
                driver.findElement(ConfirmPasswordLocator).sendKeys("Test123");            
        return driver;             
    }

    public WebDriver saveAndRegister(){
        driver.findElement(RegisterButtonLocator).click();  
        return driver; 
    }
}
