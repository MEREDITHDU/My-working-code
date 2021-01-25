@Test @Main
Feature: To test the login step
Scenario: Login tests successfully passed with given email and password

Given I click login link text at home page
When I should be navigated to login page
When I input my login credentials with Email: "duheimei@gmail.com" ,Password: "Test@123"
Then I see response of successful login
 