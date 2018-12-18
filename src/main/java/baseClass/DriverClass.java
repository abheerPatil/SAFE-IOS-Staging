package baseClass;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

public class DriverClass {
	
  public static IOSDriver<MobileElement> driver = null;
  
  public DriverClass() {
	  DesiredCapabilities caps = new DesiredCapabilities();
      caps.setCapability("automationName", "XCUITest");
      caps.setCapability("platformName", "iOS");
      //caps.setCapability("platformVersion", "11.4.1");
      //caps.setCapability("platformVersion", "12.1");
      caps.setCapability("platformVersion", "12.0.1");
      caps.setCapability("deviceName","Iphone");
      //caps.setCapability("udid", "600cb9c46c56a6a37d1349373fc58f61cd022f72");				//IPHONE11
      //caps.setCapability("udid", "6d4e9b4d63092e8cd77e44ab13ee26399cf43866");				//IPHONE5
      //caps.setCapability("udid", "a950a9396a21ebdb9db8b6a6516ce0bb3640d41a");				//IPHONE14
      //caps.setCapability("udid", "2afd79377ab15e72774099b09c65d111a4c60ee8"); 			//IPHONE20-X 
      //caps.setCapability("udid", "096258d54e191bdd1a44efe7df3679a92fb5ecf9");				//IPHONE 7
      //caps.setCapability("udid", "e0de07129fa1b2b131462ce87a84c9c43c93e1da");				//IPHONE 13
      caps.setCapability("udid", "70879e0bd5b245a55107b8a2ef1f601d2d2db180"); 			//IPHONE15-X
      caps.setCapability("noReset", true);
      caps.setCapability("bundleId","org.safemovement.frontend");
      caps.setCapability("xcodeOrgId", "Q3HXH3MWZ2");
      caps.setCapability("xcodeSigningId", "iPhone Developer");
      caps.setCapability("newCommandTimeout", 60);
      caps.setCapability("autoDismissAlerts", true);
      try {
		driver = new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
	} catch (MalformedURLException e) {
		e.printStackTrace();
	}
}
  
  public static IOSDriver<MobileElement> set(){
	  new DriverClass();
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  return driver;
	  
  }
  
  
}
