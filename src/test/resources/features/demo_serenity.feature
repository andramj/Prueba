Feature: Manage customer in the page of demo serenity.

  Scenario: The user wants register a new customer
    Given user credentials are in the page
    When The user wants register a new customer applying changes before save
    Then he should see the create customer data on table

  Scenario: The user wants update info a customer
    Given user credentials are in the page
    When The user wants update a customer applying changes before save
    Then he should see the contact name customer data on table

