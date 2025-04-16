package stepDefinations;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import pages.GlobalFeed;
import pages.HomePage;
import base.TestBase;
import base.Utils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Login;
import pages.NewArticle;
import pages.editArticle;

public class ConduitSteps {

	public static WebDriver driver =TestBase.getDriver();
	Login login=new Login(driver);
	HomePage home=new HomePage(driver);
	NewArticle art=new NewArticle(driver);
	GlobalFeed global =new GlobalFeed(driver);
	editArticle edit =new editArticle(driver);
	
	
	@Given("User is on Login page to conduit")
	public void user_is_on_login_page_to_conduit() throws IOException {
		TestBase.openUrl(Utils.getConfigProperties("url"));
	}

	@When("User provide {string} and {string}")
	public void user_provide_and(String userName, String Password) {
		login.loginApp(userName, Password);
	}

	@Then("User should be on Home Page")
	public void user_should_be_on_home_page() {
		home.verifyHomePage();
	}
	
	@Given("User click on New Article Page button")
	public void user_click_on_new_article_page_button() {
		art.userClickOnCreateArticle();
	}

	@Given("User should be on New Article Page")
	public void user_should_be_on_new_article_page() {
		art.verifyEditerPage();
	}

	@When("User enters Article details")
	public void user_enters_article_details(DataTable dataTable) throws InterruptedException {
	art.createArticle(dataTable);
	}

	@Then("Article must be created")
	public void article_must_be_created() {
		art.verifyCreatedArticle();
	}

	@Given("User should be on Global Feed page")
	public void user_should_be_on_global_feed_page() {
		global.globalFeed();
	}

	@When("User select an article {string}")
	public void user_select_an_article(String string) {
		global.selectArticle(string,driver);
	}
	

	@Given("Article detail page must be displayed")
	public void article_detail_page_must_be_displayed() {
		global.verifyArticleDetails();
	}

	@When("User update article detail")
	public void user_update_article_detail(DataTable dataTable) {
		edit.updateArticle(dataTable);
	}

	

	@When("User delete article")
	public void user_delete_article() {
		edit.deleteAricle();
		
	}

	@Then("Article must be deleted")
	public void article_must_be_deleted() {
		edit.deleteAricleAlert();
	}
}
