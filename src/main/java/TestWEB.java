import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestWEB {
		
	WebDriver driver;
	private String url = "http://localhost:8080/TrabalhoTesteSoftware/index.jsp";

	private String login_email = "lucas.alsilva01@gmail.com";
	private String login_pass = "123456";
	
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
        if (driver.getPageSource().contains("linkedin")) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }
    
    @Test
	public void test() {
    	System.out.println("Testando...");
    	
    	driver.findElement(By.id("login-email")).sendKeys(login_email);
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

		driver.findElement(By.id("login-password")).sendKeys(login_pass);
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
//		
		driver.findElement(By.id("login-submit")).click();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		String current_url = driver.getCurrentUrl();
		boolean login_sucess= !current_url.contains("unexpected_error");
		System.out.println(login_sucess);
		assertEquals(login_sucess, true);
		if(login_sucess) {
			System.out.println("Login efetuado com sucesso!");
		}
	}	
}