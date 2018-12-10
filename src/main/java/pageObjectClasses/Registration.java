package pageObjectClasses;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class Registration {

IOSDriver<MobileElement> driver;
public WebDriver driver1;
String direction;
public String email;
public String name;
public String mobile;

	public Registration(IOSDriver<MobileElement> driver){
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
/** Elements **/	
	
	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeButton' AND name == 'back violet' AND visible == 1")
	public IOSElement backBtn;
	
	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeOther' AND name == 'Sign Up' AND visible == 1")
	public IOSElement signUpHeading;

	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeTextField' AND value == 'FIRST NAME*' AND visible == 1")
	public IOSElement firstNameField;

	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeTextField' AND value == 'LAST NAME*' AND visible == 1")
	public IOSElement lastNameField;

	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeTextField' AND value == 'EMAIL*' AND visible == 1")
	public IOSElement emailField;

	@iOSXCUITFindBy(className="XCUIElementTypeSecureTextField")
	public IOSElement passwordField;
	
	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeButton' AND name == 'icShow' AND visible == 1")
	public IOSElement showPasswordBtn;
	
	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeButton' AND name == 'icHide' AND visible == 1")
	public IOSElement hidePasswordBtn;
	
	@iOSXCUITFindBy(accessibility="Must be at least 8 characters, including one uppercase and lowercase letter, one number, and one special character.")
	public IOSElement passwordRuleText;
	
	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeButton' AND name == 'icCheckBoxSelected' AND visible == 1")
	public IOSElement selectedCheckBox;
	
	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeButton' AND name == 'icCheckBoxUnSelected' AND visible == 1")
	public IOSElement unSelectedCheckBox;
	
	@iOSXCUITFindBy(iOSNsPredicate="name CONTAINS 'I agree to the'")
	public IOSElement iAgreetext;

	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeButton' AND name == 'Terms and Conditions' AND visible == 1")
	public IOSElement termsAndCondBtn;

	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeButton' AND name == 'CONTINUE' AND visible == 1")
	public IOSElement continueBtn;	
	
	@iOSXCUITFindBy(iOSNsPredicate="name CONTAINS 'Already have an account?'")
	public IOSElement alreadyAccountText;

	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeButton' AND name == 'Sign In' AND visible == 1")
	public IOSElement signInBtn;
	
	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeOther' AND name == 'Personal Info' AND visible == 1")
	public IOSElement personalInfoHeader;
	
	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeTextField' AND value == 'SEX*'")
	public IOSElement sexField;

	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeButton' AND name == 'Done'")
	public IOSElement doneBtn;

	@iOSXCUITFindBy(className = "XCUIElementTypePickerWheel")
	public List<IOSElement> pickerWheel;

	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeTextField' AND value == 'BIRTHDAY*'")
	public IOSElement birthdayField;

	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeTextField' AND value == 'ZIP CODE*' AND visible == 1")
	public IOSElement zipCodeField;

	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeButton' AND name == 'JOIN SAFE' AND visible == 1")
	public IOSElement joinSafeBtn;
	
	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeImage' AND name == 'icVerifyPhone' AND visible == 1")
	public IOSElement authenticateMobilePic;

	@iOSXCUITFindBy(accessibility = "Authenticate Device")
	public IOSElement authenticateDeviceText;
	
	@iOSXCUITFindBy(accessibility = "For your security, please enter your phone number so we can authenticate your device")
	public IOSElement authenticateDeviceDescription;
	
	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeTextField' AND visible == 1")
	public IOSElement textField;
	
	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeButton' AND name == 'SEND VERIFICATION CODE' AND visible == 1")
	public IOSElement sendVerificationBtn;
	
	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeButton' AND name == 'Resend code' AND visible == 1")
	public IOSElement resendCodeBtn;
	
	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeButton' AND name == 'OK' AND visible == 1")
	public IOSElement okBtn;
	
	@iOSXCUITFindBy(accessibility = "Enter verification code")
	public IOSElement enterVerificationText;
	
	@iOSXCUITFindBy(iOSNsPredicate = "name CONTAINS 'Your Safe Verification Code is'")
	public IOSElement verificationCodePopUp;
	
	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeImage' AND name == 'icVerify' AND visible == 1")
	public IOSElement authenticateMailPic;
	
	@iOSXCUITFindBy(accessibility = "Verify your email")
	public IOSElement verifyEmailText;

	@iOSXCUITFindBy(accessibility = "No hard feelings if you need to change what you gave us earlier")
	public IOSElement verifyEmailDescription;

	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeButton' AND name == 'VERIFY EMAIL' AND visible == 1")
	public IOSElement verifyEmailBtn;
	
	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeButton' AND name == 'Why is this necessary?' AND visible == 1")
	public IOSElement whyNecessaryLink;
	
	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeButton' AND name == 'group4' AND visible == 1")
	public IOSElement cameraCirleBtn;
	
	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeButton' AND name == 'ADD PHOTO' AND visible == 1")
	public IOSElement addPhotoBtn;
	
	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeButton' AND name == 'I’ll do it later.' AND visible == 1")
	public IOSElement laterBtn;
	
	@iOSXCUITFindBy(accessibility = "Add Your Profile Picture")
	public IOSElement addYourPhotoText;
	
	@iOSXCUITFindBy(accessibility = "Take a photo for your profile screen. It will not be displayed anywhere by here.")
	public IOSElement addPhotoDescription;
	
	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeImage' AND name == 'Group-1' AND visible == 1")
	public IOSElement tickAccoutnCreated;
	
	@iOSXCUITFindBy(accessibility = "Your account has been created!")
	public IOSElement accountCreatedText;

	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeButton' AND name == 'cancelArrow' AND visible == 1")
	public IOSElement cancelBtn;
	
	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeImage' AND name == 'icIntimate' AND visible == 1")
	public IOSElement welcomeScreenImage;
	
	@iOSXCUITFindBy(accessibility = "You can now import your STD test results for free, or schedule testing at a lab near you for just $99 or use your insurance .")
	public IOSElement welcomeDesc;
	
	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeButton' AND name == 'IMPORT TEST RESULTS' AND visible == 1")
	public IOSElement importTestResultsBtn;
	
	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeButton' AND name == 'GET TESTED' AND visible == 1")
	public IOSElement getTestedBtn;

	
	/**ACTIONS**/
	
	public boolean fillSignUpDetails(String firstname, String lastName, String email, String password){
		try{
			this.name = firstname;
			this.email = email;
			firstNameField.click();
			firstNameField.sendKeys(firstname);
			lastNameField.click();
			lastNameField.sendKeys(lastName);
			emailField.click();
			emailField.sendKeys(email);
			passwordField.click();
			passwordField.sendKeys(password);
			driver.findElement(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' AND name == 'Return'")).click();
			return true;
		}
		catch(Exception e){
			System.out.println("Exception in method : fillSignUpDeatils - Class : Registration"+e);
			return false;
		}
	}
	
	public boolean fillPersonalDetails(String gender ,String date ,String month ,String year ,String zip){
		try{
			sexField.click();
			selectGender(gender);
			doneBtn.click();
			birthdayField.click();
			selectDatePicker(date, month, year);
			doneBtn.click();
			zipCodeField.click();
			zipCodeField.sendKeys(zip);
			return true;
		}
		catch(Exception e){
			System.out.println("Exception in method : fillPersonalDetails - Class : Registration"+e);
			return false;
		}
	}
	
	public boolean addPhoneNumber(String phone){
		try{
			long a;
			if(mobile != null){
				a = Long.parseLong(phone);
				if(mobile.equals(phone)){
					a = a + 23;
					mobile = ""+a;
				}
			}
			else{
				this.mobile = phone;
			}
			textField.click();
			textField.sendKeys(mobile);
			authenticateDeviceText.click();
			return true;
		}
		catch(Exception e){
			System.out.println("Exception in method : addPhoneNumber - Class : Registration"+e);
			return false;
		}
	}
	
	public boolean mobileVerificationCode(){
		try{
			resendCodeBtn.click();
			String code = verificationCodePopUp.getAttribute("name");
			okBtn.click();
			code = code.substring(code.length()-6);
			for(int i = 0 ; i < code.length() ; i++){
				driver.findElement(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeKey' AND name == '"+code.charAt(i)+"'")).click();
			}
			return true;
		}
		catch(Exception e){
			System.out.println("Exception in method : mobileVerificationCode - Class : Registration"+e);
			return false;
		}
	}
	
	public boolean verifyEmail(String change , String email){
		try{
			if(change.equalsIgnoreCase("Y")){
				this.email = email;
				textField.clear();
				textField.sendKeys(email);
			}
			return true;
		}
		catch(Exception e){
			System.out.println("Exception in method : verifyEmail - Class : Registration"+e);
			return false;
		}
	}
	
	public boolean getEmailVerificationCode(){
		try{
			//ChromeDriverManager.getInstance().setup();
			System.setProperty("webdriver.chrome.driver", "src/main/resources/Drivers/chromedriver");
			driver1  = new ChromeDriver();
			driver1.get("http://www.yopmail.com/en/"+email);
			Thread.sleep(5000);
			driver1.switchTo().frame(driver1.findElement(By.xpath("//iframe[@class = 'whc' and @id = 'ifinbox']")));
			driver1.findElement(By.xpath("//span[text() = 'SAFE Care Team']")).click();
			driver1.switchTo().defaultContent();
			driver1.switchTo().frame(driver1.findElement(By.xpath("//iframe[@class = 'whc' and @id = 'ifmail']")));
			String s = driver1.findElement(By.xpath("//span[contains(text() ,  'Verification Code:')]/following::span/span")).getText();
			driver1.close();
			for(int i = 0 ; i < s.length() ; i++){
				driver.findElement(MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeKey' AND name == '"+s.charAt(i)+"'")).click();
			}
			return true;
		}
		catch(Exception e){
			System.out.println("Exception in method : getEmailVerificationCode - Class : Registration"+e);
			return false;
		}
	}
	
	public boolean checkWelcomeMsg(){
		try{
			driver.findElement(MobileBy.iOSNsPredicateString("name CONTAINS 'Hi'"));
			return true;
		}
		catch(Exception e){
			System.out.println("Exception in method : checkWelcomeMsg - Class : Registration"+e);
			return false;
		}
	}
	
	public void datePicker(int col , String direction){
		try{
			JavascriptExecutor js = driver;
		    Map<String, Object> params = new HashMap<String, Object>();
		    params.put("order", direction);
		    params.put("offset", 0.10);
		    params.put("element", pickerWheel.get(col).getId());
		    js.executeScript("mobile: selectPickerWheelValue", params);	
		}
		catch(Exception e){
			System.out.println("Exception in method : datePicker - Class : Registration"+e);
		}
	}
	
	public boolean selectGender(String s){
	try{
		
		if(s.equalsIgnoreCase("Male")){
			datePicker(0, "next");
		}
		else if(s.equalsIgnoreCase("Female")){
			datePicker(0, "next");
			datePicker(0, "next");
		}
		else if(s.equalsIgnoreCase("Intersex")){
			datePicker(0, "next");
			datePicker(0, "next");
			datePicker(0, "next");
		}
		else if(s.equalsIgnoreCase("other")){
			datePicker(0, "next");
			datePicker(0, "next");
			datePicker(0, "next");
			datePicker(0, "next");
		}
		return true;
	}
	catch(Exception e){
		System.out.println("Exception in method : selectGender - Class : Registration"+e);
		return false;
	}
	}
	
	public boolean selectDatePicker(String date, String month, String year){
		try{
			int d = Integer.parseInt(date);
			int y = Integer.parseInt(year);
			String dateValue = pickerWheel.get(1).getAttribute("value");
			String yearValue = pickerWheel.get(2).getAttribute("value");
			int dVal = Integer.parseInt(dateValue);
			int yVal = Integer.parseInt(yearValue);
			if(d > dVal){
				direction = "next";
			}
			else{
				direction = "previous";
			}
			while(true){
				if(pickerWheel.get(1).getAttribute("value").equals(date)){
					break;
				}
				datePicker(1, direction);
			}
			while(true){
				if(pickerWheel.get(0).getAttribute("value").equals(month)){
					break;
				}
				datePicker(0, "next");
			}
			int diff = yVal - y;
			int loop = 0;
			if(diff > 0){
				loop = diff / 4;
			}
			for(int i = 0 ; i < loop ; i++){
				JavascriptExecutor js1 = driver;
			    Map<String, Object> params1 = new HashMap<String, Object>();
			    params1.put("order", "previous");
			    params1.put("offset", 0.3);
			    params1.put("element", pickerWheel.get(2).getId());
			    js1.executeScript("mobile: selectPickerWheelValue", params1);
			}
			
			yearValue = pickerWheel.get(2).getAttribute("value");
			yVal = Integer.parseInt(yearValue);
			int pos3 = yVal - y;
			if(pos3 > 0){
				direction = "previous";
			}
			else{
				direction = "next";
			}
			while(true){
				if(pickerWheel.get(2).getAttribute("value").equals(year)){
					break;
				}
				datePicker(2, direction);
			}
			return true;
		}
		catch(Exception e){
			System.out.println("Exception in method : selectDatePicker - Class : Registration"+e);
			return false;
		}
	}
	
	
	
}
