package com.siigo.qa.steps_definitions;

import com.siigo.qa.tasks.Actualizar;
import com.siigo.qa.tasks.Crear;
import com.siigo.qa.tasks.Eliminar;
import com.siigo.qa.tasks.Listar;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

public class TestingAPIsteps {

    private Actor elvis;


    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());

    }

    @Given("el tiene acceso a la API: {string}")
    public void elTieneAccesoALaAPI(String apiBaseUrl) {
        elvis = Actor.named("Elvis").whoCan(CallAnApi.at(apiBaseUrl));
    }

    @When("el crea un nuevo usuario con nombre {string} y cargo {string}")
    public void elCreaUnNuevoUsuarioConNombreYCargo(String nombre, String cargo) {
        elvis.attemptsTo(Crear.nuevoUsuario(nombre, cargo));
        elvis.attemptsTo(Ensure.that(SerenityRest.lastResponse().getStatusCode()).isEqualTo(201));
        elvis.remember("id_nuevo_usurio", SerenityRest.lastResponse().jsonPath().get("id").toString());
    }

    //    @And("el verifica que el usuario fue creado")
//    public void elVerificaQueElUsuarioFueCreado() {
//        elvis.attemptsTo(Listar.laCreacionDelNuevoUsuario(elvis.recall("id_nuevo_usurio")));
//        elvis.attemptsTo(Ensure.that(SerenityRest.lastResponse().statusCode()).isEqualTo(200));
//
//    }
    @And("el consulta el usuario con el id {string}")
    public void elConsultaElUsuarioConElId(String id) {
        elvis.attemptsTo(Listar.losUsuarios(id));
        elvis.attemptsTo(Ensure.that(SerenityRest.lastResponse().statusCode()).isEqualTo(200));
    }

    @And("el actualiza el cargo del usuario con id {string} con el nuevo cargo {string}")
    public void elActualizaElCargoDelUsuarioConIdConElNuevoCargo(String id, String job) {
        elvis.attemptsTo(Actualizar.elJobDelUsuario(id, job));
        elvis.attemptsTo(Ensure.that(SerenityRest.lastResponse().statusCode()).isEqualTo(200));
    }

    @And("el elimina el usuario con id {string}")
    public void elEliminaElUsuarioConId(String id) {
        elvis.attemptsTo(Eliminar.elUsuarioConId(id));
    }

    @Then("el deberia poder ver {int} en la respuesta del servicio")
    public void elDeberiaPoderVerEnLaRespuestaDelServicio(int response) {
        elvis.attemptsTo(Ensure.that(SerenityRest.lastResponse().statusCode()).isEqualTo(response));
    }
}
