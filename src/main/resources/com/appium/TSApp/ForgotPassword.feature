Feature: Forgot password

In order to retrieve password
As an user
I want to use forgot password functionality



Scenario: Using forgot password link
Given I go to "App" on "Platform"
And I have forgotten password
And I tap on "ForgottenPassword"
Then I see elements
| ForgottenPasswordQ1 |
| ForgottenPasswordQ2 |