package environment;

import animals.Animal;
import lombok.Data;


import java.util.ArrayList;
import java.util.List;

@Data
public class Location {
    private List<Animal> animals;

    public Location() {
        this.animals = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public void removeAnimal(Animal animal) {
        animals.remove(animal);
    }

}