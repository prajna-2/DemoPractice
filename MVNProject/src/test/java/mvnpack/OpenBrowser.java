package mvnpack;

import java.security.PublicKey;
import java.sql.Driver;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenBrowser {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebDriverWait explicitWait=new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

		//search for mobiles
		WebElement SearchForProduct = driver.findElement(By.xpath("//input[@placeholder='Search Amazon.in']"));
		SearchForProduct.sendKeys("Mobiles");
		SearchForProduct.sendKeys(Keys.ENTER);

		WebElement firstProduct = driver.findElement(By.xpath("(//div[contains(@class,'small s-title-instructions-style')]/h2/a/span)[1]"));
		String firstProductText = firstProduct.getText();
		System.out.println(firstProductText);
		firstProduct.click();
		Thread.sleep(2000);
		
		Set<String> windowIds = driver.getWindowHandles();
		String productTextOfPDP=null;
		/*for(String windowId:windowIds) {
			driver.switchTo().window(windowId);
			//String actualTitle = driver.getTitle();
			//driver.switchTo().window(actualTitle);
		}*/
		
		//switch using iterator
		Iterator<String> itr = windowIds.iterator();
		String defaultWindowid = itr.next();
		String childWindowid = itr.next();

		driver.switchTo().window(childWindowid);
		Thread.sleep(2000);
		WebElement productInPDP = driver.findElement(By.xpath("//div[@id='titleSection']/h1/span"));
		explicitWait.until(ExpectedConditions.visibilityOf(productInPDP));
		productTextOfPDP = productInPDP.getText();
		productTextOfPDP=productTextOfPDP.trim();
		System.out.println(productTextOfPDP);
		if(firstProductText.equalsIgnoreCase(productTextOfPDP)) { 
			System.out.println("the product name in plp and pdp are same");
		}
		
		 WebElement addtocart = driver.findElement(By.xpath("//input[@name='submit.add-to-cart']"));
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", addtocart);
		addtocart.click();
		Thread.sleep(2000);
		driver.switchTo().window(defaultWindowid);
		WebElement secondProduct = driver.findElement(By.xpath("(//div[contains(@class,'small s-title-instructions-style')]/h2/a/span)[2]"));
		String secondProductText = secondProduct.getText();
		System.out.println(secondProductText);
		secondProduct.click();
		
		
		
		driver.quit();

	}

}
