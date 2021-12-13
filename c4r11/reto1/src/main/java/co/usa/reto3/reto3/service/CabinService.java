package co.usa.reto3.reto3.service;
import co.usa.reto3.reto3.repository.CabinRepository;
import co.usa.reto3.reto3.model.Cabin;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CabinService {

    @Autowired
    private CabinRepository cabinRepository;

    public List<Cabin> getAll(){
        return cabinRepository.getAll();

    }
    public Optional <Cabin> getCabin(int id){
        return cabinRepository.getCabin(id);
    }
    public Cabin save (Cabin c) {
        if(c.getId()==null) {
            return cabinRepository.save(c);
        }
        else {
            Optional<Cabin> aux=cabinRepository.getCabin(c.getId());
            if(aux.isEmpty()) {
                return cabinRepository.save(c);
            }else {
                return c;
            }
        }

    }
    public Cabin update(Cabin a){
        if(a.getId()!=null){
            Optional<Cabin>d=cabinRepository.getCabin(a.getId());
            if(!d.isEmpty()){
                if (a.getNAME()!=null){
                    d.get().setNAME(a.getNAME());
                }
                if (a.getBRAND()!=null){
                    d.get().setBRAND(a.getBRAND());
                }
                if (a.getROOMS()!=null){
                    d.get().setROOMS(a.getROOMS());
                }
                return cabinRepository.save((d.get()));
            }
        }
        return a;
    }
    public boolean deleteCabin(int id){
        Optional<Cabin> c=getCabin(id);
        if(!c.isEmpty()){
            cabinRepository.delete(c.get());
            return true;
        }
        return false;
    }
}
