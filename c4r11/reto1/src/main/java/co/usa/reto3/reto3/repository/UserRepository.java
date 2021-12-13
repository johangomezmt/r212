package co.usa.reto3.reto3.repository;
import java.util.List;
import java.util.Optional;
import co.usa.reto3.reto3.model.User;
import co.usa.reto3.reto3.repository.crud.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    @Autowired
    private UserCrudRepository userCrudRepository;
    public List<User> getAll(){
        return (List<User>) userCrudRepository.findAll();
    }
    public Optional<User> getUser(int id){
        return userCrudRepository.findById(id);
    }
    public User save(User c) {
        return userCrudRepository.save(c);
    }
    public boolean emailExistente(String email){Optional<User> usuario=userCrudRepository.findByEmail(email); return !usuario.isEmpty();}
    public Optional<User> autenticarUsuario(String email, String password){return userCrudRepository.findByEmailAndPassword(email,password);}
    public void delete(User a){
        userCrudRepository.delete(a);
    }
}
