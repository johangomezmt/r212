package co.usa.reto3.reto3.repository.crud;
import org.springframework.data.repository.CrudRepository;
import co.usa.reto3.reto3.model.User;

import java.util.Optional;

public interface UserCrudRepository extends CrudRepository<User,Integer>{
    Optional<User> findByEmail (String email);
    Optional<User> findByEmailAndPassword(String email,String password);
}
