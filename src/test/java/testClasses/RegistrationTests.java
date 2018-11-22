package testClasses;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClass.DriverClass;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import pageObjectClasses.FirstSwipeScreen;
import pageObjectClasses.HomeScreen;
import pageObjectClasses.LoginScreen;
import pageObjectClasses.Menu;
import pageObjectClasses.PasscodeScreen;
import pageObjectClasses.Registration;
import pageObjectClasses.SettingsMenu;
import testListeners.SingleDataProvider;
import utlilty.WaitClass;

public class RegistrationTests {
	
IOSDriver<MobileElement> driver;
FirstSwipeScreen ob1;	
Registration ob2;
PasscodeScreen ob3;
LoginScreen ob4;
SettingsMenu ob5;
Menu ob6;
HomeScreen ob7;

@BeforeMethod
public void beforeMethod(Object args[]){
	driver = DriverClass.set();
	ob1 = new FirstSwipeScreen(driver);	
	ob2 = new Registration(driver);
	ob3 = new PasscodeScreen(driver);
	ob4 = new LoginScreen(driver);
	ob5 = new SettingsMenu(driver);
	ob6 = new Menu(driver);
	ob7 = new HomeScreen(driver);
	try{
		if(((String) args[0]).equalsIgnoreCase("Y")){
			 ob1.swipeLeft();
			 ob1.swipeLeft();
			 ob1.swipeLeft();
			 ob1.swipeLeft();
		}
		else{
			  try{
				ob3.cancelBtn.click();
			  }
			  catch(Exception e){}
			  ob4.joinNowBtn.click();
		  }
		WaitClass.waitForElement(ob2.firstNameField, driver, 10000);
	}
	catch(Exception e){
		System.out.println("Exception in method : beforeMethod - Class : RegistrationTests"+e);
	}
}

@AfterMethod
public void afterMethod(){
	try{
		try{
			ob7.menuBtn.click();
			ob6.settingBtn.click();
			ob5.swipeTillElement(ob5.signOut);
			ob5.signOut.click();
			ob5.yes.click();
		}
		catch(Exception e){
			try{
				driver.resetApp();
				ob7.menuBtn.click();
				ob6.settingBtn.click();
				ob5.swipeTillElement(ob5.signOut);
				ob5.signOut.click();
				ob5.yes.click();
			}
			catch(Exception g){}
		}
		driver.quit();
	}
	catch(Exception e){
		System.out.println("Exception in method : afterMethod - Class : RegistrationTests"+e);
	}
}

  @Test(dataProvider="data" , dataProviderClass = SingleDataProvider.class)	
  public void register(String a, String firstName, String lastName, String email, String password, String gender, String date, String month, String year, String zip, String phone, String chanceEmail, String newEmail, String passcode) {
	  try{
		  ob2.fillSignUpDetails(firstName, lastName, email, password);
		  ob2.selectedCheckBox.isDisplayed();
		  ob2.continueBtn.click();
		  WaitClass.waitForElement(ob2.personalInfoHeader, driver, 10000);
		  ob2.fillPersonalDetails(gender, date, month, year, zip);
		  ob2.joinSafeBtn.click();
		  WaitClass.waitForElement(ob2.authenticateDeviceText, driver, 10000);
		  ob2.addPhoneNumber(phone);
		  ob2.sendVerificationBtn.click();
		  WaitClass.waitForElement(ob2.enterVerificationText, driver, 10000);
		  ob2.mobileVerificationCode();
		  ob2.continueBtn.click();
		  WaitClass.waitForElement(ob2.verifyEmailText, driver, 10000);
		  ob2.verifyEmail(chanceEmail, newEmail);
		  ob2.verifyEmailBtn.click();
		  ob2.getEmailVerificationCode();
		  ob2.continueBtn.click();
		  WaitClass.waitForElement(ob2.addYourPhotoText, driver, 10000);
		  ob2.laterBtn.click();
		  WaitClass.waitForElement(ob3.setPasscodeHeader, driver, 10000);
		  ob3.enterPasscode(passcode);
		  ob3.enterPasscode(passcode);
		  WaitClass.waitForElement(ob2.accountCreatedText,driver,10000);
		  ob2.okBtn.click();
		  WaitClass.waitForElement(ob2.welcomeDesc, driver, 10000);  	
		  boolean res = ob2.checkWelcomeMsg();
		  ob2.cancelBtn.click();
		  Assert.assertEquals(res, true);
	  }
	  catch(Exception e){
		  Assert.assertEquals(false, true);
	  }
  }
}
