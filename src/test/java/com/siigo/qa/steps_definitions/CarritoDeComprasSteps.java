package com.siigo.qa.steps_definitions;

import com.siigo.qa.questions.ElValor;
import com.siigo.qa.tasks.Agregar;
import com.siigo.qa.tasks.Ingresar;
import com.siigo.qa.tasks.Modificar;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.is;

public class CarritoDeComprasSteps {

    @Managed
    WebDriver hisBrowser;

    Actor elvis = Actor.named("Elvis");

    @Before
    public void setTheStage(){
        OnStage.setTheStage(new OnlineCast());

    }
    @Given("el se encuentra en la pagina de google")
    public void elSeEncuentraEnLaPaginaDeGoogle() {
       elvis.can(BrowseTheWeb.with(hisBrowser));
       elvis.wasAbleTo(Open.url("https://www.google.com/"));
        
    }
    @When("el busca e ingresa a la pagina de Falabella")
    public void elBuscaEIngresaALaPaginaDeFalabella() {
       elvis.attemptsTo(Ingresar.aFalabellaDesdeGoogle());
        
    }
    @And("el agrega el articulo {string} a la bolsa virtual")
    public void elAgregaElArticuloALaBolsaVirtual(String articulo) {
        elvis.attemptsTo(Agregar.elArticuloALaBolsa(articulo));
    }
    @And("el modifica en la bolsa de pedido la cantidad y agrega garantia al articulo {string}")
    public void elModificaEnLaBolsaDePedidoLaCantidadYAgregaGarantiaAlArticulo(String articulo) {
        elvis.attemptsTo(Modificar.bolsaDeArticulos(articulo));

    }

    @Then("el deberia poder ver el valor del producto en las opciones de despacho")
    public void elDeberiaPoderVerElValorDelProductoEnLasOpcionesDeDespacho() {
        elvis.should(seeThat("El valor del articulo",ElValor.delArticulo(), is(true)));
    }
}
