package week2.day2.assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Link {

	public static void main(String[] args) {


		//Step 1: Download and setup
		WebDriverManager.chromedriver().setup();

		//Step 2:Launch the chromebrowser
		ChromeDriver driver=new ChromeDriver();

		//Step 3:Launch the URL
		driver.get("http://leafground.com/pages/Link.html");

		//Step 4:Maximize the window
		driver.manage().window().maximize();

		//linktext-Go to Home Page

		driver.findElement(By.linkText("Go to Home Page")).click();

		System.out.println("Home Page URL naviagted "+driver.getCurrentUrl());

		driver.findElement(By.xpath("//h5[text()='HyperLink']/following::img[1]")).click();

		//linktext - Find where am supposed to go without clicking me? , href

		String linkName = driver.findElement(By.linkText("Find where am supposed to go without clicking me?")).getAttribute("href");

		System.out.println("Link Name without using click "+linkName);

		//Verify am i broken - Linktext - Verify am I broken?

		driver.findElement(By.linkText("Verify am I broken?")).click();

		String currentUrl = driver.getCurrentUrl();

		System.out.println(currentUrl);

		if(currentUrl.contains("error"))
			System.out.println("Yes the link is broken");
		else
			System.out.println("Nope the link is fine");

		driver.navigate().back();

		//Go to Home Page(Interact with the same link name)

		driver.findElement(By.linkText("Go to Home Page")).click();

		System.out.println("Home Page URL naviagted "+driver.getCurrentUrl());

		driver.findElement(By.xpath("//h5[text()='HyperLink']/following::img[1]")).click();

		//How many links are available in this page?

		List<WebElement> noOfLinks = driver.findElements(By.tagName("a"));

		System.out.println("The number of links in this page : "+noOfLinks.size());



	}

}
