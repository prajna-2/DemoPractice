package mvnpack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Automate_Paint {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.get("mspaint");
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		WebElement lineButton = driver.findElement(By.id("LineButton"));
		lineButton.click();
		
		WebElement startPoint = driver.findElement(By.id("Canvas"));
		Actions builder = new Actions(driver);
		builder.moveToElement(startPoint, 50, 50).click();
		
		WebElement endPoint = driver.findElement(By.id("Canvas"));
		builder.moveToElement(endPoint, 200, 200).click().build().perform();
		
		driver.findElement(By.id("SaveButton")).click();

		driver.quit();
	}

}
