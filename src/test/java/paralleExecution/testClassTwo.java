package paralleExecution;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testClassTwo {
	
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
    System.out.println("before method -: Class 2");
    Thread.sleep(5000);
    
}
	
	@Test
	public void test_Directory() throws InterruptedException
	{
		Thread.sleep(10000);
		driver.findElement(By.cssSelector("#menu_directory_viewDirectory > b")).click();
		Thread.sleep(6000);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Cecil Bonaparte");
		
		Select  se1=new Select(driver.findElement(By.id("searchDirectory_job_title")));
		se1.selectByVisibleText("Software Engineer");
		
		Select se2=new Select(driver.findElement(By.id("searchDirectory_location")));
		se2.selectByVisibleText("HQ - CA, USA");
		driver.findElement(By.id("searchBtn")).click();
		System.out.println("test method -: Class 2");
	}
	
	@Test
	public void test_Maintenance() throws InterruptedException
	{
		Thread.sleep(10000);
		driver.findElement(By.cssSelector("#menu_maintenance_purgeEmployee > b")).click();
		Thread.sleep(8000);
		driver.findElement(By.id("confirm_password")).sendKeys("Qait@12345");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		System.out.println("test method -: Class 2");
	}
	
	@AfterMethod
	public void tearDown()
	{
		System.out.println("after method -: Class 2");
		driver.quit();
	}

}
