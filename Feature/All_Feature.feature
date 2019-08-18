Feature: Login
@Test1
Scenario: Validation of Login Page Items

  Given User opens URL
  Then Validate the title of page
  When User enters login details
  Then User clicks on submit btn
  Then Validate the login details
  Then User on the Home page and validate the title of the page
  Then User logout from page
  Then Close browser
  
@Test2
Scenario: Successfull Addition of  the new Customer

   Given User on the Home page
   When  User click on Customer link
   Then User click on Add new btn
   Then User enters details of Customer and save the details
|Email             |Password|Firstname|Lastname|Dateofbirth|Companyname|Admincomment	|
|g24220@gmail.com |802044  |suffha   |gargf    |07/07/2018|TVSS      |Hellow        |

   Then Validate the new customer is successfully added or not?
   Then close the browser
   
@Test3   
Scenario: Validate the search of perticular customer with Email address
   
   Given User on the Home page   
   When User clicks on customer link
   Then User enters email to search
   Then User click on search btn
   Then Validate the search result
   