Feature: Person Details feature

Background:
Given user is on calculators and tools page

Scenario: Person with the following details
When user choose the Application type details as "Single"
And user enters Number of dependants 0
And user choose property to buy as "Home to Live in"
And user enters income before tax as 80000
And user enters income after tax as 10000
And user enters living expense of 500
And user enters current home loan payement 0
And user enters other loan repayment of 100
And user enters other commitments of 0
And user enters total credit card limits of 10000
Then user click on how much i could borrow button
And user should get the result "$507,000"


Scenario: check start over button
When user choose the Application type details as "Single"
And user enters Number of dependants 0
And user choose property to buy as "Home to Live in"
And user enters income before tax as 80000
And user enters income after tax as 10000
And user enters living expense of 500
And user enters current home loan payement 0
And user enters other loan repayment of 100
And user enters other commitments of 0
And user enters total credit card limits of 10000
Then user click on how much i could borrow button
And user should get the result "$507,000"
When user click on start over button after filling the form
Then the field should be clear and show Empty ""


Scenario: check Living Expense value
When user enters living expense of 1
Then user click on how much i could borrow button
And user should see this Error "Based on the details you've entered, we're unable to give you an estimate of your borrowing power with this calculator. For questions, call us on"
