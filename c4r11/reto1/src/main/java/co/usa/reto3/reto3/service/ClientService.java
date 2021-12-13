package co.usa.reto3.reto3.service;
import co.usa.reto3.reto3.repository.ClientRepository;
import co.usa.reto3.reto3.model.Client;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll(){
        return clientRepository.getAll();

    }
    public Optional <Client> getClient(int id){
        return clientRepository.getClient(id);
    }
    public Client save (Client c) {
        if(c.getIdClient()==null) {
            return clientRepository.save(c);
        }
        else {
            Optional<Client> aux=clientRepository.getClient(c.getIdClient());
            if(aux.isEmpty()) {
                return clientRepository.save(c);
            }else {
                return c;
            }
        }

    }
    public Client update(Client a){
        if(a.getIdClient()!=null){
            Optional<Client>d=clientRepository.getClient(a.getIdClient());
            if(!d.isEmpty()){
                if (a.getName()!=null){
                    d.get().setName(a.getName());
                }
                if (a.getEmail()!=null){
                    d.get().setEmail(a.getEmail());
                }
                if (a.getPassword()!=null){
                    d.get().setPassword(a.getPassword());
                }
                if (a.getAge()!=null){
                    d.get().setAge(a.getAge());
                }
                return clientRepository.save((d.get()));
            }
        }
        return a;
    }
    public boolean deleteClient(int id){
        Optional<Client> c=getClient(id);
        if(!c.isEmpty()){
            clientRepository.delete(c.get());
            return true;
        }
        return false;
    }
}
