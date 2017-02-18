Feature: Logged in user test

In order to check logged in user
As an user
I want to verify displays correct logged in user



Scenario: Navigating menu items
Given I go to "App" on "Platform"
And I am logged in app
And I tap on "MenuButton"
Then I verify "LoggedInUser" is "EmailId"