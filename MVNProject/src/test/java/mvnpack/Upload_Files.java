package mvnpack;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Upload_Files {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String url = "https://www.naukri.com/registration/createAccount?";
		driver.get(url);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		WebDriverWait explicitWait=new WebDriverWait(driver, Duration.ofSeconds(20));
		explicitWait.until(ExpectedConditions.urlContains(url));
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement resumeText = driver.findElement(By.xpath("//label[text()='Resume']"));
		js.executeScript("arguments[0].scrollIntoView(true)", resumeText);
		
		driver.findElement(By.className("resume-upload")).click();
		driver.findElement(By.id("resumeUpload")).sendKeys("C:\\Users\\User\\Downloads\\karthik resume2.pdf");
		
		WebElement resume = driver.findElement(By.xpath("//div[@class='uploaded-resume']/h3/span"));
		String text = resume.getText();
		explicitWait.until(ExpectedConditions.visibilityOf(resume));
		
		System.out.println(text);
		driver.quit();
	}

}
