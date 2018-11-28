import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestWEB {
		
	WebDriver driver;
	private String url = "localhost:8080/TrabalhoTesteSoftware";

	private String number1 = "15";
	private String number2 = "10";
	private String resultado = "25";
	
    @Before
    public void start() throws Throwable {
            
		System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--no-sandbox");
 
        driver = new ChromeDriver(chromeOptions);
 
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
 
        Thread.sleep(1000);
 
        if (driver.getPageSource().contains("Saraiva")) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }
    
    @Test
	public void test() {
    	/*
    	driver.findElement(By.id("number1")).sendKeys(number1);
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

		driver.findElement(By.id("number2")).sendKeys(number2);
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		
		driver.findElement(By.id("calcular")).click();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

		resultado = driver.findElement(By.id("resultado")).getAttribute("value");
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		assertEquals(resultado, "25");
		*/
	}	
}