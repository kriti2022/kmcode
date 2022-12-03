

package various;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class AutomationJunit {
	
	WebDriver driver;
	
	@Before
	public  void launchBrowser()
	{
		System.setProperty("webdriver.chrome.driver","driver\\chromedriver.exe");	
		
		 driver =new ChromeDriver();
		//Delete All Cookies
	
		driver.manage().deleteAllCookies();
		//Go to URL
		driver.get("http://techfios.com/test/101/");
		// To Maximize Windows
		driver.manage().window().maximize();
	 // apply implicitly wait
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		
	}
	
	@Test
	public  void validateAllChecked()
	{
		driver.findElement(By.name("allbox")).click();
		int i;		
		String chkboxName ;
		
		for (i=1;i<15;i++)
			{
			 chkboxName = "todo[" + i + "]";
			 
			 
			 if (driver.findElements(By.name(chkboxName)).size()==0)
			{
					chkboxName = "todo[" + i + "]";
				}
				else
				{
					chkboxName = "todo[" + i + "]";
					Assert.assertEquals(driver.findElement(By.name(chkboxName)).isSelected(),true);
				}
			}
	}
	
	@Test
	public  void validateOneDelete()
	{
		driver.findElement(By.name("todo[1]")).click();
		driver.findElement(By.xpath("//input[@value='Remove']")).click();
		Assert.assertEquals( driver.findElements(By.name("todo[1]")).size(),0);
	}
	
	
	@Test
		public  void validateAllRemoved()
		{
			driver.findElement(By.name("allbox")).click();
			driver.findElement(By.xpath("//input[@value='Remove']")).click();
			int i;		
			String chkboxName ;
			
			for (i=1;i<6;i++)
				{
				 chkboxName = "todo[" + i + "]";
				 Assert.assertEquals( driver.findElements(By.name(chkboxName)).size(),0);
				}
		}
	
	//@Test
	public void neglogin()
	{
		driver.findElement(By.id("login_field")).sendKeys("kriti2022!");
		driver.findElement(By.id("password")).sendKeys("techfios123");
	driver.findElement(By.name("commit")).click();
	}
	
	
	@After
	public  void tearDown()
	{
		driver.close();
	}

}

