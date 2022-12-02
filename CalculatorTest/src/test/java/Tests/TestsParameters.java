package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestsParameters {
protected static WebDriver driver;
	
	

	
	@BeforeClass
	public static void SetUp() {
		driver = new ChromeDriver();
		//driver.manage().window().maximize();
		driver.get("http://localhost:8080/skaiciuotuvas");
	}
	

	
	@AfterClass
	public void TearDown() {
		driver.close();
	}

}
