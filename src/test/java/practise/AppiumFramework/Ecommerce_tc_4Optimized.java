package practise.AppiumFramework;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.CheckoutPage;
import pageObjects.FormPage;


public class Ecommerce_tc_4Optimized extends baseEcommerce {
	
	//public static void main(String[] args) throws InterruptedException, IOException {  - removing because implementing TestNg
		@Test(dataProvider="InputDataEcommerce",dataProviderClass=TestData.class)
		public void totalValidation(String input) throws IOException, InterruptedException 
		{
			service=startServer();
	AndroidDriver<AndroidElement> driver=Capabilities("GeneralStoreApp");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	FormPage formPage = new FormPage(driver); 
	
	formPage.nameField.sendKeys("input");
	//formPage.getNameField().sendKeys("Hello"); //Another way to call name field (if you need system.out.print)
	driver.hideKeyboard();
	
	formPage.femaleOption.click();
	formPage.getcountrySelection().click();
	
	Utilities u=new Utilities(driver);
	u.scrollToText("Argentina");
	//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");
	
	//driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + "Argentina" + "\").instance(0))"));
    //scrolling for older versions (containedText = Argentina)
	
	driver.findElementByXPath("//*[@text='Argentina']").click();
	driver.findElementByXPath("//*[@class='android.widget.Button']").click();
	//driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).click();
		
	driver.findElementsByXPath("//android.widget.TextView[@text='ADD TO CART']").get(0).click();
	driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"+ ".resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView("+ "new UiSelector().text(\"Nike Blazer Mid '77\"));");
	driver.findElementsByXPath("//android.widget.TextView[@text='ADD TO CART']").get(0).click();
	driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
	Thread.sleep(4000); ////when object the same on multiple pages use thread sleep 
		
	int count = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).size();
	double sum = 0;
	
	CheckoutPage checkOutPage = new CheckoutPage (driver);
	
	for(int i=0;i<count;i++)
	{
	String amount1= checkOutPage.productList.get(i).getText();
	double amount = getAmount(amount1);
	sum = sum+amount; // 1st loop - 160.97(0+i[0]), 2nd 120+160.97, etc 
	}
	    
	//String amount1=	driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(0).getText(); //$160.97
	//double amount1value = getAmount(amount1);
	//String amount2=	driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(1).getText(); //$120.0
	//double amount2value = getAmount(amount2);
	//double sumOfProducts = amount1value + amount2value;
	    
	System.out.println(sum+"sum of products");
	    
	String total= checkOutPage.totalAmount.getText(); //Sum
	total = total.substring(1); //removed $ sign 
	double totalValue=Double.parseDouble(total);//convert to double value
	System.out.println(totalValue+"Total value of products");
	    
	Assert.assertEquals( sum, totalValue);   
	service.stop();
	
	}
      
		
	  public static double getAmount(String value)
	  {
	   value = value.substring(1);
	   double amount2value= Double.parseDouble(value);
	   return amount2value; 
	  }	
}
