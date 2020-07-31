package pl.buzka.shelterapp.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.buzka.shelterapp.dao.AnimalRepo;
import pl.buzka.shelterapp.dao.entity.Animal;

import java.util.Optional;
@Service
public class AnimalManager {

    private AnimalRepo animalRepo;

    @Autowired
    public AnimalManager(AnimalRepo animalRepo) {
        this.animalRepo = animalRepo;
    }

    public Optional<Animal> findById(Long id) {
        return animalRepo.findById(id);
    }

    public Iterable<Animal> findAll() {
        return animalRepo.findAll();
    }

    public Animal save(Animal animal){
        return animalRepo.save(animal);
    }

    public void  deleteById(Long id){
        animalRepo.deleteById(id);
    }

    public String status(){
        long count = animalRepo.count();
        String str;
        int allPlaces = 5;
        if(count<allPlaces) str = "In shelter is/are "+count+"Animals. There is still place.";
        else if(count == allPlaces) str = "In shelter is/are "+count+"Animals. Shelter is full.";
        else str ="In shelter is/are "+count+". There is too many animals.";
        str = "{\"status\": { \"text\": \""+str+"\"}}";
        return str;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDB(){
        save(new Animal(1L,"Dog", "Karmen", 1));
        save(new Animal(2L,"Dog", "Czika", 13));
        save(new Animal(3L,"Cat","Borys", 5));
    }


}
