package testes;

import testes.homePage;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class testeCarrinho {
	
	@Test
	public void testeCarrinho() {
		
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.get("http://demo.cs-cart.com");
		
		homePage homePage = new homePage(driver);
		homePage.pesquisar("Batman");
		
		resultadoBuscaPage resultadoBuscaPage = new resultadoBuscaPage(driver);
		resultadoBuscaPage.selecionaPruduto("Batman: Arkham City (X360)");
		
		detalheProdutoPage produtoSelecionado = new detalheProdutoPage(driver);
		produtoSelecionado.adicionaProdutoAoCarrinho(1);
		produtoSelecionado.clicaEmContinuarCompra();
		
		homePage homePage2 = new homePage(driver);
		homePage.pesquisar("Iphone");
		
		resultadoBuscaPage resultadoBuscaPage2 = new resultadoBuscaPage(driver);
		resultadoBuscaPage.selecionaPruduto("Apple iPhone 4S White");
		
		detalheProdutoPage produtoSelecionado2 = new detalheProdutoPage(driver);
		produtoSelecionado2.adicionaProdutoAoCarrinho(3);
		produtoSelecionado2.clicaEmContinuarCompra();
		
		
		carrinhoComprasPage carrinhoComprasPage = new carrinhoComprasPage(driver);
		carrinhoComprasPage.confereProdutosCarrinho(produtoSelecionado.getNomeProduto(), produtoSelecionado2.getNomeProduto());
		carrinhoComprasPage.confereTotalCarrinho(produtoSelecionado.calculaTotal() + produtoSelecionado2.calculaTotal());
		
		
		
		
		driver.close();
			
	}

}
