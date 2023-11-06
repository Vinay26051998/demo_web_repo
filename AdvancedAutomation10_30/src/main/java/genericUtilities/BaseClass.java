package genericUtilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectRespository.Books_page;
import objectRespository.Computers_page;
import objectRespository.Jewelry_page;
import objectRespository.Login_page;
import objectRespository.Register_page;
import objectRespository.Welcome_page;

public class BaseClass implements IAutoConstents{

	public static WebDriver driver;
	public static PropertyUtility property;
	public static TakeScreenShotUtility screenshotUtility;
	public static WebDriverUtility webdriverUtility;
	public static ExtentTest logger;
	public static Jewelry_page jewelrypage;
	public static Login_page loginpage;
	public static Register_page registerpage;
	public static Welcome_page welcomepage;
	public static Books_page bookspage;
	public static Computers_page computerpage;
	JavaUtility javaUtility;
	DatabaseUtility dbUtility;
	
	@BeforeClass(alwaysRun = true)
	public void launchingTheBrowserAndNaviagateToApplication() {
		property=new PropertyUtility();
		if (BROWSER.equals("chrome")) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions op=new ChromeOptions();
		op.addArguments("--remote-allow-origins=*");
		driver=new ChromeDriver(op);
		}else if (BROWSER.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}else {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(property.getDataFromPropertyFile("url"));
		webdriverUtility=new WebDriverUtility(driver);
		javaUtility=new JavaUtility();
		dbUtility=new DatabaseUtility();
	}
	
	@BeforeMethod(alwaysRun = true)
	public void loginToApplication() {
		loginpage=new Login_page(driver);
		registerpage=new Register_page(driver);
		welcomepage=new Welcome_page(driver);
		bookspage=new Books_page(driver);
		jewelrypage=new Jewelry_page(driver);
		computerpage=new Computers_page(driver);
		screenshotUtility=new TakeScreenShotUtility(driver);
		System.out.println("Logged in to appliaction");
	}
	
	@AfterMethod(alwaysRun = true)
	public void logoutFromApplication() {
		System.out.println("Logged Out from the application");
	}
	
	@AfterClass(alwaysRun = true)
	public void closingTheServer() {
		driver.quit();
	}
}
