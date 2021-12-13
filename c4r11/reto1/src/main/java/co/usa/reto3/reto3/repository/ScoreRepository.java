package co.usa.reto3.reto3.repository;
import java.util.List;
import java.util.Optional;
import co.usa.reto3.reto3.model.Score;
import co.usa.reto3.reto3.repository.crud.ScoreCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ScoreRepository {
    @Autowired
    private ScoreCrudRepository scoreCrudRepository;
    public List<Score> getAll(){
        return (List<Score>)scoreCrudRepository.findAll();
    }
    public Optional<Score> getScore(int id){
        return scoreCrudRepository.findById(id);
    }
    public Score save(Score c) {
        return scoreCrudRepository.save(c);
    }
    public void delete(Score s){
        scoreCrudRepository.delete(s);
    }
}
