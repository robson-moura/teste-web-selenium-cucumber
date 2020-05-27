package steps;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import page.HomePageActions;
import utils.DriverSetUp;

public class HomeSteps {

    private WebDriver driver;

    @Dado("^Acessei a pagina$")
    public void acessei_a_pagina() throws Throwable {
        new DriverSetUp().setUP();
        driver = DriverSetUp.getDriver();
        driver.navigate().to("https://www.sicredi.com.br/html/ferramenta/simulador-investimento-poupanca/");
    }


    @E("^inseri os valores corretos para o calculo$")
    public void inseriOsValoresCorretosParaOCalculo() {
        HomePageActions homePageActions = new HomePageActions();
        homePageActions.setRadioPerfil("paraVoce");
        homePageActions.setarValorAplicar("8000");
        homePageActions.setarValorInvestir("15000");
        homePageActions.setarTempo("12");
    }

    @E("^clico em simular$")
    public void clicoEmSimular() {
        new HomePageActions().clicarSimular();
    }

    @Entao("^eu vejo os valores simulados$")
    public void euVejoOsValoresSimulados() {
        boolean resultado = new HomePageActions().validarSimulacao();
        Assert.assertTrue(resultado, "FALHA AO SIMULAR");
    }

    @E("^clico em refazer simulacao$")
    public void clicoEmRefazerSimulacao() {
        new HomePageActions().clicarRefazerSimulacao();
    }

    @E("^insiro valores incorretos$")
    public void insiroValoresIncorretos() {
        HomePageActions homePageActions = new HomePageActions();
        homePageActions.setRadioPerfil("paraVoce");
        homePageActions.setarValorAplicar("10");
        homePageActions.setarValorInvestir("10");
        homePageActions.setarTempo("12");
    }

    @Entao("^vejo a validacao do valor$")
    public void vejoAValidacaoDoValor() {
        boolean resultado = new HomePageActions().validarValorSimulacao();
        Assert.assertTrue(resultado, "FALHA AO SIMULAR");
    }
}
