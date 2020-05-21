package homework1;

import static org.testng.Assert.assertTrue;

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

	public boolean areElementsPresent(By locator) {
		return driver.findElements(locator).size() > 0;
	}

	public boolean getElementsStickers (By locator) {
		List<WebElement> listValues = driver.findElements(locator);
		for(WebElement e : listValues )
		{	
			String attr = e.getAttribute("class");
			if (attr == null || !attr.contains("sticker"))
			{
				return false;
			}
		}		
		return true;
	}

	@Test
	public void checkStickers() throws InterruptedException {
		//параметры
		String url = "http://localhost/litecart/en/";

		//Открывает страницу магазина	 
		driver.get(url);

		
		//Finds product image and checks div class to contain word "sticker"
		boolean check = getElementsStickers(By.cssSelector(".product div:nth-of-type(1) div"));
		assertTrue(check);
	}

	@AfterClass
	public void stop() {
		driver.quit();
	}

}	
