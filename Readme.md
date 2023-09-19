"SATestProjectTechChallengeForKartik is the simple Maven Test project created with the Selenium with Java.

This is created to perform the testing of three test scenarios after opening the URL  "https://www.tendable.com" as below
1. Confirm accessibility of the top-level menus: Home, Our Story, Our Solution, and Why 
Tendable.
2. Verify that the "Request a Demo" button is present and active on each of the 
aforementioned top-level menu pages.
3. Navigate to the "Contact Us" section, choose "Marketing", and complete the form—
excluding the "Message" field. On submission, an error should arise. Ensure your script 
confirms the error message's appearance. If the error is displayed, mark the test as PASS. If 
absent, it's a FAIL.


Now Below are the important actions need to be taken while running this Test Project:

1. This is created using simple Maven project so all the dependencies need to downloaded before going for test execution. 
For doing the same kindly clean and build pom.xml file located at "SATestProjectTechChallengeForKartik\pom.xml" so it will auto download
all the dependencies required for this project to run.
2. Test File is located at the location "SATestProjectTechChallengeForKartik\src\test\java\com\tendable\test\TestClass.java" before running it
make sure you are using Chrome Browser for your execution. if want use another browser then you just need to change line number 16 and 17 accordingly.
The project has utilized WebdriverManager so to use another browser apart from Chrome you can update the code accordingly given here https://bonigarcia.dev/webdrivermanager/
3. Now you can run your project by simply running the TestClass.java file.


The strategy employed for this challenge is as below:

1. Created the project using Maven so library dependencies can be auto-downloaded.
2. For webdriver management also taken care using webdriverManager libraries.
3. Made use of testNG to work the test execution depending on test annotations and utilize the properties of testNG.
4. Created only one single class where start to end testing is getting performed.
5. To check the accessibility of the element in first scenario - made use of isDisplayed methods of selenium.
6. To check presenst and active element in second scenario - made use of isDisplayed and isEnable methods of selenium.
6. To verify error message for the third scenario - made use of getText method of selenium and by using assertEquals from testNG checked the if 
error text is present or not.