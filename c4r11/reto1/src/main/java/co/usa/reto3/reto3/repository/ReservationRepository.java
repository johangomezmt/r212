package co.usa.reto3.reto3.repository;
import java.util.List;
import java.util.Optional;
import co.usa.reto3.reto3.model.Reservation;
import co.usa.reto3.reto3.repository.crud.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReservationRepository {
    @Autowired
    private ReservationCrudRepository reservationCrudRepository;
    public List<Reservation> getAll(){
        return (List<Reservation>)reservationCrudRepository.findAll();
    }
    public Optional<Reservation> getReservation(int id){
        return reservationCrudRepository.findById(id);
    }
    public Reservation save(Reservation c) {
        return reservationCrudRepository.save(c);
    }
    public void delete(Reservation r){
        reservationCrudRepository.delete(r);
    }
}
