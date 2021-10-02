package com.siigo.qa.runners;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(glue = "com.siigo.qa.steps_definitions",
        features = {"src/test/resources/features/carrito_de_compras.feature"},
        snippets = CAMELCASE
        , tags = "")
public class CarritoDeCompras {
}
