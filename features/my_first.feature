Feature: Home

  Scenario: Home page
    Given I am on the Home screen
    When I touch Fullscreen
    Then I see "Welcome to coolest app ever"
