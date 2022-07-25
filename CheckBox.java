package week2.day2.assignments;



import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBox {

	public static void main(String[] args) throws InterruptedException {


		//Step 1: Download and setup
		WebDriverManager.chromedriver().setup();

		//Step 2:Launch the chromebrowser
		ChromeDriver driver=new ChromeDriver();

		//Step 3:Launch the URL
		driver.get("http://leafground.com/pages/checkbox.html");

		//Step 4:Maximize the window
		driver.manage().window().maximize();

		//Select the languages that you know
		//label[text()='Select the languages that you know?']/following::input[1]
		//label[text()='Select the languages that you know?']/following::input[5]
		
		driver.findElement(By.xpath("//label[text()='Select the languages that you know?']/following::input[1]")).click();
		driver.findElement(By.xpath("//label[text()='Select the languages that you know?']/following::input[5]")).click();

		//Confirm Selenium is checked
		//label[text()='Confirm Selenium is checked']/following::input[1]
		
		boolean selected = driver.findElement(By.xpath("//label[text()='Confirm Selenium is checked']/following::input[1]")).isSelected();
		System.out.println("Is the Selenium checkbox is selected : "+selected);


		//Deselect only Checked
		//label[text()='DeSelect only checked']/following::input[2]
		
		boolean checked = driver.findElement(By.xpath("//label[text()='DeSelect only checked']/following::input[2]")).isSelected();
		if(checked) {
			
			driver.findElement(By.xpath("//label[text()='DeSelect only checked']/following::input[2]")).click();
			System.out.println("Yes deselected it");
			
		}else
			System.out.println("Is not selected");


		//Select all below Checkboxes
		//label[text()='Select all below checkboxes ']/following::input[1]
			
		driver.findElement(By.xpath("//label[text()='Select all below checkboxes ']/following::input[1]")).click();
		driver.findElement(By.xpath("//label[text()='Select all below checkboxes ']/following::input[2]")).click();
		driver.findElement(By.xpath("//label[text()='Select all below checkboxes ']/following::input[3]")).click();
		driver.findElement(By.xpath("//label[text()='Select all below checkboxes ']/following::input[4]")).click();
		driver.findElement(By.xpath("//label[text()='Select all below checkboxes ']/following::input[5]")).click();
		driver.findElement(By.xpath("//label[text()='Select all below checkboxes ']/following::input[6]")).click();
		
	}

}
