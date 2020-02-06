import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileSelector;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class Base {

	public static AndroidDriver<AndroidElement> capabilities() throws MalformedURLException {
		
		File f = new File("src/app");
		File appFile = new File(f, "ApiDemos-debug.apk");
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus5X");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, 
				AutomationName.ANDROID_UIAUTOMATOR2);
		cap.setCapability(MobileCapabilityType.APP, appFile.getAbsolutePath());
		
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(
				new URL("http://127.0.0.1:4723/wd/hub"), cap);
		
		return driver;
	}
}