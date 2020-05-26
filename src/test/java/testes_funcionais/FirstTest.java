package testes_funcionais;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import page.HomePageActions;
import utils.DriverSetUp;

public class FirstTest extends DriverSetUp{

    private WebDriver driver;

    @Test
    public void test1() {
        driver = DriverSetUp.getDriver();
        driver.navigate().to("https://www.sicredi.com.br/html/ferramenta/simulador-investimento-poupanca/");

        HomePageActions setValues = new HomePageActions();
        setValues.setRadioPerfil("paraVoce");
        setValues.setarValorAplicar("8000");
        setValues.setarValorInvestir("15000");
        setValues.setarTempo("12");

    }

    @Test
    public void test2() {
        driver = DriverSetUp.getDriver();
        driver.navigate().to("https://www.sicredi.com.br/html/ferramenta/simulador-investimento-poupanca/");

        HomePageActions setValues = new HomePageActions();
        setValues.setRadioPerfil("paraVoce");
        setValues.setarValorAplicar("10");
        setValues.setarValorInvestir("10");
        setValues.setarTempo("12");

    }
}
