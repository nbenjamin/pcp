Feature: Doctor resource endpoints
	
    @Fast
    Scenario: Get Doctor by id
    Given a doctor with ID 0 exist
    When the API is called for doctor ID "0"
    Then the API returns doctor date "2010-06-05 00:00:00"