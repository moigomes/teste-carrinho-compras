package testes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class detalheProdutoPage {
	
	private Integer quantidade;
	private float valorProduto;
	private String nomeProduto;
	private WebDriver driver;
	
	

	public detalheProdutoPage(WebDriver driver) {
		
		this.driver = driver;
		
		
	}
	
	
	public void adicionaProdutoAoCarrinho(Integer quantidade) {
		
		this.quantidade = quantidade;
		this.nomeProduto = this.driver.findElement(By.xpath("//div[@id='tygh_main_container']/div[3]/div/div[2]/div/div/div/div[3]/form/h1/bdi")).getText();
		WebElement campoQuantidade = this.driver.findElement(By.xpath("//input[@class='ty-value-changer__input cm-amount']"));
		campoQuantidade.clear();
		campoQuantidade.sendKeys(Integer.toString(this.quantidade));
		
		
		this.valorProduto = Float.parseFloat(this.driver.findElement(By.xpath("//*[contains(@id,'sec_discounted_price')]")).getText());
		driver.findElement(By.xpath("//*[contains(@id,'button_cart')]")).click();
		System.out.println("Produto: "+this.nomeProduto);	
		System.out.println("Valor unitário: "+this.valorProduto);	
		System.out.println("Quantidade: "+this.quantidade);
		System.out.println("----------------------------------------------------------------------");
		
		
	}

	
	public float calculaTotal() {
		return this.quantidade * this.valorProduto;
	}
	
	
	public String getNomeProduto() {
		return this.nomeProduto;
	}
	
	public void clicaEmContinuarCompra() {
		driver.findElement(By.linkText("Continuar compras")).click();
	}

}
