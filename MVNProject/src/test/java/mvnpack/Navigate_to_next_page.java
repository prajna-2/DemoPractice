package mvnpack;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Navigate_to_next_page {

	public static void main(String[] args) throws IOException, InterruptedException {
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
        new WebDriverWait(driver, Duration.ofSeconds(80)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='logo']")));
        System.out.println("logo is displayed");
        Thread.sleep(20000);
//        JavascriptExecutor jsExecutor =(JavascriptExecutor)driver;
//        WebElement elementToBeScrolled = driver.findElement(By.xpath("//icon-linkedin[@class=\"icon\"]"));
//        jsExecutor.executeScript("arguments[0].scrollIntoView(true)", elementToBeScrolled);
//        //System.out.println("hi");
//        driver.findElement(By.xpath("//tui-wrapper[@class=\"tui-autofill _no-active _no-hover\"]")).click();
//        driver.findElement(By.xpath("//tui-select-option[text()=' 100 ']")).click();
//        jsExecutor.executeScript("arguments[0].scrollIntoView(true)", elementToBeScrolled);
        
        boolean IsDisplayed = false;
        for(;;) {
        	try {
        		WebElement element = driver.findElement(By.xpath("(//span[@class=\"title\"])[11]"));
        		IsDisplayed=element.isDisplayed();
            	 driver.findElement(By.xpath("(//span[text()='Action'])[11]")).click();
            	 break;
             }
             catch (Exception e) {
            	 driver.findElement(By.xpath("//img[contains(@src,'srightArrow')]/..")).click();
             }
        }
		
	}

}
