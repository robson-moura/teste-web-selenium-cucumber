package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomeElementMap {

	@FindBy(id="valorAplicar")
	protected WebElement inputTextValoAplicar;

	@FindBy(id="valorInvestir")
	protected WebElement inputTextValoInvestir;

	@FindBy(xpath="//button[contains(.,'Simular')]")
	protected WebElement btnSimular;

	@FindBy(id="tempo")
	protected WebElement inputTextValorTempo;


}