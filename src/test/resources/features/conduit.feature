Feature: Conduit CRUD Functions

  Scenario: Login into App
    Given User is on Login page to conduit
    When User provide "Vasanthchinnu12@gmail.com" and "Vasanth@1203"
    Then User should be on Home Page

  Scenario: Create new Article
    Given User click on New Article Page button
    * User should be on New Article Page
    When User enters Article details
      | Vasanth_1203 | My name is vasanth | Am from TCS | HelloWorld|
    Then Article must be created
    
     Scenario: Create new Article
    Given User click on New Article Page button
    * User should be on New Article Page
    When User enters Article details
      | Vasanth_1203 | My name is vasanth | Am from TCS | HelloWorld|
    Then Article must be created

  Scenario: View Article
    Given User should be on Global Feed page
    When User select an article "vasanth"
    Then Article detail page must be displayed

  Scenario: Update an Article
    Given Article detail page must be displayed
    When User update article detail
     | Vasanth_120399 | this name is vasanth | vasanth is from TCS | HelloWorld|
    Then Article detail page must be displayed
    

  Scenario: Delete an Article
    Given Article detail page must be displayed
    When User delete article
    Then Article must be deleted
