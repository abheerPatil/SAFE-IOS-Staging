package testClasses;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClass.DriverClass;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import pageObjectClasses.HomeScreen;
import pageObjectClasses.ImportResults;
import pageObjectClasses.LoginScreen;
import pageObjectClasses.Menu;
import pageObjectClasses.MyInsurance;
import pageObjectClasses.PasscodeScreen;
import pageObjectClasses.ScheduleTestScreen;
import pageObjectClasses.SettingsMenu;
import testListeners.SingleDataProvider;
import utlilty.WaitClass;

public class ScheduleTestingTests {

	IOSDriver<MobileElement> driver;
	PasscodeScreen ob1;
	LoginScreen ob2;
	HomeScreen ob3;
	Menu ob4;
	ScheduleTestScreen ob5;
	MyInsurance ob6;
	ImportResults ob7;
	SettingsMenu ob8;
	
	@BeforeMethod
	public void beforeMethod(Object args[]){
		try{
			driver = DriverClass.set();
			ob1 = new PasscodeScreen(driver);
			ob2 = new LoginScreen(driver);
			ob3 = new HomeScreen(driver);
			ob4 = new Menu(driver);
			ob5 = new ScheduleTestScreen(driver);
			ob6 = new MyInsurance(driver);
			ob7 = new ImportResults(driver);
			ob8 = new SettingsMenu(driver);
			if(((String) args[0]).equalsIgnoreCase("passcode")){
				ob1.enterPasscode((String)args[1]);
			}
			else{
				try{
					ob1.cancelBtn.click();
				}
				catch(Exception e){}
				ob2.login((String)args[2],(String) args[3]);
				ob2.signInBtn.click();
			}
			WaitClass.waitForElement(ob3.header, driver, 20000);
			
		}
		catch(Exception e){
			System.out.println("Exception in method : beforeMethod - Class : ScheduleTestingTests"+e);
		}
	}
	
	@AfterMethod
	public void afterMethod(){
		try{
			try{
				ob3.menuBtn.click();
				ob4.settingBtn.click();
				ob8.swipeTillElement(ob8.signOut);
				ob8.signOut.click();
				ob8.yes.click();
			}
			catch(Exception e){
				try{
					driver.resetApp();
					ob3.menuBtn.click();
					ob4.settingBtn.click();
					ob8.swipeTillElement(ob8.signOut);
					ob8.signOut.click();
					ob8.yes.click();
				}
				catch(Exception g){}
			}
			WaitClass.waitForElement(ob2.signInBtn, driver, 5000);
			driver.quit();
		}
		catch(Exception e){
			System.out.println("Exception in method : afterMethod - Class : ScheduleTestingTests"+e);
		}
	}
	
