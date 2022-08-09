@Login
Feature: Login module API automation

  Scenario: Get user logtoken from login endpoint
    Given User add header
    And User add basic authentication for login
    When User send "POST" request for login endpoint
    Then User verify status code is 200
    And User verify login response body firstName present as "suresh" and get logtoken
