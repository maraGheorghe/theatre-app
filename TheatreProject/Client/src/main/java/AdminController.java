import com.google.protobuf.Timestamp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Manager;
import model.Show;

import java.io.IOException;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

public class AdminController {
    @FXML
    private TextField searchBar;
    @FXML
    private Button logoutButton;
    @FXML
    private Label showLabel;
    @FXML
    private Label errorLabel;
    @FXML
    private TextField nameField, descriptionField, timeField;
    @FXML
    private DatePicker datePicker;
    private TheatreServiceGrpc.TheatreServiceBlockingStub server;
    private Manager manager;
    private Show show;
    private Show selectedShow;
    @FXML
    private ListView<Show> showsList;
    private List<Show> showListEntities;
    ObservableList<Show> showsModel = FXCollections.observableArrayList();

    public void setService(TheatreServiceGrpc.TheatreServiceBlockingStub server, Manager manager, Show show) {
        this.server = server;
        this.manager = manager;
        this.show = show;
        if(show != null)
            showLabel.setText("\"" + show.getName() + "\" at " + show.getDate().format(DateTimeFormatter.ofPattern("HH:mm")));
        else {
            showLabel.setText("No show today!");
        }
        initModelAllShows();
        showsList.setItems(showsModel);
        searchBar.textProperty().addListener(x ->
                showsModel.setAll(showListEntities.stream()
                        .filter(s -> s.getName().startsWith(searchBar.getText())).toList()));
    }

    private void initModelAllShows() {
        showListEntities = null;
        var showsMessages = server.getAllShows(Theatre.GetAllShowsRequest.newBuilder().build());
        showListEntities = showsMessages.getShowsList().stream().map(show -> {
                    LocalDateTime date = Instant.ofEpochSecond(show.getDate().getSeconds(),
                                    show.getDate().getNanos())
                            .atZone(ZoneOffset.UTC)
                            .toLocalDateTime();
                    return new Show(show.getId(), show.getName(), date, show.getDescription());
                }).toList();
        showsModel.setAll(showListEntities);
    }

    public void logout() {
        server.logout(Theatre.LogoutRequest.newBuilder().setId(manager.getID()).build());
    }

