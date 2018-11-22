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
import io.appium.java_client.ios.IOSTouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.touch.offset.PointOption;
import utlilty.WaitClass;

public class ImportResults {

	IOSDriver<MobileElement> driver;
	
	public ImportResults(IOSDriver<MobileElement> driver){
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	String physicianName ;
	boolean firstRun = false;
	
	/***ELEMENTS***/
	
	@iOSXCUITFindBy(className="XCUIElementTypeCollectionView")
	public IOSElement body;
	
	@iOSXCUITFindBy(accessibility="Securely import your recent Test Results from pretty much any physician, clinic, or lab")
	public IOSElement page1;
	
	@iOSXCUITFindBy(accessibility="Results are never shared or displayed anywhere other than on your own phone")
	public IOSElement page2;
	
	@iOSXCUITFindBy(accessibility="SAFE is a licensed healthcare provider bound to all privacy rules under HIPAA")
	public IOSElement page3;
	
	@iOSXCUITFindBy(className="XCUIElementTypePageIndicator")
	public IOSElement paginationIndicator;
	
	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeButton' AND visible == 1")
	public IOSElement skipDoneBtn;
	
	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeNavigationBar' AND name == 'Import Test Results'")
	public IOSElement importResultsHeader;
	
	@iOSXCUITFindBy(className="XCUIElementTypeTable")
	public IOSElement stateTable;
	
	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeButton' AND name == 'smallRightArrow'")
	public IOSElement footerBtn;
	
	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeNavigationBar' AND name == 'Find Your Physician'")
	public IOSElement findPhysicianHeader;
	
	@iOSXCUITFindBy(className="XCUIElementTypeTextField")
	public IOSElement physicianTextField;
	
	@iOSXCUITFindBy(className="XCUIElementTypeCell")
	public IOSElement firstRow;
	
	@iOSXCUITFindBy(accessibility="You are authorizing SAFE to retrieve your Test Results from your provider.")
	public IOSElement authorizingText;
	
	@iOSXCUITFindBy(accessibility = "IMPORT TEST RESULTS")
	public IOSElement importTestResults;
	
	@iOSXCUITFindBy(accessibility="Enter Your Address")
	public IOSElement enterAddressText;
	
	@iOSXCUITFindBy(className="XCUIElementTypeTextField")
	public IOSElement addressTextField;
	
	@iOSXCUITFindBy(accessibility = "CONTINUE")
	public IOSElement continueBtn;
	
	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeButton' AND name == 'Cancel'")
	public IOSElement cancelBtn;
	
	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeSearchField'")
	public IOSElement searchField;
	
	@iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeCell[1]")
	public IOSElement addressSelect;
	
	@iOSXCUITFindBy(iOSNsPredicate="name CONTAINS 'SSN'")
	public IOSElement ssnText;
	
	@iOSXCUITFindBy(className="XCUIElementTypeSecureTextField")
	public IOSElement ssnField;
	
	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeButton' AND name == 'NEXT'")
	public IOSElement nextBtn;
	
	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeImage' AND name == 'spinner' AND visible == 1")
	public IOSElement spinner;
	
	@iOSXCUITFindBy(iOSNsPredicate="name CONTAINS 'Thank you'")
	public IOSElement thankYouText;
	
	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeNavigationBar' AND name == 'HIPAA Consent'")
	public IOSElement hipaaConsent;
	
	@iOSXCUITFindBy(className="XCUIElementTypeWebView")
	public IOSElement view;
	
	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeButton' AND name == 'I AGREE'")
	public IOSElement iAgreeBtn;
	
	@iOSXCUITFindBy(accessibility="eSignature")
	public IOSElement eSignature;
	
	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeImage' AND visible == 1")
	public IOSElement signatureForm;
	
	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeButton' AND name == 'DONE'")
	public IOSElement doneBtn;
	
	@iOSXCUITFindBy(accessibility="Lab Report Requested")
	public IOSElement reportRequestedText;
	
	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeButton' AND name == 'OK'")
	public IOSElement okBtn;
	
	
	/***ACTIONS***/
	
	public boolean isFirstRun(String ans , int noSwipe){
		try{
			if(ans.equalsIgnoreCase("y")){
				firstRun = true;
				if(noSwipe>0){
					for(int i = 0 ; i < noSwipe; i++){
						swipe("left", body);
					}
					if(noSwipe<3){
						skipDoneBtn.click();
					}
				}
				else{
					skipDoneBtn.click();
				}
				
			}
			return true;
		}
		catch(Exception e){
			System.out.println("Exception in method : isFirstRun - Class : ImportResults"+e);
			return false;
		}
	}
	
	public boolean swipe(String direction , IOSElement element){
		try{
			JavascriptExecutor js = (JavascriptExecutor) driver;
			Map<String, Object> params = new HashMap<String , Object>();
			params.put("direction", direction);
			params.put("element", element.getId());
			js.executeScript("mobile: swipe", params);
			return true;
		}
		catch(Exception e){
			System.out.println("Exception in method : swipe - Class : ImportResults"+e);
			return false;
		}
	}
	
	public boolean selectState(String state){
		try{
			while(true){
				try{
					driver.findElement(MobileBy.iOSNsPredicateString("name == '"+state+"' AND visible == 1")).click();
					break;
				}
				catch(Exception e){
					swipe("up" , stateTable);
				}
			}
			return true;
		}
		catch(Exception e){
			System.out.println("Exception in method : selectState - Class : ImportResults"+e);
			return false;
		}
	}
	
	public boolean searchAndSelectPhysician(String physician){
		try{
			int count = 0;
			physicianTextField.sendKeys(physician);
			while(true){
				count ++;
				physicianTextField.sendKeys(" ");
				List<MobileElement> ele = driver.findElements(MobileBy.className("XCUIElementTypeCell"));
				if(ele.size() == 1){
					break;
				}
				if(count == 10){
					break;
				}
			}
			physicianName = firstRow.findElement(MobileBy.iOSClassChain("**/XCUIElementTypeStaticText[2]")).getAttribute("name");
			firstRow.click();
			return true;
		}
		catch(Exception e){
			System.out.println("Exception in method : searchAndSelectPhysician - Class : ImportResults"+e);
			return false;
		}
	}
	
	public boolean enterAddress(String address){
		try{
			if(firstRun == true){
				WaitClass.waitForElement(addressTextField, driver, 10000);
				addressTextField.click();
				searchField.sendKeys(address);
				addressSelect.click();
				WaitClass.waitForElement(continueBtn, driver, 10000);
				continueBtn.click();
			}
			return true;
		}
		catch(Exception e){
			System.out.println("Exception in method : enterAddress - Class : ImportResults"+e);
			return false;
		}
	}
	
	
	public boolean enterSSN(String ssn){
		try{
			if(firstRun == true){
				WaitClass.waitForElement(ssnText, driver, 10000);
				ssnText.isDisplayed();
				ssnField.sendKeys(ssn);
				nextBtn.click();
				spinner.isDisplayed();
				WaitClass.waitForElement(thankYouText, driver, 10000);
				thankYouText.isDisplayed();
				continueBtn.click();
			}
			return true;
		}
		catch(Exception e){
			System.out.println("Exception in method : enterSSN - Class : ImportResults"+e);
			return false;
		}
	}
	
	public boolean swipeContents(){
		try{
			while(true){
				if(iAgreeBtn.getAttribute("enabled").equals("true")){
					break;
				}
				else{
					swipe("up", view);
				}
			}
			return true;
		}
		catch(Exception e){
			System.out.println("Exception in method : swipeContents - Class : ImportResults"+e);
			return false;
		}
	}
	
	public boolean signature(){
		try{
			int x  = signatureForm.getRect().getX() + 10;
			int y = signatureForm.getRect().getY() + 10;
			IOSTouchAction ac = new IOSTouchAction(driver);
			ac.longPress(PointOption.point(x, y)).moveTo(PointOption.point(x+20, y+5)).release().perform();	
			return true;
		}
		catch(Exception e){
			System.out.println("Exception in method : signature - Class : ImportResults"+e);
			return false;
		}
	}
	
	
	
	
	
}
