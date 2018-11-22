package pageObjectClasses;

import java.util.List;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class CreditCards {

	IOSDriver<MobileElement> driver;
	
	public CreditCards(IOSDriver<MobileElement> driver){
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	/***ELEMENTS***/
	
	@iOSXCUITFindBy(accessibility="cancelArrow")
	public IOSElement cancelBtn;
	
	@iOSXCUITFindBy(accessibility="Credit Cards")
	public IOSElement header;
	
	@iOSXCUITFindBy(accessibility="Let's Add Your Credit Card")
	public IOSElement letsAddText;
	
	@iOSXCUITFindBy(accessibility="ADD CREDIT CARD")
	public IOSElement addCreditCardBtn;
	
	@iOSXCUITFindBy(accessibility="back violet")
	public IOSElement backBtn;
	
	@iOSXCUITFindBy(accessibility="Add a Card")
	public IOSElement addACardText;
	
	@iOSXCUITFindBy(accessibility="Add New Card")
	public IOSElement addNewCard;
	
	@iOSXCUITFindBy(accessibility="SAVE CARD")
	public IOSElement saveCardBtn;
	
	@iOSXCUITFindBy(accessibility="Toolbar Done Button")
	public IOSElement doneBtn;
	
	@iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeTextField[1]")
	public IOSElement creditCardNum;
	
	@iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeTextField[2]")
	public IOSElement expiryDate;
	
	@iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeTextField[3]")
	public IOSElement cvvNum;
	
	@iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeTextField[4]")
	public IOSElement nameOnCard;
	
	@iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeTextField[5]")
	public IOSElement zipCode;
	
	@iOSXCUITFindBy(accessibility="New Credit Card Added")
	public IOSElement cardAddedSuccess;
	
	@iOSXCUITFindBy(accessibility="CONTINUE")
	public IOSElement continueBtn;
	
	@iOSXCUITFindBy(className="XCUIElementTypeCell")
	public List<IOSElement> cards;
	
	/***ACTIONS***/
	
	public boolean addCredentials(String cardNum , String expiryDt, String cvv, String name, String zip){
		try{
			creditCardNum.sendKeys(cardNum);
			expiryDate.sendKeys(expiryDt);
			cvvNum.sendKeys(cvv);
			nameOnCard.sendKeys(name);
			zipCode.sendKeys(zip);
			doneBtn.click();
			return true;
		}
		catch(Exception e){
			System.out.println("Exception in method : addCredentials - Class : CreditCards"+e);
			return false;
		}
	}
	
	
	
	
	
	
	
	
}
