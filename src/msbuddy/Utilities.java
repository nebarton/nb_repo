package msbuddy;

import java.io.File;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebElement;

public class Utilities {
	


	public class MAUtils {
		public void sleep(int time_ms) {
			try {
				Thread.sleep(time_ms);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public String getMonthAndDate() {
			Format formatter = new SimpleDateFormat("MMMM d"); 
		    String date = formatter.format(new Date());
		    return date;
		}
		
		public void log(String msg) {
			System.out.println(msg);
		}
		

		public void scroll(String direction, IOSDriver<MobileElement> driver) throws InterruptedException  {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			HashMap<String, String> scrollObject = new HashMap<String, String>();
			scrollObject.put("direction", direction);
			js.executeScript("mobile: scroll", scrollObject);
		}
		
		public void scrollToName(RemoteWebElement element, IOSDriver<MobileElement> driver) throws InterruptedException {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			HashMap<String, String> scrollObject = new HashMap<String, String>();
			scrollObject.put("direction", "down");
			scrollObject.put("element", ((RemoteWebElement) element).getId());
			js.executeScript("mobile: scroll", scrollObject);
		}
		
		
		
		
		
		
	}


}
