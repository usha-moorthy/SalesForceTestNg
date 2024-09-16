package seleniumHackathon;

import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class amazon {
	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions
				.invisibilityOf(driver.findElement(By.xpath("//button[text()='Continue shopping']"))));
		WebElement search = driver.findElement(By.id("twotabsearchtextbox")); // Enter search item and click
		search.sendKeys("Kindle");
		WebElement submit = driver.findElement(By.id("nav-search-submit-button"));
		submit.click();

		WebElement overallPick = driver
				.findElement(By.xpath("//span[contains(text(),'Overall Pick') and @class='a-badge-text']"));
		if (overallPick.isDisplayed()) {
			WebElement productHeading = driver
					.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal'][1]"));
			productHeading.click();
		}
		Thread.sleep(1000);
		WebElement addToCart = driver.findElement(By.xpath("//input[@id='add-to-cart-button']"));
		addToCart.click();

//		WebElement popup=driver.findElement(By.xpath("//button[@aria-label='Close' and @ class=' a-button-close a-declarative']"));
//		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		WebElement popup = driver.findElement(By.xpath("//*[@id='abb-intl-pop-cta']/span[3]"));
		popup.click();

		driver.findElement(By.xpath("//span[@id='nav-cart-count']")).click();

		boolean displayed = driver.findElement(By.xpath("//a//img[@class='sc-product-image']")).isDisplayed();
		if (displayed) {

			System.out.println("kindle is added to the cart");
		} else {
			System.out.println("kindle is not added the cart");
		}

		driver.quit();

	}
}
