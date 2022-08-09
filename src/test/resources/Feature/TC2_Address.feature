@Address
Feature: Address module API automation

  Scenario Outline: Verify add new address to application through API
    Given User add headers and bearer authorization for accessing address endpoints
    When User add request body for add new address "<first_name>","<last_name>","<mobile>","<apartment>","<state>","<city>","<country>","<zipcode>","<address>","<address_type>"
    When User send "POST" request for add new address endpoint
    Then User verify status code is 200
    And User verify create address response message matches "Address added successfully"

    Examples: 
      | first_name | last_name | mobile     | apartment      | state | city | country | zipcode | address | address_type |
      | Suresh     | Kumar     | 9876543210 | Bharathi Nagar |    31 |   12 |      33 |  626118 | Chennai | home         |

  Scenario Outline: Verify update old address to application through API
    Given User add headers and bearer authorization for accessing address endpoints
    When User add request body for update existing address "<first_name>","<last_name>","<mobile>","<apartment>","<state>","<city>","<country>","<zipcode>","<address>","<address_type>"
    When User send "PUT" request for update existing address endpoint
    Then User verify status code is 200
    And User verify update address response message matches "Address updated successfully"

    Examples: 
      | first_name | last_name | mobile     | apartment      | state | city | country | zipcode | address | address_type |
      | Vinith     | Kumar     | 9876543210 | Bharathi Nagar |    31 |   12 |      33 |  626118 | Chennai | home         |

  Scenario: Verify get address to application through API
    Given User add headers and bearer authorization for accessing address endpoints
    When User send "GET" request for get existing address endpoint
    Then User verify status code is 200
    And User verify get address response ststus matches "OK"

  Scenario: Verify delete address to application through API
    Given User add headers and bearer authorization for accessing address endpoints
    When User add request body for delete address
    When User send "DELETE" request for delete existing address endpoint
    Then User verify status code is 200
    And User verify delete address response message matches "Address deleted successfully"
