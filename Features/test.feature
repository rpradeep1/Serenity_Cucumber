@Test
Feature: Practise test for JBPM Application

@Test1
Scenario Outline:  Objective of this scenario is to validate the My Tasks Page
Given User Logs with "<User ID>" into JBPM Application
When clicks reference data link under Mytasks section
Then My Tasks Page should be displayed

Examples: 

| User ID      |
| iht_ittest01 |