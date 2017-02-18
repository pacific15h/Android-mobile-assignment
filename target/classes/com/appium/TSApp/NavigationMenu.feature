Feature: Navigation Menu

In order to work with menu items
As an user
I want to open navigation menu



Scenario: Navigating menu items
Given I go to "App" on "Platform"
And I am logged in app
And I tap on "MenuButton"
Then Side "NavigationMenu" opens