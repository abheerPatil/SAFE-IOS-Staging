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

public class SettingsMenu {

	IOSDriver<MobileElement> driver;
	
	public SettingsMenu(IOSDriver<MobileElement> driver){
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	/***ELEMENTS***/
	
	@iOSXCUITFindBy(iOSNsPredicate="name == 'Settings' AND visible == 1")
	public IOSElement settingsHeader;
	
	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeButton' AND name == 'cancelArrow'")
	public IOSElement cancelArrow;
	
	@iOSXCUITFindBy(accessibility="Payment Method")
	public IOSElement creditCardsBtn;
	
	@iOSXCUITFindBy(iOSNsPredicate="name == 'SIGN OUT' AND visible == 1")
	public IOSElement signOut;
	
	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeTable' AND visible == 1")
	public IOSElement settingsTable;
	
	@iOSXCUITFindBy(accessibility="Yes")
	public IOSElement yes;
	
	@iOSXCUITFindBy(accessibility="No")
	public IOSElement no;
	
	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeAlert' AND name =='SAFE'")
	public IOSElement alertBox;
	
	/***ACTIONS***/
	
	public boolean swipeTillElement(IOSElement element){
		try{
			int count = 0;
			while(true){
				try{
					count++ ;
					if(count == 4){
						break;
					}
					element.isDisplayed();
					break;
				}
				catch(Exception e){
					swipe();
				}
			}
			return true;
		}
		catch(Exception e){
			return false;
		}
	}
	
	public boolean swipe(){
		try{
			JavascriptExecutor js = (JavascriptExecutor) driver;
			Map<String, Object> params = new HashMap<String , Object>();
			params.put("direction", "up");
			params.put("element", settingsTable.getId());
			js.executeScript("mobile: swipe", params);
			return true;
		}
		catch(Exception e){
			System.out.println("Exception in method : swipe - Class : MyInsurance "+e);
			return false;
		}
	}
	
}
