package testClasses;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClass.DriverClass;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import pageObjectClasses.HomeScreen;
import pageObjectClasses.ImportResults;
import pageObjectClasses.LoginScreen;
import pageObjectClasses.Menu;
import pageObjectClasses.PasscodeScreen;
import pageObjectClasses.SettingsMenu;
import testListeners.SingleDataProvider;
import utlilty.WaitClass;

public class ImportResultsTests {

	IOSDriver<MobileElement> driver;
	PasscodeScreen ob1;
	LoginScreen ob2;
	HomeScreen ob3;
	Menu ob4;
	ImportResults ob5;
	SettingsMenu ob6;
	
	@BeforeMethod
	public void beforeMethod(Object args[]){
		try{
			driver =  DriverClass.set();
			ob1 = new PasscodeScreen(driver);
			ob2 = new LoginScreen(driver);
			ob3 = new HomeScreen(driver);
			ob4 = new Menu(driver);
			ob5 = new ImportResults(driver);
			ob6 = new SettingsMenu(driver);
			if(((String) args[0]).equalsIgnoreCase("passcode")){
				ob1.enterPasscode((String)args[1]);
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
			System.out.println("Exception in method : beforeMethod - Class : ImportResultsTests"+e);
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
				WaitClass.waitForElement(ob2.signInBtn, driver,5000);
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
			System.out.println("Exception in method : afterMethod - Class : ImportResultsTests"+e);
		}
	}	
	
	@Test(dataProvider="data" ,  dataProviderClass = SingleDataProvider.class)
	public void importResults(String a, String b, String c, String d, String importedBefore,String firstRun, String swipes, String state, String physician, String address, String ssn){
		try{
			WaitClass.waitForElement(ob3.header, driver, 10000);
			ob3.menuBtn.click();
			WaitClass.waitForElement(ob4.importresultsBtn, driver, 10000);
			ob4.importresultsBtn.click();
			WaitClass.waitForElement(ob5.importResultsHeader, driver, 10000);
			if(firstRun.equalsIgnoreCase("Y")){
				int s = 0;
				s = Integer.parseInt(swipes);
				boolean re = ob5.isFirstRun(firstRun, s);
				Assert.assertEquals(re, true);
			}
			ob5.imported(importedBefore);
			WaitClass.waitForElement(ob5.importResultsHeader, driver, 10000);
			ob5.selectState(state);
			ob5.searchAndSelectPhysician(physician);
			WaitClass.waitForElement(ob5.importTestResults, driver, 10000);
			ob5.importTestResults.click();
			ob5.enterAddress(address);
			ob5.enterSSN(ssn);
			WaitClass.waitForElement(ob5.hipaaConsent, driver, 10000);
			ob5.hipaaConsent.isDisplayed();
			ob5.swipeContents();
			ob5.iAgreeBtn.click();
			try{
				driver.findElement(MobileBy.AccessibilityId("Don't Allow")).click();
			}
			catch(Exception e){}
			WaitClass.waitForElement(ob5.eSignature, driver, 10000);
			ob5.signature();
			ob5.doneBtn.click();
			WaitClass.waitForElement(ob5.reportRequestedText, driver, 10000);
			ob5.reportRequestedText.isDisplayed();
			ob5.okBtn.click();
			ob3.header.isDisplayed();
			Assert.assertEquals(true, true);
		}
		catch(Exception e){
			Assert.assertEquals(false, true);
		}
		
	}
	
}
