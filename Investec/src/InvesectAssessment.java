import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InvesectAssessment {

	public static void main(String[] args) throws InterruptedException {
		
		String LocationChrome = "C:\\Users\\nkina.ramonyai\\eclipse-workspace\\Investec\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", LocationChrome);
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.investec.com/");
		driver.manage().window().maximize();
		//wait for the page to load
		Thread.sleep(5000);
		WebElement searchButton  = driver.findElement(By.cssSelector("#search-toggle"));
		searchButton.click();
		//wait for the search results to load
		Thread.sleep(5000);
		WebElement searchBar  = driver.findElement(By.cssSelector("#searchBarInput"));
		searchBar.sendKeys("cash investment rates");
		WebElement searchBarButton  = driver.findElement(By.cssSelector("#searchBarButton"));
		searchBarButton.click();
		WebElement searchBarResults  = driver.findElement(By.linkText("See all results"));
		driver.findElement(By.cssSelector(".search-results__results-action-wrapper")); 
		searchBarResults.click();
		
		List<WebElement> URLs = driver.findElements(By.cssSelector("a[href]"));
		for(int  i =0; i< URLs.size(); i++) {
			if(URLs.get(i).getAttribute("href").contains("https://www.investec.com/en_za/focus/money/understanding-interest-rates.html")) {
				System.out.println("Found @ index = " + i +" "+ URLs.get(i).getAttribute("href"));
				driver.navigate().to(URLs.get(i).getAttribute("href"));
				break;
		}else {
			System.out.println("NOT found @ index = " + i +" "+ URLs.get(i).getAttribute("href"));
		}
			
		}
		//wait for the page to load
		Thread.sleep(5000);
		
		WebElement cookiesButton  = driver.findElement(By.cssSelector(".js-alerts-close"));
		cookiesButton.click();
		WebElement signUpButton  = driver.findElement(By.cssSelector(".button-primary"));
		Thread.sleep(2000);
		//sign up button only clickable at point(0,80) or above
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(2000);
		signUpButton.click();
		//expand the form to be visble on the screen
		js.executeScript("window.scrollBy(0,550)");
		WebElement signUpName = driver.findElement(By.name("name"));
		signUpName.click();
		signUpName.sendKeys("test");
		 
		WebElement signUpSurname = driver.findElement(By.name("surname"));
		signUpSurname.click();
		signUpSurname.sendKeys("test");

		WebElement signUpEmail = driver.findElement(By.name("email"));
		signUpEmail.click();
		signUpEmail.sendKeys("test@investec.co.za");
		
		WebElement signUpCheckbox1 = driver.findElement(By.cssSelector(".checkbox-input__trigger-button--first-child"));
		signUpCheckbox1.click();

		WebElement signUpCheckbox2 = driver.findElement(By.cssSelector(".checkbox-input__buttons:nth-child(2) > .checkbox-input__trigger-button"));
		signUpCheckbox2.click(); 
		
		WebElement signUpCheckbox3 = driver.findElement(By.cssSelector(".checkbox-input__buttons:nth-child(3) > .checkbox-input__trigger-button"));
		signUpCheckbox3.click(); 
		
		WebElement signUpSubmitButtton = driver.findElement(By.cssSelector(".forms__submit"));
		signUpSubmitButtton.click();
		
		//wait for the sign up process to be completed
		Thread.sleep(5000);
		
		//close the browser
		driver .quit();

	}
	
	
}
