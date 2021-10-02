package com.siigo.qa.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class HomeUI {
    public static final Target  BUSCAR  = Target.the("Campo buscar")
            .locatedBy("//input[@name='q']");
public static final Target LINK  = Target.the("primer link para ingresar a Falabella")
            .locatedBy("(//a[contains(.,'falabella')])[1]");



}
