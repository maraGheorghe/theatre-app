import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.stage.Stage;
import model.Seat;
import model.Show;

import java.io.IOException;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SceneController {
    private TheatreServiceGrpc.TheatreServiceBlockingStub server;
    @FXML
    private Label showLabel;
    @FXML
    private Button loginButton;
    @FXML
    private Button reserveButton;
    @FXML
    Button r0c0,r0c1,r0c2,r0c3,r0c4,r0c5,r0c6,r0c7,r0c8,r0c9;
    @FXML
    Button r1c0,r1c1,r1c2,r1c3,r1c4,r1c5,r1c6,r1c7,r1c8,r1c9;
    @FXML
    Button r2c0,r2c1,r2c2,r2c3,r2c4,r2c5,r2c6,r2c7,r2c8,r2c9;
    @FXML
    Button r3c0,r3c1,r3c2,r3c3,r3c4,r3c5,r3c6,r3c7,r3c8,r3c9;
    @FXML
    Button r4c0,r4c1,r4c2,r4c3,r4c4,r4c5,r4c6,r4c7,r4c8,r4c9;
    @FXML
    Button r5c0,r5c1,r5c2,r5c3,r5c4,r5c5,r5c6,r5c7,r5c8,r5c9;
    @FXML
    Button l0r0c0,l0r0c1,l0r1c0,l0r1c1,l0r2c0,l0r2c1,l0r2c2,l0r3c0,l0r3c1,l0r3c2;
    @FXML
    Button l1r0c0,l1r0c1,l1r1c0,l1r1c1,l1r2c0,l1r2c1,l1r2c2,l1r3c0,l1r3c1,l1r3c2;
    private List<Button> buttons;
    private List<Button> selectedButtons = new ArrayList<>();
    private Map<Button, Seat> map = new HashMap<>();
    private Show show = null;

    public void setService(TheatreServiceGrpc.TheatreServiceBlockingStub server) {
        this.server = server;
        buttons = List.of(r0c0,r0c1,r0c2,r0c3,r0c4,r0c5,r0c6,r0c7,r0c8,r0c9,
                r1c0,r1c1,r1c2,r1c3,r1c4,r1c5,r1c6,r1c7,r1c8,r1c9,
                r2c0,r2c1,r2c2,r2c3,r2c4,r2c5,r2c6,r2c7,r2c8,r2c9,
                r3c0,r3c1,r3c2,r3c3,r3c4,r3c5,r3c6,r3c7,r3c8,r3c9,
                r4c0,r4c1,r4c2,r4c3,r4c4,r4c5,r4c6,r4c7,r4c8,r4c9,
                r5c0,r5c1,r5c2,r5c3,r5c4,r5c5,r5c6,r5c7,r5c8,r5c9,
                l0r0c0,l0r0c1,l0r1c0,l0r1c1,l0r2c0,l0r2c1,l0r2c2,l0r3c0,l0r3c1,l0r3c2,
                l1r0c0,l1r0c1,l1r1c0,l1r1c1,l1r2c0,l1r2c1,l1r2c2,l1r3c0,l1r3c1,l1r3c2);
        var showResponse = server.getShowOfToday(Theatre.GetShowOfTodayRequest.newBuilder().build());
        if(showResponse.getType() == 1) {
            showLabel.setText(showResponse.getError());
            for (Button button: buttons)
                button.setDisable(true);
            reserveButton.setDisable(true);
        }
        else {
            show = new Show(showResponse.getId(), showResponse.getName(),
                    Instant
                    .ofEpochSecond( showResponse.getDate().getSeconds() , showResponse.getDate().getNanos() )
                    .atZone(ZoneOffset.UTC)
                    .toLocalDateTime(), showResponse.getDescription());
            showLabel.setText("\"" + show.getName() + "\"" +  " at "
                    + show.getDate().format(DateTimeFormatter.ofPattern("HH:mm"))
                    + '\n' + show.getDescription());
            var response = server.getAllSeats(Theatre.GetAllSeatsRequest.newBuilder().build());
            List<Seat> seats = response.getSeatsList().stream().map(s ->
                    new Seat(s.getId(), s.getRow(), s.getBox(), s.getNumber(), s.getPrice())).toList();
            var responseReserved = server.getReservedSeats(Theatre.GetReservedSeatsRequest.newBuilder().setShowId(show.getID()).build());
            List<Seat> reservedSeats = responseReserved.getSeatsList().stream().map(s ->
                    new Seat(s.getId(), s.getRow(), s.getBox(), s.getNumber(), s.getPrice())).toList();
            for (Button button : buttons) {
                map.put(button, seats.stream().filter(s -> {
                    if (button.getId().startsWith("l"))
                        return ("l" + s.getBox() + "r" + s.getRow() + "c" + s.getNumber()).equals(button.getId());
                    else return ("r" + s.getRow() + "c" + s.getNumber()).equals(button.getId());
                }).findFirst().orElse(null));
                if (reservedSeats.contains(map.get(button)))
                    button.setDisable(true);
            }
            for (Button button : buttons) {
                Tooltip tt = new Tooltip();
                tt.setText(map.get(button).toString());
                tt.setStyle("-fx-font: normal bold 16 Langdon; "
                        + "-fx-base: #AE3522; "
                        + "-fx-text-fill: #C2BE5EFF;");
                button.setTooltip(tt);
            }
        }
    }

    public void handleLoginButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(StartClient.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        fxmlLoader.<LoginController>getController().setService(this.server, show);
        Stage stage = (Stage) loginButton.getScene().getWindow();
        stage.setScene(scene);
    }

    public void handleReserve(ActionEvent actionEvent) {
    }
}
