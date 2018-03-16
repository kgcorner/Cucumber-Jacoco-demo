Feature:Book Resource Features
  Scenario:Should return list of books
    Given Book Library is initialized
    When '10' Books are requested
    Then List of '10' books should be returned with status '200'