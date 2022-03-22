# Setup : 

To get started, clone the project and run this command in the project root directory
gradlew clean build

To execute the unit tests, use the command : 
gradlew test

To execute the application, ideally "gradlew bootRun" should work but it keeps failing due to an issue with detecting the console input.

Altenatively, please open the project in an IDE and execute the AddressbookApplication.java file.

Proceed to make a selection as per the menu shown : 

!! Welcome, please choose from the following options !!
1 - Add new contact
2 - View existing contacts
3 - Compare an addressbook
4 - Exit

There is a contacts.csv file at the root directory which acts as a persistent storage.

To compare an address book, please select the option 3 and type out the names comma separated such as : 
john,mary,ken
