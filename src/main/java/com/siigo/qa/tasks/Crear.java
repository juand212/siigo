package com.siigo.qa.tasks;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.thucydides.core.annotations.Step;

public class Crear implements Task {

    private String nombre;
    private String cargo;

    public Crear(String nombre, String cargo) {
        this.nombre = nombre;
        this.cargo = cargo;
    }

    @Step("{0} crea un nuevo usuario con nombre: #nombre y cargo: #cargo llamando a el metodo POST del endpoint")

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to("/users").with(
                        requestSpecification -> requestSpecification
                                .header("Content-Type", "application/json")
                                .body("{\n" +
                                        "    \"name\": \"" + nombre + "\",\n" +
                                        "    \"job\": \"" + cargo + "\"\n" +
                                        "}")
                )

        );
    }

    public static Crear nuevoUsuario(String nombre, String cargo) {
        return Tasks.instrumented(Crear.class, nombre, cargo);

    }

}
