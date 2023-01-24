Feature: select patients
User should be able to access select patient drop down

Background:
Given User has opened the Application URL
And user logins by entering Number and OTP
And clicks on Appointments link

@ALL
Scenario: click on  a patient with no bookings
When clicks on patient with no bookings
And clicks on book an appointment button
Then User should be able to navigate to Consultations Page

@ALL
Scenario: Select a doctor and booking a doctor
When clicks on patient with no bookings
And clicks on book an appointment button
And search for a doctor and select the doctor
And complete the booking process
Then user should see the booked appointment

@ALL @book
Scenario:cancel a booking
When clicks on patient with bookings
And clicks on book an view details
And complete the cancellation process
Then user should be able to see that booking is cancelled

@Fail @ALL @book
Scenario: select a patient with bookings
When clicks on patient with bookings 
Then User should be able to see book an appointment button

@Fail @ALL
Scenario: Adding new patient
When clicks on add patient
And enters all the fields 
Then user should be able to see the new patient

@ALL
Scenario Outline: give different search data to search
When clicks on patient with no bookings
And clicks on book an appointment button
And User enters search data  as <data> into search field
Then user should see search results
Examples:
| data      |
| dentist   |
| Hyderabad |
| neha      |
