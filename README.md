# Theatre schedule 
### The purpose of this application is to organize the program of performances for a theater and also to make reservations for the performances chosen by the users.
Therefore, the application includes the following functionalities:
<ul>
  <li> Logging in as admin. In this case, one can do the following:
    <ul>
      <li> Add a new show </li>
      <li> Remove a show </li>
      <li> Update the details about an existing show </li>
      <li> View a list of all the shows </li>
      <li> View the reserved seats for a show </li>
    </ul>
  <li> View details about a seat on hover (price, row, status: free/reserved) etc. </li>
  <li> Choose a seat or multiple seats and reserve them </li>
</ul>

### Technologies:
Theatre schedule it's a desktop application, in which the technologies used were ***Java*** for the backend, ***JavaFx*** for the graphical interface and ***Gradle*** as automation tool. <br>
Since it is a client-server application, I used ***gRPC*** to define a service that specifies methods that can be called remotely. <br>
Also, persistence in the database is achieved using the ***Hibernate ORM*** framework. <br>
#### In the *Theater.mdj* file you can find *the use case diagram*, *the class diagram* and *the sequence diagrams* for the use cases. In *UseCaseDescription.pdf* file you can see the description of the use cases.

This is the page that opens when you start the application. The show from the current day is displayed, along with the seats and their status: red - reserved, yellow - free, green - selected.
<br><br> ![image](https://user-images.githubusercontent.com/93184534/181590902-acd6fa0e-e146-4efd-a3cc-6da1816490ef.png)
