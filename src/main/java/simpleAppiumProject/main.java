package simpleAppiumProject;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

//import touchactions libraries
import io.appium.java_client.TouchAction;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
//import time library
import static java.time.Duration.ofSeconds;

public class main extends Capabilities {

	//declare class properties 
	private static AndroidDriver<AndroidElement> driver;
	private static TouchAction touchAction;
	private static WebElement expandableLists;
	private static WebElement peopleNames;
	
	public static void main(String[] args) throws MalformedURLException {
		// TODO start apllication with appium
	
		driver = baseCapabilities();
		driver.resetApp();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		testDragAndDropWithAppium();

		

	}
	
	private static void testDragAndDropWithAppium() {
		
		driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
		
		driver.findElementByXPath("//android.widget.TextView[@text='Drag and Drop']").click();
		
		WebElement source=driver.findElementsByClassName("android.view.View").get(0);
		
		WebElement destination=driver.findElementsByClassName("android.view.View").get(1);
	
		touchAction = new TouchAction(driver);
		
		touchAction.longPress(longPressOptions().withElement(element(source)).withDuration(ofSeconds(2))).moveTo(element(destination)).release().perform();

	}
	
	private static void testScrollingWithAppium() {
		
		driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
		
		//driver.findElementByAndroidUIAutomator("new UiSelector().clickable(true)").getSize();
		
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));").click();
		
	}
	
	private static void testSwipingWithAppium() {
		
		driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
		
		driver.findElementByXPath("//android.widget.TextView[@text='Date Widgets']").click();
		
		driver.findElementByAndroidUIAutomator("text(\"2. Inline\")").click();
		
		driver.findElementByXPath("//*[@content-desc='8']").click();
		
		//long press for swipe action to swipe from first point to second point
		touchAction = new TouchAction(driver);
		
		WebElement first=driver.findElement(By.xpath("//*[@content-desc='15']"));
		
		WebElement second=driver.findElement(By.xpath("//*[@content-desc='45']"));
		
		touchAction.longPress(longPressOptions().withElement(element(first)).withDuration(ofSeconds(2))).moveTo(element(second)).release().perform();
		
		
	}
	
	private static void testTouchActionWithAppium() {
		driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();

		touchAction = new TouchAction(driver);

		expandableLists = driver.findElement(By.xpath("//android.widget.TextView[@text='Expandable Lists']"));

		touchAction.tap(tapOptions().withElement(element(expandableLists))).perform();
		
		driver.findElementByXPath("//android.widget.TextView[@text='1. Custom Adapter']").click();
		
		peopleNames = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
		
		touchAction.longPress(longPressOptions().withElement(element(peopleNames)).withDuration(ofSeconds(2))).release().perform();
	
	}

	
	
	
	
	private void testClickActionsWithAppium() {
		
		driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='5. Preferences from code']").click();
		driver.findElementByXPath("//android.widget.LinearLayout[@index='1']").click();
		driver.findElementByXPath("//android.widget.LinearLayout[@index='4']").click();
		driver.findElementByXPath("//android.widget.EditText[@index='0']").sendKeys("shady");
		driver.findElementByXPath("//android.widget.Button[@index='1']").click();
		driver.findElementByXPath("//android.widget.LinearLayout[@index='4']").click();
		driver.findElementByXPath("//android.widget.EditText[@index='0']").replaceValue("ahmed");
		driver.findElementByXPath("//android.widget.Button[@index='1']").click();
	}

}
