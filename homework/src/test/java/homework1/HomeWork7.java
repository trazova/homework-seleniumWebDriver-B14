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

		Thread.sleep(1000);
		String selectorParent = "[id='app-'] > a";
		String selectorChild = "[id*='doc-'] a";
		int leftMenuItemsParent = driver.findElements(By.cssSelector(selectorParent)).size();

		for (int i = 0; i < leftMenuItemsParent; i++) {
			List<WebElement> parent = driver.findElements(By.cssSelector(selectorParent));
			WebElement client = parent.get(i);
			client.click();
			assertTrue(areElementsPresent(By.cssSelector("h1[style]")));

			int leftMenuItemsChild = driver.findElements(By.cssSelector(selectorChild)).size();			
			for (int j = 0; j < leftMenuItemsChild; j++) {
				List<WebElement> child = driver.findElements(By.cssSelector(selectorChild));
				WebElement client2 = child.get(j);
				client2.click();
				assertTrue(areElementsPresent(By.cssSelector("h1[style]")));
			}
		}
		
		//Выходит из учетной записи
		driver.findElement(By.cssSelector("i[class='fa fa-sign-out fa-lg']")).click();
	}


	@AfterClass
	public void stop() {
		driver.quit();
	}

}	
