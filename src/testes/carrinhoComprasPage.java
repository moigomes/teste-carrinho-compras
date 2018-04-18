package testes;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class carrinhoComprasPage {
	private WebDriver driver;
	
	
	
	public carrinhoComprasPage(WebDriver driver) {
		this.driver = driver;
		
		
	}
	
	public void confereProdutosCarrinho(String produto1, String produto2 ) {
		
		this.driver.findElement(By.xpath("//div[@id='sw_dropdown_8']/a/i")).click();
		this.driver.findElement(By.linkText("Ver carrinho")).click();
		
		
		assertEquals(produto1, driver.findElement(By.xpath("(//a[contains(text(),'"+produto1+"')])[2]")).getText());
		
		assertEquals(produto2, driver.findElement(By.xpath("(//a[contains(text(),'"+produto2+"')])[2]")).getText());
		
	}
	
	public void confereTotalCarrinho(float valorTotalProdutos) {
		
		
		
		String valorTotalCarrinho = driver.findElement(By.id("sec_cart_total")).getText();
		valorTotalCarrinho = valorTotalCarrinho.replace(",", "");
		
		
		assertEquals(Float.toString(valorTotalProdutos), valorTotalCarrinho);
		System.out.println("Teste realizado com sucesso!!!");	
		
	}

}
