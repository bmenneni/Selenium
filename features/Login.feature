#Each feature contains one feature
Feature: Test the login functionality on the-internet.herokuapp.con

#A feature may have given different specific scenarios
#Scenarios use Given-When-Then structure
Scenario: The user should be able to login with correct username and password.
Given user is on the login page
When user enters correct username and correct password
Then user gets confirmation