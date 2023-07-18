Feature: End to End testing of OrangeHRM Admin

Scenario Outline: Login Successful

Given I am on the OrangeHRM website
And I log in with valid username  "<Username>" and password "<Password>"
When I successfully navigate to the homepage
And I click on the Admin button
And I validate the system user with valid employee name "<Employee Name>"
Then I should successfully retrieve the record for the given username

    Examples: 
      |Username | Password | Employee Name |
      | Admin   | admin123 | Alice.Duval   |
      