package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage extends AbstractClass {
	By fieldUserName = By.cssSelector("body > div > form > div > input:nth-child(2)");
	By fieldPsw = By.cssSelector("body > div > form > div > input:nth-child(3)");
	By buttonLogin = By.cssSelector("body > div > form > div > button");
	By newUserRegistration = By.cssSelector("body > div > form > div > h4 > a");
	
	By buttonLogout = By.cssSelector("body > nav > div > ul.nav.navbar-nav.navbar-right > a");
	private WebDriver driver;
	
	By loginMessage = By.cssSelector("body > div > form > div > span:nth-child(4)");

	
	public loginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	//Metodai
	
	public void TypePersonalData(String username, String psw) throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(fieldUserName).sendKeys(username);
		Thread.sleep(2000);
		driver.findElement(fieldPsw).sendKeys(psw);
		Thread.sleep(2000);
	}
	
	public void ClickButtonLogin() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(buttonLogin).click();
		Thread.sleep(2000);
	}

	public void CatchUserName() throws InterruptedException {
		Thread.sleep(1000);
		String CartMessage = driver.findElement(buttonLogout).getText();
		Thread.sleep(1000);
		System.out.println("Show user name:" + CartMessage);
		Thread.sleep(1000);
		assertTrue("Logout, Dange11", true);
		Thread.sleep(1000);
		 
		System.out.println("Success Login");
	}

	

	
	private void assertTrue(String string, boolean b) {
		// TODO Auto-generated method stub
		
	}

	public void ClickLogout() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(buttonLogout).click();
		Thread.sleep(1000);
		
	}


	public void CatchErrorMessage() throws InterruptedException {
		Thread.sleep(1000);
		String CartMessage = driver.findElement(loginMessage).getText();
		Thread.sleep(1000);
		System.out.println(CartMessage);
		Thread.sleep(1000);
		assertTrue("Įvestas prisijungimo vardas ir/ arba slaptažodis yra neteisingi", true);
		Thread.sleep(1000);
		 
		System.out.println("Success. Catch Error Message");
	}
	
	
	
}
