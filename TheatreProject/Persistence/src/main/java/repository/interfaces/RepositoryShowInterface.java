package repository.interfaces;

import model.Seat;
import model.Show;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface RepositoryShowInterface extends RepositoryInterface<Show> {
    List<Seat> findReservedSeats(Long id);

    Optional<Show> getShowOfADay(LocalDate date);
}
