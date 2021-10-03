package com.siigo.qa.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.core.annotations.Step;

public class Listar implements Task{
    private String id;

    public Listar(String id) {
        this.id = id;
    }


@Step("{0} verifica la creacion del nuevo usuario con el metodo GET al endpoint /users/#id")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource("/users/".concat(id))
        );

    }
    public static Listar losUsuarios(String id){
        return Tasks.instrumented(Listar.class,id);
    }
}