    public void handleLogoutButton(ActionEvent actionEvent) throws IOException {
        logout();
        Stage stage = (Stage) logoutButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(StartClient.class.getResource("checkAvailability.fxml"));
        AnchorPane root = fxmlLoader.load();
        fxmlLoader.<SceneController>getController().setService(server);
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    public void handleAddButton(ActionEvent actionEvent) {
        String name = nameField.getText();
        String description = descriptionField.getText();
        try {
            LocalTime time = LocalTime.parse(timeField.getText());
            LocalDate date = datePicker.getValue();
            LocalDateTime dateTime = LocalDateTime.of(date, time);
            Instant instant = dateTime.toInstant(ZoneOffset.UTC);
            var timestamp = Timestamp.newBuilder().setSeconds(instant.getEpochSecond())
                    .setNanos(instant.getNano())
                    .build();
            var existShow = server.getShowOfADay(Theatre.GetShowOfADayRequest
                    .newBuilder().setDate(timestamp).build());
            if (existShow.getType() == 1) {
                var result = server.addShow(Theatre.AddShowRequest.newBuilder().setName(name)
                        .setDescription(description)
                        .setDate(timestamp)
                        .build());
                if (result.getType() == 1) {
                    errorLabel.setVisible(true);
                    errorLabel.setText(result.getError());
                }
                else {
                    clearSelection();
                    LocalDateTime dateShow = Instant.ofEpochSecond(result.getDate().getSeconds(),
                                    result.getDate().getNanos())
                            .atZone(ZoneOffset.UTC)
                            .toLocalDateTime();
                    Show newShow = new Show(result.getId(), result.getName(), dateShow, result.getDescription());
                    showsModel.add(newShow);
                    showListEntities = showsModel.stream().toList();
                    if ((dateShow.toLocalDate()).equals(LocalDate.now())) {
                        show = newShow;
                        showLabel.setText("\"" + show.getName() + "\" at " + show.getDate().format(DateTimeFormatter.ofPattern("HH:mm")));
                    }
                }
            }
            else {
                errorLabel.setVisible(true);
                errorLabel.setText("There is another show for this day!");
            }
        } catch(DateTimeParseException e){
            errorLabel.setVisible(true);
            errorLabel.setText("Invalid format for date or time. Please try again!");
        }
    }

    public void handleDeleteShowButton(ActionEvent actionEvent) {
        Show toDeleteShow = showsList.getSelectionModel().getSelectedItem();
        if(toDeleteShow != null) {
            Instant instant = toDeleteShow.getDate().toInstant(ZoneOffset.UTC);
            var result = server.deleteShow(Theatre.DeleteShowRequest.newBuilder()
                    .setId(toDeleteShow.getID())
                    .setName(toDeleteShow.getName())
                    .setDescription(toDeleteShow.getDescription())
                    .setDate(Timestamp.newBuilder().setSeconds(instant.getEpochSecond())
                            .setNanos(instant.getNano())
                            .build())
                    .build());
            if (result.getType() == 1) {
                errorLabel.setVisible(true);
                errorLabel.setText(result.getError());
            } else {
                showsModel.remove(toDeleteShow);
                showListEntities = showsModel.stream().toList();
                clearSelection();
                if (toDeleteShow.equals(show)) {
                    showLabel.setText("No show today!");
                    show = null;
                }
            }
        }
        else {
            errorLabel.setVisible(true);
            errorLabel.setText("You did not selected any show!");
        }
    }

    public void handleSelectShow(MouseEvent mouseEvent) {
        if (mouseEvent.getClickCount() == 2) {
            selectedShow = showsList.getSelectionModel().getSelectedItem();
            if(selectedShow != null) {
                nameField.setText(selectedShow.getName());
                descriptionField.setText(selectedShow.getDescription());
                timeField.setText(selectedShow.getDate().toLocalTime().format(DateTimeFormatter.ofPattern("HH:mm")));
                datePicker.setValue(selectedShow.getDate().toLocalDate());
            }
        }
    }

    public void handleClearSelection(MouseEvent mouseEvent) { clearSelection(); }

    private void clearSelection() {
        selectedShow = null;
        nameField.setText("");
        descriptionField.setText("");
        timeField.setText("");
        datePicker.setValue(LocalDate.now());
        errorLabel.setVisible(false);
    }

    public void handleUpdateButton(ActionEvent actionEvent) {
        if(selectedShow != null) {
            Show oldShow = selectedShow;
            String name = nameField.getText();
            String description = descriptionField.getText();
            try {
                LocalTime time = LocalTime.parse(timeField.getText());
                LocalDate date = datePicker.getValue();
                LocalDateTime dateTime = LocalDateTime.of(date, time);
                Instant instant = dateTime.toInstant(ZoneOffset.UTC);
                var timestamp = Timestamp.newBuilder().setSeconds(instant.getEpochSecond())
                        .setNanos(instant.getNano())
                        .build();
                var existShow = server.getShowOfADay(Theatre.GetShowOfADayRequest
                        .newBuilder().setDate(timestamp).build());
                if (existShow.getType() == 1 || date == selectedShow.getDate().toLocalDate()) {
                    var result = server.updateShow(Theatre.UpdateShowRequest.newBuilder()
                            .setId(selectedShow.getID())
                            .setName(name)
                            .setDescription(description)
                            .setDate(timestamp)
                            .build());
                    if (result.getType() == 1) {
                        errorLabel.setVisible(true);
                        errorLabel.setText(result.getError());
                    } else {
                        clearSelection();
                        LocalDateTime dateShow = Instant.ofEpochSecond(result.getDate().getSeconds(),
                                        result.getDate().getNanos())
                                .atZone(ZoneOffset.UTC)
                                .toLocalDateTime();
                        Show newShow = new Show(result.getId(), result.getName(), dateShow, result.getDescription());
                        showsModel.remove(oldShow);
                        showsModel.add(newShow);
                        showListEntities = showsModel.stream().toList();
                        if ((dateShow.toLocalDate()).equals(LocalDate.now())) {
                            show = newShow;
                            showLabel.setText("\"" + show.getName() + "\" at " + show.getDate().format(DateTimeFormatter.ofPattern("HH:mm")));
                        }
                    }
                }
                else {
                    errorLabel.setVisible(true);
                    errorLabel.setText("There is another show for this day!");
                    clearSelection();
                }
            } catch(DateTimeParseException e){
            errorLabel.setVisible(true);
            errorLabel.setText("Invalid format for date or time. Please try again!");
            }
        }
        else {
            errorLabel.setVisible(true);
            errorLabel.setText("You did not selected any show!");
        }
    }
    // TODO: bug ciudat update - daca schimb data si dupa o pun inapoi nu mai merge
}
