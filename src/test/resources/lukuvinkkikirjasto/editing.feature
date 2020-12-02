Feature: Reading tips can be edited.

    Scenario: Header can be modified
        Given tip with header "Hello Ruby" and description "intro to coding" is added
        And command "edit header" is selected
        When id 1 and new header "Hello again Ruby" are given
        Then tip with id 1 has new header "Hello again Ruby"