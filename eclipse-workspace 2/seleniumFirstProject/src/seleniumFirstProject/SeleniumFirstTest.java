package seleniumFirstProject;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.junit.Assert;  



public class SeleniumFirstTest {
WebDriver driver;


	//@Given("^End to End DBS Test$")
	public static void main(String []args) {
	System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
	WebDriver driver=new ChromeDriver();
	
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	driver.get("https://www.dbs.com.sg/personal/default.page");		//Navigate to the URL

	driver.manage().window().maximize();

	driver.findElement(By.xpath("//div[@id='flpHeader']//a[text()='Cards']")).click();		//Click on the Cards Tab
    
	Actions actions = new Actions(driver);
    WebElement element = driver.findElement(By.xpath("//a[@href='/personal/cards/cards-comparator.page']"));
    actions.moveToElement(element).click().perform();		//Scroll to element for the element visibility

	
	driver.findElement(By.xpath("//a[@href='/personal/cards/cards-comparator.page']")).click();		//Click on the Credit Card Tab
	
	
    driver.findElement(By.xpath("//input[@id='cb0']//following-sibling::label//span")).click();		//Select the first Card
    

    
    JavascriptExecutor js = (JavascriptExecutor) driver;    
    js.executeScript("window.scrollTo(0, document.body.scrollHeight)");		//Scroll to element for the second card
    
    driver.findElement(By.xpath("//input[@id='cb14']//following-sibling::label//span")).click();		//Select second card
    
  	driver.findElement(By.id("cardCompareBtn")).click();		//Click on the Comapre button

  	

  	//Assertion for the UI data comparison for selected cards
  	
  	Assert.assertEquals("It's the fastest way to fly anywhere",driver.findElement(By.xpath("(//div[@id='card0']//div[@class='sub-header'])[1]")).getText());
  	Assert.assertEquals("VISA",driver.findElement(By.xpath("(//div[@id='card0']//div[@class='sub-header'])[2]")).getText());
  	Assert.assertEquals("S$30,000",driver.findElement(By.xpath("(//div[@id='card0']//div[@class='sub-header'])[3]")).getText());
  	Assert.assertEquals("S$45,000",driver.findElement(By.xpath("(//div[@id='card0']//div[@class='sub-header'])[4]")).getText());
  	Assert.assertEquals("1 Year",driver.findElement(By.xpath("(//div[@id='card0']//div[@class='sub-header'])[6]")).getText());
    Assert.assertEquals("The only Credit Card that helps you give back while you spend",driver.findElement(By.xpath("(//div[@id='card14']//div[@class='sub-header'])[1]")).getText());
  	Assert.assertEquals("VISA",driver.findElement(By.xpath("(//div[@id='card14']//div[@class='sub-header'])[2]")).getText());
  	Assert.assertEquals("S$30,000",driver.findElement(By.xpath("(//div[@id='card14']//div[@class='sub-header'])[3]")).getText());
  	Assert.assertEquals("S$45,000",driver.findElement(By.xpath("(//div[@id='card14']//div[@class='sub-header'])[4]")).getText());
  	Assert.assertEquals("2 Years",driver.findElement(By.xpath("(//div[@id='card14']//div[@class='sub-header'])[6]")).getText());
}
}