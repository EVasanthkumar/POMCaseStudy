package pages;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;

public class editArticle {
	@FindBy(xpath="//a[text()=' Edit Article']")
	WebElement btnEditArticle;
	
	@FindBy(xpath="//*[@placeholder='Article Title']")
	WebElement txtArticleTitle;
	
	@FindBy(xpath="(//*[@class='form-control '])[1]")
	WebElement txtArticleAbout;
	
	@FindBy(xpath="//*[@name='body']")
	WebElement txtArticleDescription;
	
	@FindBy(xpath="//*[@name='tags']")
	WebElement txtArticletags;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement btnPublishArticle;
	
	@FindBy(xpath="//button[text()=' Delete Article']")
	WebElement btnDeleteArticle;

	private WebDriver driver;
	
	public editArticle(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	

	public void deleteAricle() {
		Assert.assertTrue(btnDeleteArticle.isDisplayed());
		btnDeleteArticle.click();
	}

	public void updateArticle(DataTable dataTable) {
		btnEditArticle.click();
		List<List<String>> data=dataTable.asLists(String.class);
		txtArticleTitle.clear();
		txtArticleTitle.sendKeys(data.get(0).get(0));
		txtArticleAbout.clear();
		txtArticleAbout.sendKeys(data.get(0).get(1));
		txtArticleDescription.clear();
		txtArticleDescription.sendKeys(data.get(0).get(2));
		txtArticletags.clear();
		txtArticletags.sendKeys(data.get(0).get(3));
		btnPublishArticle.click();
		
	}

	public void deleteAricleAlert() {
		Alert alert=driver.switchTo().alert();
	Assert.assertEquals(alert.getText(), "Want to delete the article?");
	alert.accept();
	
	}

}
