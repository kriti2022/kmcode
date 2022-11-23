package pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class TechfiosNSSPage {
	WebDriver driver;

	public TechfiosNSSPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//button[text()='Set SkyBlue Background']")
	 WebElement SkyBlueButton;
	@FindBy(how = How.XPATH, using = "//button[text()='Set White Background']")
	 WebElement WhiteButton;
	@FindBy(how = How.XPATH, using = "/html/body")
	 WebElement PageAttributes;

	public void clickonSkyBlueButton() {
		SkyBlueButton.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	public void clickonWhiteButton() {
		WhiteButton.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}
	public String checkBackgroudColor() {
		String pageColor;
		pageColor = PageAttributes.getCssValue("background-color");
		pageColor=(Color.fromString(pageColor).asHex().toString()) ;
		return pageColor;
	}
//#87ceeb	
	
	public String getPageTitle() {
		return driver.getTitle();

	}
	
		
	}
