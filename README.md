## Group Member Contribution

Horace Zeng - Implemented CashRegisterMVC app.

Arvin Jain - Completed sequence diagram and scanner generateUPC().

Oluwatobiloba Odubanjo - Completed questions 1 and 2.

## Q1 & Q2:

1. Java Swing is a Graphical User Interface toolkit that allows developers to create desktop applications in Java. It is part of the Java Foundation Classes and it provides lightweight, platform-independent components such as buttons and text fields. Swing is built on top of the Abstract Window Toolkit but offers more flexibility and customization. It follows a Model-View-Controller design at the component level, separating data handling which is the model, visual representation, which is the view, and user interaction, which is the controller. This makes applications easier to maintain, extend, and test.
   <img width="1052" height="621" alt="image" src="https://github.com/user-attachments/assets/79e4db7e-63f3-44a8-9b41-0d064d4a9293" />

   
2. How the example demonstrates the MVC Pattern:
In the sample code, the MVC architecture is structured into three main parts. The Model which manages the program’s data ,such as the first and last names , and includes getter and setter methods for accessing and modifying this information. It functions as the core logic of the program, remaining separate from the interface itself. The View which builds and handles all graphical elements using Java Swing. Its purpose is to display information and collect input from the user. The Controller connects the Model and View, initializing the interface and, adding event listeners for user actions, updating the Model based on user input, and refreshing the View using dialog boxes when necessary.

## Differences from the traditional MVC Pattern explained in Notes:

This implementation differs from the MVC structure in the notes in several ways. Firstly, it lacks an automatic update system, in conventional MVC, the Model notifies the View and Controller when data changes, enabling them to update themselves automatically. In this example, the Controller must manually update both the Model and the View, meaning the interface doesn’t refresh automatically when the data changes. Secondly, the Controller has direct access to View components, creating a tighter coupling between layers. In conventional MVC, the View and Controller are kept in the presentation layer while the Model is separate, making the system more modular. This version uses the `initView()` method to manually sync data during startup, whereas the Conventional MVC would typically rely on the Observer pattern to synchronize updates automatically. Lastly, there’s no direct connection between the Model and the View, all communication happens through the Controller.

## Sequence Diagram for Q4

<img width="898" height="506" alt="image" src="https://github.com/user-attachments/assets/42d69da2-425c-418d-89fb-18b03f464c01" />
