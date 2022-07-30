# Theatre App 
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
It's a desktop application, in which the technologies used were:
<ul>
  <li><b>Java</b> for the backend</li>
  <li><b>JavaFx</b> for the graphical interface</li>
  <li><b>Gradle</b> as automation tool</li>
  <li>Since it is a client-server application, I used <b>gRPC</b> to define a service that specifies methods that can be called remotely</li>
  <li>Also, persistence in the database is achieved using the <b>Hibernate ORM</b> framework</li>
</ul>

    
In the <b>Theater.mdj</b> file you can find <b>the use case diagram</b>, <b>the class diagram</b> and <b>the sequence diagrams</b> for the use cases. In <b>UseCaseDescription.pdf</b> file you can see the description of the use cases.

This is the page that opens when you start the application. The show from the current day is displayed, along with the seats and their status:
    red - reserved, yellow - free, green - selected.
<br><br> ![image](https://user-images.githubusercontent.com/93184534/181590902-acd6fa0e-e146-4efd-a3cc-6da1816490ef.png)
