package homework1;

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

public class HomeWork9 {
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

	//collects countries with zone >0
	public List<String> getCountryZones (By locator) {
		List<WebElement> listValues = driver.findElements(locator);
		List<String> countrywithZones = new ArrayList<String>();
		for(WebElement e : listValues )
		{	
			String attr = e.getText();
			countrywithZones.add(attr);
		}		
		return countrywithZones;
	}

	@Test
	public void countryNamesSorting() throws InterruptedException {
		//параметры
		String url = "http://localhost/litecart/admin/?app=countries&doc=countries";
		String login = "admin";
		String pass = "admin";
		//Открывает страницу магазина	 
		driver.get(url);
		driver.findElement(By.cssSelector("td input[name='username']")).sendKeys(login);
		driver.findElement(By.cssSelector("td input[name='password']")).sendKeys(pass);
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		//1а. проверить, что страны расположены в алфавитном порядке
		By countryLocator = By.cssSelector(".row td:nth-of-type(5) a");
		List<WebElement> countryElements = driver.findElements(countryLocator);
		boolean isSorted = true;
		for(int i = 0; i < countryElements.size() - 1; i++) {
			String e =countryElements.get(i).getAttribute("text"); 
			String e_next =countryElements.get(i + 1).getAttribute("text"); 		
			if(e.compareToIgnoreCase(e_next) > 0) { 
				isSorted = false;
				break;
			}
		}
		assertTrue(isSorted, "FAIL: Country list is not alphabetzied");
		//1б. для тех стран, у которых количество зон отлично от нуля -- 
		//открыть страницу этой страны и там проверить, что зоны расположены в алфавитном порядке
		int count = driver.findElements(By.cssSelector(".row td:nth-of-type(6)")).size();
		for(int i = 0; i < count; i++) {	
			List<WebElement> zoneCount = driver.findElements(By.cssSelector(".row td:nth-of-type(6)"));
			if(zoneCount.get(i).getText().compareToIgnoreCase("0") != 0) { 
				List<WebElement> countryToClick = driver.findElements(By.cssSelector(".row td:nth-of-type(5) a"));
				countryToClick.get(i).click();
				boolean zonesSorted = true;
				By zoneLocator = By.cssSelector("[name$='][name]']");
				List<WebElement> zones = driver.findElements(zoneLocator);
				for(int j = 0; j < zones.size() - 1; j++) {
					String e =zones.get(j).getAttribute("value"); 
					String e_next =zones.get(j + 1).getAttribute("value"); 				
					if(e.compareToIgnoreCase(e_next) > 0) { 
						zonesSorted = false;
						break;
					}
				}	
				assertTrue(zonesSorted, "FAIL: Zone list is not alphabetzied");
				driver.findElement(By.cssSelector("button[name='cancel']")).click();
				Thread.sleep(1000);
			}	
		}
		//2. на странице http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones
		//зайти в каждую из стран и проверить, что зоны расположены в алфавитном порядке		
		driver.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");		
		By countryName = By.cssSelector(".row td:nth-of-type(3) a");	
		int countCountry = driver.findElements(countryName).size();
		for (int i = 0; i < countCountry; i++) {
			List<WebElement> name = driver.findElements(countryName);
			WebElement client = name.get(i);
			System.out.println(i);
			client.click();
			By zoneName = By.cssSelector("[name$='[zone_code]'] [selected='selected']");
			List<WebElement> zonesToCheck = driver.findElements(zoneName);
			boolean zonesAreSorted = true;
			for(int j = 0; j < zonesToCheck.size() - 1; j++) {
				String e =zonesToCheck.get(j).getAttribute("text"); 
				String e_next =zonesToCheck.get(j + 1).getAttribute("text"); 
				if(e.compareToIgnoreCase(e_next) > 0) { 
					zonesAreSorted = false;
					break;
				}
			}
			assertTrue(zonesAreSorted, "FAIL: Zone list is not alphabetzied");
			driver.findElement(By.cssSelector("button[name='cancel']")).click();
			Thread.sleep(1000);
		}
	}

	@AfterClass
	public void stop() {
		driver.quit();
	}

}	
