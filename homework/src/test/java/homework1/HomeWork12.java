package homework1;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.xml.crypto.KeySelector.Purpose;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import net.bytebuddy.utility.RandomString;

public class HomeWork12 {
	private WebDriver driver;
	static By userName = By.cssSelector("td input[name='username']");
	static By password = By.cssSelector("td input[name='password']");
	static By submitBtn = By.cssSelector("button[type='submit']");
	static By catalogMenu = By.cssSelector("[id='box-apps-menu'] > li:nth-of-type(2) > a");
	static By addNewProductBtn = By.cssSelector(".button:nth-of-type(2)");
	static By productName = By.cssSelector("[name='name[en]']");
	static By productCode = By.cssSelector("[name='code']");
	static By productStatus = By.cssSelector("[name='status']");
	static By productCategory = By.cssSelector("[name='categories[]']");
	static By productGroup = By.cssSelector("[name='product_groups[]']");
	static By productQuantity = By.cssSelector("[name='quantity']");
	static By soldOutStatus = By.cssSelector("[name='sold_out_status_id']");
	static By soldOutOptions = By.cssSelector("[name='sold_out_status_id'] option");
	static By productImage = By.cssSelector("[name='new_images[]']");
	static By dateStart = By.cssSelector("[name='date_valid_from']");
	static By dateEnd = By.cssSelector("[name='date_valid_to']");
	static By informationTab = By.cssSelector("[href='#tab-information']");
	static By productManufact = By.cssSelector("[name='manufacturer_id']");
	static By manufactOptions = By.cssSelector("[name='manufacturer_id'] option");
	static By keywords = By.cssSelector("[name='keywords']");
	static By shortDescription = By.cssSelector("[name='short_description[en]']");
	static By productDescription = By.cssSelector(".trumbowyg-editor");
	static By headTitle = By.cssSelector("[name='head_title[en]']");
	static By metaDescription = By.cssSelector("[name='meta_description[en]']");
	static By pricesTab = By.cssSelector("[href='#tab-prices']");
	static By purchasePrice = By.cssSelector("[name='purchase_price']");
	static By currency = By.cssSelector("[name='purchase_price_currency_code']");
	static By currencyOptions = By.cssSelector("[name='purchase_price_currency_code'] option");
	static By tax = By.cssSelector("[name='tax_class_id']");
	static By priceUSD = By.cssSelector("[name='prices[USD]']");
	static By priceEur = By.cssSelector("[name='prices[EUR]']");
	static By saveBtn = By.cssSelector("button[name='save']");

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
	public void homeWork12() throws InterruptedException {

		//параметры
		String url = "http://localhost/litecart/admin/";
		String login = "admin";
		String pass = "admin";
		String name = "Goose";
		String code = "Goose"+ new Random().nextInt(100);
		String quantity = "500";
		String date1 = "05/20/2020";
		String date2 = "12/31/2020";
		String tag = "Bath, Goose, Duck";
		String shortDescr = "Rubber Goose for great bathing time.";
		String longDescr = "With their bright color, smooth texture, and (for some) squeaky or quacky sounds, rubber ducks sharpen toddlers' senses.";
		String title = "Rubber Goose";
		String price = "20";
		String price1 = "20";
		String price2 = "15";
				
		//Открывает страницу логина	 
		driver.get(url);
		//Вводит логин, пароль, нажимает кнопку Войти
		driver.findElement(userName).sendKeys(login);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(submitBtn).click();
		Thread.sleep(1000);

		//	открыть меню Catalog, в правом верхнем углу нажать кнопку "Add New Product"
		driver.findElement(catalogMenu).click();
		driver.findElement(addNewProductBtn).click();
		
		//  заполнить поля с информацией о товаре и сохранить.
		//	заполнить информацию на вкладках General, Information и Prices.
		driver.findElement(productName).sendKeys(name);
		driver.findElement(productCode).sendKeys(name);
		driver.findElements(productStatus).get(0).click();
		//скорее всего в приложении есть баг, т.к. если не снять галочку root category и поставить галочку в subcategory,
		//то root не снимается. поэтому сначала снимаю галку root, потом проставляю нужную, чтобы Default Category отображала верную категорию
		driver.findElements(productCategory).get(0).click();
		driver.findElements(productCategory).get(2).click();
		driver.findElements(productGroup).get(2).click();
		driver.findElement(productQuantity).clear();
		driver.findElement(productQuantity).sendKeys(quantity);
		driver.findElement(soldOutStatus).click();
		driver.findElements(soldOutOptions).get(0).click();
//Картинку товара уложить в репозиторий вместе с кодом. указывать в коде полный абсолютный путь к файлу плохо. средствами языка преобразовать относительный путь в абсолютный.
		driver.findElement(dateStart).sendKeys(date1);
		driver.findElement(dateEnd).sendKeys(date2);
		driver.findElement(informationTab).click();
		Thread.sleep(1000);
		driver.findElement(productManufact).click();
		//does not click options
		driver.findElement(manufactOptions).click();
		driver.findElement(keywords).sendKeys(tag);
		driver.findElement(shortDescription).sendKeys(shortDescr);
		driver.findElement(productDescription).sendKeys(longDescr);
		driver.findElement(headTitle).sendKeys(title);
		driver.findElement(metaDescription).sendKeys(title);
		driver.findElement(pricesTab).click();
		Thread.sleep(1000);
		driver.findElement(purchasePrice).clear();
		driver.findElement(purchasePrice).sendKeys(price);
		driver.findElement(currency).click();
		driver.findElements(currencyOptions).get(1).click();
		driver.findElement(priceUSD).sendKeys(price1);
		driver.findElement(priceEur).sendKeys(price2);
		driver.findElement(saveBtn).click();
		
		//	После сохранения товара нужно убедиться, что он появился в каталоге (в админке). Клиентскую часть магазина можно не проверять.


	}

	@AfterClass
	public void stop() {
		driver.quit();
	}

}	
