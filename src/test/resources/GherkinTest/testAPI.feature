@api
Feature: API Test
  @api-1
  Scenario: User GET list from dummy API
    Given user have an API to access "https://dummyapi.io/data/v1/"
    And user choose page (2) and limit (20)
    When user send GET API respond
    Then respond code should be (200)
    And respond should be page (2) and limit (20)

  @api-2
  Scenario: User POST change information from dummy API
    Given user have an API to access "https://dummyapi.io/data/v1/"
    And user change the information
    When user send POST API respond
    Then respond code should be (200)
    And respond should be the information was change

  @api-3
  Scenario: User GET api using tag from dummy API
    Given user have an API to access "https://dummyapi.io/data/v1/tag/"
    And user input tag with "nature"
    And user input limit (15)
    When user send GET tag API respond
    Then respond code should be (200)