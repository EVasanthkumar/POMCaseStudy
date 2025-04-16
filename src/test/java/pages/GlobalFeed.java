package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import stepDefinations.ConduitSteps;

public class GlobalFeed {
	@FindBy(xpath="//a[text()='Home']")
	WebElement btnHomePage;
	
	@FindBy(xpath="//button[text()='Global Feed']")
	WebElement btnGlobalFeed;
	
	@FindBy(xpath="//a[@class='preview-link']//h1")
	WebElement title;
	
	@FindBy(xpath="//div[@class='container']//h1")
	WebElement mainTitle;
	
	@FindBy(xpath="//div[@class='row article-content']//p")
	WebElement txtContent;
	
	
	
	public GlobalFeed(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void globalFeed() {
		btnHomePage.click();
		btnGlobalFeed.click();
	}
	
	public void selectArticle(String title1,WebDriver driver) {
		WebElement element=driver.findElement(By.xpath("//a[text()='"+title1+"']"));
		element.click();
		title.click();
	}

	
	public void verifyArticleDetails() {
		mainTitle.isDisplayed();
		txtContent.isDisplayed();
	}

	

}
