package StepDefination;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import BaseClass.TestBase;
import PageObject.PageObjectClass;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class StepDefination extends TestBase{
	
	
     public WebDriver driver;
  //   public	PageObjectClass poc;
     PageObjectClass poc = new PageObjectClass(driver); 
     Properties prop = new Properties();
     
 @Before    
 public void SetUp() throws InterruptedException{
	 
	 try {
			
			prop = new Properties();
			FileInputStream ip = new FileInputStream("D:\\Eclips instalation setup\\Cucumber_nopcommerce_Application_POM\\Property\\Cucumber.properties");
			prop.load(ip);
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	 Thread.sleep(9000);
	 
	 String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")) {
		
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\vaio\\Downloads\\chromedriver.exe");	
	     	driver = new ChromeDriver(); 
	     	
		}else if (browserName.equals("FF")){
		
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Kanchan\\Downloads\\chromedriver_win32\\geckodriver.exe");	
	     	driver = new FirefoxDriver(); 

		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		//Thread.sleep(9000);
 
 }

 @After
 public void CloseBrowser() {
	 
	 driver.quit();
	 
 }
 
 
 @Given("User opens URL")
 public void user_opens_URL()  {
		
	 
	driver.get(prop.getProperty("url"));

	}

	@Then("Validate the title of page")
	public void validate_the_title_of_page() {
		
	 PageObjectClass poc = new PageObjectClass(driver); 	
	 String tt =	poc.titleloginpage();
	
	Assert.assertEquals(tt, "Your store. Login");
	}
	

	@When("User enters login details")
	public void user_enters_login_details() {
		
		PageObjectClass poc = new PageObjectClass(driver); 
		poc.setUserName(prop.getProperty("username"));
		poc.setPassword(prop.getProperty("password"));
	}

	@Then("User clicks on submit btn")
	public void user_clicks_on_submit_btn() {
		PageObjectClass poc = new PageObjectClass(driver); 
		poc.clickLogin();
	}

	@Then("Validate the login details")
	public void validate_the_login_details() {
		//PageObjectClass poc = new PageObjectClass(driver); 
		if(driver.getPageSource().contains("Login was unsuccessful")) {
			
			System.out.println("........Login was unsuccessful Beacause Login Creadential are wrong..................");
			
			driver.quit();
		}
			else if(driver.getCurrentUrl().contains("http://admin-demo.nopcommerce.com/admin/")) {	
		
				System.out.println("........Login was successful..................");
			
			}
		
	}

	@Then("User on the Home page and validate the title of the page")
	public void user_on_the_Home_page_and_validate_the_title_of_the_page() {
		PageObjectClass poc = new PageObjectClass(driver); 
		String ttt=poc.titlehomepage();
		Assert.assertEquals(ttt, "Dashboard / nopCommerce administration");
		
		}

	@Then("User logout from page")
	public void user_logout_from_page() {
		PageObjectClass poc = new PageObjectClass(driver); 
		poc.clickLogout();
		}

	@Then("Close browser")
	public void close_browser() {
		
		driver.quit();
	}

	@Given("User on the Home page")
	public void user_on_the_Home_page() throws InterruptedException {
		
		Thread.sleep(9000);
		PageObjectClass poc = new PageObjectClass(driver); 
		driver.get(prop.getProperty("url"));
		Thread.sleep(9000);
		poc.setUserName(prop.getProperty("username"));
        poc.setPassword(prop.getProperty("password"));
       // Thread.sleep(9000);
        poc.clickLogin();
        driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		Thread.sleep(9000);
	}

	@When("User click on Customer link")
	public void user_click_on_Customer_link() throws InterruptedException {
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		PageObjectClass poc = new PageObjectClass(driver); 
		poc.ClickCustomerBtn();
		Thread.sleep(9000);
	}

	@Then("User click on Add new btn")
	public void user_click_on_Add_new_btn() throws InterruptedException {
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		PageObjectClass poc = new PageObjectClass(driver); 
		poc.ClickAddNewCustomer();
		//Thread.sleep(9000);
	}

	@Then("User enters details of Customer and save the details")
	public void user_enters_details_of_Customer_and_save_the_details(DataTable table) throws InterruptedException {
		//driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);

		PageObjectClass poc = new PageObjectClass(driver); 
		List<Map<String, String>> data = table.asMaps(String.class,String.class);
		   
		   for(Map<String,String> data1:data) {
			
poc.EnterNewDetailsofCustomer(data1.get("Email"),data1.get("Password"),data1.get("Firstname"),data1.get("Lastname"),data1.get("Dateofbirth"),data1.get("Companyname"),data1.get("Admincomment"));
		  
		poc.ClickOnSaveBtn();
		
	//	poc.ClickAddNewCustomer();
		
		Thread.sleep(9000);
		   }	
	}

	@Then("Validate the new customer is successfully added or not?")
	public void validate_the_new_customer_is_successfully_added_or_not() {
		
		
		// plz write the logic for this field....//
		
	}

	@Then("close the browser")
	public void close_the_browser() {
		
	driver.quit();	
	}
	
	@When("User clicks on customer link")
	public void user_clicks_on_customer_link() {
		PageObjectClass poc = new PageObjectClass(driver); 
		poc.ClickCustomerBtn();
	}

	@Then("User enters email to search")
	public void user_enters_email_to_search() {
		PageObjectClass poc = new PageObjectClass(driver);
		Properties prop = new Properties();
		poc.entersearch("victoria_victoria@nopCommerce.com");
	}

	@Then("User click on search btn")
	public void user_click_on_search_btn() {
		PageObjectClass poc = new PageObjectClass(driver); 
		poc.clickonsearchbtn();
	}

	@Then("Validate the search result")
	public void validate_the_search_result() {
		PageObjectClass poc = new PageObjectClass(driver);	
		poc.emailtable("victoria_victoria@nopCommerce.com");
		
//		List<WebElement> emails  = ldriver.findElement(By.xpath("//table[@id='customers-grid']//tbody//td[2]"));
//      
//         
//         	for(WebElement em:emails) {
//       
//         		System.out.println("............values ----------"+em.getText());	
//         		
//       	if(em.getText().equals(email)) {	
//       		
//       		System.out.println(".........Email found in the Record......  ");
//       	}
//       		
//       		else {
//       			
//       			System.out.println(".........Email not found in the Record......  ");
//       		}
//       		}
//		
	}


	
	
}