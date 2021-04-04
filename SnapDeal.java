package week4.day1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapDeal {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//div[@id='category6Data']/preceding-sibling::a/span")).click();
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("(//span[text()='Sports Shoes'])[1]"))).perform();
		
		driver.findElement(By.xpath("(//span[text()='Sports Shoes'])[1]")).click();
		Thread.sleep(3000);
		String ShoeCount = driver.findElement(By.xpath("//span[@class='category-count']")).getText();
		System.out.println("Total shoe count"+" "+ShoeCount);
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Sort by:']")).click();
		
		driver.findElement(By.xpath("(//li[@data-index='1'])[2]")).click();
		Thread.sleep(3000);
		
		  List<WebElement> findElements = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
		  Thread.sleep(3000);
		  List<Integer> list=new ArrayList<Integer>();
		 for (int i = 0; i < findElements.size(); i++) {
			 
			 
		
			 
			 String text = findElements.get(i).getText();
			 String replaceAll = text.replaceAll("\\D", "");
			 int parseInt = Integer.parseInt(replaceAll);
			 list.add(parseInt);
			 
		 }
	
	
		for (int j = 0; j < list.size()-1; j++) {
			
		
	Integer integer = list.get(j);
	Integer integer1 = list.get(j+1);
	

	
	
	
	if(	integer < integer1)
	{
		System.out.println("Previous value" + integer+"and next value" + integer1+"shoes are sorted properly");
	}
	else
	{
		System.out.println("Previous value  " + integer+"  and next value" + integer1 +"shoes are not sorted properly");
		}	
	}
		
		driver.findElement(By.id("searchWithinSearch")).sendKeys("puma blue",Keys.ENTER);
		Thread.sleep(3000);
		action.moveToElement(driver.findElement(By.xpath("//p[text()='Puma Blue Training Shoes']"))).perform();;
		driver.findElement(By.xpath("//div[@class='center quick-view-bar  btn btn-theme-secondary  ']")).click();
		Thread.sleep(3000);
		String text = driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText();
		String text2 = driver.findElement(By.xpath("//span[@class='percent-desc ']")).getText();
		//Set<String> windowHandles = driver.getWindowHandles();
		//System.out.println(windowHandles.size());
		System.out.println("The cost is"+" "+text);
		System.out.println("The discount is"+" "+text2);
		File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
		File file = new File("C://Sri/snap1.jpg");
		FileUtils.copyFile(screenshotAs, file);
		
		driver.close();
		driver.quit();

			
		}
		
}
		
		  
		 
		
	
		

	


