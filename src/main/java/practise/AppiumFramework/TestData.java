package practise.AppiumFramework;

import org.testng.annotations.DataProvider;

public class TestData {
	@DataProvider(name="InputData")
	public Object[][] getDataforEditBoxField()
	{
		//2 sets of data, "Hello", "!@#$" we will create multidimentional array 
		Object[][] obj= new Object[][]    //Object - for diferent data type, int - for numbers
				{
			{"Hello"}, {"@#%$"}
				};
				
				return obj;
				
		}
	
	@DataProvider(name="InputDataEcommerce")
	public Object[] totalValidation()
	{
		//2 sets of data, "Hello", "!@#$" we will create multidimentional array 
		Object[] obj= new Object[][]    //Object - for diferent data type, int - for numbers
				{
			 {"@#%$"}
				};
				
				return obj;
				
		}
}
