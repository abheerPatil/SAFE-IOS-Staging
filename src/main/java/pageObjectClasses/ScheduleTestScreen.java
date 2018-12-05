package pageObjectClasses;

import java.util.HashMap;
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

public class ScheduleTestScreen {
	
	IOSDriver<MobileElement> driver;
	public boolean firstRun = false;
	public String facility;
	public String facilityAdd;
	public String month;
	public String year;
	public String dt;
	public String apptTime;
	
	public ScheduleTestScreen(IOSDriver<MobileElement> driver){
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	/***ELEMENTS***/
	
	@iOSXCUITFindBy(accessibility="Enter Your Address")
	public IOSElement enterAddressText;
	
	@iOSXCUITFindBy(className="XCUIElementTypeTextField")
	public IOSElement addressTextField;
	
	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeButton' AND name == 'Cancel'")
	public IOSElement cancelBtn;
	
	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeSearchField'")
	public IOSElement searchField;
	
	@iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeCell[1]")
	public IOSElement addressSelect;
	
	@iOSXCUITFindBy(accessibility = "CONTINUE")
	public IOSElement continueBtn;
	
	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeNavigationBar' AND name == 'Get Tested'")
	public IOSElement getTestedHeader;
	
	@iOSXCUITFindBy(accessibility = "Would you like to use your insurance?")
	public IOSElement insuranceAskText;
	
	@iOSXCUITFindBy(accessibility="Yes")
	public IOSElement yesBtn;
	
	@iOSXCUITFindBy(accessibility="No")
	public IOSElement noBtn;
	
	@iOSXCUITFindBy(accessibility="smallRightArrow")
	public IOSElement footer;
	
	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeNavigationBar' AND name == 'Sexual Health Exam' AND visible == 1")
	public IOSElement healthExamHeader;
	
	@iOSXCUITFindBy(accessibility="cancelArrow")
	public IOSElement crossBtn;
	
	@iOSXCUITFindBy(accessibility="Reference SAFEPhysician")
	public IOSElement referenceSafeText;
	
	@iOSXCUITFindBy(accessibility="BEGIN CONSULTATION")
	public IOSElement beginConsultBtn;
	
	@iOSXCUITFindBy(accessibility="When is the last time you were sexually active?")
	public IOSElement lastTimeActiveQuestion;
	
	@iOSXCUITFindBy(accessibility="Less than a Year")
	public IOSElement lessThanYearBtn;
	
	@iOSXCUITFindBy(accessibility="More than a year")
	public IOSElement moreThanYearBtn;
	
	@iOSXCUITFindBy(accessibility="Never")
	public IOSElement neverBtn;
	
	@iOSXCUITFindBy(accessibility="I have had sex with:")
	public IOSElement iHaveWithQuestion;
	
	@iOSXCUITFindBy(accessibility="Men")
	public IOSElement menBtn;
	
	@iOSXCUITFindBy(accessibility="Women")
	public IOSElement womenBtn;
	
	@iOSXCUITFindBy(accessibility="Both")
	public IOSElement bothBtn;
	
	@iOSXCUITFindBy(accessibility="How many partners have you had in your lifetime?")
	public IOSElement noOfPartnersQuestion;
	
	@iOSXCUITFindBy(accessibility="1")
	public IOSElement oneBtn;
	
	@iOSXCUITFindBy(accessibility="2-5")
	public IOSElement twoToFiveBtn;
	
	@iOSXCUITFindBy(accessibility="5-10")
	public IOSElement fiveToTenBtn;
	
	@iOSXCUITFindBy(accessibility="More than 10")
	public IOSElement moreThanTenBtn;

	@iOSXCUITFindBy(accessibility="Do you use protection (e.g. condoms or dental dam)?")
	public IOSElement doYouUseQuestion;
	
	@iOSXCUITFindBy(accessibility="Always")
	public IOSElement alwaysBtn;
	
	@iOSXCUITFindBy(accessibility="Sometimes")
	public IOSElement sometimesBtn;
	
	@iOSXCUITFindBy(accessibility="When was your last STD Test?")
	public IOSElement lastStdQuestion;
	
	@iOSXCUITFindBy(accessibility="0-6 months")
	public IOSElement uptoSixMonthsBtn;
	
	@iOSXCUITFindBy(accessibility="6-12 months")
	public IOSElement sixToTwelveBtn;
	
	@iOSXCUITFindBy(accessibility="Over a year")
	public IOSElement overAYearBtn;
	
	@iOSXCUITFindBy(accessibility="Have you ever tested positive for an STD?")
	public IOSElement everTestedPositiveQuestion;
	
	@iOSXCUITFindBy(accessibility="Were you treated by a physician?")
	public IOSElement treatedBeforeQuestion;
	
	@iOSXCUITFindBy(accessibility="Which STD(s) have you tested positive for in the past?")
	public IOSElement whichStdQuestion;
	
	@iOSXCUITFindBy(accessibility="Chlamydia")
	public IOSElement chlamydiaBtn;
	
	@iOSXCUITFindBy(accessibility="Gonorrhea")
	public IOSElement gonorrheaBtn;
	
	@iOSXCUITFindBy(accessibility="Syphilis")
	public IOSElement syphilisBtn;
	
	@iOSXCUITFindBy(accessibility="HPV")
	public IOSElement hpvBtn;
	
	@iOSXCUITFindBy(accessibility="Trich")
	public IOSElement trichBtn;
	
	@iOSXCUITFindBy(accessibility="Herpes")
	public IOSElement herpesBtn;
	
	@iOSXCUITFindBy(accessibility="HIV")
	public IOSElement hivBtn;
	
	@iOSXCUITFindBy(accessibility="Hep A")
	public IOSElement hepABtn;
	
	@iOSXCUITFindBy(accessibility="Hep B")
	public IOSElement hepBBtn;
	
	@iOSXCUITFindBy(accessibility="Hep C")
	public IOSElement hepCBtn;
	
	@iOSXCUITFindBy(accessibility="Are you concerned you have been exposed to an STD?")
	public IOSElement exposedToSTDQuestion;
	
	@iOSXCUITFindBy(accessibility="Unsure")
	public IOSElement unsureBtn;
	
	@iOSXCUITFindBy(accessibility="Which STD(s) are you concerned you've been exposed to?")
	public IOSElement concernedSTDQuestion;
	
	@iOSXCUITFindBy(accessibility="Are you experiencing any of the following symptoms?")
	public IOSElement symptomsQuestion;
	
	@iOSXCUITFindBy(accessibility="None")
	public IOSElement noneBtn;
	
	@iOSXCUITFindBy(accessibility="Pus or unusual discharge from genital areas")
	public IOSElement optionOne;
	
	@iOSXCUITFindBy(accessibility="Burning or discomfort with urination")
	public IOSElement optionTwo;
	
	@iOSXCUITFindBy(accessibility="New pelvic pain")
	public IOSElement optionThree;
	
	@iOSXCUITFindBy(accessibility="Genital sores, bumps, or rash")
	public IOSElement optionFour;
	
	@iOSXCUITFindBy(accessibility="Other")
	public IOSElement optionFive;
	
	@iOSXCUITFindBy(accessibility="Have you ever injected illegal drugs?")
	public IOSElement illegalDrugsQuestion;
	
	@iOSXCUITFindBy(className="XCUIElementTypeTable")
	public IOSElement tableView;
	
	@iOSXCUITFindBy(accessibility="Recommended Panel")
	public IOSElement recommendedPanelHeader;
	
	@iOSXCUITFindBy(accessibility="Based on your answers, Reference SAFEPhysician recommends the SAFE Sexual Health Panel")
	public IOSElement basedOnUrAnswersText;
	
	@iOSXCUITFindBy(accessibility="Service Fee: $10")
	public IOSElement serviceFeeText;
	
	@iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeCell[$name CONTAINS 'HIV'$]")
	public IOSElement hivCheckBox;
	
	@iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeCell[$name == 'HSV2'$]")
	public IOSElement hsvCheckBox;
	
	@iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeCell[$name == 'SYPHILIS'$]")
	public IOSElement syphilisCheckBox;
	
	@iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeCell[$name == 'GONORRHEA'$]")
	public IOSElement gonorrheaCheckBox;
	
	@iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeCell[$name == 'CHLAMYDIA'$]")
	public IOSElement chlamydiaCheckBox;
	
	@iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeCell[$name == 'HEP-C'$]")
	public IOSElement hepCheckBox;
	
	@iOSXCUITFindBy(accessibility="SCHEDULE TESTING")
	public IOSElement scheduleTestingBtn;
	
	@iOSXCUITFindBy(accessibility="Don't Allow")
	public IOSElement dontAllowBtn;
	
	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeNavigationBar' AND name == 'Select Facility' AND visible == 1")
	public IOSElement selectFacilityHeader;
	
	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeTextField' AND visible == 1")
	public IOSElement searchFacilityField;
	
	@iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeCell[1]")
	public IOSElement firstSearch;
	
	@iOSXCUITFindBy(accessibility="Search")
	public IOSElement searchBtn;
	
	@iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeCell/XCUIElementTypeStaticText[1]")
	public IOSElement facilityName;
	
	@iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeCell/XCUIElementTypeStaticText[2]")
	public IOSElement facilityAddress;
	
	@iOSXCUITFindBy(accessibility="BOOK FACILITY")
	public IOSElement bookFacilityBtn;
	
	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeNavigationBar' AND name == 'Schedule Appointment' AND visible == 1")
	public IOSElement scheduleApptHeader;
	
	@iOSXCUITFindBy(accessibility="calendarRightArrow")
	public IOSElement calenderRightArrow;
	
	@iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeCollectionView[2]")
	public IOSElement appointmentTimeView;
	
	@iOSXCUITFindBy(iOSNsPredicate="name CONTAINS 'confirmation' AND visible == 1")
	public IOSElement confirmationText;
	
	@iOSXCUITFindBy(accessibility="CONFIRM")
	public IOSElement confirmBtn;
	
	@iOSXCUITFindBy(accessibility="CANCEL")
	public IOSElement cancelConfirmationBtn;
	
	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeNavigationBar' AND name == 'CheckOut' AND visible == 1")
	public IOSElement checkOutHeader;
	
	@iOSXCUITFindBy(accessibility="CHECK OUT")
	public IOSElement checkOutBtn;
	
	@iOSXCUITFindBy(accessibility="CONFIRM ORDER")
	public IOSElement confirmOrderBtn;
	
	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeNavigationBar' AND name == 'Informed Consent' AND visible == 1")
	public IOSElement informedConsentHeader;
	
	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeNavigationBar' AND name == 'HIV Consent' AND visible == 1")
	public IOSElement hivConsentHeader;
	
	@iOSXCUITFindBy(className="XCUIElementTypeWebView")
	public IOSElement view;
	
	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeButton' AND name == 'I AGREE'")
	public IOSElement iAgreeBtn;
	
	@iOSXCUITFindBy(accessibility="Your Appointment Confirmed!")
	public IOSElement appointmentConfirmedText;
	
	@iOSXCUITFindBy(accessibility="No Thanks")
	public IOSElement noThanksBtn;
	
	@iOSXCUITFindBy(accessibility="Add to your Calender")
	public IOSElement addToCalenderBtn;
	
	@iOSXCUITFindBy(iOSNsPredicate="name CONTAINS 'no need'")
	public IOSElement noNeedText;
	
	@iOSXCUITFindBy(accessibility="ADD HSV2 TEST")
	public IOSElement hsvTestBtn;
	
	@iOSXCUITFindBy(accessibility="CLOSE")
	public IOSElement closeBtn;
	
	@iOSXCUITFindBy(accessibility="While HSV2 (genital herpes) is a common STD, the CDC does not recommend testing people without symptoms due to cases of false positive results which could cause emotional distress. You have the option to add this test at no additional charge below.")
	public IOSElement hsvDescription;
	
	@iOSXCUITFindBy(iOSNsPredicate="name CONTAINS 'No Appointments'")
	public IOSElement noAppointmentsText;
	
	@iOSXCUITFindBy(accessibility="Are you pregnant ?")
	public IOSElement isPregnantQuestion;
	
	@iOSXCUITFindBy(accessibility="RESCHEDULE")
	public IOSElement rescheduleTest;
	
	@iOSXCUITFindBy(accessibility="CANCEL")
	public IOSElement cancelRescheduleBtn;
	
	/***ACTIONS***/
	
	public boolean isFirst(String first, String importDone){
		try{
			if(first.equalsIgnoreCase("Y")){
				if(importDone.equalsIgnoreCase("N")){
					firstRun = true;
				}
			}
			return true;
		}
		catch(Exception e){
			System.out.println("Exception in method : isFirstRun - Class : ScheduleTestScreen"+e);
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
			System.out.println("Exception in method : enterAddress - Class : ScheduleTestScreen"+e);
			return false;
		}
	}
	
	public boolean withInsurance(boolean opt){
		try{
			if(opt == true){
				yesBtn.click();
			}
			else{
				noBtn.click();
			}
			return true;
		}
		catch(Exception e){
			System.out.println("Exception in method : enterAddress - Class : ScheduleTestScreen"+e);
			return false;
		}
	}
	/*
	public boolean checkInsurance(boolean doneInsurance, String state, String providerName, String insuranceID, String groupNum){
		try{
			MyInsurance ob = new MyInsurance(driver);
			if(doneInsurance == true){
				ob.confirmAndContinueBtn.click();
			}
			else{
				ob.addMyInsuranceBtn.click();
				WaitClass.waitForElement(ob.myInsuranceHeader, driver, 10000);
				ob.enterDetails(state, providerName, insuranceID, groupNum);
				ob.addMyInsuranceBtn.click();
			}
			return true;
		}
		catch(Exception e){
			System.out.println("Exception in method : checkInsurance - Class : ScheduleTestScreen"+e);
			return false;
		}
	}
	*/
	public boolean lastTimeActive(int option){
		try{
			lastTimeActiveQuestion.isDisplayed();
			if(option == 1){
				lessThanYearBtn.click();
			}
			else if(option == 2){
				moreThanYearBtn.click();
			}
			else if(option == 3){
				neverBtn.click();
			}
			return true;
		}
		catch(Exception e){
			System.out.println("Exception in method : lastTimeActive - Class : ScheduleTestScreen"+e);
			return false;
		}
	}
	
	public boolean lastTimeWith(int option){
		try{
			iHaveWithQuestion.isDisplayed();
			if(option == 1){
				menBtn.click();
			}
			else if(option == 2){
				womenBtn.click();
			}
			else if(option == 3){
				bothBtn.click();
			}
			return true;
		}
		catch(Exception e){
			System.out.println("Exception in method : lastTimeWith - Class : ScheduleTestScreen"+e);
			return false;
		}
	}
	
	public boolean partnersInLifeTime(int option){
		try{
			noOfPartnersQuestion.isDisplayed();
			if(option == 1){
				oneBtn.click();
			}
			else if(option == 2){
				twoToFiveBtn.click();
			}
			else if(option == 3){
				fiveToTenBtn.click();
			}
			else if(option == 4){
				moreThanTenBtn.click();
			}
			return true;
		}
		catch(Exception e){
			System.out.println("Exception in method : partnersInLifeTime - Class : ScheduleTestScreen"+e);
			return false;
		}
	}
	
	public boolean doYouUse(int option){
		try{
			doYouUseQuestion.isDisplayed();
			if(option == 1){
				alwaysBtn.click();
			}
			else if(option == 2){
				sometimesBtn.click();
			}
			else if(option == 3){
				neverBtn.click();
			}
			return true;
		}
		catch(Exception e){
			System.out.println("Exception in method : doYouUse - Class : ScheduleTestScreen"+e);
			return false;
		}
	}
	
	public boolean stdWhenDone(int option){
		try{
			lastStdQuestion.isDisplayed();
			if(option == 1){
				uptoSixMonthsBtn.click();
			}
			else if(option == 2){
				sixToTwelveBtn.click();
			}
			else if(option == 3){
				overAYearBtn.click();
			}
			else if(option == 4){
				neverBtn.click();
			}
			return true;
		}
		catch(Exception e){
			System.out.println("Exception in method : stdWhenDone - Class : ScheduleTestScreen"+e);
			return false;
		}
	}
	
	public boolean everTestedPositive(int option){
		try{
			everTestedPositiveQuestion.isDisplayed();
			if(option == 1){
				yesBtn.click();
			}
			else if(option == 2){
				noBtn.click();
			}
			return true;
		}
		catch(Exception e){
			System.out.println("Exception in method : everTestedPositive - Class : ScheduleTestScreen"+e);
			return false;
		}
	}
	
	public boolean treatedBefore(int option){
		try{
			treatedBeforeQuestion.isDisplayed();
			if(option == 1){
				yesBtn.click();
			}
			else if(option == 2){
				noBtn.click();
			}
			return true;
		}
		catch(Exception e){
			System.out.println("Exception in method : treatedBefore - Class : ScheduleTestScreen"+e);
			return false;
		}
	} 
	
	public boolean whichPositiveSTD(int option){
		try{
			whichStdQuestion.isDisplayed();
			if(option > 5){
				JavascriptExecutor js = (JavascriptExecutor) driver;
				Map<String, Object> params = new HashMap<String, Object>();
				params.put("direction", "up");
				params.put("element", tableView.getId());
				js.executeScript("mobile: swipe", params);

			}
			
			if(option == 0){
				chlamydiaBtn.click();
			}
			else if(option == 1){
				gonorrheaBtn.click();
			}
			else if(option == 2){
				syphilisBtn.click();
			}
			else if(option == 3){
				hpvBtn.click();
			}
			else if(option == 4){
				trichBtn.click();
			}
			else if(option == 5){
				herpesBtn.click();
			}
			else if(option == 6){
				hivBtn.click();
			}
			else if(option == 7){
				hepABtn.click();
			}
			else if(option == 8){
				hepBBtn.click();
			}
			else if(option == 9){
				hepCBtn.click();
			}
			
			return true;
		}
		catch(Exception e){
			System.out.println("Exception in method : whichPositiveSTD - Class : ScheduleTestScreen"+e);
			return false;
		}
	}
	
	public boolean exposedToSTD(int option){
		try{
			exposedToSTDQuestion.isDisplayed();
			if(option == 1){
				yesBtn.click();
			}
			else if(option == 2){
				noBtn.click();
			}
			else if(option == 3){
				unsureBtn.click();
			}
			return true;
		}
		catch(Exception e){
			System.out.println("Exception in method : exposedToSTD - Class : ScheduleTestScreen"+e);
			return false;
		}
	}
	
	public boolean concernedSTD(int option){
		try{
			if(option > 5){
				JavascriptExecutor js = (JavascriptExecutor) driver;
				Map<String, Object> params = new HashMap<String, Object>();
				params.put("direction", "up");
				params.put("element", tableView.getId());
				js.executeScript("mobile: swipe", params);
			}
			
			if(option == 0){
				chlamydiaBtn.click();
			}
			else if(option == 1){
				gonorrheaBtn.click();
			}
			else if(option == 2){
				syphilisBtn.click();
			}
			else if(option == 3){
				hpvBtn.click();
			}
			else if(option == 4){
				trichBtn.click();
			}
			else if(option == 5){
				herpesBtn.click();
			}
			else if(option == 6){
				hivBtn.click();
			}
			else if(option == 7){
				hepABtn.click();
			}
			else if(option == 8){
				hepBBtn.click();
			}
			else if(option == 9){
				hepCBtn.click();
			}
			return true;
		}
		catch(Exception e){
			System.out.println("Exception in method : concernedSTD - Class : ScheduleTestScreen"+e);
			return false;
		}
	}
	
	public boolean symptomsFound(int option){
		try{
			symptomsQuestion.isDisplayed();
			if(option == 1){
				optionOne.click();
			}
			else if(option == 2){
				optionTwo.click();
			}
			else if(option == 3){
				optionThree.click();
			}
			else if(option == 4){
				optionFour.click();
			}
			else if(option == 5){
				optionFive.click();
			}
			return true;
		}
		catch(Exception e){
			System.out.println("Exception in method : symptomsFound - Class : ScheduleTestScreen"+e);
			return false;
		}
	}
	
	public boolean ifPregnant(int option){
		try{
			isPregnantQuestion.isDisplayed();
			if(option == 1){
				yesBtn.click();
			}
			else if(option == 2){
				noBtn.click();
			}
			return true;
		}
		catch(Exception e){
			System.out.println("Exception in method : ifPregnant - Class : ScheduleTestScreen"+e);
			return false;
		}
	}
	
	public boolean injectedIlleaglDrug(int option){
		try{
			illegalDrugsQuestion.isDisplayed();
			if(option == 1){
				yesBtn.click();
			}
			else if(option == 2){
				noBtn.click();
			}
			return true;
		}
		catch(Exception e){
			System.out.println("Exception in method : injectedIlleaglDrug - Class : ScheduleTestScreen"+e);
			return false;
		}
	}
	
	public boolean isSelected(IOSElement element){
		try{
			try{
				String a = element.getAttribute("value");
				if(a.equals("1")){
					return true;
				}
				else{
					return false;
				}
			}
			catch(Exception e){
				return false;
			}
		}
		catch(Exception e){
			System.out.println("Exception in method : isSelected - Class : ScheduleTestScreen"+e);
			return false;
		}
	}
	
	public boolean scheduleTesting(int option){
		try{
			if(option == 1){
				hivCheckBox.click();
			}
			else if(option == 2){
				hsvCheckBox.click();
				hsvTestBtn.click();
			}
			else if(option == 3){
				syphilisCheckBox.click();
			}
			else if(option == 4){
				gonorrheaCheckBox.click();
			}
			else if(option == 5){
				chlamydiaCheckBox.click();
			}
			else if(option == 6){
				hepCheckBox.click();
			}
			return true;
		}
		catch(Exception e){
			System.out.println("Exception in method : scheduleTesting - Class : ScheduleTestScreen"+e);
			return false;
		}
	}
	
	public boolean getFacility(){
		try{
			facility = facilityName.getAttribute("name");
			facilityAdd = facilityAddress.getAttribute("name");
			return true;
		}
		catch(Exception e){
			System.out.println("Exception in method : getFacility - Class : ScheduleTestScreen"+e);
			return false;
		}
	}
	
	public boolean getToMonthAndYear(String monthAndYear){
		try{
			int count = 0;
			boolean a = true;
			year = monthAndYear.substring(monthAndYear.length()-4);
			month = monthAndYear.substring(0, monthAndYear.length()-4);
			while(a == true){
				try{
					driver.findElement(MobileBy.AccessibilityId(monthAndYear));
					a = false;
					break;
				}
				catch(Exception e){
					calenderRightArrow.click();
					count++;
					if(count == 10){
						a = false;
						break;
					}
				}
			}
			return true;
		}
		catch(Exception e){
			System.out.println("Exception in method : getToMonthAndYear - Class : ScheduleTestScreen"+e);
			return false;
		}
	}
	
	public boolean clickDate(String date){
		try{
				driver.findElement(MobileBy.name(date)).click();
				try{
					noAppointmentsText.isDisplayed();
					driver.findElement(MobileBy.name(date)).click();
					noAppointmentsText.isDisplayed();
					throw new Exception("Wrong Date Selected");
				}
				catch(Exception e){}
				if(date.length()==1){
					dt = "0"+date;
				}
				else{
					dt = date;
				}
			return true;
		}
		catch(Exception e){
			System.out.println("Exception in method : clickDate - Class : ScheduleTestScreen"+e);
			return false;
		}
	}
	
	public boolean selectTime(String time){
		try{
			apptTime = time;
			while(true){
			try{
				driver.findElement(MobileBy.iOSNsPredicateString("name == '"+time+"' AND visible == 1")).click();
				break;
			}
			catch(Exception e){
				int y1 = driver.findElement(MobileBy.iOSClassChain("**/XCUIElementTypeCollectionView[2]/**/XCUIElementTypeCell[`visible = 1`][1]")).getRect().getY();
				int x1 = driver.findElement(MobileBy.iOSClassChain("**/XCUIElementTypeCollectionView[2]/**/XCUIElementTypeCell[`visible = 1`][1]")).getRect().getX();
				int y2 = driver.findElement(MobileBy.iOSClassChain("**/XCUIElementTypeCollectionView[2]/**/XCUIElementTypeCell[`visible = 1`][3]")).getRect().getY();
				int x2 = driver.findElement(MobileBy.iOSClassChain("**/XCUIElementTypeCollectionView[2]/**/XCUIElementTypeCell[`visible = 1`][3]")).getRect().getX();
				IOSTouchAction ac = new IOSTouchAction(driver);
				ac.longPress(PointOption.point(x2, y2)).moveTo(PointOption.point(x1, y1)).release().perform();
			}
			}
			return true;
		}
		catch(Exception e){
			System.out.println("Exception in method : selectTime - Class : ScheduleTestScreen"+e);
			return false;
		}
	}
	
	
	public boolean checkAppointmentDetails(){
		try{
			driver.findElement(MobileBy.iOSNsPredicateString("name CONTAINS '"+dt+"'"));
			driver.findElement(MobileBy.iOSNsPredicateString("name CONTAINS '"+month+"'"));
			driver.findElement(MobileBy.iOSNsPredicateString("name CONTAINS '"+year+"'"));
			driver.findElement(MobileBy.iOSNsPredicateString("name CONTAINS '"+apptTime+"'"));
			driver.findElement(MobileBy.iOSNsPredicateString("name CONTAINS '"+facility+"'"));
			driver.findElement(MobileBy.iOSNsPredicateString("name CONTAINS '"+facilityAdd+"'"));
			return true;
		}
		catch(Exception e){
			System.out.println("Exception in method : checkAppointmentDetails - Class : ScheduleTestScreen"+e);
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
			System.out.println("Exception in method : swipeContents - Class : ScheduleTestScreen"+e);
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
			System.out.println("Exception in method : swipe - Class : ScheduleTestScreen"+e);
			return false;
		}
	}
	
}
