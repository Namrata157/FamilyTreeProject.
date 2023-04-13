package testscript;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchFamilyMemberTest {
	@Test
	public void searchFamilyMemberTest() throws InterruptedException
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
		
		//To search for a member
		String name="First Member Name";
		driver.findElement(By.id("input")).sendKeys(name);
		List<WebElement> listOfMembers = driver.findElements(By.xpath("//ul/li/div/p"));
		for(WebElement a:listOfMembers)
		{
			if(a.getText().contains(name))
			{
				System.out.println("Member is present");
				break;
			}
			else
				System.out.println("Member is not present");
			
		}
		Thread.sleep(2000);
		driver.close();
	}

}
