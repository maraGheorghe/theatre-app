import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.Manager;
import model.Show;

import java.io.IOException;

public class LoginController {
    private TheatreServiceGrpc.TheatreServiceBlockingStub server;
    @FXML
    private Button loginButton;
    @FXML
    private TextField usernameField;
    @FXML
    private TextField passwordField;
    @FXML
    private Label errorLabel;
    private Show show;

    public void setService(TheatreServiceGrpc.TheatreServiceBlockingStub server, Show show) {
        this.server = server;
        this.show = show;
    }

    public void handleLoginButton(ActionEvent actionEvent) throws IOException {
        String username = usernameField.getText();
        String password = passwordField.getText();;
        FXMLLoader fxmlLoader = new FXMLLoader(StartClient.class.getResource("admin_menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        var result = server.login(Theatre.LoginRequest.newBuilder().setUsername(username).setPassword(password).build());
        if (result.getType() == 1) {
            errorLabel.setVisible(true);
            errorLabel.setText(result.getError());
        } else {
            Manager manager = new Manager(result.getId(), username, password);
            fxmlLoader.<AdminController>getController().setService(this.server, manager, show);
            Stage stage = (Stage) loginButton.getScene().getWindow();
            stage.setScene(scene);
            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    fxmlLoader.<AdminController>getController().logout();
                    Platform.exit();
                    System.exit(0);
                }
            });
        }
    }
}
