
@tag
Feature: Amazon shopping
  I want to login, search for a product, add it to my cart and checkout so that I can purchase

  @tag1
  Scenario: Purchase an item on amazon website 
    Given I am on the amazon website
    When I enter the email Id as "kiruthigadaran@gmail.com"
    And I enter the "Continue" button
    And I should enter the password "Hello@1234"
    And I  click the "Sign in" button
    Then I should see the amazon homepage
    And I select the category "Electronics"
    And I should search for "iphone 14 pro max"
    And I click the search button
    Then  I see the results for "iphone 14 pro max"
    When I add the first item to cart
    Then I should see added to cart
    
 