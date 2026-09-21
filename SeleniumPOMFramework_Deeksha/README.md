# Selenium Java POM Framework

This project contains a basic Selenium + Java + TestNG Page Object Model framework.

## Covered scenarios
1. Launch application
2. Login with valid credentials
3. Login with invalid credentials
4. Search for product
5. Verify search results
6. Open product
7. Add product to cart
8. Update quantity
9. Remove product
10. Checkout
11. Verify order
12. Logout

## Before running
Update:
- src/test/resources/config.properties
- Application URL
- Valid/invalid credentials
- Selenium locators in the page classes

## Run
Use Maven:
mvn test

The locators are generic examples and must be replaced with the actual application's locators.
