# InsureTestExecutionService
**Automation framework for testing Insure application**

### Built With:

 - Spring Boot
 - Selenium
 - Cucumber

### Prerequisites:
 - Java 17
 - Maven

### How to Run:
**Below are the command with different options:**
 - To just run - "mvn clean test" 
 - mvn clean test -"Dspring.profiles.active=grid" -"Ddataproviderthreadcount=2" -"Dautomation.browser=firefox"
   - spring.profiles.active will set specific spring profile while running example grid
   - dataproviderthreadcount will set the number of thread when running parallel
   - automation.browser can be used to change the browser and all configurations can be changes like this
