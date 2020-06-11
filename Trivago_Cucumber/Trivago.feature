Feature: Hotel Booking based on criteria

Background:
Given Open the Chrome Browser
And Maximise the webpage
And Set the default implicit wait

Scenario: [TC001]Booking Ticket based on maximum criteria match
Given Load the browser with Trivago URL
And Enter the destination as Agra, Uttar Pradesh
And Select the check in date as 2020-06-20
And Select the check out date as 2020-06-30
And Select the room as Family Room
And Select the number of Adults as 2 
And Select the number of Childrens as 1
And Select the Child's Age as 4
And Click the Confirm button
And Click the Search button
And Select the accommodation type as 4 stars hotel
And Select the Guest rating as Very Good
And Select the Hotel Location as Agra Fort
And Select the additional facilities as Air conditioning, Restaurant and WiFi
And Select the Sort the result as Rating & Recommended
And click view deal button
And Click reserve for the hotel that satisfied maximum criteria
When Click I'll Reserve
Then Booking details will be displayed
