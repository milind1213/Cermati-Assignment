
Feature: Verify Product Search Functionality with Multiple Options

  Scenario Outline: Accessing Cell Phones & Accessories with Applied Filters
    Given the user landed on the eBay homepage
    When the user navigates to Electronics under Shop by category
    And the user selects "Cell phones & accessories" from the available options
    And clicks on "Cell Phones & Smartphones" in the left-hand navigation section
    And clicks and opens the All Filters menu
    And clicks on Condition filter option and selects "<phoneConditionType>"
    And clicks on Price filter and enters items "<fromPrice>" and "<toPrice>"
    And clicks on Item Location filter and selects "<location>" and clicks on Apply button
    Then verifies the applied filter tags  "Condition","Price" and "Item Location"

    Examples: 
      | phoneConditionType | fromPrice | toPrice | location  |
      | New                |       300 |     600 | Worldwide |

   Scenario: Searching for a Product and Verifying the First Result
    Given the user landed on the eBay homepage
    When the user enters "<items>" in the search bar
    And changes the search category to "category" and clicks Search
    Then verifies that the page loads completely
    And verifies that the name of the first result contains "Macbook"

    Examples:
      | items  | category                  |
      | iPhone | Cell Phones & Accessories |
    
   
   
   
   
   
   