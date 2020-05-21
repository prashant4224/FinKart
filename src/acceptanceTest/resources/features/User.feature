Feature: Check the User operations using records

  Scenario Outline: Retreive all user records
    Given User pass <firstName> <lastName> <address1> <city> data
    When User calls POST method
    Then user gets response status <status>
	Examples:
    |	id	| firstName | lastName 	| address1 					| city 					| status	|
    |	1		| "Ravi"		| "patil"		| "Silver Gardenia"	|	"Pune"				|	200			|
    |	2		| "Rajeev"	| "patel"		| "Silver Gardenia"	|	"Vijayapura"	|	200			|