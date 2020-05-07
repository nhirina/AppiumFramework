package practise.AppiumFramework;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class baseEcommerce {
	public static AppiumDriverLocalService service;
	public static AndroidDriver<AndroidElement> driver; 
	
	  public AppiumDriverLocalService startServer()
	    {
		//appium github java client
		boolean flag = checkIfServerIsRunning(4723);   //To terminate all the ports from CMD ( taskkill /F /IM node.exe )
		if(!flag)  // true of negation is false so if server not running if code will not be ecexuted 
	    {		
		 service=AppiumDriverLocalService.buildDefaultService();     //appium class with method - build default service
         service.start();
	    }
         return service;
	    }
	  
      public static boolean checkIfServerIsRunning(int port) 
      {
		boolean isServerRunning = false;
		  ServerSocket serverSocket;
		  try
		  {
			serverSocket = new ServerSocket(port);
			serverSocket.close();
		  } 
		  catch (IOException e) 
		  {
			//If control comes here, then it means that the port is in use
			isServerRunning = true;
		  } 
		  finally 
		  {
			serverSocket = null;
		  }
		 return isServerRunning;
	   }
	
    
      public static void startEmulator() throws IOException, InterruptedException
    {
    	//C:\Users\nataliya.hirina\eclipse-workspace\AppiumFramework\src\main\java\resources\startEmulator.bat
    	Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\startEmulator.bat");
        Thread.sleep(6000);
    }
      
	  public static AndroidDriver<AndroidElement> Capabilities(String appName) throws MalformedURLException, IOException  //When you initialize driver for the first time - AndroidDriver<AndroidElement> - same should match with your Utilities 
       , InterruptedException
	{
		//FileInputStream fis=new FileInputStream("C:\\Users\\nataliya.hirina\\eclipse-workspace\\AppiumFramework\\src\\main\\java\\practise\\AppiumFramework\\global.properties");
		//System.getProperty("user.dir");
		//FileInputStream fis=new FileInputStream (System.getProperty("user.dir")+"\\src\\General-Store.apk");
		FileInputStream fis=new FileInputStream (System.getProperty("user.dir")+"\\src\\main\\java\\practise\\AppiumFramework\\global.properties");
		Properties prop=new Properties();
        prop.load(fis);
	
		File appDir=new File("src"); //folder where apk is located 
		File app=new File(appDir, (String) prop.get(appName));
		DesiredCapabilities cap = new DesiredCapabilities();
		
		//String device=(String) prop.get("device");   //Pixelemulator
		
		String device =System.getProperty("deviceName");
		
		 if (device.contains("emulator"))
		 {
			 startEmulator();
		 }
		 // start Emulator method 
		
		
		
    cap.setCapability(MobileCapabilityType.DEVICE_NAME, device);   //  cap.setCapability(capabilityName, value);
    cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2"); // Android updated its internal framework to uiautomator2 and through Appium code, we need to tell that we need to access uiautomator2 elements of Android.
    cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 14);
    
    //cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
    //cap.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));
    //cap.setCapability("chromedriverExecutable", "C:\\Users\\nataliya.hirina\\AppData\\Roaming\\npm\\node_modules\\appium\\node_modules\\appium-chromedriver\\chromedriver\\win\\chromedriver.exe");
    
    cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath()); // Path to application
    AndroidDriver<AndroidElement> driver =new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap); 
    return driver; 
	}
    
	public static void getScreenshot(String s) throws IOException 
	{
	  File scrfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFile(scrfile, new File(System.getProperty("user.dir")+"\\"+s+".png"));
	}
	
	@BeforeTest
	public void killAllNodes() throws IOException, InterruptedException
	{	
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Thread.sleep(3000);
	}
	
}
	

