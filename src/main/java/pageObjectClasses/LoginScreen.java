package pageObjectClasses;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.ios.IOSTouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.touch.offset.PointOption;

public class LoginScreen {

	IOSDriver<MobileElement> driver;
	
	public LoginScreen(IOSDriver<MobileElement> driver){
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	/***ELEMENTS***/
	
	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeButton' AND name == 'back arrow' AND visible == 1")
	public IOSElement backBtn;
	
	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeImage' AND name == 'SafeLogoWhite'")
	public IOSElement safeLogo;
	
	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeTextField' AND visible == 1")
	public IOSElement emailTextField;
	
	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeSecureTextField' AND visible == 1")
	public IOSElement passwordField;
	
	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeButton' AND name == 'FORGOT PASSWORD' AND visible == 1")
	public IOSElement forgotPasswordLink;
	
	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeButton' AND name == 'Join Now' AND visible == 1")
	public IOSElement joinNowBtn;
	
	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeButton' AND name == 'SIGN IN' AND visible == 1")
	public IOSElement signInBtn;
	
	@iOSXCUITFindBy(accessibility="Don't have an account?")
	public IOSElement dontHaveAccountText;
	
	
	/***ACTIONS***/
	
	public boolean login(String email, String password){
		try{
			IOSTouchAction ac = new IOSTouchAction(driver);
			emailTextField.sendKeys(email);
			passwordField.sendKeys(password);
			ac.tap(PointOption.point(100, 50)).perform();
			return true;
		}
		catch(Exception e){
			System.out.println("Exception in method : login - Class : LoginScreens"+e);
			return false;
		}
	}
		
}
