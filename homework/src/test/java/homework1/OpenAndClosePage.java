package homework1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OpenAndClosePage {
		private WebDriver driver;
		 
		    @BeforeClass
		    public void start () {
		    // initiate web driver and max page size
				System.setProperty("webdriver.chrome.driver", "C://software//chromedriver_win32//chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
		     }	     
		     	     
		     @Test
			  public void trHomework1() {
				 driver.get("http://2020.petsbehavior.ru/");
				 driver.findElement(By.xpath("//a[@href='#где']/button[@class='btn font-text']/span[@class='text']")).click();
			 }
		 
			 @AfterClass
			 public void stop() {
			       driver.quit();
			    }

	}	
