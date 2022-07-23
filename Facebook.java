package week2.day2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebook {
	
	public static void main(String[] args) throws InterruptedException {
		
		//Step 1: Download and setup
		WebDriverManager.chromedriver().setup();
		
		//Step 2:Launch the chromebrowser
		ChromeDriver driver=new ChromeDriver();
		
		//Step 3:Launch the URL
		driver.get("https://en-gb.facebook.com/");
		
		//Step 4:Maximize the window
		driver.manage().window().maximize();
		
		//Step 5:Add ImplicitWait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Step 6: Click on Create New Button ->linktext-Create New Account
		
		driver.findElement(By.linkText("Create New Account")).click();
		
		//Step 7: Enter the First name->name-firstname
		
		driver.findElement(By.name("firstname")).sendKeys("Revathi");
		
		//Step 8: Enter the Last name->name-lastname
		
		driver.findElement(By.name("lastname")).sendKeys("Thiru");
		
		//Step 9: Enter the Mobile number->reg_email__
		
		driver.findElement(By.name("reg_email__")).sendKeys("7339313604");
		
		//Step 10: Enter the Password->name-reg_passwd__
		driver.findElement(By.name("reg_passwd__")).sendKeys("secret_05");
		
		//Step 11. Handle all three dropdowns->id-day,month,Year
		//5,Jun,1990
		
		WebElement day = driver.findElement(By.id("day"));
		Select select1=new Select(day);
		select1.selectByVisibleText("5");
		
		WebElement month = driver.findElement(By.id("month"));
		Select select2=new Select(month);
		select2.selectByVisibleText("Jun");
		
		WebElement year = driver.findElement(By.id("year"));
		Select select3=new Select(year);
		select3.selectByVisibleText("1990");
		
				
		//Step 12: Select radio button female->(//label[text()='Female']/following::input)[1]

		driver.findElement(By.xpath("(//label[text()='Female']/following::input)[1]")).click();
				
		
	}

}
