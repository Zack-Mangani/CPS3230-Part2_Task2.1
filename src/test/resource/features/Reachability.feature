Feature: Online Shopping Website Functionality
  Scenario Outline: Reachability of product categories (Check at least 5 categories)
    Given I am a user of the online shopping website
    When I visit the website
    And I click on the <category-name> category
    Then I should be taken to the <category-name> category
    And the category should show at least <num-products> products
    When I click on the first product in the results
    Then I should be taken to the details page for that product
    Examples:
        | category-name | num-products |
        |"Fragrances & Aftershaves" | 5 |
        |"Oral & Dental Care Products" | 5 |
        |"Vitamins & Lifestyle Supplements" | 5 |
        |"Make-Up Products" | 5 |
        |"Healthcare Products" | 5 |



