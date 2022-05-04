Feature: Login into the application using the username and password
@LoginPage
Scenario Outline: Search Experience for product search in both home and offers page

Given User is on OrangeHRM Landing page
When User input the <Username> and <Password> into the corresponding fields
Then User select the login button
And Validate the OrangeHRM Home page title

Examples:
| Username  | Password |
| Admin     | admin123 |