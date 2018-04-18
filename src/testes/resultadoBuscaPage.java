package testes;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class resultadoBuscaPage {
	private WebDriver driver;

	public resultadoBuscaPage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public void selecionaPruduto(String produto) {
		driver.findElement(By.linkText(produto)).click();
		
	}
	
}