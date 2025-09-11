Feature: This feature file verifies the login functionality.

@login
Scenario: Verifies login functionality with valid data.
	Given user navigates to site URL
	When user clicks on login link
	Then verify login page title "Demo Web Shop. Login"
	When user enters the email address "rktesting123@gmail.com"
	And user enters password "rktesting123"
	When user clicks on login button
	Then verify the logout link is visible