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

public class Menu {
	
	IOSDriver<MobileElement> driver;
	
	public Menu(IOSDriver<MobileElement> driver){
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	/***ELEMENTS***/
	
	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeButton' AND name == 'SCHEDULE TESTING'")
	public IOSElement scheduleTestingBtn;
	
	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeButton' AND name == 'IMPORT RESULTS'")
	public IOSElement importresultsBtn;
	
	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeButton' AND name == 'My Insurance'")
	public IOSElement myInsuranceBtn;
	
	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeButton' AND name == 'Settings'")
	public IOSElement settingBtn;
	
	
	
	/***ACTIONS***/
	
	public boolean swipeTill(IOSElement element){
		try{
			while(true){
				if(element.getAttribute("visible").equals("true")){
					break;
				}
				JavascriptExecutor js = (JavascriptExecutor) driver;
				Map<String, Object> params = new HashMap<String, Object>();
				params.put("direction", "down");
				params.put("element", element.getId());
				js.executeScript("mobile: swipe", params);
			}
			return true;
		}
		catch(Exception e){
			System.out.println("Exception in method : swipeTill - Class : Menu"+e);
			return false;
		}
	}
	
	
	
	
	

}
