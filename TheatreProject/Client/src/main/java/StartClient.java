import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Properties;

public class StartClient extends Application {
    private static int defaultPort = 26126;
    private static String defaultServer = "localhost";

    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("Starting client...");
        Properties properties = new Properties();
        try {
            properties.load(StartClient.class.getResourceAsStream("/client.properties"));
            System.out.println("Client properties set.");
            properties.list(System.out);
        } catch (IOException e) {
            System.err.println("Cannot find client.properties: " + e);
            return;
        }
        String serverIP = properties.getProperty("server.host", defaultServer);
        int serverPort = defaultPort;
        try {
            serverPort = Integer.parseInt(properties.getProperty("server.port"));
        } catch (NumberFormatException ex) {
            System.err.println("Wrong port number: " + ex.getMessage());
            System.out.println("Using default port: " + defaultPort);
        }
        System.out.println("Using server IP: " + serverIP);
        System.out.println("Using server port: " + serverPort);
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("127.0.0.1", defaultPort)
                .usePlaintext()
                .build();
        TheatreServiceGrpc.TheatreServiceBlockingStub service = TheatreServiceGrpc.newBlockingStub(channel);
        FXMLLoader fxmlLoader = new FXMLLoader(StartClient.class.getResource("checkAvailability.fxml"));
        AnchorPane root = fxmlLoader.load();
        fxmlLoader.<SceneController>getController().setService(service);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
