package configuration;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit; 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
 
public class ActionKeywords {
 
		public static WebDriver driver;
		static InputStream  f1;
		static Properties p1;
		
	//Open Browser
	public static void openBrowser(){		
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\chromedriver.exe");
				driver=new ChromeDriver();
				}
	// Properties File
	public static void propertyFile() throws Exception{
				 f1 = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\product.properties");
				 p1 = new Properties();
				 p1.load(f1);
				}
	//Opening Url
	public static void navigate() throws Exception{
				propertyFile();
				driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				driver.get(p1.getProperty("Prod_Url"));
				driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
				}
	//Back to Url
	public static void navigateBack(){
				driver.navigate().back();
				}
	//Select category
	public static void selectCategory(String searchCategory) throws Exception{
		propertyFile();
		driver.manage().timeouts().implicitlyWait(1200, TimeUnit.SECONDS);
		WebElement selectCategory=driver.findElement(By.id(p1.getProperty("amazon_select_category_id")));
		Select s1=new Select(selectCategory);
		s1.selectByVisibleText(searchCategory);
	}
	// Search Product
	public static void searchFunc(String searchData) throws Exception{
				propertyFile();
				driver.manage().timeouts().implicitlyWait(1200, TimeUnit.SECONDS);
				WebElement element1=driver.findElement(By.id(p1.getProperty("amazon_search_textBox_id")));
				element1.sendKeys(searchData);
				}
	 // Submit Button
	public static void clickSearchBtn() throws Exception{
			propertyFile();
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			driver.findElement(By.id(p1.getProperty("amazon_search_submitBtn_id"))).click();
			}
	//Waiting
	public static void waitFor() throws Exception{
			Thread.sleep(5000);
			}
	//Verify Title
	public static void verifyTitle(String searchStr){
			Assert.assertEquals(driver.getTitle(), "Amazon.in : "+searchStr);
			Reporter.log("Title Verified: "+driver.getTitle(),true);
			}
	//Closing Browser
	public static void closeBrowser(){
			driver.quit();
			}
} 

