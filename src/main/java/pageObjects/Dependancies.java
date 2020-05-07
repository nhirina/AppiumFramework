package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Dependancies {
	public Dependancies(AppiumDriver driver)
	{
		//PageFactory.initElements(driver, this); - for selenium       //IOSFindBy
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="(//android.widget.RelativeLayout)[2]")  
	public WebElement relativeLayout;
	
	@AndroidFindBy(className="android.widget.EditText")  
	public WebElement editText;
}
