@ProfilePic
Feature: ProfilePic module API automation

  Scenario: Verify change profilePic to application through API
    Given User add headers,bearer authorization and multiPart for accessing upload profile picture
    When User add multipart for upload profile pic
    When User send "POST" request to change ProfilePic endpoints
    Then User verify status code is 200
    And User verify change profile pic response message matches "Profile updated Successfully"