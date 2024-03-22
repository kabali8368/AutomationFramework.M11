package practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionsPratice {
	
	@Test
	public void sample()
	{
		String a = "Hi";
		
		System.out.println("Step 1");
		System.out.println("Step 2");
		System.out.println("Step 3");
		
	//	Assert.assertEquals("a", "A");
		
		Assert.assertTrue(a.contains("I"));
		
		System.out.println("Step 4");
		System.out.println("Step 5");
		System.out.println("kabali");
		System.out.println("kabali 2");
			
	}
	
	@Test
	public void sample1()
	{
		
		SoftAssert sa = new SoftAssert();
		
		String a = "Hi";
		
		System.out.println("Step 1");
		sa.assertTrue(false);//fail
		
		System.out.println("Step 2");
		System.out.println("Step 3");
		
	
		sa.assertEquals(1, 2);//fail
		
		
		System.out.println("Step 4");
		System.out.println("Step 5");
		
		sa.assertAll();//log the assert failures
		
		
	}
}
