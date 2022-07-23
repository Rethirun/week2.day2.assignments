package week2.day2.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();//Verify the version,download and set the chrome driver

		ChromeDriver driver=new ChromeDriver();//Launch the chrome browser

		driver.get("http://leaftaps.com/opentaps/control/login");//load the URL

		driver.manage().window().maximize();//maximize the browser

		//2. Enter Username and Password Using id locator
		//id->username,password
		//Demosalesmanager

		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");

		//3. Click on Login button using Class Locator
		//classname->decorativeSubmit

		driver.findElement(By.className("decorativeSubmit")).click();

		//4. Click on CRM/SFA Link
		//linktext->CRM/SFA

		driver.findElement(By.linkText("CRM/SFA")).click();

		//5. Click on Leads Button
		//linktext->Leads

		driver.findElement(By.linkText("Leads")).click();

		//* 7	Click Find leads- linkText->Find Leads

		driver.findElement(By.linkText("Find Leads")).click();

		//8	Click on Phone ->//span[text()='Phone']

		driver.findElement(By.xpath("//span[text()='Phone']")).click();

		//9	Enter phone number->name-phoneCountryCode,phoneAreaCode,phoneNumber

		driver.findElement(By.name("phoneCountryCode")).clear();
		driver.findElement(By.name("phoneCountryCode")).sendKeys("91");

		driver.findElement(By.name("phoneAreaCode")).clear();
		driver.findElement(By.name("phoneAreaCode")).sendKeys("044");

		driver.findElement(By.name("phoneNumber")).clear();
		driver.findElement(By.name("phoneNumber")).sendKeys("7339313604");

		//10	Click find leads button->//button[text()='Find Leads']

		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();

		//11	Capture lead ID of First Resulting lead-(//a[@class='linktext'])[4] or (//table[@class='x-grid3-row-table'])[1]/tbody/tr/td/div/a[1]

		Thread.sleep(2000);
		String leadID = driver.findElement(By.xpath("(//a[@class='linktext'])[4]")).getText();
		System.out.println("Captured Lead ID :"+leadID);


		//12	Click First Resulting lead
		Thread.sleep(2000);		
		driver.findElement(By.xpath("(//a[@class='linktext'])[4]")).click();

		//13	Click Delete- //a[text()='Delete']

		driver.findElement(By.xpath("//a[text()='Delete']")).click();

		//14	Click Find leads - //a[text()='Find Leads']
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();

		//15	Enter captured lead ID-//input[@name='id']
		driver.findElement(By.name("id")).sendKeys(leadID);

		//16	Click find leads button - //button[text()='Find Leads']
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();

		//17	Verify message "No records to display" in the Lead List. This message confirms the successful deletion
		////div[@class='x-paging-info']

		Thread.sleep(2000);

		String recordText = driver.findElement(By.xpath("//div[@class='x-paging-info']")).getText();
		System.out.println("Verified message is : "+recordText);
		
		//18 close the browser
		
		
		driver.close();


	}

}
