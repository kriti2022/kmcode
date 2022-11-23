package steps;

import org.openqa.selenium.support.PageFactory;
import java.sql.Timestamp;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import pages.TechfiosNSSPage;
import pages.TestBase;

public class LoginStepDefinition extends TestBase {
	TechfiosNSSPage techfiosnsspage;

	@Before
	public void SetUp() {
		initDriver();
		techfiosnsspage = PageFactory.initElements(driver, TechfiosNSSPage.class);
		
		
	}
	         
	@Given("^Set SkyBlue Background button exists$")
	public void given_skyblue_button_exists() {
		driver.get("https://techfios.com/test/101/");
		
	}
	
	@When("^User clicks on Set Skyblue Background$")
	public void User_clicks_on_Set_Skyblue_Background() {
		//switch(buttonorLink) {
		//case "Set Skyblue Background":
			techfiosnsspage.clickonSkyBlueButton();	}
		//break;
		//case "Set White Background":
		//	techfiosnsspage.clickonSkyBlueButton();	
		//	break;
		//	default:
		//	System.out.println("Unable to click button or link" + buttonorLink);	
		//	break;
		
		
	//}
	

	@Given("^Set SkyWhite Background button exists$")
	public void given_white_button_exists() {
		driver.get("https://techfios.com/test/101/");
		
	}

	@When("^User clicks on Set White Background$")
	public void User_clicks_on_Set_White_Background() {
		//switch(buttonorLink) {
		//case "Set Skyblue Background":
			techfiosnsspage.clickonWhiteButton();	}

	@Then("^User should see Skyblue Background$")
	public void User_should_see_Skyblue_Background() {
		
		
		String ExpectedColor = "#87ceeb";
		String ActualColor = techfiosnsspage.checkBackgroudColor();
		Assert.assertEquals(ExpectedColor, ActualColor);
         takeScreenshot(driver);
	}

	@Then("^User should see White Background$")
	public void User_should_see_White_Background() {
		String ExpectedColor = "#ffffff";
		String ActualColor = techfiosnsspage.checkBackgroudColor();
		Assert.assertEquals(ExpectedColor, ActualColor);
         takeScreenshot(driver);
	}
	

	@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}
