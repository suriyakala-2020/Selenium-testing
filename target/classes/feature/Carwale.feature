Feature: Car with Least km
Scenario: Find details of car with least km

Given User open the chrome browser
And User maximise the browser
And User set the default implicit timeout
And User load the URL
And User click on Used Cars
And User select the City as Chennai
And User select budget min as 8
And User select budget max as 12
And User click on search
And User click on search cars with photos
And User select manufacture as Hyundai Creta
And User select fuel type as petrol
And User select best match as KM: Low to High
And User validate the cars are listed with KMs Low to High
And User add the least KM ran car to wishlist
And User click on wishlist
And User click on more details
When User print all the details under Overview
Then User close the browser




