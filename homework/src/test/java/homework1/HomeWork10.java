package homework1;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomeWork10 {
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
	public void homeWork10() throws InterruptedException {
		//параметры
		String url = "http://localhost/litecart/en/";
		//Открывает страницу магазина	 
		driver.get(url);
		Thread.sleep(1000);

		//открыть главную страницу, получаем свойства первого товарв в блоке Campaigns		
		List<WebElement> productsInCampaign = driver.findElements(By.cssSelector("[id='box-campaigns'] .product .link"));
		String nameOnMainPage = driver.findElements(By.cssSelector("[id='box-campaigns'] .product .link")).get(0).getAttribute("title");	
		String regPriceOnMainPage = driver.findElements(By.cssSelector("[id='box-campaigns'] .product .regular-price")).get(0).getText();	
		String campPriceOnMainPage = driver.findElements(By.cssSelector("[id='box-campaigns'] .product .campaign-price")).get(0).getText();	
		String regPriceStyleMainPage = driver.findElements(By.cssSelector("[id='box-campaigns'] .product .regular-price")).get(0).getCssValue("text-decoration");
		String regPriceColorMainPage = driver.findElements(By.cssSelector("[id='box-campaigns'] .product .regular-price")).get(0).getCssValue("color");
		String campPriceStyleMainPage = driver.findElements(By.cssSelector("[id='box-campaigns'] .product .campaign-price")).get(0).getTagName();
		String campPriceColorMainPage = driver.findElements(By.cssSelector("[id='box-campaigns'] .product .campaign-price")).get(0).getCssValue("color");
		String regPriceSizeMainPage = driver.findElements(By.cssSelector("[id='box-campaigns'] .product .regular-price")).get(0).getCssValue("font-size");
		String campPriceSizeMainPage = driver.findElements(By.cssSelector("[id='box-campaigns'] .product .campaign-price")).get(0).getCssValue("font-size");
		//Открываем страницу первого товара в блоке Campaign
		driver.findElements(By.cssSelector("[id='box-campaigns'] .product")).get(0).click();
		String nameOnProductPage = driver.findElement(By.cssSelector("h1[itemprop='name']")).getText();
		String regPriceOnProductPage = driver.findElement(By.cssSelector(".regular-price")).getText();	
		String campPriceOnProductPage = driver.findElement(By.cssSelector(".campaign-price")).getText();	
		String regPriceStyleProductPage = driver.findElement(By.cssSelector(".regular-price")).getCssValue("text-decoration");
		String regPriceColorProductPage = driver.findElement(By.cssSelector(".regular-price")).getCssValue("color");
		String campPriceStyleProductPage = driver.findElement(By.cssSelector(".campaign-price")).getTagName();
		String campPriceColorProductPage = driver.findElement(By.cssSelector(".campaign-price")).getCssValue("color");
		String regPriceSizeProductPage = driver.findElements(By.cssSelector(".regular-price")).get(0).getCssValue("font-size");
		String campPriceSizeProductPage = driver.findElements(By.cssSelector(".campaign-price")).get(0).getCssValue("font-size");

		//а. на главной странице и на странице товара совпадает текст названия товара
		Assert.assertEquals(nameOnMainPage, nameOnProductPage, "FAIL: Names on Main Page And Product Page Do Not Match");

		//б. на главной странице и на странице товара совпадают цены (обычная и акционная)
		Assert.assertEquals(regPriceOnMainPage, regPriceOnProductPage, "FAIL: Regular Price on Main Page And Product Page Do Not Match");
		Assert.assertEquals(campPriceOnMainPage, campPriceOnProductPage, "FAIL: Campaign Price on Main Page And Product Page Do Not Match");

		//в. обычная цена зачёркнутая и серая ("серый" это такой, у которого в RGBa одинаковые значения для  R, G и B)
		assertTrue(regPriceStyleMainPage.contains("line-through"), "Fail: regular price is not crossed out");
		String[] colorMp = regPriceColorMainPage
				.replace("rgba(", "")
				.replace("rgb(", "")
				.replace(")", "")
				.split(", ");    

		assertEquals(colorMp[0], colorMp[1]);
		assertEquals(colorMp[0], colorMp[2]);

		assertTrue(regPriceStyleProductPage.contains("line-through"), "Fail: regular price is not crossed out");
		String[] colorPp = regPriceColorProductPage
				.replace("rgba(", "")
				.replace("rgb(", "")
				.replace(")", "")
				.split(", ");               

		assertEquals(colorPp[0], colorPp[1]);
		assertEquals(colorPp[0], colorPp[2]);

		//г. акционная жирная и красная ("красный" это такой, у которого в RGBa каналы G и B имеют нулевые значения)
		assertTrue(campPriceStyleMainPage.equals("strong"), "Fail: campaign price is not bold");
		String[] colorCampMp = campPriceColorMainPage.replace("rgba(", "").replace(")", "").split(", ");         
		assertEquals(colorCampMp[1], "0");
		assertEquals(colorCampMp[2], "0");

		assertTrue(campPriceStyleProductPage.equals("strong"), "Fail: campaign price is not bold");
		String[] colorCampPp = campPriceColorProductPage.replace("rgba(", "").replace(")", "").split(", ");               
		assertEquals(colorCampMp[1], "0");
		assertEquals(colorCampMp[2], "0");

		//д. акционная цена крупнее, чем обычная
		//на основной странице
		String regPriceN = regPriceSizeMainPage.replace("px", ""); 
		float f1 = Float.valueOf(regPriceN);
		String campPriceN = campPriceSizeMainPage.replace("px", ""); 
		float f2 = Float.valueOf(campPriceN);
		assertTrue(f2 > f1, "FAIL: campaign price is NOT bigger than regular price");

		//на странице товара
		String regPN = regPriceSizeProductPage.replace("px", ""); 
		float f3 = Float.valueOf(regPriceN);
		String campPN = campPriceSizeProductPage.replace("px", ""); 
		float f4 = Float.valueOf(campPriceN);
		assertTrue(f4 > f3, "FAIL: campaign price is NOT bigger than regular price");
	}

	@AfterClass
	public void stop() {
		driver.quit();
	}

}	
