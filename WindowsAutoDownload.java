import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class WindowsAutoDownload {
	
	public static String randomLanguageSelector(){
		String languages[]={"English","Arabic","French","Dutch","German","Greek","Hebrew","Finnish"};
		int randomIndex = new Random().nextInt(languages.length);
	    return languages[randomIndex];
	}
	
	public static void main(String args[]){
		
		try{
			
		System.setProperty("webdriver.chrome.driver", "/home/webonise/workspace/TestingAutomation/res/chromedriver");
        WebDriver driver = new ChromeDriver();
    
        // Loads up Microsoft website
        driver.get("https://www.microsoft.com/en-in/software-download/windows10ISO");
        
            
        // Selects windows 10 version
        WebElement mySelectElement = driver.findElement(By.xpath("//*[@id='product-edition']"));
        Select dropdown= new Select(mySelectElement);
        dropdown.selectByVisibleText("Windows 10");
        
        // Clicks confirm button
        driver.findElement(By.xpath("//*[@id='submit-product-edition']")).click();
        Thread.sleep(5000);
        
        // Selects random language from the drop-down list 
        mySelectElement = driver.findElement(By.xpath("//*[@id='product-languages']"));
        Select languagesDropdown= new Select(mySelectElement);
       
        // selects random languages from dropdown
        for (int i=0;i<5;i++){
            languagesDropdown.selectByVisibleText(randomLanguageSelector());
            Thread.sleep(2000);	
        }
        
        // Clicks confirm language
        driver.findElement(By.xpath("//*[@id='submit-sku']")).click();
        Thread.sleep(5000);
        
        // Click 32 bit version for downloading
        driver.findElement(By.xpath("//*[@id='card-info-content']/div/div[1]/div/a")).click();
        Thread.sleep(5000);
  
        // Expands feedback section
        driver.findElement(By.xpath("//*[@id='774b232c-a48d-452a-a8fb-3906dc168d5c']/a/span[2]")).click();
        Thread.sleep(5000);
      
        // Select feedback question 1
        driver.findElement(By.xpath("//*[@id='feedback-question1']/ul/li[1]/label/input")).click();
        Thread.sleep(5000);
      
        // Select feedback question 2
        driver.findElement(By.xpath("//*[@id='feedback-question2']/ul/li[1]/label/input")).click();
        
        // Select feedback textview box
        driver.findElement(By.xpath("//*[@id='feedback-extra-comments']")).click();
        
        // Enters feedback into comment box
        driver.findElement(By.xpath("//*[@id='feedback-extra-comments']")).sendKeys("Awesome OS");;
        
        // Sends the feedback
        driver.findElement(By.xpath("//*[@id='feedback-send-button']")).click();
        
        }
		catch(Exception e){
			System.out.print("Error: "+e);
		}
	}
	
}
