package pageObjectClasses;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class HomeScreen {

IOSDriver<MobileElement> driver;
	
	public HomeScreen(IOSDriver<MobileElement> driver){
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	/***ELEMENTS***/
	
	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeNavigationBar' AND name == 'SAFE' AND visible == 1")
	public IOSElement header;
	
	@iOSXCUITFindBy(accessibility="hamburger")
	public IOSElement menuBtn;
	

	/***ACTIONS***/
	
	public boolean checkName(String first , String last){
		try{
			driver.findElement(MobileBy.iOSNsPredicateString("name == '"+first+" "+last+"'"));
			return true;
		}
		catch(Exception e){
			System.out.println("Exception in method : checkName - Class : HomeScreen"+e);
			return false;
		}
	}
	
}
