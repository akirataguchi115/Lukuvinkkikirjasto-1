Feature: The reading tips can be listed.

    Scenario: an empty list gives a "No tips" -notification
        Given command "list" is selected
        Then "No tips" message is shown
