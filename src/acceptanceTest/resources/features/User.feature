Feature: Check the User operations using records

  Scenario Outline: Create user records
    Given User pass <firstName> <lastName> <address1> <city> data
    When User calls POST method
    Then user gets response status <status>
	Examples:
    |	id	| firstName | lastName 	| address1 					| city 					| status	|
    |	1		| "Ravi"		| "patil"		| "Silver Gardenia"	|	"Pune"				|	200			|
    |	2		| "Rajeev"	| "patel"		| "Silver Gardenia"	|	"Vijayapura"	|	200			|
    
  Scenario Outline: Retrieve user records
    Given User pass data
    When User calls GET method
    Then user gets response status <status>
	Examples:
    |	id	| firstName | lastName 	| address1 					| city 					| status	|
    |	1		| "Ravi"		| "patil"		| "Silver Gardenia"	|	"Pune"				|	200			|
    
    
  Scenario Outline: Retrieve user records
    Given User pass <id> data
    When User calls GET with <id>
    Then user gets response status <status>
	Examples:
    |	id	| firstName | lastName 	| address1 					| city 					| status	|
    |	1		| "Ravi"		| "patil"		| "Silver Gardenia"	|	"Pune"				|	200			|
    
  Scenario Outline: Retrieve invalid user records
    Given User pass <id> invalid data
    When User calls GET with <id> invalid record
    Then user gets invalid response status <status>
	Examples:
    |	id		| firstName | lastName 	| address1 					| city 					| status	|
    |	999		| "Ravi"		| "patil"		| "Silver Gardenia"	|	"Pune"				|	400			|