@loginTests
Feature: To validate all test cases retated to login page
Background:
    Given To launch chrome browser
    And To enter the site URL
    
@validData
Scenario: To validate dashboard page once user will entered valid credentials
    Given To enter email "queuecodes@gmail.com"
    And To enter password "123456"
    When click on submit button
    Then To validate dashboard page title "Queue Codes | Dashboard"
    And To click on Logout button
    
    @invalidData
    Scenario Outline:To validate login page title once user enter Invalid login data 
    Given To enter email "<userName>"
    And To enter password "<userPassword>"
    When click on submit button
    Then To validate Login page title "Queue Codes | Log in"
    Examples:
             | testName          |userName            | userPassword |
             |both are empty     |                    |              |
             |userName is empty  |                    |123456        |
             |userPass is empty  |queuecodes@gmail.com|              |
             |userName is invalid|  queue@gamil.com   |  123456      |
             |userPass is invalid|queuecodes@gmail.com|12345         |
             |both are invalid   |queue@gmail.com     |12345         |
               