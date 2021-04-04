package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Irtc {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.irctc.co.in/");		
		driver.manage().window().maximize();		
		Thread.sleep(3000);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		driver.findElement(By.xpath("//a[text()=' FLIGHTS ']")).click();
		Thread.sleep(5000);
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println(windowHandles.size());
		List<String>list=new ArrayList<String>(windowHandles);
		String string = list.get(1);
		driver.switchTo().window(string);
		System.out.println(driver.getTitle());
		String text = driver.findElement(By.xpath("(//a[@href='mailto:flights@irctc.co.in'])[1]")).getText();
		System.out.println(text);
		driver.switchTo().window(list.get(0));
		driver.close();
		
		
		

	}

}
