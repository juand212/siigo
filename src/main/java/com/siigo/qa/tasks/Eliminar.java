package com.siigo.qa.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Delete;
import net.thucydides.core.annotations.Step;

public class Eliminar implements Task {
    private String id;

    public Eliminar(String id) {
        this.id = id;
    }

    @Step("{0} Elimina al usuario con id: #id")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Delete.from("/users/".concat(id))
        );
    }
    public static Eliminar elUsuarioConId(String id){
        return Tasks.instrumented(Eliminar.class, id);
    }
}
