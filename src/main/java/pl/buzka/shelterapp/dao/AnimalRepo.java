package pl.buzka.shelterapp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.buzka.shelterapp.dao.entity.Animal;

@Repository
public interface AnimalRepo extends CrudRepository<Animal,Long> {

}
