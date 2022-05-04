Feature: Search and Place the order of Productos
@PlaceOrder
Scenario Outline: Search Experience for product search in both home and offers page

Given User is on GreenCart Landing page
When User searched with shortname <Name> and extracted actual name of the product
And Added "3" item of the selected product to cart
Then User proceeds to Checkout and validate the <Name> items in checkout page
And Verify user has ability to enter promo code and place the order

Examples:
| Name |
| Tom  |