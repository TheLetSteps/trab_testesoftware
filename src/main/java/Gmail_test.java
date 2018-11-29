import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;

public class Gmail_test {
	
	WebDriver driver;
	private String url = "https://gmail.com/";
	
	private String login_email_valido = "testesoftware.uea@gmail.com";
	private String login_pass_valido = "Teste2018";
	private String login_email_invalido = "testemuitoerrado@gmail.com";
	private String login_pass_invalido = "erreiasenha";	
	private String login_email_invalido2 = "lucas.alsilva01@gmail.com";
	private String login_pass_invalido2 = "erreiasenhadenovo";	
	public void restartDriver() {
		System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
	    
	    ChromeOptions chromeOptions = new ChromeOptions();
	    chromeOptions.addArguments("--headless");
	    chromeOptions.addArguments("--no-sandbox");
	
	    this.driver = new ChromeDriver(chromeOptions);
	
	    this.driver.get(url);
	    this.driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

	}
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
	    if (driver.getPageSource().contains("google")) {
	        System.out.println("Entrou site");
	    } else {
	        System.out.println("Falha de conexão!");
	    }
	}
    public void login(String login_email,String login_pass) {
//    	CASO- 1. Checar se login e senha foram inseridos corretamente. 
//    		Checar se o campo para inserir email existe e enviar o login
    	boolean login_sucess= false;
    	restartDriver();
        try
        {
          WebElement campo_email = driver.findElement(By.xpath("//*[@id='Email']"));
          System.out.println("Campo email Ok.");
          campo_email.sendKeys(login_email);
         }
        catch(Throwable e)
         {
        	System.out.println("Campo email não encontrado.");
        	assertEquals(login_sucess, true);
         }
//		Checar se o botao de proximo existe
	    try
	    {
	      WebElement botao_proximo = driver.findElement(By.xpath("//*[@id='next']"));
	      System.out.println("Botao proximo Ok.");
	      botao_proximo.click();
		  driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	     }
	    catch(Throwable e)
	     {
	    	System.out.println("Botão próximo não encontrado.");
	    	assertEquals(login_sucess, true);
	     }
//		Submit Login
	    try
	    {
	      WebElement campo_senha = driver.findElement(By.xpath("//*[@id='Passwd']"));
	      System.out.println("Campo senha Ok.");
	      campo_senha.sendKeys(login_pass);
	     }
	    catch(Throwable e)
	     {
	    	System.out.println("Campo senha não encontrado ou email não existe");
	    	assertEquals(login_sucess, true);
	     }
//		Teste de login
	    try {
		    driver.findElement(By.xpath("//*[@id='signIn']")).click();
		    driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	    }
	    catch(Throwable e)
	     {
	    	System.out.println("Erro ao efetuar login!");
	    	assertEquals(login_sucess, true);
	     }
	    String current_url = driver.getCurrentUrl();
		login_sucess= current_url.contains("inbox");
		if(login_sucess) {
			System.out.println("Login efetuado com sucesso!");
			assertEquals(login_sucess, true);
		}
		else {
			System.out.println("Erro ao efetuar login!");
			assertEquals(login_sucess, true);
		}
		driver.close();
}
    @Test
	public void test() {
    	System.out.println("Testando login válido");
    	login(this.login_email_valido,this.login_pass_valido);
    	System.out.println("Testando login inválido");
    	login(this.login_email_invalido,this.login_pass_invalido);
    	System.out.println("Testando login inválido  2");
    	login(this.login_email_invalido2,this.login_pass_invalido2);
	}

}