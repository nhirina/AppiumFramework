package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CheckoutPage {

	public CheckoutPage (AppiumDriver <AndroidElement> driver)
	{
		//PageFactory.initElements(driver, this); - for selenium
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}	
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	public WebElement nameField;
	
	@AndroidFindBy(xpath="//*[@text='Female']")
	public WebElement femaleOption;

	@AndroidFindBy(id="android:id/text1")
	public WebElement countrySelection;
	
	@AndroidFindBy(xpath="//*[@text='Argentina']")
	public WebElement Argentina;
	
		@AndroidFindBy(xpath="[@class='android.widget.Button']")
	public WebElement LetsShopButton;
		
		//driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"))
		@AndroidFindBy(id="com.androidsample.generalstore:id/productPrice")
		public List<WebElement> productList;
		
		//By.id("com.androidsample.generalstore:id/totalAmountLbl"))
		@AndroidFindBy(id="com.androidsample.generalstore:id/totalAmountLbl")
		public WebElement totalAmount;
		
		public List<WebElement> getProductList() //creating method for productList
		{
			return productList;
		}
}

