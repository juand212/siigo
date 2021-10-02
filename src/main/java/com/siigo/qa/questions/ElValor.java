package com.siigo.qa.questions;

import com.siigo.qa.user_interfaces.FalabellaHomeUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.questions.Visibility;

public class ElValor implements Question<Boolean>{

    public static Question<Boolean> deLaOrden(){
        return actor -> Visibility.of(FalabellaHomeUI.SUB_TOTAL).viewedBy(actor).asBoolean();
    }
    @Subject("El valor del articulo")
    @Override
    public Boolean answeredBy(Actor actor) {
        return Visibility.of(FalabellaHomeUI.SUB_TOTAL).viewedBy(actor).asBoolean();
    }
    public static ElValor delArticulo(){
        return new ElValor();
    }
}
