Feature: Search and place the order for products

Scenario Outline: Search experience for product search in both home and offers page

Given user is on greenkart landing page
When user searched with shortname <Name> and extracted actual name of the product
Then user searched for <Name> shortname in offers page
And validate product name in offers page matches with landing page

Examples:
|Name|
|tom|
|beet|