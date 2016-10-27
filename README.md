# Bradshaw_Marina_MVC-SWING
### Summary
This Solution is implemented in Java 8 and it is completely developed in three tier architecture (MVC). It provides a modern and easy to use interface. It is the result of a team work in Java Programming Course.
![Main View](https://cloud.githubusercontent.com/assets/12819018/19774720/0755ad44-9c3c-11e6-86b1-5cf9106c5e21.png)

### Application Background
BradShaw Marina is a privately owned corporation that rents boats and provides boat services on a lake
Needs automated system to:
Track:
Customers, leased slips, and boats in the slips
Tasks: creating lease, computing lease amount, assigning boats
Search: 
vacant slips leased to specific customers 

### Special Features and Technologies Used
- Collections
- MVC Design Pattern
- Custom Event Handlers
- Read/Write to/from XML File

### Application Overview
The Application has a main view with side bar buttons for easy browsing between different views.
* Manage Customers View
![Main View](https://cloud.githubusercontent.com/assets/12819018/19774725/0cf51320-9c3c-11e6-95d1-8a62bcb5e3f6.png)
Provides a table model which contains all customers summary and from a tool tip menu the user can access all the customers data, including lease information and its boat(s). The view has editing functionality, so every modification to customer's data is saved with a simple Save button Action.
In order to register a new customer and a new lease contract, the application user has to complete and submit:
1.  Customer Information Form
![Add Customer View](https://cloud.githubusercontent.com/assets/12819018/19774729/11b29e00-9c3c-11e6-8ddb-1e14082f4b44.png)
2. Boat Information and Appropriate Slip choosing Form
![Add Boat View](https://cloud.githubusercontent.com/assets/12819018/19774733/15d6364a-9c3c-11e6-9a8b-ea408b1d3df8.png)
3. Lease Terms Form
![Lease Form](https://cloud.githubusercontent.com/assets/12819018/19774747/19075fa6-9c3c-11e6-989c-201c610d4a7e.png)

The Application writes to an XML File the new customer and refreshes the main view. It uses Custom Event Handlers to pass data from one form to another, making sure no partial or invalid data is saved to the file.

Also, the user has a handy tool to check the current price of a particular slip according to different features

![Check Price View](https://cloud.githubusercontent.com/assets/12819018/19777062/885a8ad8-9c44-11e6-9d4f-bd232b0070f4.png)


