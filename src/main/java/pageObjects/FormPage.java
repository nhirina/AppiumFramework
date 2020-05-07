package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPage {

	public FormPage(AppiumDriver <AndroidElement> driver)
	{
		//PageFactory.initElements(driver, this); - for selenium
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}	
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	public WebElement nameField;
	
	@AndroidFindBy(xpath="//*[@text='Female']")
	public WebElement femaleOption;

	@AndroidFindBy(id="android:id/text1")
	private WebElement countrySelection;
	
	@AndroidFindBy(xpath="//*[@text='Argentina']")
	public WebElement Argentina;
	
	//driver.findElementByXPath("//*[@class='android.widget.Button']").click();
	@AndroidFindBy(xpath="[@class='android.widget.Button']")
	public WebElement LetsShopButton;
	
	public WebElement getnameField()
	{
		System.out.println("trying to find the name field");
		return nameField;
	}
	
	public WebElement getcountrySelection()
	{
		System.out.println("Select the option from the dropdown");
		return countrySelection;
	}
}

