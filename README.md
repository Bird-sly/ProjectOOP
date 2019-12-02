# ProjectOOP
oop class project 
THis project is set up through weekly sprints throughout the class
I had to catch up learning java so most of the project will be sent in at the same time 

Issue 2 - AudioPlayer 
All of the items on this production line will have basic media controls. Create an interface called MultimediaControl that will define the following methods which don't need to return anything.
	• play()
	• stop()
	• previous()
	• next();
We require a concrete class that will allow us to capture the details of an audio player. Create a class called AudioPlayer that is a subclass of Product and implements the MultimediaControl interface.
The class will have 2 fields
	• String audioSpecification
	• String mediaType
Create a constructor that will take in 3 parameters – name, manufacturer, and audioSpecification.The constructor should call its parents constructor and also setup the media type.
Implement the methods from the MultimediaControl interface by simply writing the action to the console.
	E.g. in play System.out.println("Playing"); Normally we would have code that would instruct the media player to play, but we will simply display a message.
Create a toString method that will display the superclass's toString method, but also add rows for Audio Spec and Type.
Create a driver class for AudioPlayer that will test to see whether we can instantiate occurrences of it, use the media controls and print out their details to the console.

Week 8 Polymorphism
Issue 3 - Production
Allow the user to record production of a given product. Create a Production class and table. The user should be able to input a quantity. Create a production record for each produced item. Set manufacturedOn as the current date and time. Store each record in a productionRun collection. Store the contents of the collection to a Production table in the database. Display the contents of the Production table in a TextView. 

Week 9 Polymorphism
Issue 4 - MoviePlayer
The production facility will also create portable movie players. The main difference between these and the audio players is that they contain screens. Create an enum called MonitorType that will store
	Type
	LCD
	LED
Create an interface called ScreenSpec. This will define 3 methods:
	• public String getResolution();
	• public int getRefreshRate();
	• public int getResponseTime();
Create a class called Screen that implements ScreenSpec. Add three fields
	• String resolution
	• int refreshrate
	• int responsetime
Complete the methods from the ScreenSpec interface.
Add a toString method that will return the details of the 3 field in the same format as the Product Class.
Create a Driver class for Screen that tests the functionality of the screen class.
Create a class called MoviePlayer that extends Product and implements MultimediaControl. Add 2 fields to this class called screen and monitor type and assign appropriate types to them.
Complete the methods from the MultimediaControl interface in a similar fashion to the audio player.
Create a toString method that calls the product toString, displays the monitor and the screen details.
Create a diver class to test the functionality of the movie player.

Week 10 Encapsulation
Issue 5 - MultimediaControl 

Issue 6 - Sorting and Searching
Add functionality to your classes that would allow them to be sorted by name with the Collections.sort method.
Add functionality to your user interface to show production based on factors like product type, manufacturer, name, etc.

Week 12 Lambda Expressions
Issue 7 - EmployeeInfo 
The program is required to create an audit trail on its tests of the production line so that it records which employee ran the test. To accomplish this you will need to create a class named EmployeeInfo that will allow the user to input their full name and then create a user id of their first initial and surname.
The class will have 2 fields
	• StringBuilder name;
	• String code;
The class will have the following methods defined:
	• public StringBuilder getName()
	• public String getCode()
	• private void setName()
	• private void createEmployeeCode(StringBuilder name)
	• private String inputName()
	• private boolean checkName(StringBuilder name)
The setName() method will be called from the constructor which will use inputName() to get a name (firstname and surname) as a single input from the user before checkName() is used to make sure that the name supplied has a space in it.
If a valid name is given then createEmployeeCode() is used to take the first initial from the first name and add it to the full surname to create the code. If there is no space then default value of guest is to be used as the value for code.
In the TestProductionLine class create an employee object using the EmployeeInfo class. Using the getCode() method display the employee code at the bottom of the product output.

Week 13 Strings, Regular Expressions
Issue 8 - deptId
An additional piece of information is required to be produced for the auditing with the users department information being required as well. The department code is made up of four letters and two numbers.
The format of the department code is the first letter must be in uppercase with the following three all being lowercase and no spaces.
The following three fields need to be added to the EmployeeInfo class:
	• String deptId;
	• Pattern p;
	• Scanner in;
The following new methods have to be defined:
	• public String getDeptId()
	• private void setDeptId()
	• private String getId()
	• private boolean validId(String id)
As there will be multiple inputs across the class now the scanner will need to be declared and closed in the constructor. The pattern to control the format of the input will also have to be declared in the constructor. In between opening and closing the scanner, the constructor will need to not only get the name but also the deptId of the user.
setDeptId() will call getDeptId() to get the id from the user before validId() is used to check if the input matches the pattern. If the pattern matches then the given id is set to deptId otherwise a default value of None01 should be assigned. 
As there are now two values to be displayed (code, deptId) create a toString() method that will override the output and allow you to simply display the value of the object to the screen.
Update the TestProductionLine class to use the toString() method to display the values to the console.

Week 14 Recursion, Modules
Issue 9 - Reverse deptId
To ensure that sensitive information is not leaked it is important that the information saved to file is encoded. To meet these regulations you need to add a method to the EmployeeInfo class that will reverse the order of the text stored for the department id. This should be done recursively using a method named reverseString().
The following new methods have to be defined:
	• public String reverseString(String id)
If a valid department id is provided then reverseString() should be called before assigning the user input to the deptId field.

Week 15 Quality Review and Deployment
Issue 10 
Create a method called print that would take your collection and list all of the contents. It should handle all of your classes.
