import io.grpc.Server;
import io.grpc.ServerBuilder;
import model.Show;
import repository.SessionFactoryUtil;
import repository.hibernate.RepositoryManager;
import repository.hibernate.RepositorySeat;
import repository.hibernate.RepositoryShow;
import repository.interfaces.RepositoryInterface;
import repository.interfaces.RepositoryManagerInterface;
import repository.interfaces.RepositorySeatInterface;
import repository.interfaces.RepositoryShowInterface;

import java.io.IOException;
import java.util.Properties;

public class StartServer {
    private static int defaultPort = 26126;
    private Server server;

    public static void main(String[] args) {
        Properties properties = new Properties();
        try {
            properties.load(StartServer.class.getResourceAsStream("/server.properties"));
            System.out.println("Server properties set.");
            properties.list(System.out);
        } catch (IOException e) {
            System.err.println("Cannot find server.properties: " + e);
            return;
        }
        RepositoryManagerInterface repositoryManager = new RepositoryManager();
        RepositoryShowInterface repositoryShow = new RepositoryShow();
        RepositorySeatInterface repositorySeat = new RepositorySeat();
        ServiceImplementation service = new ServiceImplementation(repositoryManager, repositoryShow, repositorySeat);
        try {
            defaultPort = Integer.parseInt(properties.getProperty("server.port"));
        } catch (NumberFormatException nef) {
            System.err.println("Wrong  Port Number: " + nef.getMessage());
            System.err.println("Using default port: " + defaultPort);
        }
        System.out.println("Starting server on port: " + defaultPort);
        StartServer server = new StartServer();
        try {
            server.start(service);
            server.blockUntilShutdown();
            SessionFactoryUtil.close();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            SessionFactoryUtil.close();
        }
    }

    public void start(ServiceImplementation service) throws IOException {
        server = ServerBuilder
                .forPort(defaultPort)
                .addService(service)
                .build()
                .start();
    }

    public void blockUntilShutdown() throws InterruptedException {
        if(server == null)
            return;
        server.awaitTermination();
    }
}
