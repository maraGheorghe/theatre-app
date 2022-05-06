package repository.interfaces;

import model.Manager;
import java.util.Optional;

public interface RepositoryManagerInterface extends RepositoryInterface<Manager> {

    Optional<Manager> checkConnection(String username, String password);
}
