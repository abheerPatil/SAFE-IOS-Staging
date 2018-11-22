package pageObjectClasses;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import utlilty.WaitClass;

public class MyInsurance {

	IOSDriver<MobileElement> driver;
	int count = 0;
	
	public MyInsurance(IOSDriver<MobileElement> driver){
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	/***ELEMENTS***/
	
	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeNavigationBar' AND name =='My Insurance' AND visible == 1")
	public IOSElement myInsuranceHeader; 
	
	@iOSXCUITFindBy(accessibility="cancelArrow")
	public IOSElement cancelBtn;
	
	@iOSXCUITFindBy(accessibility="Let’s Look Up Your Insurance")
	public IOSElement letsLookUpText;
	
	@iOSXCUITFindBy(accessibility="Save your time & money.")
	public IOSElement saveUrTimeText;
	
	@iOSXCUITFindBy(accessibility="ADD MY INSURANCE")
	public IOSElement addMyInsuranceBtn;
	
	@iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeTextField[1]")
	public IOSElement findInsuranceProvider;
	
	@iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeTextField[2]")
	public IOSElement insuranceId;
	
	@iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeTextField[3]")
	public IOSElement groupId;
	
	@iOSXCUITFindBy(accessibility="What state is your insurance located?")
	public IOSElement whatStateText;
	
	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeNavigationBar' AND name =='Find Provider' AND visible == 1")
	public IOSElement findProviderText; 
	
	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeNavigationBar' AND name =='Select Provider' AND visible == 1")
	public IOSElement selectProviderText;
	
	@iOSXCUITFindBy(className="XCUIElementTypeTextField")
	public IOSElement selectProviderTextField;
	
	@iOSXCUITFindBy(className="XCUIElementTypeCell")
	public IOSElement firstSearchedProvider;
	
	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeImage' AND name == 'spinner' AND visible == 1")
	public IOSElement spinner;
	
	@iOSXCUITFindBy(accessibility="Verifying Eligibility")
	public IOSElement verifyingText;
	
	@iOSXCUITFindBy(accessibility="Btn White Round Close Btn")
	public IOSElement roundCloseBtn;
	
	@iOSXCUITFindBy(accessibility="InsuranceVerificationPassedImage")
	public IOSElement insuranceAcceptedPic;
	
	@iOSXCUITFindBy(iOSNsPredicate="name CONTAINS 'Accepted'")
	public IOSElement insuranceAcceptedText;
	
	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeButton' AND name == 'CONTINUE' AND visible == 1")
	public IOSElement continueBtn;
	
	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeButton' AND name == 'CONFIRM & CONTINUE' AND visible == 1")
	public IOSElement confirmAndContinueBtn;
	
	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeTable' AND visible == 1")
	public IOSElement stateTable;
	
	
	/***ACTIONS***/
	
	public boolean enterDetails(String state, String providerName, String insuranceID, String groupNum){
		try{
			boolean a = true;
			int count = 0;
			selectProviderTextField.click();
			WaitClass.waitForElement(findInsuranceProvider, driver, 10000);
			while(a == true){
				try{
					driver.findElement(MobileBy.iOSNsPredicateString("name == '"+state+"' AND visible == 1")).click();
					a = false;
					break;
				}
				catch(Exception e){
					swipe();
					count++;
					if(count == 4){
						a = false;
						break;
					}
				}
			}
			a = true;
			WaitClass.waitForElement(selectProviderText, driver, 10000);
			selectProviderTextField.sendKeys(providerName);
			while(a == true){
				count ++;
				selectProviderText.sendKeys(" ");
				List<MobileElement> ele = driver.findElements(MobileBy.className("XCUIElementTypeCell"));
				if(ele.size() == 1){
					a = false;
					break;
				}
				if(count == 10){
					a = false;
					break;
				}
			}
			WaitClass.waitForElement(firstSearchedProvider, driver, 10000);
			firstSearchedProvider.click();
			WaitClass.waitForElement(myInsuranceHeader, driver, 10000);
			insuranceId.clear();
			insuranceId.sendKeys(insuranceID);
			groupId.clear();
			groupId.sendKeys(groupNum);
			try{
				driver.findElement(MobileBy.AccessibilityId("Done")).click();
			}
			catch(Exception e){
				confirmAndContinueBtn.click();
			}
			return true;
		}
		catch(Exception e){
			System.out.println("Exception in method : enterDetails - Class : MyInsurance"+e);
			return false;
		}
	}
	
	public boolean swipe(){
		try{
			JavascriptExecutor js = (JavascriptExecutor) driver;
			Map<String, Object> params = new HashMap<String , Object>();
			params.put("direction", "up");
			params.put("element", stateTable.getId());
			js.executeScript("mobile: swipe", params);
			count = 0;
			return true;
		}
		catch(Exception e){
			count++;
			System.out.println("Exception in method : swipe - Class : MyInsurance"+e);
			return false;
		}
	}
	
	
}
