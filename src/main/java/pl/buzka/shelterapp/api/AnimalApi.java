package pl.buzka.shelterapp.api;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.buzka.shelterapp.dao.entity.Animal;
import pl.buzka.shelterapp.manager.AnimalManager;

import java.util.Optional;

@RestController
@RequestMapping("/api/animals")
public class AnimalApi {

    private AnimalManager animals;

    @Autowired
    public AnimalApi(AnimalManager animals) {
        this.animals = animals;
    }

    @GetMapping("/all")
    public Iterable<pl.buzka.shelterapp.dao.entity.Animal> getAll(){return animals.findAll();}
    @GetMapping()
    public Optional<Animal> getById(@RequestParam Long index){
        return animals.findById(index);
    }
    @GetMapping("/status")
    public String status()
    {
        return animals.status();
    }
    @PostMapping()
    public Animal addAnimal(@RequestBody Animal animal){
        return animals.save(animal);
    }
    @PutMapping()
    public Animal updateAnimal(@RequestBody Animal animal){
        return animals.save(animal);
    }
    @DeleteMapping()
    public void deleteAnimal(@RequestParam Long index){
        animals.deleteById(index);
    }
}
