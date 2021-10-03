package com.siigo.qa.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.type.Type;

import static com.siigo.qa.user_interfaces.HomeUI.BUSCAR;
import static com.siigo.qa.user_interfaces.HomeUI.LINK;
import static org.openqa.selenium.Keys.ENTER;

public class Ingresar {
    public static Performable aFalabellaDesdeGoogle(){
        return Task.where("{0} ingresa a falabella desde el motor de busqueda de Google",
                Type.theValue("Fallabela").into(BUSCAR).thenHit(ENTER)
                , Click.on(LINK)
                );
    }
}
