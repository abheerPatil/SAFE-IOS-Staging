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
	
	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeNavigationBar' AND name =='Add My Insurance' AND visible == 1")
	public IOSElement myInsuranceHeader; 
	
	@iOSXCUITFindBy(accessibility="cancelArrow")
	public IOSElement cancelBtn;
	
	@iOSXCUITFindBy(accessibility="Let’s Look Up Your Insurance")
	public IOSElement letsLookUpText;
	
	@iOSXCUITFindBy(accessibility="Save your time & money.")
	public IOSElement saveUrTimeText;
	
	@iOSXCUITFindBy(accessibility="ADD MY INSURANCE")
	public IOSElement addMyInsuranceBtn;
	
	@iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeTextField[`visible = 1`][1]")
	public IOSElement addressField;
	
	@iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeTextField[`visible = 1`]")
	public List<IOSElement> totalTextFields;
	
	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeTextField' AND value == 'Apt/Ste (Optional)'")
	public IOSElement streetTextField;
	
	@iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeTextField[`visible = 1`][2]")
	public IOSElement findInsuranceProvider;
	
	@iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeTextField[`visible = 1`][3]")
	public IOSElement findInsuranceProviderWithoutCurrent;
	
	@iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeTextField[`visible = 1`][3]")
	public IOSElement insuranceId;
	
	@iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeTextField[`visible = 1`][4]")
	public IOSElement insuranceIdWithourCurrent;
	
	@iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeTextField[`visible = 1`][4]")
	public IOSElement groupId;
	
	@iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeTextField[`visible = 1`][5]")
	public IOSElement groupIdWithoutCurrent;
	
	@iOSXCUITFindBy(accessibility="What state is your insurance located?")
	public IOSElement whatStateText;
	
	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeNavigationBar' AND name =='Find Provider' AND visible == 1")
	public IOSElement findProviderText; 
	
	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeNavigationBar' AND name =='Select Provider' AND visible == 1")
	public IOSElement selectProviderText;
	
	@iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeTextField[`visible = 1`]")
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
	
	@iOSXCUITFindBy(accessibility="Toolbar Done Button")
	public IOSElement toolbarDoneBtn;
	
	@iOSXCUITFindBy(accessibility="Done")
	public IOSElement keyboardDoneBtn;
	
	
	/***ACTIONS***/
	
	public boolean enterAddress(String address){
		try{
			addressField.clear();
			addressField.sendKeys(address);
			WaitClass.waitForElement(letsLookUpText, driver, 10000);
			try{
				driver.findElement(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeCell' AND visible == 1")).click();
			}
			catch(Exception e){
				toolbarDoneBtn.click();
			}
			WaitClass.waitForElement(myInsuranceHeader, driver, 10000);
			return true;
		}
		catch(Exception e){
			System.out.println("Exception in method : enterAddress - Class : MyInsurance"+e);
			return false;
		}
	}
	
	public boolean selectProvider(String state, String providerName){
		try{
			WaitClass.waitForElement(myInsuranceHeader, driver, 10000);
			boolean a = true;
			int count = 0;
			int fields = totalTextFields.size();
			try{
				streetTextField.isDisplayed();
				fields = 5;
			}
			catch(Exception e){}
			if(fields == 5){
				findInsuranceProviderWithoutCurrent.click();
			}
			else{
				findInsuranceProvider.click();
			}
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
			selectProviderTextField.sendKeys(providerName);
			selectProviderText.sendKeys(" ");
			WaitClass.waitForElement(myInsuranceHeader, driver, 10000);
			WaitClass.waitForElement(firstSearchedProvider, driver, 10000);
			firstSearchedProvider.click();			
			WaitClass.waitForElement(myInsuranceHeader, driver, 10000);
			return true;
		}
		catch(Exception e){
			System.out.println("Exception in method : selectProvider - Class : MyInsurance"+e);
			return false;
		}
	}
	
	public boolean enterDetails(String insuranceID, String groupNum){
		try{
			if(totalTextFields.size() == 4){
				insuranceId.clear();
				insuranceId.sendKeys(insuranceID);
				toolbarDoneBtn.click();
				groupId.clear();
				groupId.sendKeys(groupNum);
			}
			else{
				insuranceIdWithourCurrent.clear();
				insuranceIdWithourCurrent.sendKeys(insuranceID);
				toolbarDoneBtn.click();
				groupIdWithoutCurrent.clear();
				groupIdWithoutCurrent.sendKeys(groupNum);
			}
			toolbarDoneBtn.click();
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
