package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Hello world!
 *
 */
public class BannerPage 
{
private WebDriver driver;
    
    private By BannerLocator =By.xpath("//*[@id=\"nivo-slider\"]/img");

    public BannerPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public boolean ifBannerExists(){
        driver.findElement(BannerLocator).isDisplayed();   
        return true;
    }
}
