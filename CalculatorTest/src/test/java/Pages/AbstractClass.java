package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AbstractClass {
	protected WebDriver driver;

	public void AbstractClass(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
}
}
