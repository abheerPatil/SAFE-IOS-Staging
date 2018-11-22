package utlilty;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

public class WaitClass {

	public static void waitForElement(MobileElement element, IOSDriver<MobileElement>driver, int time){
		try{
			long currentTime = System.currentTimeMillis();
			long end = currentTime+time;
			while(System.currentTimeMillis() < end){
				try{
					element.isDisplayed();
					break;
				}
				catch(Exception e){}
			}
		}
		catch(Exception e){
			System.err.println("Exception in class - WaitClass, in method - waitForElement :"+e);
		}
	}
	
	public static void waitForWebElement(int time){
		try{
			long currentTime = System.currentTimeMillis();
			long end = currentTime+time;
			while(System.currentTimeMillis() < end){
				try{
					break;
				}
				catch(Exception e){}
			}
		}
		catch(Exception e){
			System.err.println("Exception in class - WaitClass, in method - waitForElement :"+e);
		}
	}
}
