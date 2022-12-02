package Pages;

import static org.testng.Assert.assertEquals;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class registrationPage {
	By createNewUser = By.cssSelector("body > div > form > div > h4 > a");
	By fieldUserName = By.id("username");
	By fieldPsw = By.id("password");
	By fieldPswComfirm = By.id("passwordConfirm");
	By buttonSignUp = By.cssSelector("#userForm > button");
	By errorMessage = By.id("password.errors");
	By buttonLogout = By.cssSelector("body > nav > div > ul.nav.navbar-nav.navbar-right > a");
	By errorMessage2 = By.id("username.errors");
	By errorMessage3 = By.xpath("//*[@id=\"username.errors\"]");
	By errorMessage4 = By.id("passwordConfirm.errors");
	private WebDriver driver;
	
	

	public registrationPage(WebDriver driver) {
		this.driver=driver;
		
	}
	
	//Metodai
	public void ClickCreateNewUser() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(createNewUser).click();	
		Thread.sleep(1000);
	}
	
	
	public void EnterPersonalData(String username, String psw) throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(fieldUserName).sendKeys(username+RandomStringUtils.random(2,true, false));
		Thread.sleep(1000);
		driver.findElement(fieldPsw).sendKeys(psw);
		Thread.sleep(1000);
		driver.findElement(fieldPswComfirm).sendKeys(psw);
		Thread.sleep(1000);
		
	}
	
	public void EnterCredentials(String username, String psw) throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(fieldUserName).sendKeys(username);
		Thread.sleep(1000);
		driver.findElement(fieldPsw).sendKeys(psw);
		Thread.sleep(1000);
		driver.findElement(fieldPswComfirm).sendKeys(psw);
		Thread.sleep(1000);
	}
	
	
	
	public void ClickButtonSignUp() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(buttonSignUp).click();	
		Thread.sleep(1000);
	}
	
	
	
	public void CatchUserName() throws InterruptedException {
		Thread.sleep(1000);
		String CartMessage = driver.findElement(buttonLogout).getText();
		Thread.sleep(1000);
		System.out.println("Show user name:" + CartMessage);
		Thread.sleep(1000);
		takeSnapShot(driver);
		
		System.out.println("Success registration");
	}

	

	private void takeSnapShot(WebDriver driver2) {
		// TODO Auto-generated method stub
		
	}

	public void ClickLogout() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(buttonLogout).click();
		Thread.sleep(1000);
		
	}

	
	
	//Negative tests
	
	public void CatchOnlyNameError() throws InterruptedException {
		Thread.sleep(1000);
		String Message = driver.findElement(errorMessage).getAttribute("innerHTML");
		Thread.sleep(1000);
		System.out.println(Message);
		
		Thread.sleep(1000);
		assertEquals("Šį laukelį būtina užpildyti<br>Privaloma įvesti bent 3 simbolius", Message);
		Thread.sleep(1000);
		 
		System.out.println("Success catch error messages" + Message);
	}
	
	public void CatchOnlyPswError() throws InterruptedException {
		Thread.sleep(1000);
		String Message = driver.findElement(errorMessage2).getAttribute("innerHTML");
		Thread.sleep(1000);
		System.out.println(Message);
		
		Thread.sleep(1000);
		assertEquals("Šį laukelį būtina užpildyti<br>Privaloma įvesti nuo 3 iki 32 simbolių", Message);
		Thread.sleep(1000);
		 
		System.out.println("Success catch error messages" + Message);
	}
	
	
	public void CatchWithUsedUsernameError() throws InterruptedException {
		Thread.sleep(1000);
		String Message3 = driver.findElement(errorMessage3).getText();
		Thread.sleep(1000);
		System.out.println(Message3);
		
		Thread.sleep(1000);
		assertEquals("Toks vartotojo vardas jau egzistuoja", Message3);
		Thread.sleep(1000);
		 
		System.out.println("Success, catch error message.");
	}
	
	
	public void TypeCredentials(String username, String psw) throws InterruptedException {
			Thread.sleep(1000);
			driver.findElement(fieldUserName).sendKeys(username+RandomStringUtils.random(2,true, false));
			Thread.sleep(1000);
			driver.findElement(fieldPsw).sendKeys(psw);
			Thread.sleep(1000);
			driver.findElement(fieldPswComfirm).sendKeys(psw+RandomStringUtils.random(2,true, false));
			Thread.sleep(1000);
		
		
	}
	
	
	
	public void CatchPasswordsDontMatchError() throws InterruptedException {
		Thread.sleep(1000);
		String Message4 = driver.findElement(errorMessage4).getText();
		Thread.sleep(1000);
		System.out.println(Message4);
		
		Thread.sleep(1000);
		assertEquals("Įvesti slaptažodžiai nesutampa", Message4);
		Thread.sleep(1000);
		 
		System.out.println("Success, catch error message.");
	}
	
	
	public void ClearData() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(fieldUserName).clear();
		Thread.sleep(1000);
		driver.findElement(fieldPsw).clear();
		Thread.sleep(1000);
		driver.findElement(fieldPswComfirm).clear();
		Thread.sleep(1000);
	}
	
	
	
}

































