Feature: Testing API
  Como usuario de Reqres
  Quiero tener endpoints
  Para poder interactuar con ellos y realizar una CRUD


  Scenario: Realizazr una CRUD en el API de Reqres
    Given el tiene acceso a la API: "https://reqres.in/api"
    When el crea un nuevo usuario con nombre "Elvis" y cargo "QA Automation"
#    And el verifica que el usuario fue creado
    And el consulta el usuario con el id "3"
    And el actualiza el cargo del usuario con id "2" con el nuevo cargo "QA Automation Sr."
    And el elimina el usuario con id "1"
    Then el deberia poder ver 204 en la respuesta del servicio







