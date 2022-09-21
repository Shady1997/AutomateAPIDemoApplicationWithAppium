package test_cases;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

//import touchactions libraries
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pages.PageBase;

public class E2E_Drag_Drop extends TestBase {

	// declare class properties
	private static WebElement expandableLists;
	private static WebElement peopleNames;

	@Test(priority = 1, groups = "smoke", description = "Check drag and drop operation")
	public void checkDragDrop() throws InterruptedException {
		homePage.viewsWidget.click();
		PageBase.captureScreenshot(driver, "beforeDragDrop");
		Thread.sleep(2000);
		homePage.dragDrop.click();
		Thread.sleep(2000);
		WebElement source = driver.findElementsByClassName("android.view.View").get(0);

		WebElement destination = driver.findElementsByClassName("android.view.View").get(1);

		dragDrop(driver, source, destination);
		PageBase.captureScreenshot(driver, "afterDragDrop");
	}

	public void dragDrop(AndroidDriver<AndroidElement> driver, WebElement source, WebElement destination) {
		TouchAction touchAction = new TouchAction(driver);
		touchAction.longPress(longPressOptions().withElement(element(source)).withDuration(ofSeconds(2)))
				.moveTo(element(destination)).release().perform();
	}
}
