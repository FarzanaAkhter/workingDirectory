Feature:To Do List
as a
User of the domain he/she Should be able to add to and remove from do list

@Add Item 
Scenario: Add Item 
Given user is on home page
When user type to do item in to do item textbox
And select catagory
And select due date
And press add button
Then user should see to do item added to the to do list
@Remove Item
Scenario: Remove Item 
Given user is on home page
When user select to do item from to do list
And press remove button
Then user should not see to do item exists any more in do list
@Complete Item
Scenario: Complete Item 
Given user is on home page
When user select incomplete to do item from to do list
And press Complete button
Then user should see to do item completed in do list
@Add New Category
Scenario: Add New Category
Given user is on home page
When user type category into category textbox
And select catagory type from category drop down
And press Add category button
Then user should see category added to the category list