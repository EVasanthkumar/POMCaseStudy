package pages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;

public class NewArticle {

	
	@FindBy(xpath="//*[text()='New Article']")
	WebElement lnkNewArticle;
	
	@FindBy(xpath="//*[@placeholder='Article Title']")
	WebElement txtArticleTitle;
	
	@FindBy(xpath="(//*[@class='form-control '])[1]")
	WebElement txtArticleAbout;
	
	@FindBy(xpath="//*[@name='body']")
	WebElement txtArticleDescription;
	
	@FindBy(xpath="//*[@name='tags']")
	WebElement txtArticletags;
	
	@FindBy(xpath="//*[text()='Publish Article']")
	WebElement btnPublishArticle;
	
	@FindBy(xpath="//*[@class='article-actions']")
	WebElement isArticleCreated;

	private WebDriver driver;
	
	
	
	public NewArticle(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void userClickOnCreateArticle() {
		lnkNewArticle.click();
	}
	
	public void verifyEditerPage() {
		driver.getTitle();
		Assert.assertEquals(driver.getCurrentUrl(), "https://conduit-realworld-example-app.fly.dev/#/editor");
	}
	
public void createArticle(DataTable dataTable) throws InterruptedException {
	List<List<String>> data=dataTable.asLists(String.class);
	txtArticleTitle.clear();
	txtArticleTitle.sendKeys(data.get(0).get(0));
	txtArticleAbout.sendKeys(data.get(0).get(1));
	txtArticleDescription.sendKeys(data.get(0).get(2));
	txtArticletags.sendKeys(data.get(0).get(3));
	btnPublishArticle.click();
}

public void verifyCreatedArticle() {
	Assert.assertTrue(isArticleCreated.isDisplayed());
	
}

}
