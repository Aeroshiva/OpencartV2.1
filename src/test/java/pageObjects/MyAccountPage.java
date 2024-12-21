package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath = "//h2[normalize-space()='My Account']")  //My Account Page Heading
	WebElement msgHeading;
	
	@FindBy(xpath = "//div[@class='list-group']//a[text()='Logout']") //added in step6
	WebElement linkLogout;

	public boolean isMyAccountPageExists() {
		try {
			return (msgHeading.isDisplayed());	
		}
		catch(Exception e) {
			return false;
		}
	}
	
	public void clickLogoutLink() {
		linkLogout.click();
	}
}
