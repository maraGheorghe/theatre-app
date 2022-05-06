import com.google.protobuf.Timestamp;
import io.grpc.stub.StreamObserver;
import model.Manager;
import model.Seat;
import model.Show;
import repository.interfaces.RepositoryManagerInterface;
import repository.interfaces.RepositorySeatInterface;
import repository.interfaces.RepositoryShowInterface;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Optional;

public class ServiceImplementation extends TheatreServiceGrpc.TheatreServiceImplBase {
    private RepositoryManagerInterface managerRepository;
    private RepositoryShowInterface showRepository;
    private RepositorySeatInterface seatRepository;
    private boolean connectedManager = false;

    public ServiceImplementation(RepositoryManagerInterface managerRepository,
                                 RepositoryShowInterface showRepository,
                                 RepositorySeatInterface seatRepository) {
        this.managerRepository = managerRepository;
        this.showRepository = showRepository;
        this.seatRepository = seatRepository;
    }

    @Override
    public void login(Theatre.LoginRequest request, StreamObserver<Theatre.LoginResponse> responseObserver) {
        Optional<Manager> manager = managerRepository.checkConnection(request.getUsername(), request.getPassword());
        var response = Theatre.LoginResponse.newBuilder().setType(1)
                .setError("Username and password do not match! Please try again.").build();
        if(connectedManager) {
            response = Theatre.LoginResponse.newBuilder().setType(1)
                    .setError("Manager is already connected.").build();
        }
        else if(manager.isPresent()) {
            response = Theatre.LoginResponse.newBuilder().setType(0).setUsername(manager.get().getUsername())
                    .setPassword(manager.get().getPassword()).setId(manager.get().getID()).build();
            connectedManager = true;
        }
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void logout(Theatre.LogoutRequest request, StreamObserver<Theatre.LogoutResponse> responseObserver) {
        var response = Theatre.LogoutResponse.newBuilder().build();
        connectedManager = false;
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void addShow(Theatre.AddShowRequest request, StreamObserver<Theatre.AddShowResponse> responseObserver) {
        Optional<Show> show = showRepository.save(new Show(request.getName(), Instant
                .ofEpochSecond( request.getDate().getSeconds() , request.getDate().getNanos() )
                .atZone(ZoneOffset.UTC)
                .toLocalDateTime(), request.getDescription()));
        var response = Theatre.AddShowResponse.newBuilder().setType(1)
                .setError("Could not save this show! Please try again.").build();
        if(show.isPresent())
            response = Theatre.AddShowResponse.newBuilder().setType(0).setId(show.get().getID()).setName(show.get().getName())
                    .setDate(request.getDate()).setDescription(show.get().getDescription()).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void deleteShow(Theatre.DeleteShowRequest request, StreamObserver<Theatre.DeleteShowResponse> responseObserver) {
        Optional<Show> show = showRepository.delete(new Show(request.getId(), request.getName(), Instant
                .ofEpochSecond( request.getDate().getSeconds() , request.getDate().getNanos() )
                .atZone(ZoneOffset.UTC)
                .toLocalDateTime(), request.getDescription()));
        var response = Theatre.DeleteShowResponse.newBuilder().setType(1)
                .setError("Could not delete this show!").build();
        if(show.isPresent())
            response = Theatre.DeleteShowResponse.newBuilder().setType(0).setId(show.get().getID()).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void updateShow(Theatre.UpdateShowRequest request, StreamObserver<Theatre.UpdateShowResponse> responseObserver) {
        Optional<Show> show = showRepository.update(new Show(request.getId(), request.getName(), Instant
                .ofEpochSecond( request.getDate().getSeconds() , request.getDate().getNanos() )
                .atZone(ZoneOffset.UTC)
                .toLocalDateTime(), request.getDescription()));
        var response = Theatre.UpdateShowResponse.newBuilder().setType(1)
                .setError("Could not update this show! Please try again.").build();
        if(show.isPresent())
            response = Theatre.UpdateShowResponse.newBuilder().setType(0).setId(show.get().getID())
                    .setName(show.get().getName())
                    .setDate(request.getDate())
                    .setDescription(show.get().getDescription())
                    .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getAllSeats(Theatre.GetAllSeatsRequest request, StreamObserver<Theatre.GetAllSeatsResponse> responseObserver) {
        List<Seat> seats = seatRepository.findAll();
        var seatsMessage = seats.stream()
                .map(seat -> Theatre.SeatMessage.newBuilder()
                        .setId(seat.getID())
                        .setRow(seat.getRow())
                        .setBox(seat.getBox())
                        .setNumber(seat.getNumber())
                        .setPrice(seat.getPrice())
                        .build()).toList();
        var response = Theatre.GetAllSeatsResponse.newBuilder().addAllSeats(seatsMessage).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getReservedSeats(Theatre.GetReservedSeatsRequest request, StreamObserver<Theatre.GetReservedSeatsResponse> responseObserver) {
        List<Seat> seats = showRepository.findReservedSeats(request.getShowId());
        var seatsMessage = seats.stream()
                .map(seat -> Theatre.SeatMessage.newBuilder()
                        .setId(seat.getID())
                        .setRow(seat.getRow())
                        .setBox(seat.getBox())
                        .setNumber(seat.getNumber())
                        .setPrice(seat.getPrice())
                        .build()).toList();
        var response = Theatre.GetReservedSeatsResponse.newBuilder().addAllSeats(seatsMessage).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getShowOfToday(Theatre.GetShowOfTodayRequest request, StreamObserver<Theatre.GetShowOfTodayResponse> responseObserver) {
        Optional<Show> show = showRepository.getShowOfADay(LocalDate.now());
        var response = Theatre.GetShowOfTodayResponse.newBuilder().setType(1)
                .setError("There is no show today. Please come back tomorrow.").build();
        if(show.isPresent()) {
            Instant instant = show.get().getDate().toInstant(ZoneOffset.UTC);
            response = Theatre.GetShowOfTodayResponse.newBuilder().setType(0)
                    .setId(show.get().getID())
                    .setName(show.get().getName())
                    .setDate(Timestamp.newBuilder().setSeconds(instant.getEpochSecond())
                            .setNanos(instant.getNano())
                            .build())
                    .setDescription(show.get().getDescription())
                    .build();
        }
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getShowOfADay(Theatre.GetShowOfADayRequest request, StreamObserver<Theatre.GetShowOfADayResponse> responseObserver) {
        var date = Instant
                .ofEpochSecond( request.getDate().getSeconds() , request.getDate().getNanos() )
                .atZone(ZoneOffset.UTC)
                .toLocalDateTime();
        Optional<Show> show = showRepository.getShowOfADay(date.toLocalDate());
        var response = Theatre.GetShowOfADayResponse.newBuilder().setType(1)
                .setError("There is no show that day.").build();
        if(show.isPresent()) {
            Instant instant = show.get().getDate().toInstant(ZoneOffset.UTC);
            response = Theatre.GetShowOfADayResponse.newBuilder().setType(0)
                    .setId(show.get().getID())
                    .setName(show.get().getName())
                    .setDate(Timestamp.newBuilder().setSeconds(instant.getEpochSecond())
                            .setNanos(instant.getNano())
                            .build())
                    .setDescription(show.get().getDescription())
                    .build();
        }
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getAllShows(Theatre.GetAllShowsRequest request, StreamObserver<Theatre.GetAllShowsResponse> responseObserver) {
        List<Show> shows = showRepository.findAll();
        var showsMessage = shows.stream()
                .map(show ->  {
                    Instant instant = show.getDate().toInstant(ZoneOffset.UTC);
                    return Theatre.ShowMessage.newBuilder()
                        .setId(show.getID())
                        .setName(show.getName())
                        .setDate(Timestamp.newBuilder().setSeconds(instant.getEpochSecond())
                                .setNanos(instant.getNano())
                                .build())
                            .setDescription(show.getDescription())
                            .build();
                }).toList();
        var response = Theatre.GetAllShowsResponse.newBuilder().addAllShows(showsMessage).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
