
package session5;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AutomationTestNG {
	WebDriver driver;
	By USERNAME = By.xpath("//input[@id='username']");
	By PASSWORD = By.xpath("//input[@id='password']");
	By LOGIN = By.xpath("//button[@class='btn btn-success block full-width']");
	By DASHBOARD = By.xpath("//h2[text()=' Dashboard ']");
	String username = "demo@techfios.com";
	String password = "abc123";
	String expectedTitle = "Dashboard";

	@BeforeMethod
	public void init() {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://techfios.com/test/101/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void addCategory() {
		String catName = "KMCat"+ System.currentTimeMillis();
		driver.findElement(By.name("categorydata")).sendKeys(catName);
		driver.findElement(By.xpath("//input[@value='Add category']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//span[text()='" + catName + "']")).getText(),catName,"Category Found");

	}

	@Test
	public void addDuplicateCategory() {
		String catName = "KMCat108";
		driver.findElement(By.name("categorydata")).sendKeys(catName);
		driver.findElement(By.xpath("//input[@value='Add category']")).click();
		//Assert.assertEquals(driver.findElement(By.xpath("//body[contains(text(),'The category you want to add already exists:')]")).getText(),"The category you want to add already exists: " + catName + ".","The category you want to add already exists: " + catName + ".");
		Assert.assertEquals(driver.findElements(By.xpath("//body[contains(text(),'The category you want to add already exists:')]")).size(),0,"The category you want to add already exists: " + catName + ".");
		
		
		
	}
	
	@Test
	public void checkDueMonth() {
	
		Select se = new Select(driver.findElement(By.xpath("//*[@name='due_month']")));
		int i;
		int j=0;
		List<WebElement> options = se.getOptions();
		
		String[] mths = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
		List<String> mthList = Arrays.asList(mths);
		
		for (i=0;i<options.size();i++)
		{
			if (mthList.indexOf(options.get(i).getText()) >=0 )
			 {
				j=j+mthList.indexOf(options.get(i).getText());
			 }
			
			//System.out.println(options.get(i).getText() + mthList.indexOf(options.get(i).getText()) );
		}
		//System.out.println(j );
		
		Assert.assertEquals(j,66,"Months missing");
		
		
	}
		
	}
	

