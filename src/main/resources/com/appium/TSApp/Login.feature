Feature: Logging into App

In order to work 
As an user
I want to login

@login
Scenario Outline: Logging in automateme app
Given I go to "App" on "Platform"
And I enter "UserEmail" as "<UserEmail>"
And I enter "Password" as "<Password>"
And I click on "SignInButton"
Then Login is "<LoginExpected>" on appearance of "<Element>"

Examples:
| UserEmail                | Password   | Element    | LoginExpected |
| automateme@tscodelab.com | tigerspike | AppToolbar | Success       |
| 123@ts.com               |            | AppToolbar | Success       |
|                          |            | AppToolbar | Failure       |
| tigerspike               | tigerspike | AppToolbar | Failure       |
 