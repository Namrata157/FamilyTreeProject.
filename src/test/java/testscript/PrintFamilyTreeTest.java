package testscript;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PrintFamilyTreeTest {
	
	@Test
	public void printFamilyTreeTest() throws InterruptedException
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
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='root']/descendant::div[@class='tree']/child::div/descendant::div/p")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//label[.='Print Family Tree']")).click();
		driver.findElement(By.xpath("//button[.='Save PDF']")).click();
		
		//Family Tree is not visible in downloaded pdf
		Thread.sleep(2000);
		driver.close();
	}
	
	
	
}
