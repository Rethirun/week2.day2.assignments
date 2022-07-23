package week2.day2.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Button {

	public static void main(String[] args) {


		//Step 1: Download and setup
		WebDriverManager.chromedriver().setup();

		//Step 2:Launch the chromebrowser
		ChromeDriver driver=new ChromeDriver();

		//Step 3:Launch the URL
		driver.get("http://leafground.com/pages/Button.html");

		//Step 4:Maximize the window
		driver.manage().window().maximize();
		
		//Click the button to go to home page - //button[text()='Go to Home Page']
		
		driver.findElement(By.xpath("//button[text()='Go to Home Page']")).click();
		
		System.out.println("Returned to home Page"+driver.getCurrentUrl());
		
		driver.findElement(By.xpath("//h5[text()='Button']/following::img[1]")).click();
		
		//Find position of button(x,y)- id ->position,getLocation
		
		Point location = driver.findElement(By.id("position")).getLocation();
		
		System.out.println("(x,y) coordinates of button is : "+location);

		//Find button color - id->color , getCssValue-background-color
		
		String buttonColor = driver.findElement(By.id("color")).getCssValue("background-color");
		
		System.out.println("The color of button in CSS value : "+buttonColor);

		//Find the height and width - id->size , getSize
		
		Dimension size = driver.findElement(By.id("size")).getSize();
		
		System.out.println("The Height and Width of button : "+size);

	
	}

}
