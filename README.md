# Design-Patterns

## Observatons on Test Driven Devleopment

### Software Process 

##### Original Process
 
Lifecycle Phase  | Description |
-----------------| ------------
Analysis         | Understanding the domain
Design           | Understand how components interact with each other and the highlevel design of the components
Code             | Understand all the minutura about component and wirte the code
Test             | Understnad the happy path and all the problamatic paths the code could transverse
Release          | Releas the code to your comapany for further testing and release to the customer
Maintenance      | Fix any issues that the company deems important

##### Process with Test Driven Process

Lifecycle Phase  | Description |
-----------------| ------------
Analysis         | Understanding the domain
Design           | Understand how components interact with each other and the highlevel design of the components
Creating Test    | Design and create the test ( both happy and unhappy paths ) and what code needs to be wrtitten to complete the task.
Code             | Write the code to have all newly created test pass
Test             | Run the test to verify that the code works
Release          | Releas the code to your comapany for further testing and release to the customer
Maintenance      | Fix any issues that the company deems important

#### Comparision
The difference between previous two sections is the developer will think about the test before writing the code. in the "Test Driven Process"  From my experiments with Test Driven Development, writing the test first then the code.  The results were more unit tests and the code was meant to be tested.  Also the code was better quality since the developer would be think less about the sequnece of steps and focused on where the code should be located.

An example of improving the code would be creating a program where I only added code when I had a test that needed the code.  By not writing the whole fucntion
at once it was easier to decide where the node would go.  I did not have to think of writing the function as sequence of steps, but could focus on readability 
and maintainability.

An example of improving testability is the following: writing code to understand the Class ThreadPoolExeute a thread would need to be created by the 
ExecutorServcie with a name and in a state so the developer can find the thread using the api.  Usuaally when this type of code was written, thread was
created and the developer could find thread using API mehtods.  An extra requirement was considering the testability by makeing sure that thread
could be interrupted so the test class could continue without blocking the other test.

### Banners

Since you are developing the test before writing the code more test are usually created.  When I created the tests using TDD, I was getting lost in the file.  My
solution was to create a banner to sections of different test  An example banner would be 

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////<br/>
// BuilderCode addField() with parameters variable1Type and variable1Type<br/>
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////</br>

### Project Management
When introducing a new developer to test driven development the leader should provide some more time for him to complete the first few assignments using test driven development since it does require a change to how you think about writing code.  It took me longer to write the code, but after a while it should become second nature.

