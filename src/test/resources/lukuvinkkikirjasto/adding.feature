Feature: A reading tip can be added.

    Scenario: Adding is successful with valid name and header
        Given command "new" is selected
	Then message "Header: " is shown
        When header "Hello Ruby" and description "intro to coding" are given
        Then the book "Hello Ruby" is added.

