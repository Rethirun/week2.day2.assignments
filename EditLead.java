package week2.day2.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();//Verify the version,download and set the chrome driver

		ChromeDriver driver=new ChromeDriver();//Launch the chrome browser

		driver.get("http://leaftaps.com/opentaps/control/login");//load the URL

		driver.manage().window().maximize();//maximize the browser

		//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

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

		//* 8	Enter first name- (//div[@class='x-form-element'])[3]/following::input[@name='firstName'][2]

		driver.findElement(By.xpath("(//div[@class='x-form-element'])[3]/following::input[@name='firstName'][2]")).sendKeys("Revathi");

		//* 9	Click Find leads button- //button[text()='Find Leads']

		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();

		System.out.println("Clicked");

		//* 10 Click on first resulting lead - (//a[@class='linktext'])[4]

		Thread.sleep(2000);

		driver.findElement(By.xpath("(//table[@class='x-grid3-row-table'])[1]/tbody/tr/td/div/a[1]")).click();

		//* 11 Verify title of the page

		String title=driver.getTitle();
		if(title.contains("View Lead")) {
			System.out.println("Title of the page is verified "+title);
		}

		//* 12 Click Edit - //a[text()='Edit']

		driver.findElement(By.xpath("//a[text()='Edit']")).click();

		//* 13 Change the company name - id ->updateLeadForm_companyName
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("TestLeaf2.0");

		//* 14 Click Update - class->smallSubmit
		driver.findElement(By.className("smallSubmit")).click();

		//* 15 Confirm the changed name appears- id ->viewLead_companyName_sp

		String updatedCmpnyName = driver.findElement(By.id("viewLead_companyName_sp")).getText();

		if(updatedCmpnyName.contains("TestLeaf2.0")) {
			System.out.println("Changed Name appeared correctly "+updatedCmpnyName);
		}


		//* 16 Close the browser (Do not log out)

		driver.close();

	}

}
