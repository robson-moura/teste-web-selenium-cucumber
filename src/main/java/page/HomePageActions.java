package page;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import utils.DriverSetUp;

public class HomePageActions extends HomeElementMap{


	public HomePageActions() {
		PageFactory.initElements(DriverSetUp.getDriver(), this);
	}

	public void setRadioPerfil(String valor){
		DriverSetUp.getDriver().findElement(By.xpath("//input[@value='" + valor + "']")).click();
	}

	public void setarValorAplicar(String valor){
		inputTextValoAplicar.sendKeys(valor);
	}

	public void setarValorInvestir(String valor){
		inputTextValoInvestir.sendKeys(valor);
	}

	public void setarTempo(String valor){
		inputTextValorTempo.sendKeys(valor);

		btnSimular.click();
	}
}
