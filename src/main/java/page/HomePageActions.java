package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverSetUp;

public class HomePageActions extends HomeElementMap {


    public HomePageActions() {
        PageFactory.initElements(DriverSetUp.getDriver(), this);
    }

    public void setRadioPerfil(String valor) {
        DriverSetUp.getDriver().findElement(By.xpath("//input[@value='" + valor + "']")).click();
    }

    public void setarValorAplicar(String valor) {
        inputTextValoAplicar.sendKeys(valor);
    }

    public void setarValorInvestir(String valor) {
        inputTextValoInvestir.sendKeys(valor);
    }

    public void setarTempo(String valor) {
        inputTextValorTempo.sendKeys(valor);
    }

    public void clicarSimular() {
        btnSimular.click();
    }

    public boolean validarSimulacao() {
        boolean retorno = false;
        try {
            WebElement tabelaValoresSimulacao = DriverSetUp.getDriver().findElement(By.xpath("//div[@class='maisOpcoes']/span[text()='Veja estas outras opções para você']"));
            WebDriverWait wait = new WebDriverWait(DriverSetUp.getDriver(), 5);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='maisOpcoes']/span[text()='Veja estas outras opções para você']")));

            if (tabelaValoresSimulacao.isEnabled())
                retorno = true;
        } catch (Exception e) {
                e.printStackTrace();
        }
        return retorno;
    }

    public void clicarRefazerSimulacao() {
        DriverSetUp.getDriver().findElement(By.xpath("//a[@class='btn btnAmarelo btnRefazer']")).click();
    }

    public boolean validarValorSimulacao(){
        boolean retorno = false;

        try {
            WebElement tabelaValoresSimulacao = DriverSetUp.getDriver().findElement(By.xpath("//div[@class='blocoFormulario blocoInput blocoInputValor']/label[text()='Valor mínimo de 20.00']"));
            WebDriverWait wait = new WebDriverWait(DriverSetUp.getDriver(), 5);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='blocoFormulario blocoInput blocoInputValor']/label[text()='Valor mínimo de 20.00']")));

            if (tabelaValoresSimulacao.isEnabled())
                retorno = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retorno;
    }
}
