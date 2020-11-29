Feature: A reading tip can be added.

    Scenario: Adding is successful with valid name and header.
        Given command "add" is selected
	When Header "Hello Ruby" and description "intro to coding" are given.
        Then The book "Hello Ruby" is added.

