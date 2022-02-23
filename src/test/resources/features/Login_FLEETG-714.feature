@FLEETG-731
Feature: Login Function

	Background:
		#@FLEETG-714
		Given user on the login page
		

	#{color:#ff0000}*User Story :* {color}
	#
	#As a user, I should be able to log in
	#
	# 
	#
	#{color:#57d9a3}*_Acceptance Criteria:_*{color}
	#
	#{*}1{*}-All users can log in with valid credentials (We have 3 types of users such as sales manager, store manager, truck driver).
	#     - Driver should land on the "Quick Launchpad" page after successful login
	#     - Sales Manager/ Store Manager should land on the "Dashboard" page after successful login
	@FLEETG-715 @FLEETG-713
	Scenario Outline: Verify all users can login with valid credentials
		When user login as "<userType>"
		Then user should land on "<expectedPage>" page
		
		    Examples:
		      | userType      | expectedPage    |
		      | driver        | Quick Launchpad |
		      | store manager | Dashboard       |
		      | sales manager | Dashboard       |	

	#{color:#ff0000}*User Story :* {color}
	#
	#As a user, I should be able to log in
	#
	# 
	#
	#{color:#57d9a3}*_Acceptance Criteria:_*{color}
	#
	#-"Invalid username or password." should be displayed for invalid (valid username-invalid password and invalid username-valid password) credentials
	@FLEETG-717 @FLEETG-713
	Scenario Outline: Verify user can not login with invalid credentials
		When user enter "<username>" and "<password>"
		    And user click login button
		    Then "Invalid username or password." message should be displayed
		    Examples:
		      | username | password    |
		      | user1    | password    |
		      | username | UserUser123 |
		      | username | password    |	

	#{color:#ff0000}*User Story :* {color}
	#
	#As a user, I should be able to log in
	#
	# 
	#
	#{color:#57d9a3}*_Acceptance Criteria:_*{color}
	#
	#{*}{*}- "Please fill out this field" message should be displayed if the password or username is empty
	@FLEETG-718 @FLEETG-713
	Scenario Outline: Verify user can not login without credentials
		When user enter "<username>" and "<password>"
		    And user click login button
		    Then "Please fill out this field" pop up should be displayed
		    Examples:
		      | username | password    |
		      | user1    |             |
		      |          | UserUser123 |
		      |          |             |	

	#{color:#ff0000}*User Story :* {color}
	#
	#As a user, I should be able to log in
	#
	# 
	#
	#{color:#57d9a3}*_Acceptance Criteria:_*{color}
	#
	#{*}{*}-User land on the ‘Forgot Password’ page after clicking on the "Forgot your password?" link
	@FLEETG-720 @FLEETG-713
	Scenario: Verify forgot password function is working
		Then user should see "Forgot your password?" link is displayed
		    When user click Forgot Password? link
		    Then user should navigate to "Forgot Password" page	

	#{color:#ff0000}*User Story :* {color}
	#
	#As a user, I should be able to log in
	#
	# 
	#
	#{color:#57d9a3}*_Acceptance Criteria:_*{color}
	#
	#{*}{*}-User can see "Remember Me" link exists and is clickable on the login page
	@FLEETG-721 @FLEETG-713
	Scenario: Verify Remember Me checkbox is working
		Then user should see Remember me checkbox is displayed
		    When user click Remember Me checkbox
		    Then checkbox should be selected	

	#{color:#ff0000}*User Story :* {color}
	#
	#As a user, I should be able to log in
	#
	# 
	#
	#{color:#57d9a3}*_Acceptance Criteria:_*{color}
	#
	#{*}{*}-User should see the password in bullet signs by default
	@FLEETG-722 @FLEETG-713
	Scenario Outline: Verify user see password as bullet sign
		When user enter "<username>" and "<password>"
		    Then user should see password as bullet sign
		    Examples:
		      | username | password    |
		      | user1    | UserUser123 |	

	#{color:#ff0000}*User Story :* {color}
	#
	#As a user, I should be able to log in
	#
	# 
	#
	#{color:#57d9a3}*_Acceptance Criteria:_*{color}
	#
	#{*}{*}- Verify if the ‘Enter’ key of the keyboard is working correctly on the login page.
	@FLEETG-723 @FLEETG-713
	Scenario Outline: Verify Enter key is working
		When user enter "<username>" and "<password>"
		    And user hit Enter key
		    Then user should land on "<expectedPage>" page
		
		    Examples:
		      | username        | password    | expectedPage    |
		      | user1           | UserUser123 | Quick Launchpad |
		      | storemanager85  | UserUser123 | Dashboard       |
		      | salesmanager101 | UserUser123 | Dashboard       |	

	#{color:#ff0000}*User Story :* {color}
	#
	#As a user, I should be able to log in
	#
	# 
	#
	#{color:#57d9a3}*_Acceptance Criteria:_*{color}
	#
	#*-* All users can see their own usernames in the profile menu, after successful login
	@FLEETG-730 @FLEETG-713
	Scenario Outline: Verify user see own username in the profile menu
		When  user enter "<username>" and "<password>"
		    And user hit Enter key
		    Then user should see "<username>" in the profile menu
		    Examples:
		      | username        | password    |
		      | user1           | UserUser123 |
		      | salesmanager101 | UserUser123 |
		      | storemanager85  | UserUser123 |