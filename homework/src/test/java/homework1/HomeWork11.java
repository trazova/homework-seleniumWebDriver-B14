package homework1;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomeWork11 {
	private WebDriver driver;

	@BeforeClass
	public void start () {
		// initiate web driver and max page size
		System.setProperty("webdriver.chrome.driver", "C://software//chromedriver_win32//chromedriver.exe");
		//System.setProperty("webdriver.gecko.driver", "C://software//geckodriver-v0.26.0-win64//geckodriver.exe");
		//System.setProperty("webdriver.ie.driver", "C://software//IEDriverServer_x64_3.150.1//IEDriverServer.exe");
		driver = new ChromeDriver();
		//driver = new FirefoxDriver();
		//driver = new InternetExplorerDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}	     

	public boolean areElementsPresent(By locator) {
		return driver.findElements(locator).size() > 0;
	}

	@Test
	public void homeWork11() throws InterruptedException {
		//параметры
		String url = "http://localhost/litecart/en/";
		//Открывает страницу магазина	 
		driver.get(url);
		Thread.sleep(1000);
		//переменные
		String firstName = "Ann";
		String lastName = "Taylor";
		String address = "1 Spring street";
		String postCode = "02145";
		String city  = "Melrose";		
		String email = "melrose_citizen" + new Random().nextInt(100000) + "@tesst.com";
		String phone = "6030012233";
		String password = "melrose";

		//1) регистрация новой учётной записи
		driver.findElement(By.cssSelector("form[name='login_form'] > table a")).click();
		Thread.sleep(500);
		driver.findElement(By.cssSelector("[name='firstname']")).sendKeys(firstName);
		driver.findElement(By.cssSelector("[name='lastname']")).sendKeys(lastName);
		driver.findElement(By.cssSelector("[name='address1']")).sendKeys(address);
		driver.findElement(By.cssSelector("[name='postcode']")).sendKeys(postCode);
		driver.findElement(By.cssSelector("[name='city']")).sendKeys(city);
		driver.findElement(By.cssSelector("[name='zone_code']")).click();
		driver.findElements(By.cssSelector("[name='zone_code'] option")).get(13).click();
		driver.findElement(By.cssSelector("[name='email']")).sendKeys(email);
		driver.findElement(By.cssSelector("[name='phone']")).sendKeys(phone);
		driver.findElement(By.cssSelector("[name='password']")).sendKeys(password);
		driver.findElement(By.cssSelector("[name='confirmed_password']")).sendKeys(password);
		driver.findElement(By.cssSelector("button[type='submit']")).click();

		//2) logout
		driver.findElement(By.cssSelector("div[id=\"box-account\"] .list-vertical li:nth-of-type(4) a")).click();
		
		//3) повторный вход в только что созданную учётную запись,
		driver.findElement(By.cssSelector("[name='email']")).sendKeys(email);
		driver.findElement(By.cssSelector("[name='password']")).sendKeys(password);
		driver.findElement(By.cssSelector("button[name='login']")).click();

		//4) ещё раз выход
		driver.findElement(By.cssSelector("div[id=\"box-account\"] .list-vertical li:nth-of-type(4) a")).click();
		


	}

	@AfterClass
	public void stop() {
		driver.quit();
	}

}	
