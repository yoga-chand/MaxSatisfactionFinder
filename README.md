# Problem Statement:
Gordon is at a restaurant and he has many different types of food to choose from. Gordon gets x amount of satisfaction and requires y amount of time to eat an item from the menu. Given t minutes, write a java program that reads the text file and ﬁnds out the maximum satisfaction that Gordon can get from eating at the restaurant.

# Assumptions Made:
This solution is developed taking into consideration that time t can be in minutes and t can b in seconds.

# Approach Taken:
  Based on the knapsack algorithm, this program is developed which follows greedy approach. The input data is stored in the form of menu items.To calculate the maximum satisfaction value in a given time, we have a loop for T(time taken to eat an item) within a loop of N(total number of items) which gives the complexity of O(NT).

# Input

Below are the inputs considered to solve this problem 
1. Total time taken
2. Total number of items
3. Satisfaction value of each item
4. Time taken to eat an item

# Output: 
Maximum Satisfaction value for the given time

# Steps to run the project.

1. Clone or download maven project into STS.
2. After importing successfully, right click on project and run as-> Maven Install. 
3. Once build is successful, run the Application.java as Spring Boot application

Output can be seen on the console.

To Run the test cases:
1) Open the Command Prompt on the Project Working Directory and run the Maven Command : mvn clean test 
2) To Run Individual Test methods, go to the method with the annotation @Test in any class which ends with *.Tests and right click on the method and choose the option Run As Junit Test. Test result for that method will be displayed in the Junit console.
