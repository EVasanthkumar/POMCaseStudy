package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	

	@FindBy(xpath="//a[text()='Login']")
	WebElement btnLogin;
	
	@FindBy(name="email")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;

	@FindBy(xpath="//button[text()='Login']")
	WebElement loginButton;

	
	
	public Login(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void loginApp(String user, String password1)
	 {
		 btnLogin.click();
		 username.sendKeys(user);
		 password.sendKeys(password1);
		 loginButton.click();
	 }

}
