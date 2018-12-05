package testClasses;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClass.DriverClass;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import pageObjectClasses.HomeScreen;
import pageObjectClasses.LoginScreen;
import pageObjectClasses.Menu;
import pageObjectClasses.MyInsurance;
import pageObjectClasses.PasscodeScreen;
import pageObjectClasses.SettingsMenu;
import testListeners.SingleDataProvider;
import utlilty.WaitClass;

public class InsuranceTests {

	IOSDriver<MobileElement> driver;
	PasscodeScreen ob1;
	LoginScreen ob2;
	HomeScreen ob3;
	Menu ob4;
	MyInsurance ob5;
	SettingsMenu ob6;
	
	@BeforeMethod
	public void beforeMethod(Object args[]){
		try{
			driver = DriverClass.set();
			ob1 = new PasscodeScreen(driver);
			ob2 = new LoginScreen(driver);
			ob3 = new HomeScreen(driver);
			ob4 = new Menu(driver);
			ob5 = new MyInsurance(driver);
			ob6 = new SettingsMenu(driver);
			if(((String) args[0]).equalsIgnoreCase("passcode")){
				ob1.enterPasscode((String) args[1]);
			}
			else{
				try{
					ob1.cancelBtn.click();
				}
				catch(Exception e){}
				ob2.login((String)args[2], (String)args[3]);
				ob2.signInBtn.click();
			}
			WaitClass.waitForElement(ob3.header, driver, 10000);
			
		}
		catch(Exception e){
			System.out.println("Exception in method : beforeMethod - Class : InsuranceTests"+e);
		}
	}
	
	@AfterMethod
	public void afterMethod(){
		try{
			try{
				ob3.menuBtn.click();
				ob4.settingBtn.click();
				ob6.swipeTillElement(ob6.signOut);
				ob6.signOut.click();
				ob6.yes.click();
				WaitClass.waitForElement(ob2.signInBtn, driver, 5000);
			}
			catch(Exception e){
				try{
					driver.resetApp();
					ob3.menuBtn.click();
					ob4.settingBtn.click();
					ob6.swipeTillElement(ob6.signOut);
					ob6.signOut.click();
					ob6.yes.click();
					WaitClass.waitForElement(ob2.signInBtn, driver, 5000);
				}
				catch(Exception g){}
			}
			driver.quit();
		}
		catch(Exception e){
			System.out.println("Exception in method : afterMethod - Class : InsuranceTests"+e);
		}
	}
	
	@Test(dataProvider="data" , dataProviderClass = SingleDataProvider.class)
	public void addinsurance(String one, String two, String three, String four,String firstRun, String address, String state, String provider, String insuranceId, String groupNum){
		try{
			WaitClass.waitForElement(ob3.header, driver, 10000);
			ob3.menuBtn.click();
			WaitClass.waitForElement(ob4.settingBtn, driver, 10000);
			ob4.myInsuranceBtn.click();
			WaitClass.waitForElement(ob5.myInsuranceHeader, driver, 10000);
			if(firstRun.equalsIgnoreCase("Y")){
				ob5.addMyInsuranceBtn.click();
				WaitClass.waitForElement(ob5.myInsuranceHeader, driver, 10000);
				ob5.enterAddress(address);
			}
			ob5.selectProvider(state, provider);
			ob5.enterDetails(insuranceId, groupNum);
			if(firstRun.equalsIgnoreCase("Y")){
				ob5.addMyInsuranceBtn.click();
			}
			else{
				ob5.confirmAndContinueBtn.click();
			}
			WaitClass.waitForElement(ob5.insuranceAcceptedText, driver, 10000);
			ob5.insuranceAcceptedText.isDisplayed();
			ob5.continueBtn.click();
			boolean res = ob3.header.isDisplayed();
			Assert.assertEquals(res, true);
		}
		catch(Exception e){
			Assert.assertEquals(false, true);
		}
	}
	
}
