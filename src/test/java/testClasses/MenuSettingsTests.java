package testClasses;

import java.util.ArrayList;

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
import pageObjectClasses.PasscodeScreen;
import pageObjectClasses.SettingsMenu;
import utlilty.WaitClass;

public class MenuSettingsTests {

	IOSDriver<MobileElement> driver;
	PasscodeScreen ob1;
	LoginScreen ob2;
	HomeScreen ob3;
	Menu ob4;
	SettingsMenu ob5;
	
	@BeforeMethod
	public void beforeMethod(){
		try{
			driver = DriverClass.set();
			ob1 = new PasscodeScreen(driver);
			ob2 = new LoginScreen(driver);
			ob3 = new HomeScreen(driver);
			ob4 = new Menu(driver);
			ob5 = new SettingsMenu(driver);
			ArrayList<String> array = new ArrayList<String>();												
			if("passcode".equals("passcode")){																
				ob1.enterPasscode("1234");
			}
			else{
				try{
					ob1.cancelBtn.click();
				}
				catch(Exception e){}
				ob2.login(array.get(0), array.get(1));
				ob2.signInBtn.click();
			}
			WaitClass.waitForElement(ob3.header, driver, 10000);
			ob3.menuBtn.click();
			WaitClass.waitForElement(ob4.settingBtn, driver, 10000);
			ob4.settingBtn.click();
			WaitClass.waitForElement(ob5.settingsHeader, driver, 10000);
		}
		catch(Exception e){
			System.out.println("Exception in method : beforeMethod - Class : MenuSettingsTests"+e);
		}
	}
	
	@AfterMethod
	public void afterMethod(){
		try{
			driver.quit();
		}
		catch(Exception e){
			System.out.println("Exception in method : afterMethod - Class : MenuSettingsTests"+e);
		}
	}
	
	@Test
	public void logOut(){
		try{
			ob5.swipeTillElement(ob5.signOut);
			ob5.signOut.click();
			ob5.alertBox.isDisplayed();
			ob5.yes.click();
			try{
				ob1.enterPasscodeText.isDisplayed();
				ob1.cancelBtn.click();
			}
			catch(Exception e){}
			ob2.emailTextField.isDisplayed();
			Assert.assertEquals(true, true);
		}
		catch(Exception e){
			Assert.assertEquals(false, true);
		}
	}
	
}