	@Test(dataProvider="data" , dataProviderClass = SingleDataProvider.class)
	public void scheduleTestingWithInsurance(String a, String b, String c, String d,String scheduledBefore,String option, String firstrun, String importedBefore,String swipes,String state, String quesA, String quesB, String quesC, String quesD, String quesE, String quesF, String quesG, String quesH, String quesI,
			String quesJ, String quesK, String quesP, String quesL, String tests, String faciltiy, String monthAndYear, String date, String time){
		try{
			WaitClass.waitForElement(ob3.header, driver, 20000);
			ob3.menuBtn.click();
			WaitClass.waitForElement(ob4.scheduleTestingBtn, driver, 20000);
			ob4.scheduleTestingBtn.click();
			if(scheduledBefore.equalsIgnoreCase("N")){
				WaitClass.waitForElement(ob5.getTestedHeader, driver, 20000);
				int integerFormat , firstQues, lastQues;
				if(importedBefore.equalsIgnoreCase("N")&&(firstrun.equalsIgnoreCase("Y"))){
					int s = 0;
					s = Integer.parseInt(swipes);
					boolean re = ob7.isFirstRun(firstrun, s);
					Assert.assertEquals(re, true);
				}
				try{
					WaitClass.waitForElement(ob5.getTestedHeader, driver, 20000);
					ob5.getTestedHeader.isDisplayed();
					ob7.selectState(state);
				}catch(Exception e){}
				WaitClass.waitForElement(ob5.healthExamHeader, driver, 20000);
				ob5.beginConsultBtn.click();
				ob5.lastTimeActiveQuestion.isDisplayed();
				integerFormat = Integer.parseInt(quesA);
				firstQues = integerFormat;
				ob5.lastTimeActive(integerFormat);
				if((integerFormat == 1)||(integerFormat == 2)){
					integerFormat = Integer.parseInt(quesB);
					ob5.lastTimeWith(integerFormat);		
					integerFormat = Integer.parseInt(quesC);
					ob5.partnersInLifeTime(integerFormat);				
					integerFormat = Integer.parseInt(quesD);
					ob5.doYouUse(integerFormat);						
					integerFormat = Integer.parseInt(quesE);
					ob5.stdWhenDone(integerFormat);						
					integerFormat = Integer.parseInt(quesF);
					ob5.everTestedPositive(integerFormat);				
					if(integerFormat == 1){
						for(int i = 0 ; i < quesG.length() ; i++){
							char ch = quesG.charAt(i);
							int x = ch - '0';
							ob5.whichPositiveSTD(x);
						}
						ob5.continueBtn.click();
						integerFormat = Integer.parseInt(quesH);
						ob5.treatedBefore(integerFormat);
					}
					integerFormat = Integer.parseInt(quesI);
					ob5.exposedToSTD(integerFormat);
					if((integerFormat == 1)||(integerFormat == 3)){
						for(int i = 0 ; i < quesJ.length() ; i++){
							char ch = quesJ.charAt(i);
							int x = ch - '0';
							ob5.concernedSTD(x);
						}
						ob5.continueBtn.click();
					}
					ob5.symptomsQuestion.isDisplayed();
					if(quesK != null){
						for(int i = 0 ; i < quesK.length() ; i++){
							char ch = quesK.charAt(i);
							int x = ch - '0';
							ob5.symptomsFound(x);
						}
					}
					ob5.continueBtn.click();
					integerFormat = Integer.parseInt(quesP);
					ob5.ifPregnant(integerFormat);
				}
				integerFormat = Integer.parseInt(quesL);
				lastQues = integerFormat;
				ob5.injectedIlleaglDrug(integerFormat);	
				if(((firstQues == 1)||(firstQues == 2)) || ((firstQues == 3) && (lastQues == 1))){	
				WaitClass.waitForElement(ob5.syphilisCheckBox, driver, 20000);
				ob5.scheduleTesting(1);
				ob5.scheduleTesting(3);
				ob5.scheduleTesting(4);
				ob5.scheduleTesting(5);
				ob5.scheduleTesting(6);
				for(int i = 0; i < tests.length(); i++){
					char ch = tests.charAt(i);
					int x = ch - '0';
					ob5.scheduleTesting(x);
				}
				ob5.scheduleTestingBtn.click();
				WaitClass.waitForElement(ob5.selectFacilityHeader, driver, 20000);
				try{
					ob5.dontAllowBtn.click();
				}
				catch(Exception e){}
				ob5.searchFacilityField.sendKeys(faciltiy);
				ob5.searchBtn.click();
				WaitClass.waitForElement(ob5.illegalDrugsQuestion, driver, 8000);
				ob5.firstSearch.click();
				WaitClass.waitForElement(ob5.bookFacilityBtn, driver, 20000);
				ob5.getFacility();
				ob5.bookFacilityBtn.click();
				WaitClass.waitForElement(ob5.scheduleApptHeader, driver, 20000);
				ob5.getToMonthAndYear(monthAndYear);
				ob5.clickDate(date);
				ob5.selectTime(time);
				ob5.continueBtn.click();
				WaitClass.waitForElement(ob5.confirmationText, driver, 20000);
				ob5.confirmBtn.click();
				WaitClass.waitForElement(ob5.getTestedHeader, driver, 20000);
				ob5.withInsurance(true);
				WaitClass.waitForElement(ob6.myInsuranceHeader, driver, 20000);
				ob6.confirmAndContinueBtn.click();
				WaitClass.waitForElement(ob6.insuranceAcceptedText, driver, 20000);
				ob6.continueBtn.click();
				WaitClass.waitForElement(ob5.checkOutHeader, driver, 20000);
				ob5.confirmOrderBtn.click();
				WaitClass.waitForElement(ob5.informedConsentHeader, driver, 20000);
				ob5.swipeContents();
				ob5.iAgreeBtn.click();
				WaitClass.waitForElement(ob7.hipaaConsent, driver, 20000);
				ob7.swipeContents();
				ob7.iAgreeBtn.click();
				WaitClass.waitForElement(ob5.hivConsentHeader, driver, 20000);
				ob5.swipeContents();
				ob5.iAgreeBtn.click();
				WaitClass.waitForElement(ob7.eSignature, driver, 20000);
				try{
					ob5.dontAllowBtn.click();
				}
				catch(Exception e){}
				ob7.signature();
				ob7.doneBtn.click();
				ob7.spinner.isDisplayed();
				WaitClass.waitForElement(ob5.appointmentConfirmedText, driver, 20000);
				ob5.noThanksBtn.click();
				}
				else{
					WaitClass.waitForElement(ob5.noNeedText, driver, 20000);
					ob5.noNeedText.isDisplayed();
					ob5.crossBtn.click();
					WaitClass.waitForElement(ob5.yesBtn, driver, 20000);
					ob5.yesBtn.click();
				}
			}	
			else if((scheduledBefore.equalsIgnoreCase("Y"))&&(option.equals("RESCHEDULE"))){
					WaitClass.waitForElement(ob5.rescheduleTest, driver, 20000);
					ob5.rescheduleTest.click();
					WaitClass.waitForElement(ob5.selectFacilityHeader, driver, 20000);
					try{
						ob5.dontAllowBtn.click();
					}
					catch(Exception e){}
					ob5.searchFacilityField.sendKeys(faciltiy);
					ob5.searchBtn.click();
					WaitClass.waitForElement(ob5.illegalDrugsQuestion, driver, 8000);
					ob5.firstSearch.click();
					WaitClass.waitForElement(ob5.bookFacilityBtn, driver, 20000);
					ob5.getFacility();
					ob5.bookFacilityBtn.click();
					WaitClass.waitForElement(ob5.scheduleApptHeader, driver, 20000);
					ob5.getToMonthAndYear(monthAndYear);
					ob5.clickDate(date);
					ob5.selectTime(time);
					ob5.continueBtn.click();
					WaitClass.waitForElement(ob5.confirmationText, driver, 20000);
					ob5.confirmBtn.click();
					ob7.spinner.isDisplayed();
					WaitClass.waitForElement(ob5.appointmentConfirmedText, driver, 20000);
					ob5.noThanksBtn.click();
				}
			else{
				WaitClass.waitForElement(ob5.cancelRescheduleBtn, driver, 20000);
				ob5.cancelRescheduleBtn.click();
			}
			boolean res = ob3.header.isDisplayed();
			Assert.assertEquals(res, true);
		}
		catch(Exception e){
			Assert.assertEquals(false, true);
		}
	}
	
	
}
