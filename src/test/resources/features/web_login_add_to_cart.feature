@web
Feature: Sauce Demo Web - Login and add to cart

  @web
  Scenario: Login and add product to cart (web)
    Given I am on the Sauce Demo login page
    When I login with valid credentials
    And I add any product to the cart
    Then cart icon shows 1 item
