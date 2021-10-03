package com.siigo.qa.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static com.siigo.qa.user_interfaces.FalabellaHomeUI.*;
import static java.time.Duration.ofSeconds;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Agregar implements Task {
    private String articulo;

    public Agregar(String articulo) {
        this.articulo = articulo;
    }

    @Step("{0} agrega el articulo #articulo a la bolsa de articulos")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(LOGO, isVisible()).forNoMoreThan(15).seconds()
                , Enter.theValue(articulo).into(BARRA_BUSQUEDA)
                , Click.on(BOTON_BUSCAR)
                , Click.on(ITEM.waitingForNoMoreThan(ofSeconds(15)))
        );

        if(BANNER_PUBLICITARIO.resolveFor(actor).isVisible()){
          actor.attemptsTo(Click.on(CERRAR_BANNER)
          ,JavaScriptClick.on(AGREGAR_BOLSA));
        }

    }

    public static Agregar elArticuloALaBolsa(String articulo) {
        return Tasks.instrumented(Agregar.class, articulo);
    }
}
