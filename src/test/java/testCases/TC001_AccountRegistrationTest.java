package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{

	
	
	@Test (groups={"Regression","Master"})
	public void verify_account_registration() {
		
		logger.info("**** Starting TC001_AccountRegistrationTest ****");
		
		//HomePage
		try{
		HomePage hp= new HomePage(driver);
		hp.clickMyAccount();
		logger.info("**** Clicked on MyAccount Link ****");
		
		hp.clickMyRegister();
		logger.info("**** Clicked on Register Link ****");
		
		//Account Registration Page
		logger.info("**** Providing Customer details.. ****");
		AccountRegistrationPage regPage = new AccountRegistrationPage(driver);
			regPage.setFirstName(randomString().toUpperCase());
			regPage.setLastName(randomString().toUpperCase());
			regPage.setEmail(randomString()+"@gmail.com");//randomly generated email
			regPage.setTelephone(randomNumbers());
			
			//regPage random Password generation
			String password = randomAlphaNumeric();
			regPage.setPassword(password);
			regPage.setConfirmPassword(password);
			
			regPage.setPrivacyPolicy();
			regPage.btnContinue();
			
			logger.info("**** Validating expected message ****");
			String congMsg = regPage.getConfirmationMsg();
			if(congMsg.equals("Your Account Has Been Created!")) {
				Assert.assertTrue(true);
			}else {
				logger.error("Test failed..");
				logger.debug("Debug logs....");
				Assert.assertTrue(false);
			}
			//Assert.assertEquals(congMsg, "!Your Account Has Been Created!");
		} catch(Exception e) {
			
			Assert.fail();
		}
		
		logger.info("**** Finished TC001_AccountRegistrationTest ****");
			
	}
	
	
	
	
	
	
}
