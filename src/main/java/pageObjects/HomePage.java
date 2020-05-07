package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

// All the objects belonging to one page will be belonging to one class
public class HomePage {
	
	//1. Call the driver object from test case to Page object file
	
	   //Concantanate driver
	public HomePage(AppiumDriver<AndroidElement> driver)
	{
		//PageFactory.initElements(driver, this); - for selenium
	PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Preference']")   //IOSFindBy
	public WebElement Preferances;
	
	//findElementByXpath("//android.widget.TextView[@text='Preference']");
}
