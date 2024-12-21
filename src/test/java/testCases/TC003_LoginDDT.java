package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;



public class TC003_LoginDDT extends BaseClass {
/* The syntax @Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class) in TestNG 
 * is used to specify a data provider that is located in another class. 
 * 
 * @DataProvider: Marks a method as a data provider. 
 * name="LoginData": Assigns a name to the data provider. 
 * This name is used to link the data provider to a specific test method.
 */
	
	@Test(dataProvider = "LoginData", dataProviderClass=DataProviders.class, groups ="datadriven") 
	public void verifyLoginDDT(String email, String pwd, String exp)
	{
		logger.info("**** Started TC003_LoginDDT ****");
		try {
		//HomePage
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLoginLink();
		
		//LoginPage
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(pwd);
		lp.clickLoginButton();
		
		//MyAccountPage
		
		MyAccountPage mAp = new MyAccountPage(driver);
		boolean targetPage = mAp.isMyAccountPageExists();
		
		/*
		 * Data is valid -- login success -- test pass -- logout
		 *				 -- login failed -- test fail
		 * 
		 * Data is Invalid -- login success -- test fail -- logout
		 * 				   -- login failed -- test pass 
		 */
		
		if(exp.equalsIgnoreCase("Valid")) 
		{
			if(targetPage=true)
			{
				mAp.clickLogoutLink();
				Assert.assertTrue(true);
			}
			else 
			{
				Assert.assertTrue(false);
			}
		}
		
		if(exp.equalsIgnoreCase("Invalid"))
		{
			if(targetPage=true) {
				mAp.clickLogoutLink();
				Assert.assertTrue(false);
			}
			else {
				Assert.assertTrue(true);
			}
		}
	} 
	catch(Exception e) 
	{
		Assert.fail();
	}
	
	logger.info("**** Finished TC003_LoginDDT ****");
}
	
	
	
	
	
	
	
	
}
