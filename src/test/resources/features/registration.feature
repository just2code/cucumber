Feature: Register a new user
@ui
Scenario: Register a new user with valid details
Given the user is on the registration page
When the user submits the registration form with the following details:
|firstName|joyce|
|lastName|pereira|
|email|joyceP@gmail.com|
|mobile|3467878346298|
Then the registration should be successful