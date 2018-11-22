package pageObjectClasses;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class PasscodeScreen {
	
	IOSDriver<MobileElement> driver;
	
	public PasscodeScreen(IOSDriver<MobileElement> driver){
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	/***Elements**/
	
	@iOSXCUITFindBy(accessibility = "Set Passcode")
	public IOSElement setPasscodeHeader;
	
	@iOSXCUITFindBy(accessibility = "Set passcode for secure identification")
	public IOSElement setPasscodeDescription;
	
	@iOSXCUITFindBy(accessibility = "Please enter your passcode")
	public IOSElement enterPasscodeText;
	
	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeButton' AND name == 'Cancel'")
	public IOSElement cancelBtn;
	
	@iOSXCUITFindBy(accessibility = "Re-enter Passcode")
	public IOSElement reEnterPasscodeDescription;
	
	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeButton' AND name == '1 1'")
	public IOSElement btn1;
	
	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeButton' AND name == '2 1'")
	public IOSElement btn2;
	
	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeButton' AND name == '3 1'")
	public IOSElement btn3;
	
	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeButton' AND name == '4 1'")
	public IOSElement btn4;
	
	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeButton' AND name == '5 1'")
	public IOSElement btn5;
	
	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeButton' AND name == '6 1'")
	public IOSElement btn6;
	
	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeButton' AND name == '7 1'")
	public IOSElement btn7;
	
	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeButton' AND name == '8 1'")
	public IOSElement btn8;
	
	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeButton' AND name == '9 1'")
	public IOSElement btn9;
	
	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeButton' AND name == '0 1'")
	public IOSElement btn0;
	
	
	/***ACTION***/
	
	public boolean enterPasscode(String passcode){
		try{
			for(int i = 0 ; i < passcode.length(); i++){
				char digit = passcode.charAt(i);
				if(digit == '1'){
					btn1.click();
				}
				else if(digit == '2'){
					btn2.click();
				}
				else if(digit == '3'){
					btn3.click();
				}
				else if(digit == '4'){
					btn4.click();
				}
				else if(digit == '5'){
					btn5.click();
				}
				else if(digit == '6'){
					btn6.click();
				}
				else if(digit == '7'){
					btn7.click();
				}
				else if(digit == '8'){
					btn8.click();
				}
				else if(digit == '9'){
					btn9.click();
				}
				else if(digit == '0'){
					btn0.click();
				}
			}
			return true;
		}
		catch(Exception e){
			System.out.println("Exception in method : enterPasscode - Class : PasscodeScreen"+e);
			return false;
		}
	}
	

}
