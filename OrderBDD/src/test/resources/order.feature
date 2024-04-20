Feature:Placing order on SportsStore
  Scenario: User places an order
    Given User is on sportsstore homepage
    When User clicks on category
    And User adds product to the cart
    And User proceeds to checkout
    And User fills order information
    Then User should see order confirmation message
    Then Return To Store