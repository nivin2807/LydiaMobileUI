package Lydia.Driver;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.testng.annotations.Test;
import java.net.MalformedURLException;

public class DriverFactory {
   
	private static AndroidDriver driver; 
	private static AppiumDriverLocalService service;

	
		
    public static AndroidDriver setupDriver() 

    {
    	 
    		 try {
    	 
		
		service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\balap\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
			.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();
		
		// Appium 2.0 Options setup
		
		// Setting the APK file path
		
		// Launch App
		
		String apkPath = new File("src\\test\\resources\\App\\app-alpha-universal-release.apk").getAbsolutePath();
		
		UiAutomator2Options options = new UiAutomator2Options();
    	
    	options.setPlatformName("Android");
    	options.setAutomationName("UiAutomator2");
    	options.setDeviceName("Android_Emulator");
    	
    	
    	options.setAppPackage("org.wikipedia.alpha");
    	options.setAppActivity("org.wikipedia.main.MainActivity");
   
    	
    	options.setApp(apkPath);
    	
    	driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
    	
    }
    	 catch (Exception e) {
             throw new RuntimeException("Failed to start AndroidDriver", e);
             
    	 } 
    	 
    	 return driver;
    	 
    	 }
   public static void teardownDriver() {

    	// Close app
        if (driver != null) { 
            driver.quit(); 
            service.stop();
            driver = null;
        }
		
		
    }
    
    	
}	

