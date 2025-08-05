package TestNgPractices;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Enabled {
	@Test
	public void a11()
	{
		Reporter.log("a11 is executed", true);
	}
	@Test(enabled=false)
	public void a23()
	{
		Reporter.log("a23 is executed", true);
	}
	@Test(invocationCount=0)
	public void a31()
	{
		Reporter.log("a31 is executed", true);
	}
	@Test
	public void b25()
	{
		Reporter.log("b25 is executed", true);
	}
	@Test
	public void b11()
	{
		Reporter.log("b11 is executed", true);
	}
}
