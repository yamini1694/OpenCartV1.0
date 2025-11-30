package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

public class BaseClass {
	
	public static WebDriver driver;
	public Logger logger;
	public Properties prop;
	public FileInputStream fi;
	
	@BeforeClass (groups={"sanity","master","Regression","TDDtest"})
	@Parameters ({"OS","Browser"})
	public void setup(String OS, String browser) throws FileNotFoundException, IOException
	{
		
		logger = LogManager.getLogger(this.getClass());
		 fi= new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//config.properties");
		
		 prop = new Properties();
		 prop.load(fi);
		
		switch (browser.toLowerCase())
		{
		case "chrome" :
			ChromeOptions options = new ChromeOptions();
			options.setAcceptInsecureCerts(true);
			
			driver= new ChromeDriver(options);
			break;
			
		case "edge":
			driver= new EdgeDriver();
			break;
			
		case "firefox":
			driver= new FirefoxDriver();
			break;
			
			default:
				System.out.println("Invalid Browser");
				return;
		}
		
		
		driver.manage().deleteAllCookies();
		//driver.get("https://localhost:444/opencart/upload/");
		
		driver.get(prop.getProperty("appurl"));   // Reading url from property file
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}
	
	@AfterClass(groups={"sanity","master","Regression","TDDtest"})
	public void tearDown()
	{
		driver.quit();
	}

	public String randomString()
	{
		String str = RandomStringUtils.randomAlphabetic(6);
		return str;
	}
	
	public String randomNumber()
	{
		String str = RandomStringUtils.randomNumeric(10);
		return str;
	}
	
	public String randomAlphaNumeric()
	{
		String str = RandomStringUtils.randomAlphanumeric(10);
		return str;
	}
	
	public String getScreenShot(String methodname)
	{
		
		SimpleDateFormat df= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		Date d= new Date();
		String timestamp= df.format(d);
		
		TakesScreenshot ts= (TakesScreenshot)driver;
		File sourcefile= ts.getScreenshotAs(OutputType.FILE);
		
		String targetPath= System.getProperty("user.dir")+"\\screenshots\\"+methodname+"_"+timestamp+".png";
		File targetfile= new File(targetPath);
		
		sourcefile.renameTo(targetfile);
		return targetPath;
	}
}
