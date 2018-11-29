import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;

public class Github_test {
		
	WebDriver driver;
	private String url = "https://github.com/";

	private String login_email = "lucas.alsilva01@gmail.com";
	private String login_pass = "testesoft3s";
	
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
            System.out.println("Entrou site");
        } else {
            System.out.println("Falhar de conexão!");
        }
    }
    public void login() {
    	String login_url = "https://github.com/login";
    	driver.get(login_url);
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
         
    	driver.findElement(By.id("login_field")).sendKeys(login_email);
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

		driver.findElement(By.id("password")).sendKeys(login_pass);
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
//		
		driver.findElement(By.name("commit")).click();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		boolean login_sucess= driver.getPageSource().contains("Signed in");
		if(login_sucess) {
			System.out.println("Login efetuado com sucesso!");
		}
		else {
			System.out.println("Erro ao efetuar login!");
		}
		assertEquals(login_sucess, true);

    }
    @Test
	public void test() {
    	System.out.println("Testando login..");
    	login();
	}	
}