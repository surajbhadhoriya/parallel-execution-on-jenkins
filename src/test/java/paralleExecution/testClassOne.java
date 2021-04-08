package paralleExecution;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testClassOne {
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
    
    System.out.println("before method -: Class 1");
    Thread.sleep(5000);
    
}
	@Test
	public void test_Admin() throws InterruptedException
	{
		Thread.sleep(10000);
		driver.findElement(By.cssSelector("#menu_admin_viewAdminModule > b")).click();
		Thread.sleep(8000);
		driver.findElement(By.id("searchSystemUser_userName")).sendKeys("Suraj Kumar");
	Select se1=new Select(driver.findElement(By.id("searchSystemUser_userType")));
	se1.selectByVisibleText("ESS");
	
	driver.findElement(By.id("searchSystemUser_employeeName_empName")).sendKeys("Suraj Kumar");
	Select se2=new Select(driver.findElement(By.id("searchSystemUser_status")));
	se2.selectByVisibleText("Enabled");
	Thread.sleep(5000);
	
	driver.findElement(By.id("searchBtn")).click();
	System.out.println("test method -: Class 1");
		
	}
	
	@Test
	public void test_TimeSheet() throws InterruptedException
	{
	    Thread.sleep(10000);
		driver.findElement(By.cssSelector("#menu_time_viewTimeModule > b")).click();
		Thread.sleep(6000);
		driver.findElement(By.id("employee")).sendKeys("Charlie Carter");
		driver.findElement(By.id("btnView")).click();
		System.out.println("test method -: Class 1");
		
	}
	
	
	

	
	@AfterMethod
	public void tearDown()
	{
		System.out.println("after method -: Class 1");
		driver.quit();
	}
	}
