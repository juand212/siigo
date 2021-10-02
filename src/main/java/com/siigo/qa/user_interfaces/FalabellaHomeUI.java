package com.siigo.qa.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class FalabellaHomeUI {
    public static final Target LOGO = Target.the("Barra de busqueda")
            .locatedBy("//img[@alt='falabella']");
    public static final Target BARRA_BUSQUEDA = Target.the("Barra de busqueda")
            .locatedBy("//input[@id='testId-SearchBar-Input']");
    public static final Target BOTON_BUSCAR = Target.the("Boton buscar")
            .locatedBy("//button[contains(@class,'SearchBar-module_searchBtnIcon')]");
    public static final Target ITEM = Target.the("Primer elemento del resultado de la busqueda")
            .locatedBy("//div[contains(@class,'search-results')]/following::a[contains(@class,'ayout_grid-view')]");
    public static final Target AGREGAR_BOLSA = Target.the("Boton agregar a la bolsa de articulos")
            .locatedBy("//button[@type='button'][contains(.,'Agregar a la Bolsa')]");
    public static final Target CERRAR_BANNER = Target.the("Boton cerrar banner")
            .locatedBy("//div[@class='dy-lb-close']");
public static final Target BANNER_PUBLICITARIO = Target.the("Banner publicitario")
            .locatedBy("//img[@class='banner-cmr-notificacion']");
public static final Target VER_BOLSA = Target.the("Boton Ver Bolsa")
            .locatedBy("//a[@href='/falabella-co/basket']");
public static final Target ITEM_BOLSA = Target.the("Item: {0} en la bolsa de compras")
            .locatedBy("//a[contains(.,'{0}')]");
public static final Target BOTON_MAS = Target.the("Boton agregar mas item: {0} desde bolsa" )
            .locatedBy("//a[contains(.,'{0}')]/following::button[contains(.,'+')]");
public static final Target GARANTIA = Target.the("Boton agregar mas item: {0} desde bolsa" )
            .locatedBy("//a[@class='fb-warranty-dropdown fb-inline-dropdown__link js-inline-dropdown__link']");
public static final Target OPCION_GARANTIA = Target.the("Primara opcion garantia" )
            .locatedBy("//a[contains(@class,'fb-inline-dropdown__item-link') and text()='1 a\u00F1o de Garant\u00EDa Extendida $ 195.490']");
public static final Target SUB_TOTAL = Target.the("Sub-total de la orden" )
            .locatedBy("(//span[contains(.,'Sub-total productos')]/following::span)[1]");



}
