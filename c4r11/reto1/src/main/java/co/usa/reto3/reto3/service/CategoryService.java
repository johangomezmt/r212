package co.usa.reto3.reto3.service;
import co.usa.reto3.reto3.repository.CategoryRepository;
import co.usa.reto3.reto3.model.Category;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll(){
        return categoryRepository.getAll();

    }
    public Optional <Category> getCategory(int id){
        return categoryRepository.getCategory(id);
    }
    public Category save (Category c) {
        if(c.getId()==null) {
            return categoryRepository.save(c);
        }
        else {
            Optional<Category> aux=categoryRepository.getCategory(c.getId());
            if(aux.isEmpty()) {
                return categoryRepository.save(c);
            }else {
                return c;
            }
        }

    }
    public Category update(Category a){
        if(a.getId()!=null){
            Optional<Category>d=categoryRepository.getCategory(a.getId());
            if(!d.isEmpty()){
                if (a.getName()!=null){
                    d.get().setName(a.getName());
                }
                if (a.getDescription()!=null){
                    d.get().setDescription(a.getDescription());
                }
                return categoryRepository.save((d.get()));
            }
        }
        return a;
    }
    public boolean deleteCategory(int id){
        Optional<Category> c=getCategory(id);
        if(!c.isEmpty()){
            categoryRepository.delete(c.get());
            return true;
        }
        return false;
    }
}
