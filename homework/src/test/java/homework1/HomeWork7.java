package homework1;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomeWork7 {
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
	
	@Test
	public void AdminLogin() throws InterruptedException {
		//параметры
		String url = "http://localhost/litecart/admin/";
		String login = "admin";
		String pass = "admin";
		//Открывает страницу логина	 
		driver.get(url);
		//Вводит логин, пароль, нажимает кнопку Войти
		driver.findElement(By.cssSelector("td input[name='username']")).sendKeys(login);
		driver.findElement(By.cssSelector("td input[name='password']")).sendKeys(pass);
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		
		//Click Menu Appearance
		driver.findElement(By.xpath("//a//span[@class='name'] [(text()='Appearence')]")).click();
		//Check header is presents
		assertTrue(areElementsPresent(By.cssSelector("h1[style]")));		
		//click sub-menu Template
		driver.findElement(By.cssSelector("[id='doc-template'] a")).click();
		//Check header is presents
		assertTrue(areElementsPresent(By.cssSelector("h1[style]")));		
		//click sub-menu Logotype
		driver.findElement(By.cssSelector("[id='doc-logotype'] a")).click();
		//Check header is presents
		assertTrue(areElementsPresent(By.cssSelector("h1[style]")));		
		
		//Click Parent Menu Catalog
		driver.findElement(By.xpath("//a//span[@class='name'] [(text()='Catalog')]")).click();
		//Check header is presents
		assertTrue(areElementsPresent(By.cssSelector("h1[style]")));		
		
		//Click Child Menu Catalog
		driver.findElement(By.cssSelector("[id='doc-catalog'] a")).click();
		//Check header is presents
		assertTrue(areElementsPresent(By.cssSelector("h1[style]")));		
		
		//Click Product Groups
		driver.findElement(By.cssSelector("[id='doc-product_groups'] a")).click();
		//Check header is presents
		assertTrue(areElementsPresent(By.cssSelector("h1[style]")));
		
		//Click Option Groups
		driver.findElement(By.cssSelector("[id='doc-option_groups'] a")).click();
		//Check header is presents
		assertTrue(areElementsPresent(By.cssSelector("h1[style]")));
		
		//Click Manufacturers
		driver.findElement(By.cssSelector("[id='doc-manufacturers'] a")).click();
		//Check header is presents
		assertTrue(areElementsPresent(By.cssSelector("h1[style]")));
		
		//Click Suppliers
		driver.findElement(By.cssSelector("[id='doc-suppliers'] a")).click();
		//Check header is presents
		assertTrue(areElementsPresent(By.cssSelector("h1[style]")));
		
		//Click Delivery Statuses
		driver.findElement(By.cssSelector("[id='doc-delivery_statuses'] a")).click();
		//Check header is presents
		assertTrue(areElementsPresent(By.cssSelector("h1[style]")));
		
		//Click Sold Out Statuses
		driver.findElement(By.cssSelector("[id='doc-sold_out_statuses'] a")).click();
		//Check header is presents
		assertTrue(areElementsPresent(By.cssSelector("h1[style]")));
		
		//Click Quantity Units
		driver.findElement(By.cssSelector("[id='doc-quantity_units'] a")).click();
		//Check header is presents
		assertTrue(areElementsPresent(By.cssSelector("h1[style]")));
		
		//Click CSV Import/Export
		driver.findElement(By.cssSelector("[id='doc-csv'] a")).click();
		//Check header is presents
		assertTrue(areElementsPresent(By.cssSelector("h1[style]")));
		
		//Click Menu Countries
		driver.findElement(By.xpath("//a//span[@class='name'] [(text()='Countries')]")).click();
		//Check header is presents
		assertTrue(areElementsPresent(By.cssSelector("h1[style]")));	
		
		//Click Menu Currencies
		driver.findElement(By.xpath("//a//span[@class='name'] [(text()='Currencies')]")).click();
		//Check header is presents
		assertTrue(areElementsPresent(By.cssSelector("h1[style]")));	
		
		//Click Parent Menu Customers
		driver.findElement(By.xpath("//a//span[@class='name'] [(text()='Customers')]")).click();
		//Check header is presents
		assertTrue(areElementsPresent(By.cssSelector("h1[style]")));	
		
		//Click Child Menu Customers
		driver.findElement(By.cssSelector("[id='doc-customers'] a")).click();
		//Check header is presents
		assertTrue(areElementsPresent(By.cssSelector("h1[style]")));	
		
		//Click Child Menu CSV Import/Export
		driver.findElement(By.cssSelector("[id='doc-csv'] a")).click();
		//Check header is presents
		assertTrue(areElementsPresent(By.cssSelector("h1[style]")));
		
		//Click Child Menu Newsletter
		driver.findElement(By.cssSelector("[id='doc-newsletter'] a")).click();
		//Check header is presents
		assertTrue(areElementsPresent(By.cssSelector("h1[style]")));	
		
		//Click Menu Geo Zones
		driver.findElement(By.xpath("//a//span[@class='name'] [(text()='Geo Zones')]")).click();
		//Check header is presents
		assertTrue(areElementsPresent(By.cssSelector("h1[style]")));
		
		//Click Parent Menu Languages
		driver.findElement(By.xpath("//a//span[@class='name'] [(text()='Languages')]")).click();
		//Check header is presents
		assertTrue(areElementsPresent(By.cssSelector("h1[style]")));
		
		//Click Child Menu Languages
		driver.findElement(By.cssSelector("[id='doc-languages'] a")).click();
		//Check header is presents
		assertTrue(areElementsPresent(By.cssSelector("h1[style]")));	
		
		//Click Menu Storage Encoding
		driver.findElement(By.cssSelector("[id='doc-storage_encoding'] a")).click();
		//Check header is presents
		assertTrue(areElementsPresent(By.cssSelector("h1[style]")));		
		
		//Click Menu Modules
		driver.findElement(By.xpath("//a//span[@class='name'] [(text()='Modules')]")).click();
		//Check header is presents
		assertTrue(areElementsPresent(By.cssSelector("h1[style]")));	
		
		//Click Menu Background Jobs
		driver.findElement(By.cssSelector("[id='doc-jobs'] a")).click();
		//Check header is presents
		assertTrue(areElementsPresent(By.cssSelector("h1[style]")));	
		
		//Click Menu Customer
		driver.findElement(By.cssSelector("[id='doc-customer'] a")).click();
		//Check header is presents
		assertTrue(areElementsPresent(By.cssSelector("h1[style]")));
		
		//Click Menu Shipping
		driver.findElement(By.cssSelector("[id='doc-shipping'] a")).click();
		//Check header is presents
		assertTrue(areElementsPresent(By.cssSelector("h1[style]")));
		
		//Click Menu Payment
		driver.findElement(By.cssSelector("[id='doc-payment'] a")).click();
		//Check header is presents
		assertTrue(areElementsPresent(By.cssSelector("h1[style]")));
		
		//Click Menu Order Total
		driver.findElement(By.cssSelector("[id='doc-order_total'] a")).click();
		//Check header is presents
		assertTrue(areElementsPresent(By.cssSelector("h1[style]")));
		
		//Click Menu Order Success
		driver.findElement(By.cssSelector("[id='doc-order_success'] a")).click();
		//Check header is presents
		assertTrue(areElementsPresent(By.cssSelector("h1[style]")));
		
		//Click Menu Order Action
		driver.findElement(By.cssSelector("[id='doc-order_action'] a")).click();
		//Check header is presents
		assertTrue(areElementsPresent(By.cssSelector("h1[style]")));		
		
		//Click Parent Menu Orders
		driver.findElement(By.xpath("//a//span[@class='name'] [(text()='Orders')]")).click();
		//Check header is presents
		assertTrue(areElementsPresent(By.cssSelector("h1[style]")));	
		
		//Click Child Menu Orders
		driver.findElement(By.cssSelector("[id='doc-orders'] a")).click();
		//Check header is presents
		assertTrue(areElementsPresent(By.cssSelector("h1[style]")));
		
		//Click Menu Order Statuses
		driver.findElement(By.cssSelector("[id='doc-order_statuses'] a")).click();
		//Check header is presents
		assertTrue(areElementsPresent(By.cssSelector("h1[style]")));
		
		//Click Menu Pages
		driver.findElement(By.xpath("//a//span[@class='name'] [(text()='Pages')]")).click();
		//Check header is presents
		assertTrue(areElementsPresent(By.cssSelector("h1[style]")));	
		
		//Click Menu Reports
		driver.findElement(By.xpath("//a//span[@class='name'] [(text()='Reports')]")).click();
		//Check header is presents
		assertTrue(areElementsPresent(By.cssSelector("h1[style]")));
		
		//Click Menu Monthly Sales
		driver.findElement(By.cssSelector("[id='doc-monthly_sales'] a")).click();
		//Check header is presents
		assertTrue(areElementsPresent(By.cssSelector("h1[style]")));
		
		//Click Menu Most Sold Products
		driver.findElement(By.cssSelector("[id='doc-most_sold_products'] a")).click();
		//Check header is presents
		assertTrue(areElementsPresent(By.cssSelector("h1[style]")));
		
		//Click Menu Most Shopping Customers
		driver.findElement(By.cssSelector("[id='doc-most_shopping_customers'] a")).click();
		//Check header is presents
		assertTrue(areElementsPresent(By.cssSelector("h1[style]")));	
		
		//Click Menu Settings
		driver.findElement(By.xpath("//a//span[@class='name'] [(text()='Settings')]")).click();
		//Check header is presents
		assertTrue(areElementsPresent(By.cssSelector("h1[style]")));
		
		//Click Menu Store Info
		driver.findElement(By.cssSelector("[id='doc-store_info']")).click();
		//Check header is presents
		assertTrue(areElementsPresent(By.cssSelector("h1[style]")));
		
		//Click Menu Defaults
		driver.findElement(By.cssSelector("[id='doc-defaults'] a")).click();
		//Check header is presents
		assertTrue(areElementsPresent(By.cssSelector("h1[style]")));
		
		//Click Menu General
		driver.findElement(By.cssSelector("[id='doc-general'] a")).click();
		//Check header is presents
		assertTrue(areElementsPresent(By.cssSelector("h1[style]")));
		
		//Click Menu Listings
		driver.findElement(By.cssSelector("[id='doc-listings'] a")).click();
		//Check header is presents
		assertTrue(areElementsPresent(By.cssSelector("h1[style]")));
		
		//Click Menu Images
		driver.findElement(By.cssSelector("[id='doc-images'] a")).click();
		//Check header is presents
		assertTrue(areElementsPresent(By.cssSelector("h1[style]")));
		
		//Click Menu Checkout
		driver.findElement(By.cssSelector("[id='doc-checkout'] a")).click();
		//Check header is presents
		assertTrue(areElementsPresent(By.cssSelector("h1[style]")));
		
		//Click Menu Advanced
		driver.findElement(By.cssSelector("[id='doc-advanced'] a")).click();
		//Check header is presents
		assertTrue(areElementsPresent(By.cssSelector("h1[style]")));
		
		//Click Menu Security
		driver.findElement(By.cssSelector("[id='doc-security'] a")).click();
		//Check header is presents
		assertTrue(areElementsPresent(By.cssSelector("h1[style]")));	
		
		//Click Menu Slides
		driver.findElement(By.xpath("//a//span[@class='name'] [(text()='Slides')]")).click();
		//Check header is presents
		assertTrue(areElementsPresent(By.cssSelector("h1[style]")));	
		
		//Click Menu Tax
		driver.findElement(By.xpath("//a//span[@class='name'] [(text()='Tax')]")).click();
		//Check header is presents
		assertTrue(areElementsPresent(By.cssSelector("h1[style]")));	
		
		//Click Menu Tax Classes
		driver.findElement(By.cssSelector("[id='doc-tax_classes'] a")).click();
		//Check header is presents
		assertTrue(areElementsPresent(By.cssSelector("h1[style]")));
		
		//Click Menu Tax Rates
		driver.findElement(By.cssSelector("[id='doc-tax_rates'] a")).click();
		//Check header is presents
		assertTrue(areElementsPresent(By.cssSelector("h1[style]")));
		
		//Click Menu Translations
		driver.findElement(By.xpath("//a//span[@class='name'] [(text()='Translations')]")).click();
		//Check header is presents
		assertTrue(areElementsPresent(By.cssSelector("h1[style]")));	
		
		//Click Menu Search Translations
		driver.findElement(By.cssSelector("[id='doc-search'] a")).click();
		//Check header is presents
		assertTrue(areElementsPresent(By.cssSelector("h1[style]")));
		
		//Click Menu Scan Files
		driver.findElement(By.cssSelector("[id='doc-scan'] a")).click();
		//Check header is presents
		assertTrue(areElementsPresent(By.cssSelector("h1[style]")));
		
		//Click Menu CSV Import/Export
		driver.findElement(By.cssSelector("[id='doc-csv'] a")).click();
		//Check header is presents
		assertTrue(areElementsPresent(By.cssSelector("h1[style]")));	
		
		//Click Menu Users
		driver.findElement(By.xpath("//a//span[@class='name'] [(text()='Users')]")).click();
		//Check header is presents
		assertTrue(areElementsPresent(By.cssSelector("h1[style]")));	
		
		//Click Parent Menu vQmods
		driver.findElement(By.xpath("//a//span[@class='name'] [(text()='vQmods')]")).click();
		//Check header is presents
		assertTrue(areElementsPresent(By.cssSelector("h1[style]")));
		
		//Click Child Menu vQmods
		driver.findElement(By.cssSelector("[id='doc-vqmods'] a")).click();
		//Check header is presents
		assertTrue(areElementsPresent(By.cssSelector("h1[style]")));
			
		//Выходит из учетной записи
		driver.findElement(By.cssSelector("i[class='fa fa-sign-out fa-lg']")).click();
	}

	@AfterClass
	public void stop() {
		driver.quit();
	}

}	
