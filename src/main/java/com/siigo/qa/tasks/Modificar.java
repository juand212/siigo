package com.siigo.qa.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;

import static com.siigo.qa.user_interfaces.FalabellaHomeUI.*;
import static com.siigo.qa.user_interfaces.FalabellaHomeUI.ITEM_BOLSA;
import static java.time.Duration.ofSeconds;

public class Modificar {
    public static Performable bolsaDeArticulos(String articulo){
        return Task.where("{0} modifica la bolsa de articulos",
                Click.on(VER_BOLSA)
                , Scroll.to(ITEM_BOLSA.of(articulo).waitingForNoMoreThan(ofSeconds(15)))
                ,Click.on(BOTON_MAS.of(articulo))
                , Click.on(GARANTIA)
                ,Click.on(OPCION_GARANTIA)

        );
    }
}
