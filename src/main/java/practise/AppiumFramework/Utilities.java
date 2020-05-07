package practise.AppiumFramework;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Utilities {
	AndroidDriver<AndroidElement> driver; // declaring one more driver variable here
	
	public Utilities (AndroidDriver<AndroidElement> driver) //Add type arguments net to AndrDri <AndroidElement>
	//because, driver return type is a driver of <AndroidElement>
	{
		this.driver=driver;
	}

	public void scrollToText(String text)
	{
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));");
	}
}
