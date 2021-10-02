Feature: Carrito de compras

  Yo como usuario de Falabella
  Quiero una bolsa de productos
  Para poder agregar los articulos que quiero y poder modificar los pedidos desde la misma.


  Scenario: Modificar pedido desde la bolsa de productos
    Given el se encuentra en la pagina de google
    When el busca e ingresa a la pagina de Falabella
    And el agrega el articulo "Consola PS4 Megapack 15 1TB" a la bolsa virtual
    And el modifica en la bolsa de pedido la cantidad y agrega garantia al articulo "Consola PS4 Megapack 15 1TB"
    Then el deberia poder ver el valor del producto en las opciones de despacho




