package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadDtaFromPropertyFileTest {

	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("./data/commondata.properties.txt");
		
		Properties p=new Properties();
		p.load(fis);
		
		String ul = p.getProperty("url");
		String un = p.getProperty("username");
		String pw = p.getProperty("password");
		
		WebDriver driver=new ChromeDriver();
		driver.get(ul);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(un);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(pw);
		driver.findElement(By.id("submitButton")).click();	
		
		driver.findElement(By.xpath("//a[.='Contacts']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();	
	}

}
