Feature: The reading tips can be listed.

    Scenario: an empty list gives a "No tips" -notification
        Given command "list" is selected
        When option "all" is given
        Then "No tips" message is shown

    Scenario: list command lists tip if a tip is added
        Given tip with header "Hello Ruby" and description "intro to coding" is added
        When command "list" is selected
        And option "all" is given
        Then tip with id, header "Hello Ruby" and description "intro to coding" is listed