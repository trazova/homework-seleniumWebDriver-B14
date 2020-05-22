package homework1;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomeWork8 {
	private WebDriver driver;

	@BeforeClass
	public void start () {
		// initiate web driver and max page size
		System.setProperty("webdriver.chrome.driver", "C://software//chromedriver_win32//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}	     

	public List<String> getAttributeForEach(By locator, String attributeName) {
	        List<WebElement> elements = driver.findElements(locator);
	        List<String> attributes = new ArrayList<String>();
	        for (WebElement element : elements) {
	            attributes.add(element.getAttribute(attributeName));
	        }
	        return attributes;
	    }
	
	@Test
	public void checkStickers() throws InterruptedException {
		//параметры
		String url = "http://localhost/litecart/en/";

		//Открывает страницу магазина	 
		driver.get(url);

		//Finds product image and checks div class to contain word "sticker"
		int countStickers = getAttributeForEach(By.cssSelector(".product div[class*='sticker']"), "class").size();
		int countProducts = driver.findElements(By.cssSelector(".product [class='link']")).size();
		assertEquals(countStickers, countProducts);
	}

	@AfterClass
	public void stop() {
		driver.quit();
	}

}	
