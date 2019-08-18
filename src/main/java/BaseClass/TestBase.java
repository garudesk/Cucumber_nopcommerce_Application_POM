package BaseClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import PageObject.PageObjectClass;

public class TestBase {
	
	
	public   WebDriver driver;
	
	//WebDriver driver=new ChromeDriver();
	
	public   Properties prop;
	
	public PageObjectClass poc;
	
	
}
 