Feature: The reading tips can be listed.

    Scenario: an empty list gives a "No tips" -notification
        Given command "list" is selected
        Then "No tips" message is shown

    Scenario: list command lists tip if a tip is added
        Given tip with header "Hello Ruby" and description "intro to coding" is added
        And command "list" is selected
        Then tip with id, header "Hello Ruby" and description "intro to coding" is listed