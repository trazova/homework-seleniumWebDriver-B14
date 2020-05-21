package homework1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class LoginTask {
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
		//Выходит из учетной записи
		driver.findElement(By.cssSelector("i[class='fa fa-sign-out fa-lg']")).click();
	}

	@AfterClass
	public void stop() {
		driver.quit();
	}

}	
