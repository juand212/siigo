Feature: Realizar el proceso de compra

  Yo como usuario de Amazon
  Quiero poder comprar desde la pagina
  Para realizar mis compras comodamente
  @prioritario
  Scenario: Usuario con cuenta Amazon configuarada compra articulo con Tarjata de credito con resultado exitoso
    Given el se encuentra logueado en la pagina principal de Amazon
    When el realiza la busqueda del articulo <"articulo">
    And el agregar el articulo al carrito de compras
    And el realiza la compra del articulo con la tarjeta de credito
      | articulo   | numeroTarjetaDebito   | nombreEnLaTarjeta   | fechaCaducidad   | cvv   |
      | <articulo> | <numeroTarjetaDebito> | <nombreEnLaTarjeta> | <fechaCaducidad> | <cvv> |
    Then el deberia poder ver el mensaje de compra exitosa

    @prioritario
  Scenario Outline: Usuario con cuenta Amazon configuarada compra articulo con Tarjata de credito <"escenario">
    Given el se encuentra logueado en la pagina principal de Amazon
    When el realiza la busqueda del articulo <"articulo">
    And el agregar el articulo al carrito de compras
    And el realiza la compra del articulo con la tarjeta de credito
      | articulo   | numeroTarjetaDebito   | nombreEnLaTarjeta   | fechaCaducidad   | cvv   |
      | <articulo> | <numeroTarjetaDebito> | <nombreEnLaTarjeta> | <fechaCaducidad> | <cvv> |
    Then el deberia poder el mensaje de error <"mensaje"> al intentar pagar la orden
    Examples:
      | "articulo" | articulo | numeroTarjetaDebito | nombreEnLaTarjeta | fechaCaducidad | cvv | "escenario"                                      | "mensaje"                                                                   |
      | haedset    | articulo | numeroTarjetaDebito | nombreEnLaTarjeta | fechaCaducidad | cvv | numero de tarjeta no valido                      | "El numero de la tarjeta de credito ingresada no es valido"                 |
      | haedset    | articulo | numeroTarjetaDebito | nombreEnLaTarjeta | fechaCaducidad | cvv | ccv incorrecto                                   | "El numero cvv  de la tarjeta de credito ingresada no es valido"            |
      | haedset    | articulo | numeroTarjetaDebito | nombreEnLaTarjeta | fechaCaducidad | cvv | fecha de vencimiento incorrecto                  | "La fecha de vencimiento de la tarjeta de credito ingresada no es valida"   |
      | haedset    | articulo | numeroTarjetaDebito | nombreEnLaTarjeta | fechaCaducidad | cvv | tarjeta bloqueada                                | "La tarjeta de credito ingresada se encuentra bloqueada"                    |
      | haedset    | articulo | numeroTarjetaDebito | nombreEnLaTarjeta | fechaCaducidad | cvv | fecha de vencimiento de la tarjeta esta caducada | "La fecha de vencimiento de la tarjeta de credito ingresada esta caducada"  |
      | haedset    | articulo | numeroTarjetaDebito | nombreEnLaTarjeta | fechaCaducidad | cvv | franquicia no aceptada por el comercio           | "La de la tarjeta de credito ingresada esta no es aceptada por el comercio" |
      | haedset    | articulo | numeroTarjetaDebito | nombreEnLaTarjeta | fechaCaducidad | cvv | valida sin cupo suficiente para la compra        | "La compra fue rechazada por falta de fondos sucifientes"                   |

    #Compra con tarjeta debito
  @prioritario
  Scenario : Usuario con cuenta Amazon configuarada compra articulo con Tarjata debito con resultado Exitoso
    Given el se encuentra logueado en la pagina principal de Amazon
    When el realiza la busqueda del articulo <"articulo">
    And el agregar el articulo al carrito de compras
    And el realiza la compra del articulo con la tarjeta de debito
      | articulo   | numeroTarjetaDebito   | nombreEnLaTarjeta   | fechaCaducidad   | cvv   |
      | <articulo> | <numeroTarjetaDebito> | <nombreEnLaTarjeta> | <fechaCaducidad> | <cvv> |
    Then el deberia poder ver el mensaje de compra exitosa
  @prioritario
  Scenario: Usuario logueado realiza compra agregando una nueva tarjeta debito valida
    Given el se encuentra logueado en la pagina principal de Amazon
    When el realiza la busqueda del articulo <"articulo">
    And el agregar el articulo al carrito de compras
    And el realiza la compra del articulo con una nueva tarjeta debito
      | articulo   | numeroTarjetaDebito   | nombreEnLaTarjeta   | fechaCaducidad   | cvv   |
      | <articulo> | <numeroTarjetaDebito> | <nombreEnLaTarjeta> | <fechaCaducidad> | <cvv> |
    Then el deberia poder ver el mensaje de compra exitosa

  @prioritario
  Scenario: Usuario sin cuenta de Amazon realiza compra con tarjeta debito valida creando una nueva cuenta de amazon
    Given el se encuentra en la pagina de creacion de cuenta nueva de Amazon
    When el crea su cuenta en amazon con sus datos e inicia sesion
      | nombre | correo | clave |
      | nombre | correo | clave |
    When el realiza la busqueda del articulo <"articulo">
    And el agrega el articulo al carrito de compras
    And el realiza la compra del articulo con una nueva tarjeta debito
      | articulo   | numeroTarjetaDebito   | nombreEnLaTarjeta   | fechaCaducidad   | cvv   |
      | <articulo> | <numeroTarjetaDebito> | <nombreEnLaTarjeta> | <fechaCaducidad> | <cvv> |
    Then el deberia poder ver el mensaje de compra exitosa

  Scenario: Usuario realiza compra con tarjeta debito valida sin estar logeuado en amazon
    Given el se encuentra en la pagina de prinpipal de amazon
    When el inicia sesion con sus credenciales
    When el realiza la busqueda del articulo <"articulo">
    And el agrega el articulo al carrito de compras
    And el realiza la compra del articulo con una nueva tarjeta debito
      | articulo   | numeroTarjetaDebito   | nombreEnLaTarjeta   | fechaCaducidad   | cvv   |
      | <articulo> | <numeroTarjetaDebito> | <nombreEnLaTarjeta> | <fechaCaducidad> | <cvv> |
    Then el deberia poder ver el mensaje de compra exitosa
  @prioritario
  Scenario:Usuario logueado realiza compra con el metodo de pago predeterminado
    Given el se encuentra logueado en la pagina principal de Amazon
    When el realiza la busqueda del articulo <"articulo">
    And el agregar el articulo al carrito de compras
    And el realiza la compra del articulo con el medio de pago predeterminado
    Then el deberia poder ver el mensaje de compra exitosa

  @prioritario
  Scenario Outline: Usuario con cuenta Amazon configuarada compra articulo con Tarjata debito  <"escenario">
    Given el se encuentra logueado en la pagina principal de Amazon
    When el realiza la busqueda del articulo <"articulo">
    And el agregar el articulo al carrito de compras
    And el realiza la compra del articulo con la tarjeta de debito
      | articulo   | numeroTarjetaDebito   | nombreEnLaTarjeta   | fechaCaducidad   | cvv   |
      | <articulo> | <numeroTarjetaDebito> | <nombreEnLaTarjeta> | <fechaCaducidad> | <cvv> |
    Then el deberia poder el mensaje de error <"mensaje"> al intentar pagar la orden
    Examples:
      | "articulo" | articulo | numeroTarjetaDebito | nombreEnLaTarjeta | fechaCaducidad | cvv | "escenario"                                 | "mensaje"                                                                   |
      | haedset    | articulo | numeroTarjetaDebito | nombreEnLaTarjeta | fechaCaducidad | cvv | valida sin cobertura al lugar de residencia | "Lo siento, no tenemos cobertura para el pais seleccionado"                 |
      | haedset    | articulo | numeroTarjetaDebito | nombreEnLaTarjeta | fechaCaducidad | cvv | numero de tarjeta no valido                 | "El numero de la tarjeta debito ingresada no es valido"                     |
      | haedset    | articulo | numeroTarjetaDebito | nombreEnLaTarjeta | fechaCaducidad | cvv | clave incorrecta                            | "La clave de la tarjeta debito ingresada es incorrecta"                     |
      | haedset    | articulo | numeroTarjetaDebito | nombreEnLaTarjeta | fechaCaducidad | cvv | clave incorrecta                            | "La clave de la tarjeta debito ingresada es incorrecta"                     |
      | haedset    | articulo | numeroTarjetaDebito | nombreEnLaTarjeta | fechaCaducidad | cvv | franquicia no valida                        | "La franquicia de su tarjeta no es admitida por el comercio"                |
      | haedset    | articulo | numeroTarjetaDebito | nombreEnLaTarjeta | fechaCaducidad | cvv | tarjeta bloqueada                           | "La tarjeta seleccionada se encuentra en estado: bloqueada"                 |
      | haedset    | articulo | numeroTarjetaDebito | nombreEnLaTarjeta | fechaCaducidad | cvv | tarjeta vencida                             | "La tarjeta seleccionada se encuentra en estado: caducada"                  |
      | haedset    | articulo | numeroTarjetaDebito | nombreEnLaTarjeta | fechaCaducidad | cvv | sin saldo suficiente                        | "La tarjeta seleccionada no tiene saldo suficiente para realizar la compra" |

    #Cupon
  @prioritario
  Scenario: Usuario con cuenta Amazon configuarada compra articulo con el medio de pago predeterminado y cupon de descuento con resultado Exitoso
    Given el se encuentra logueado en la pagina principal de Amazon
    When el realiza la busqueda del articulo <"articulo">
    And el agregar el articulo al carrito de compras
    And el aplica el cupon de descuento <"cupon"> a su compra actual
    Then el deberia poder que el fue aplicado con exito
  @prioritario
  Scenario Outline: Usuario con cuenta Amazon configuarada compra articulo con el medio de pago predeterminado y cupon de descuento "<escenario>">
    Given el se encuentra logueado en la pagina principal de Amazon
    When el realiza la busqueda del articulo <"articulo">
    And el agregar el articulo al carrito de compras
    And el aplica el cupon de descuento <"cupon"> a su compra actual
    Then el deberia ver el mensaje de error "<mensaje>"
    Examples:
      | "articulo" | "cupon" | mensaje                                                                              | escenario                                            |
      | "articulo" | "cupon" | "El cupon ingresado ha caducado"                                                     | vencido                                              |
      | "articulo" | "cupon" | "El cupon no es aplicable para el articulo seleccionado"                             | No aplicable para el articulo                        |
      | "articulo" | "cupon" | "Los articulos seleccionados no supueran las  condiciones de compra para este bono " | Cupon valido y el valor de la compra es insuficiente |

    #carrito de compra
  Scenario: modificar pedido de compra: duplicar pedido

    Given el se encuentra logueado en la pagina principal de Amazon
    When el realiza la busqueda del articulo <"articulo">
    And el agregar el articulo al carrito de compras
    And incrementa en 2 la cantidad del articulo en el carrito de compras
    Then el deberia poder ver que el precio de la orden se duplico

  Scenario: modificar pedido de compra: eliminar el pedido

    Given el se encuentra logueado en la pagina principal de Amazon
    When el realiza la busqueda del articulo <"articulo">
    And el agregar el articulo al carrito de compras
    And elimina el pedido actual
    Then el deberia poder ver que la orden se elimino correctamente




