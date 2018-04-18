package testes;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class homePage {
	
	private WebDriver driver;
	
	public homePage(WebDriver driver) {
		this.driver = driver;	
	}
	
	public void pesquisar(String produto) {
		WebElement campoPesquisa = driver.findElement(By.id("search_input"));
		campoPesquisa.clear();
		campoPesquisa.sendKeys(produto);
		campoPesquisa.submit();		
	}
	
}
