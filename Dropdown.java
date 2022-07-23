package week2.day2.assignments;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dropdown {

	public static void main(String[] args) throws InterruptedException {


		//Step 1: Download and setup
		WebDriverManager.chromedriver().setup();

		//Step 2:Launch the chromebrowser
		ChromeDriver driver=new ChromeDriver();

		//Step 3:Launch the URL
		driver.get("http://leafground.com/pages/Dropdown.html");

		//Step 4:Maximize the window
		driver.manage().window().maximize();

		WebElement dropdownIndex = driver.findElement(By.id("dropdown1"));
		Select select1=new Select(dropdownIndex);
		select1.selectByIndex(1);
		
		WebElement dropdownText = driver.findElement(By.name("dropdown2"));
		Select select2=new Select(dropdownText);
		select2.selectByVisibleText("UFT/QTP");
		
		WebElement dropdownValue = driver.findElement(By.id("dropdown3"));
		Select select3=new Select(dropdownValue);
		select3.selectByValue("3");
		
		WebElement dropdownOptions = driver.findElement(By.xpath("//select[@class='dropdown']"));
		Select select4=new Select(dropdownOptions);
		List<WebElement> options = select4.getOptions();
		System.out.println("The number of dropdown options "+options.size());
		
		driver.findElement(By.xpath("(//div[@class='example'])[5]/select")).sendKeys("Selenium");
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("(//div[@class='example'])[5]/select")).sendKeys(Keys.TAB);
		
		
		
		//Select select5=new Select(findElement);
		//select5.selectByVisibleText("Loadrunner");
		
	}

}
