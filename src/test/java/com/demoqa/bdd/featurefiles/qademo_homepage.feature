Feature: Navigation To Book Store Application HomePage
  I want to go to the Book Store App Home Page                                      

  @smoke
  Scenario: Book Store Application Home Page
    Given I am on the demoqa homepage
    When I click on the Book Store App Card
    Then I am taken to the Book Store App Home Page
    And The Login button is displayed
#  @tag2
#  Scenario Outline: Title of your scenario outline
#    Given I want to write a step with <name>
#    When I check for the <value> in step
#    Then I verify the <status> in step

#    Examples: 
#      | name  | value | status  |
#      | name1 |     5 | success |
#      | name2 |     7 | Fail    |
