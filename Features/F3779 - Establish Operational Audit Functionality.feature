@tag
Feature: F3779 - Establish Operational Audit Functionality

  @Regression
  Scenario Outline: US10491 - Admin Screen - Validating records on Grid (TC7460)
    Given User logs with "<User ID>" as CPT ICD RA into JBPM Application
 	  When RA clicks on CPT ICD Link in My Tasks
    And RA clicks on "Group" Task Tab
    And RA claims "<LCD_OR_ARTICLE>" code from group Tasks
    When RA clicks on "Individual" Task Tab
    When RA clicks on claimed "<LCD_OR_ARTICLE>"    
    Then RA Review Work Queue screen should be displayed
    And Review status should be dispalyed as "Not Started"
    When RA clicks on "Start Review"
    Then Review status should be dispalyed as "Started"
    When RA clicks on "<Support_OR_Doesnot_Support>" Task Tab
    When RA enters the remarks as "Functional Test,Automation test" for the rejected codes
    Then RA should be able to view the filter codes based on "Remarks"
    And RA should be able to view the filter codes based on "Display Blanks"
    And Remarks column should be sorted
    Then Logout of the Application
      
      
   Examples: 
      | User ID         | Support_OR_Doesnot_Support   |LCD_OR_ARTICLE|
      | iht_ittest05 		| Support                      |  LCD         | 
      | iht_ittest05    | Does                         |  LCD         |
      
 