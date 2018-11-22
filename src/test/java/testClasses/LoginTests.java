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
import pageObjectClasses.LoginScreen;
import pageObjectClasses.Menu;
import pageObjectClasses.PasscodeScreen;
import pageObjectClasses.Registration;
import pageObjectClasses.SettingsMenu;
import testListeners.SingleDataProvider;
import utlilty.WaitClass;

public class LoginTests {
	
	IOSDriver<MobileElement> driver;
	boolean newApp = false;
	boolean newLogin = false;
	
	LoginScreen ob1;
	HomeScreen ob2;
	PasscodeScreen ob3;
	Registration ob4;
	SettingsMenu ob5;
	Menu ob6;

	
	@BeforeMethod
	public void beforeMethod(Object args[]){
		driver = DriverClass.set();
		ob1 = new LoginScreen(driver);
		ob2 = new HomeScreen(driver);
		ob3 = new PasscodeScreen(driver);
		ob4 = new Registration(driver);
		ob5 = new SettingsMenu(driver);
		ob6 = new Menu(driver);
		try{
			if(((String) args[0]).equalsIgnoreCase("Y")){
				newApp = true;
				try{
					ob4.signInBtn.click();
				}
				catch(Exception f){}
			}
			if(((String) args[1]).equalsIgnoreCase("Y")){
				newLogin = true;
			}
		}
		catch(Exception e){
			System.out.println("Exception in method : beforeMethod - Class : LoginTests"+e);
		}
	}
	
	@AfterMethod
	public void afterMethod(){
		try{
			try{
				ob2.menuBtn.click();
				ob6.settingBtn.click();
				ob5.swipeTillElement(ob5.signOut);
				ob5.signOut.click();
				ob5.yes.click();
			}catch(Exception e){}
			driver.quit();
		}
		catch(Exception e){
			System.out.println("Exception in method : afterMethod - Class : LoginTests"+e);
		}
	}
	
	@Test(dataProvider="data" , dataProviderClass= SingleDataProvider.class)
	public void positiveLoginWithEmail(String newAppRun, String newLoginRun, String email, String password, String passcode, String firstName, String lastName){
		try{
			if(newApp == false){
				try{
					ob3.cancelBtn.click();
				}
				catch(Exception e){}
			}
			ob1.login(email, password);
			ob1.signInBtn.click();
			WaitClass.waitForElement(ob2.header, driver, 10000);
			try{
				WaitClass.waitForElement(driver.findElement(MobileBy.AccessibilityId("Yes")), driver, 10000);
				driver.findElement(MobileBy.AccessibilityId("Yes")).click();
				ob3.enterPasscode(passcode);
				ob3.enterPasscode(passcode);
			}
			catch(Exception e){}
			WaitClass.waitForElement(ob2.header, driver, 10000);
			boolean res = ob2.checkName(firstName, lastName);
			Assert.assertEquals(res, true);
		}
		catch(Exception e){
			Assert.assertEquals(false, true);
		}
	}

}
