@web
Feature: Web UI Test
  @web-1
  Scenario: User choose the item and purchase it without login first
    Given user is on home page
    And user choose the item
    And user check the item
    When user click checkout button
    Then user input the every information that needed
    And user get the notify massage "Thank you for your purchase!"

  @web-2
  Scenario: Login Using registration username and password then logout
    Given user is on home page
    And user input username with "UserTest123"
    And user input password with "123"
    When user click login button
    Then user is on homepage with information "Welcome UserTest123"
    And User try to logout

  @web-3
  Scenario: User choose several item and delete it from checkout item
    Given user is on home page
    And user choose several item
    And user check the item
    When user click delete button for several item
    Then the item from the checkout empty
    And user continue shopping in home page