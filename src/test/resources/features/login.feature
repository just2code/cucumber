Feature: User Login

@ui
Scenario Outline: Login attempt with invalid credentials
Given the user is on the login page
When the user logs in with username "<username>" and password "<password>"
Then an error message should be displayed
Examples:
|username|password|
|jagadish|papamanger|
|hoover|bridge|