@mobile
Feature: Sauce Labs Sample Mobile App - Login and add to cart

  @mobile
  Scenario: Login and add product to cart (mobile)
    Given I launch the sample mobile app
    When I login with valid credentials on mobile
    And I add any product to the cart on mobile
    Then cart icon shows 1 item on mobile
