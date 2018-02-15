Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: SimpleFormDemo
Given user is on a Simple Form test site
When I type TEST into form box and click the button
When I type 10 and 27 numbers and sum them up
Then I assert whether I am getting TEST message and sum of 37