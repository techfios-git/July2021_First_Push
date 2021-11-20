package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest_Junit {

	static WebDriver driver;

	@BeforeClass
	public static void beforeClass() {
		System.out.println("Before Class!!");
	}

	@AfterClass
	public static void afterClass() {
		System.out.println("After Class!!");
	}

	@Before
	public void launchBrowser() {
		System.out.println("Launch Browser");
		// user dir
		// System.setProperty("webdriver.chrome.driver",
		// "C:\\Users\\Dell\\July2021_Selenium\\Session1\\driver\\chromedriver.exe");
		// System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		// System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");

		driver = new ChromeDriver();
		driver.get("https://techfios.com/billing/?ng=admin/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

	 @Test
	public void loginTest() throws InterruptedException {
		System.out.println("Login Test");
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
		driver.findElement(By.id("password")).sendKeys("abc123");
		driver.findElement(By.name("login")).click();
		Thread.sleep(3000);
	}

	@Test
	public void negLoginTest() throws InterruptedException {
		System.out.println("Neg Login Test");
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
		driver.findElement(By.id("password")).sendKeys("abc123");
//		driver.findElement(By.name("login")).click();
		driver.findElement(By.className("btn btn-success block full-width")).click();
		Thread.sleep(3000);
		// varification or validation
	}
	
	@After
	public void tearDown() {
		System.out.println("Tear down");
		driver.close();
		driver.quit();
	}

}
