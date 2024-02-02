
@tag
Feature: Error validation



  @ErrorValidations
  Scenario Outline: Error message while providing incorrect credentials
    Given I landed on Ecommerce page
    And Logged in with username <name> and password <password>
    Then "Incorrect email or password." message is displayed

    Examples: 
      | name  										|    password 	 |			
      | pratishtha@mailinator.com |  	Welcome@1234 |      