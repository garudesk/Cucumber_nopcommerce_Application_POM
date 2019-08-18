$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:/D:/Eclips%20instalation%20setup/Cucumber_nopcommerce_Application_POM/Feature/All_Feature.feature");
formatter.feature({
  "name": "Login",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Validation of Login Page Items",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Test1"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User opens URL",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefination.user_opens_URL()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Validate the title of page",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefination.validate_the_title_of_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User enters login details",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefination.user_enters_login_details()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User clicks on submit btn",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefination.user_clicks_on_submit_btn()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Validate the login details",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefination.validate_the_login_details()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User on the Home page and validate the title of the page",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefination.user_on_the_Home_page_and_validate_the_title_of_the_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User logout from page",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefination.user_logout_from_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Close browser",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefination.close_browser()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});