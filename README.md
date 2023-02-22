# Selenium-Run-MavenCommand
Introduction:
In this tutorial, we will learn how to run Selenium scripts using Maven commands. Maven is a powerful build automation tool that can manage your project dependencies, run your tests, and generate reports.

Prerequisites:

Java JDK installed on your system.
Maven installed on your system.
Selenium WebDriver and TestNG dependencies added to your Maven project.
Steps to run Selenium scripts using Maven commands:

Step 1: Open a command prompt and navigate to your project directory.

Step 2: Compile your project:

mvn compile
Step 3: Run your tests using the following command:

mvn test
This command will run all the test cases present in your project.

Step 4: If you want to run a test case, you can use the following command:

mvn test

Step 5: If you want to generate a report after running your tests, you can use the following command:

Copy code
mvn surefire-report:report
This command will generate a report in the target/site directory of your project.

Step 6: If you want to run your tests on a specific browser, you can use the following command:

mvn -Dbrowser=BrowserName test
Replace BrowserName with the name of the browser you want to run your tests on.

Step 7: If you want to run your tests on a specific environment, you can use the following command:

mvn -Denvironment=EnvironmentName test

Step 8: If you want to run your tests in parallel, you can use the following command:

mvn -Dtest=TestClassName -DthreadCount=3 test
Replace TestClassName with the name of your test class and threadCount with the number of threads you want to use.

Conclusion:
Maven provides a convenient way to manage your project dependencies, run your tests, and generate reports. With the help of Maven, you can easily automate your testing process and save a lot of time and effort.
