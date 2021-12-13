package co.usa.reto3.reto3.service;
import co.usa.reto3.reto3.repository.ReservationRepository;
import co.usa.reto3.reto3.model.Reservation;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll(){
        return reservationRepository.getAll();

    }
    public Optional <Reservation> getReservation(int id){
        return reservationRepository.getReservation(id);
    }
    public Reservation save (Reservation c) {
        if(c.getID()==null) {
            return reservationRepository.save(c);
        }
        else {
            Optional<Reservation> aux=reservationRepository.getReservation(c.getID());
            if(aux.isEmpty()) {
                return reservationRepository.save(c);
            }else {
                return c;
            }
        }

    }
    public Reservation update(Reservation a){
        if(a.getID()!=null){
            Optional<Reservation>d=reservationRepository.getReservation(a.getID());
            if(!d.isEmpty()){
                if (a.getSTART_DATE()!=null){
                    d.get().setSTART_DATE(a.getSTART_DATE());
                }
                if (a.getDELIVERY_DATE()!=null){
                    d.get().setDELIVERY_DATE(a.getDELIVERY_DATE());
                }
                return reservationRepository.save((d.get()));
            }
        }
        return a;
    }
    public boolean deleteReservation(int id){
        Optional<Reservation> c=getReservation(id);
        if(!c.isEmpty()){
            reservationRepository.delete(c.get());
            return true;
        }
        return false;
    }
}
