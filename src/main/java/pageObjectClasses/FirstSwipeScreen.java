package pageObjectClasses;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class FirstSwipeScreen {
 
	IOSDriver<MobileElement> driver;
	
	public FirstSwipeScreen(IOSDriver<MobileElement> driver){
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
/** Elements **/	
	
	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeImage' AND name == 'headerWithLogoOnboarding' AND visible == 1")
	public IOSElement safeLogo;
	
	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeImage' AND name == 'icOnboardingA' AND visible == 1")
	public IOSElement pageOnePic;

	@iOSXCUITFindBy(accessibility="Import Results")
	public IOSElement importResultsText;

	@iOSXCUITFindBy(accessibility="Securely import your recent Test Results from pretty much any physician, clinic, or lab")
	public IOSElement pageOneDesc;

	@iOSXCUITFindBy(className="XCUIElementTypePageIndicator")
	public IOSElement pagination;

	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeButton' AND name == 'SIGN IN' AND visible == 1")
	public IOSElement signInBtn;
	
	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeButton' AND name = 'JOIN NOW' AND visible == 1")
	public IOSElement joinNowBtn;
	
	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeImage' AND name == 'icOnboardingC' AND visible == 1")
	public IOSElement pageTwoPic;

	@iOSXCUITFindBy(accessibility="Show Your Status")
	public IOSElement showStatusText;

	@iOSXCUITFindBy(accessibility="Test results are never shared or displayed anywhere but the screen of your phone")
	public IOSElement pageTwoDesc;
	
	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeImage' AND name == 'icOnboardingB' AND visible == 1")
	public IOSElement pageThreePic;

	@iOSXCUITFindBy(accessibility="Get Tested")
	public IOSElement getTestedText;

	@iOSXCUITFindBy(accessibility="Schedule testing at thousands of locations for just $99 or use your insurance to pay for it")
	public IOSElement pageThreeDesc;
	
	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeImage' AND name == 'icOnboardingD' AND visible == 1")
	public IOSElement pageFourPic;

	@iOSXCUITFindBy(accessibility="Private and Secure")
	public IOSElement privateSecureText;

	@iOSXCUITFindBy(accessibility="SAFE is fully HIPAA compliant and uses blockchain technology to protect your privacy")
	public IOSElement pageFourDesc;
	
	@iOSXCUITFindBy(className="XCUIElementTypeCollectionView")
	public IOSElement view;
	
	
	/**ACTIONS**/
	
	public boolean swipeLeft(int till){
		try{
			for(int i = 0 ; i < till; i++){
				JavascriptExecutor js = (JavascriptExecutor) driver;
				Map<String, Object> params = new HashMap<String,Object>();
				params.put("direction", "left");
				params.put("element", view.getId());
				js.executeScript("mobile: swipe", params);
			}
			return true;
		}
		catch(Exception e){
			System.out.println("Exception in method : swipeLeft - Class : FirstSwipeScreen"+e);
			return false;
		}
	}
	
	
}
