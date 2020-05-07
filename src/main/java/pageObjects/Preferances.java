package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Preferances {

	public Preferances(AppiumDriver<AndroidElement> driver)
	{
		//PageFactory.initElements(driver, this); - for selenium
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}	
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='3. Preference dependencies']")   //IOSFindBy
	public WebElement dependencies;
	
	@AndroidFindBy(className="android.widget.Button")   //IOSFindBy
	public List<WebElement> button;
}
