package week2.day2.assignments;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tables {

	public static void main(String[] args) throws InterruptedException {


		//Step 1: Download and setup
		WebDriverManager.chromedriver().setup();

		//Step 2:Launch the chromebrowser
		ChromeDriver driver=new ChromeDriver();

		//Step 3:Launch the URL
		driver.get("http://leafground.com/pages/table.html");

		//Step 4:Maximize the window
		driver.manage().window().maximize();

		//Get the count of number of columns
		
		List<WebElement> colCount = driver.findElements(By.tagName("th"));
		System.out.println("The number of columns : "+colCount.size());
		
		//Get the count of number of rows

		List<WebElement> rowCount = driver.findElements(By.tagName("tr"));
		System.out.println("The number of rows : "+rowCount.size());
		
		//Get the progress value of 'Learn to interact with Elements'
		//(//font[contains(text(),'Learn to interact with')])[1]/following::font[1]
		
		String text = driver.findElement(By.xpath("(//font[contains(text(),'Learn to interact with')])[1]/following::font[1]")).getText();
		System.out.println("Progress Value of Learn to interact with "+text);

		//Check the vital task for the least completed progress.
		//font[contains(text(),'20%')]/following::input[1]
		
		driver.findElement(By.xpath("//font[contains(text(),'20%')]/following::input[1]")).click();


				
	}

}
