package seleniumHackathon;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CurrencyConversion {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.xe.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		WebElement from = driver.findElement(By.xpath("//div[@class='sc-e6a0deed-4 HjvoF']/input[@placeholder='Type to search...'][1]"));
		from.sendKeys("USD");
		driver.findElement(By.xpath("//div[contains(text(),'USD')]")).click();
		Thread.sleep(2000);
		
		WebElement to = driver.findElement(By.xpath("(//div[@class='sc-e6a0deed-4 HjvoF']/input[@placeholder='Type to search...'])[2]"));
		to.sendKeys("INR");
		
		// span[@class='amount-input']//input
		// div[contains(text(),'INR')]
		
		driver.findElement(By.xpath("//div[contains(text(),'INR')]")).click();
		WebElement amount = driver.findElement(By.xpath("//span[@class='amount-input']//input"));
		amount.sendKeys("10");
		
		// button[text()='Convert']
		Thread.sleep(2000);
	// (driver.findElement(By.xpath("//button[text(),'Convert']"))));
		// button[@style='grid-area:buttons' and text()='Convert']
		WebElement convert = driver.findElement(By.xpath("//button[@style='grid-area:buttons' and text()='Convert']"));
		convert.click();

	}
}
