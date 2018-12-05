package testClasses;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClass.DriverClass;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import pageObjectClasses.CreditCards;
import pageObjectClasses.HomeScreen;
import pageObjectClasses.LoginScreen;
import pageObjectClasses.Menu;
import pageObjectClasses.PasscodeScreen;
import pageObjectClasses.SettingsMenu;
import testListeners.SingleDataProvider;
import utlilty.WaitClass;

public class CreditCardTest {

	IOSDriver<MobileElement> driver;
	
	PasscodeScreen ob1;
	LoginScreen ob2;
	HomeScreen ob3;
	Menu ob4;
	SettingsMenu ob5;
	CreditCards ob6;
	
	@BeforeMethod
	public void beforeMethod(Object args[]){
		driver = DriverClass.set();
		ob1 = new PasscodeScreen(driver);
		ob2 = new LoginScreen(driver);
		ob3 = new HomeScreen(driver);
		ob4 = new Menu(driver);
		ob5 = new SettingsMenu(driver);
		ob6 = new CreditCards(driver);
		try{
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
			try{
				WaitClass.waitForElement(driver.findElement(MobileBy.AccessibilityId("Yes")), driver, 10000);
				driver.findElement(MobileBy.AccessibilityId("Yes")).click();
				ob1.enterPasscode((String)args[1]);
				ob1.enterPasscode((String)args[1]);
			}
			catch(Exception e){}
		}
		catch(Exception e){
			System.out.println("Exception in method : beforeMethod - Class : CreditCardTest"+e);
		}
	}
	
	@AfterMethod
	public void afterMethod(){
		try{
			try{
				ob5.swipeTillElement(ob5.signOut);
				ob5.signOut.click();
				ob5.yes.click();
				WaitClass.waitForElement(ob2.signInBtn, driver, 5000);
			}catch(Exception e){
				driver.resetApp();
				try{
						ob3.menuBtn.click();
						ob4.settingBtn.click();
						ob5.swipeTillElement(ob5.signOut);
						ob5.signOut.click();
						ob5.yes.click();
						WaitClass.waitForElement(ob2.signInBtn, driver, 5000);
					}
					catch(Exception g){}
				}
			
			driver.quit();
		}
		catch(Exception e){
			System.out.println("Exception in method : afterMethod - Class : CreditCardTest"+e);
		}
	}
	
	@Test(dataProvider="data" , dataProviderClass = SingleDataProvider.class)
	public void addCreditCard(String one, String two, String three, String four,String firstCard,String address, String cardNum, String expiry, String cvv, String name){
		try{
			WaitClass.waitForElement(ob3.header, driver, 10000);
			ob3.menuBtn.click();
			WaitClass.waitForElement(ob4.settingBtn, driver, 10000);
			ob4.settingBtn.click();
			WaitClass.waitForElement(ob5.settingsHeader, driver, 10000);
			ob5.creditCardsBtn.click();
			WaitClass.waitForElement(ob6.header, driver, 10000);
			int cards = ob6.cards.size();
			if(firstCard.equalsIgnoreCase("Y")){
				ob6.letsAddText.isDisplayed();
				ob6.addCreditCardBtn.click();
				WaitClass.waitForElement(ob6.addACardText, driver, 10000);
			}
			else{
				ob6.addNewCard.click();
				WaitClass.waitForElement(ob6.addACardText, driver, 10000);
			}
			ob6.enterAddress(address);
			ob6.addCredentials(cardNum, expiry, cvv, name);
			ob6.saveCardBtn.click();
			WaitClass.waitForElement(ob6.cardAddedSuccess, driver, 10000);
			boolean res = ob6.cardAddedSuccess.isDisplayed();
			ob6.continueBtn.click();
			WaitClass.waitForElement(ob6.header, driver, 10000);
			if(ob6.cards.size() == (cards+1)){
				ob6.backBtn.click();
				Assert.assertEquals(res, true);
			}
			else{
				ob6.backBtn.click();
				Assert.assertEquals(false, true);
			}
		}
		catch(Exception e){
			Assert.assertEquals(false, true);
		}
	}
	
}
