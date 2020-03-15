package pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PageBase {
	
	 protected WebDriver driver;
	
	//Create Constructor
	public PageBase(WebDriver driver) {
		
		
		PageFactory.initElements(driver, this);		
	}
	protected static void clickButton(WebElement button) {
		
		button.click();
	}
	protected static void SetTextElement(WebElement TextName , String Value) {
		
		TextName.sendKeys(Value);
		
	}
	protected static void AssertElement(WebElement message , String Value) {
		assertEquals(message.getText(), Value);
	}

}
