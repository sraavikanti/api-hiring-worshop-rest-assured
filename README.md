API WorkShop:

Please run mvn test command to verify the code works fine

Write Basic Automation tests for the given endpoints

* GET - List of Users - https://reqres.in/api/users?page=2 
  -> Assert the status of the response
  -> Assert that pageid in path parameter and page value in response body to be 
  -> Assert the size of the data json array to be equal to per_page value in response body
  -> Print the status and error message if invalid input is passed - Negative numbers, float numbers and invalid characters and invalid data
  
  
* POST - Create a User - https://reqres.in/api/users
  
  -> Test script for creating an user and validate if the name and job details passed in body are the same returned on response side
request body for post :
{
"name": "morpheus",
"job": "leader"
}

* GET  List of Users - https://reqres.in/api/users?page=2
    -> Hit this api "n" number of times and extract the response time for all the hit and display the least response time taken value and hit count

 
