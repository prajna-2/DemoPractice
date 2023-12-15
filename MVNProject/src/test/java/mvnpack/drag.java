package mvnpack;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class drag {
	public static void main(String[] args) throws InterruptedException, IOException {
		String dir = "C:\\Users\\user\\Desktop\\Default chrome";
		Integer port = 9222;
		String cmdCommand = "chrome.exe -remote-debugging-port=" + port
				+ " --no-first-run --no-default-browser-check --user-data-dir=" + dir;
		String chromePath = "C:\\Program Files\\Google\\Chrome\\Application";
		Runtime.getRuntime().exec("cmd /c start cmd.exe /K " + cmdCommand, null, new File(chromePath));
		Thread.sleep(2000);

		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("debuggerAddress", "localhost:9222 ");
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://sbdashboard.kbill.in/#/login");
        new WebDriverWait(driver, Duration.ofSeconds(80)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tui-island[contains(@class,'drag') and text()=' Header ']")));
        
       
        System.out.println("hi");
        
        
	    
	    
	    Thread.sleep(3000);
	    
	    
        WebElement element11 = driver.findElement(By.xpath("//tui-island[contains(@class,'drag') and text()=' Header ']"));
		WebElement element22 = driver.findElement(By.xpath("//div[@class=\"cdk-drop-list\"]"));
	

	    
        
	    Actions actions3 = new Actions(driver);

        // Click and hold the source element, move to the target element, and release the mouse button
        actions3.clickAndHold(element11).build().perform();
        Thread.sleep(1000);
        actions3.moveByOffset(100,100).build().perform();
        Thread.sleep(1000);
        actions3.click(element22).build().perform();
        
        actions3.build();
        actions3.perform();
        actions3.release();


	
	}


}
