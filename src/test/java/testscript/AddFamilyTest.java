package testscript;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddFamilyTest {
	
	@Test
	public void addFamilyTest() throws IOException, InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://beamish-empanada-a56e27.netlify.app/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Entering all the mandatory fields
		driver.findElement(By.name("Name")).sendKeys("First Member Name");
		driver.findElement(By.name("Spouse")).sendKeys("Spouse");
		driver.findElement(By.name("Location")).sendKeys("Location");
		driver.findElement(By.name("Birth Year")).sendKeys("1945");
		driver.findElement(By.name("Present Address")).sendKeys("Present Address");
		driver.findElement(By.name("Custom Label1")).sendKeys("Custom Label1");
		driver.findElement(By.name("Custom Label2")).sendKeys("Custom Label2");
		driver.findElement(By.xpath("//label[.='Upload Pictures']")).click();
		
		
		//to upload pictures using AutoIt because selenium cannot handle window based application
		//AutoIt script for file uploading is available in src/main/resources
		Runtime.getRuntime().exec("./src/test/resources/Family_Tree.au4.exe");
		
		Thread.sleep(10000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		/* Not able to click on ADD button because after uploading picture, ADD button is not visible in UI 
		so selenium cannot find the element and it throws "ElementNotInteractableException" */
		
		Thread.sleep(3000);
		driver.close();
		
	}

}
