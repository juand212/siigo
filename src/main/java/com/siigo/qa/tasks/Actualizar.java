package com.siigo.qa.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Patch;
import net.thucydides.core.annotations.Step;

public class Actualizar implements Task {
    private String id;
    private String job;

    public Actualizar(String id, String job) {
        this.id = id;
        this.job = job;
    }

    @Step("{0} actualiza el job del user #id por: #job")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Patch.to("/api/users/".concat(id))
                        .with(
                                requestSpecification -> requestSpecification
                                        .header("Content-Type", "application/json")
                                        .body("{\n" +
                                                "    \"job\": \"" + job + "\"\n" +
                                                "}")
                        )


        );

    }
    public static Actualizar elJobDelUsuario(String id, String job){
        return Tasks.instrumented(Actualizar.class, id,job);
    }
}
