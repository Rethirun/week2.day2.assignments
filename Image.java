package week2.day2.assignments;



import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Image {

	public static void main(String[] args) {


		//Step 1: Download and setup
		WebDriverManager.chromedriver().setup();

		//Step 2:Launch the chromebrowser
		ChromeDriver driver=new ChromeDriver();

		//Step 3:Launch the URL
		driver.get("http://leafground.com/pages/Image.html");

		//Step 4:Maximize the window
		driver.manage().window().maximize();

		//Click on this image to go to home page - 
		//label[text()='Click on this image to go home page']/following::img[1]
		
		driver.findElement(By.xpath("//label[text()='Click on this image to go home page']/following::img[1]")).click();
		System.out.println("Gone to Home Page on click: " +driver.getCurrentUrl());
		driver.findElement(By.xpath("//h5[text()='Image']/following::img[1]")).click();
		
		//Am i Broken Image?
		
		String clickURL = driver.findElement(By.xpath("//img[@src='../images/abcd.jpg']")).getAttribute("onclick");
		if(clickURL=="")
			System.out.println("Image is broken no Onclick element value");
		else
			System.out.println("Image is not broken");
		
		//Click me using Keyboard or Mouse
		//label[text()='Click me using Keyboard or Mouse']/following::img
		
		driver.findElement(By.xpath("//label[	text()='Click me using Keyboard or Mouse']/following::img")).click();
		System.out.println("Clicked using mouse: "+driver.getCurrentUrl());
		

	}

}
