Feature: Home page
User should be able to navigate to appointment page or consultations page

@ALL
Scenario: navigate to Consultations page without login
Given User has opened the Application
When clicks on Consult Online link 
Then User should be able to navigate to Consultationspage

@ALL
Scenario: navigate to appointments page with login
Given User has opened the Application
And user logins by entering Number
When clicks on Appointments button
Then User should be able to navigate to Appointmentspage

