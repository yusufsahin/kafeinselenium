Feature: Placing order on SportsStore

  Scenario Outline: User places an order
    Given User is on sportsstore homepage
    When User clicks on category
    And User adds product to the cart
    And User proceeds to checkout
    And User fills order information with name "<Name>", line1 "<Line1>", line2 "<Line2>", line3 "<Line3>", city "<City>", state "<State>", zip "<Zip>", and country "<Country>"
    Then User should see order confirmation message
    And Return To Store

    Examples:
      | Name     | Line1      | Line2      | Line3    | City     | State | Zip    | Country |
      | John Doe | ABC Bulv.  | 996677 Str.|  No 9    | Austin   | TX    | 456677 | USA     |
      | Jane Doe | DEF Street | 123456 Pl. |  No10    | Austin   | TX    | 234567 | USA     |
