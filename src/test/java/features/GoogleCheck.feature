Feature: We Verify if wikipedia knows about our coin

  Scenario: Check if Wikipedia knows about our code
    Given Set our favourite coin to Monero
    When Open "https://google.fr"
    And Make a google search "Monero"
    Then Verify There is a wikipedia link
