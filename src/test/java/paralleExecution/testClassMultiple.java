package paralleExecution;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testClassMultiple {
	
	
	
	public static WebDriver driver;
	//System.setProperty("webdriver.chrome.driver","C:\\Users\\Ranjeet singh\\Downloads\\chromedriver_win32\\chromedriver.exe");
	//driver=new ChromeDriver();
	
	@BeforeMethod
	public void test_Login() throws InterruptedException
	{
	
	System.setProperty("webdriver.chrome.driver","C:\\Users\\Ranjeet singh\\Downloads\\chromedriver_win32\\chromedriver.exe");
	driver=new ChromeDriver();
	Thread.sleep(2000);
    driver.get("https://opensource-demo.orangehrmlive.com/");
    driver.findElement(By.id("txtUsername")).sendKeys("Admin");
    driver.findElement(By.id("txtPassword")).sendKeys("admin123");
    driver.findElement(By.id("btnLogin")).click();
    Thread.sleep(5000);
    System.out.println("before method");
    
}
	@Test
	public void test_Admin() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("#menu_admin_viewAdminModule > b")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("searchSystemUser_userName")).sendKeys("Suraj Kumar");
	Select se1=new Select(driver.findElement(By.id("searchSystemUser_userType")));
	se1.selectByVisibleText("ESS");
	
	driver.findElement(By.id("searchSystemUser_employeeName_empName")).sendKeys("Suraj Kumar");
	Select se2=new Select(driver.findElement(By.id("searchSystemUser_status")));
	se2.selectByVisibleText("Enabled");
	Thread.sleep(5000);
	
	driver.findElement(By.id("searchBtn")).click();
	System.out.println("Test method 1");
		
	}
	
	@Test
	public void test_TimeSheet()
	{
	
		driver.findElement(By.cssSelector("#menu_time_viewTimeModule > b")).click();
		driver.findElement(By.id("employee")).sendKeys("Charlie Carter");
		driver.findElement(By.id("btnView")).click();
		System.out.println("Test method 2");
		
	}
	@Test
	public void test_Directory() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("#menu_directory_viewDirectory > b")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Cecil Bonaparte");
		
		Select  se1=new Select(driver.findElement(By.id("searchDirectory_job_title")));
		se1.selectByVisibleText("Software Engineer");
		
		Select se2=new Select(driver.findElement(By.id("searchDirectory_location")));
		se2.selectByVisibleText("HQ - CA, USA");
		driver.findElement(By.id("searchBtn")).click();
		System.out.println("Test method 3");
	}
	
	@Test
	public void test_Maintenance() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("#menu_maintenance_purgeEmployee > b")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("confirm_password")).sendKeys("Qait@12345");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		System.out.println("Test method 4");
	}

	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
