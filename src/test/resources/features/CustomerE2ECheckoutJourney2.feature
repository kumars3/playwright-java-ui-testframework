Feature: CustomerE2ECheckoutJourney2
  In order buy a product at Automation Test Store
  As a customer I want to complete my checkout journey
  So that my order is fulfilled and it is listed in my order details

  Background:
    Given I am on home page

  @chrome
  Scenario Outline: Login as as an existing customer
    When I navigate to account login page
    And I log into my account
    Then login is successful and I am navigated to my account page
    #And I add sale product into basket
    #And I navigate to home page
    #And I add "<ProductBrand>" product into the basket
    #When I search a product "<ProductCategory>" from product category menu
    #And I add a product into basket from the search list
    #And I checkout from my basket
    #And I confirm my order
    #Then My order is created successfully
    #When I navigate to my order history page
    #Then My order is listed in order history page
    #When I navigate to my order details page
    #Then The order is displayed in my order detail page

    Examples:
      | EmailId                |
      | santosh_uk96@yahoo.com |

  @chrome
  Scenario Outline: Empty basket as an existing customer
    When I navigate to account login page
    And I log into my account
   #Then login is successful and I am navigated to my account page
    And I add sale product into basket
    #And I navigate to home page
    #And I add "<ProductBrand>" product into the basket
    #When I search a product "<ProductCategory>" from product category menu
    #And I add a product into basket from the search list
    And I empty my basket
    Then basket is emptied successfully
    #And I confirm my order
    #Then My order is created successfully
    #When I navigate to my order history page
    #Then My order is listed in order history page
    #When I navigate to my order details page
    #Then The order is displayed in my order detail page

    Examples:
      | EmailId                | ProductBrand | ProductCategory |
      | santosh_uk96@yahoo.com | Dove         | Fragrance-5     |

  @chrome
  Scenario Outline: Complete checkout journey as an existing customer
    When I navigate to account login page
    And I log into my account
    #And I select GBP currency option
    #Then login is successful and I am navigated to my account page
    And I add sale product into basket
    And I checkout from my basket
    And I confirm my order
    Then My order is created successfully
    #When I navigate to my order history page
    #Then My order is listed in order history page
    #When I navigate to my order details page
    #Then The order is displayed in my order detail page

    Examples:
      | EmailId                | ProductBrand | ProductCategory |
      | santosh_uk96@yahoo.com | Dove         | Fragrance-5     |