package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage {

	public HomePage(AppiumDriver driver) {

		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	// Path to view widget
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Views']")
	public WebElement viewsWidget;

	// drag and drop
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Drag and Drop']")
	public WebElement dragDrop;

	// second button
	@AndroidFindBy(className = "android.view.View")
	public WebElement viewButton;

}
