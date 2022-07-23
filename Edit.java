package week2.day2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Edit {

	public static void main(String[] args) {


		//Step 1: Download and setup
		WebDriverManager.chromedriver().setup();

		//Step 2:Launch the chromebrowser
		ChromeDriver driver=new ChromeDriver();

		//Step 3:Launch the URL
		driver.get("http://leafground.com/pages/Edit.html");

		//Step 4:Maximize the window
		driver.manage().window().maximize();

		//Step 5:Add ImplicitWait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//Enter the Email - id ->email

		driver.findElement(By.id("email")).sendKeys("revathi.cse@gmail.com");

		//Append a text and press keyboard tab - //input[contains(@value,'Append ')]

		driver.findElement(By.xpath("//input[contains(@value,'Append ')]")).sendKeys("new");
		driver.findElement(By.xpath("//input[contains(@value,'Append ')]")).sendKeys(Keys.TAB);

		//Get default text entered - name -> username

		String defaultText = driver.findElement(By.name("username")).getAttribute("value");

		System.out.println(defaultText);

		//Clear the text -  (//input[@name='username'])[2]

		driver.findElement(By.xpath("(//input[@name='username'])[2]")).clear();

		//confirm that edit field is disabled - //label[text()='Confirm that edit field is disabled']/following::input

		boolean isEnabled = driver.findElement(By.xpath("//label[text()='Confirm that edit field is disabled']/following::input")).isEnabled();

		if(!isEnabled) {
			System.out.println("Field is disabled");
		}else {
			System.out.println("Field is enabled");
		}

	}

}
