package simulation;

import animals.Animal;
import animals.factory.AnimalFactory;
import animals.herbivores.*;
import animals.predators.*;
import enums.HerbivoreType;
import enums.PredatorType;
import environment.Island;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import environment.Location;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;

public class IslandSimulation {
    private final Logger logger = LoggerFactory.getLogger(IslandSimulation.class);
    private final Logger animalLogger = LoggerFactory.getLogger(Animal.class);
    private final Island island;
    private IslandFrame islandFrame;
    private final AnimalFactory animalFactory = new AnimalFactory();
    private int simulationCount = 0;

    public IslandSimulation(int width, int height) {
        this.island = new Island(width, height);
        initializeAnimals();

        // Создаем и показываем окно в потоке Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(() -> {
            islandFrame = new IslandFrame(island);
            islandFrame.setVisible(true);
        });
    }

    private void initializeAnimals() {
        Random rand = new Random();
        // Инициализация хищников
        for (int i = 0; i < 10; i++) {
            Animal animal = animalFactory.createAnimal(PredatorType.BEAR);
            int x = rand.nextInt(island.getWidth());
            int y = rand.nextInt(island.getHeight());
            island.getLocation(x, y).addAnimal(animal);
        }
        for (int i = 0; i < 10; i++) {
            Animal animal = animalFactory.createAnimal(PredatorType.BOA);
            int x = rand.nextInt(island.getWidth());
            int y = rand.nextInt(island.getHeight());
            island.getLocation(x, y).addAnimal(animal);
        }
        for (int i = 0; i < 10; i++) {
            Animal animal = animalFactory.createAnimal(PredatorType.EAGLE);
            int x = rand.nextInt(island.getWidth());
            int y = rand.nextInt(island.getHeight());
            island.getLocation(x, y).addAnimal(animal);
        }
        for (int i = 0; i < 20; i++) {
            Animal animal = animalFactory.createAnimal(PredatorType.FOX);
            int x = rand.nextInt(island.getWidth());
            int y = rand.nextInt(island.getHeight());
            island.getLocation(x, y).addAnimal(animal);
        }
        for (int i = 0; i < 20; i++) {
            Animal animal = animalFactory.createAnimal(PredatorType.WOLF);
            int x = rand.nextInt(island.getWidth());
            int y = rand.nextInt(island.getHeight());
            island.getLocation(x, y).addAnimal(animal);
        }

        // Инициализация травоядных
        for (int i = 0; i < 30; i++) {
            Animal animal = animalFactory.createAnimal(HerbivoreType.BOAR);
            int x = rand.nextInt(island.getWidth());
            int y = rand.nextInt(island.getHeight());
            island.getLocation(x, y).addAnimal(animal);
        }
        for (int i = 0; i < 50; i++) {
            Animal animal = animalFactory.createAnimal(HerbivoreType.BUFFALO);
            int x = rand.nextInt(island.getWidth());
            int y = rand.nextInt(island.getHeight());
            island.getLocation(x, y).addAnimal(animal);
        }
        for (int i = 0; i < 30; i++) {
            Animal animal = animalFactory.createAnimal(HerbivoreType.CATERPILLAR);
            int x = rand.nextInt(island.getWidth());
            int y = rand.nextInt(island.getHeight());
            island.getLocation(x, y).addAnimal(animal);
        }
        for (int i = 0; i < 50; i++) {
            Animal animal = animalFactory.createAnimal(HerbivoreType.DEER);
            int x = rand.nextInt(island.getWidth());
            int y = rand.nextInt(island.getHeight());
            island.getLocation(x, y).addAnimal(animal);
        }
        for (int i = 0; i < 30; i++) {
            Animal animal = animalFactory.createAnimal(HerbivoreType.DUCK);
            int x = rand.nextInt(island.getWidth());
            int y = rand.nextInt(island.getHeight());
            island.getLocation(x, y).addAnimal(animal);
        }
        for (int i = 0; i < 50; i++) {
            Animal animal = animalFactory.createAnimal(HerbivoreType.GOAT);
            int x = rand.nextInt(island.getWidth());
            int y = rand.nextInt(island.getHeight());
            island.getLocation(x, y).addAnimal(animal);
        }
        for (int i = 0; i < 30; i++) {
            Animal animal = animalFactory.createAnimal(HerbivoreType.HORSE);
            int x = rand.nextInt(island.getWidth());
            int y = rand.nextInt(island.getHeight());
            island.getLocation(x, y).addAnimal(animal);
        }
        for (int i = 0; i < 50; i++) {
            Animal animal = animalFactory.createAnimal(HerbivoreType.MOUSE);
            int x = rand.nextInt(island.getWidth());
            int y = rand.nextInt(island.getHeight());
            island.getLocation(x, y).addAnimal(animal);
        }
        for (int i = 0; i < 30; i++) {
            Animal animal = animalFactory.createAnimal(HerbivoreType.RABBIT);
            int x = rand.nextInt(island.getWidth());
            int y = rand.nextInt(island.getHeight());
            island.getLocation(x, y).addAnimal(animal);
        }
        for (int i = 0; i < 50; i++) {
            Animal animal = animalFactory.createAnimal(HerbivoreType.SHEEP);
            int x = rand.nextInt(island.getWidth());
            int y = rand.nextInt(island.getHeight());
            island.getLocation(x, y).addAnimal(animal);
        }
    }

    public void growPlants() {

    }

    public void animalLifeCycle() {

    }

    public void printStatistics() {

    }


    public void updateIsland() {
        Random rand = new Random();
        Location[][] locations = island.getLocations();

        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations[i].length; j++) {
                List<Animal> animals = locations[i][j].getAnimals();
                for (Animal animal : new ArrayList<>(animals)) {
                    int newX = rand.nextInt(island.getWidth());
                    int newY = rand.nextInt(island.getHeight());
                    island.getLocation(newX, newY).addAnimal(animal);
                    animals.remove(animal);
                }
            }
        }

        SwingUtilities.invokeLater(() -> islandFrame.updateIsland());
    }

}

