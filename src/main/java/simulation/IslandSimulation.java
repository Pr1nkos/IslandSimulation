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

public class IslandSimulation {
    private final Logger logger = LoggerFactory.getLogger(IslandSimulation.class);
    private final Logger animalLogger = LoggerFactory.getLogger(Animal.class);
    private final Island island;
    private final AnimalFactory animalFactory = new AnimalFactory();
    private int simulationCount = 0;

    public IslandSimulation(int width, int height) {
        this.island = new Island(width, height);
        initializeAnimals();
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

    @SneakyThrows
    public void printIsland() {
        for (int y = 0; y < island.getHeight(); y++) {
            for (int x = 0; x < island.getWidth(); x++) {
                Location location = island.getLocation(x, y);
                if (location.getAnimals().isEmpty()) {
                    System.out.print("◻️"); // Пустая клетка
                }
                else {
                    // Проверяем типы животных в ячейке и выводим соответствующий символ Unicode
                    // Хищники
                    boolean hasBear = location.getAnimals().stream().anyMatch(Bear.class::isInstance);
                    boolean hasBoa = location.getAnimals().stream().anyMatch(Boa.class::isInstance);
                    boolean hasEagle = location.getAnimals().stream().anyMatch(Eagle.class::isInstance);
                    boolean hasFox = location.getAnimals().stream().anyMatch(Fox.class::isInstance);
                    boolean hasWolf = location.getAnimals().stream().anyMatch(Wolf.class::isInstance);

                    //Травоядные
                    boolean hasBoar = location.getAnimals().stream().anyMatch(Boar.class::isInstance);
                    boolean hasBuffalo = location.getAnimals().stream().anyMatch(Buffalo.class::isInstance);
                    boolean hasCaterpillar = location.getAnimals().stream().anyMatch(Caterpillar.class::isInstance);
                    boolean hasDeer = location.getAnimals().stream().anyMatch(Deer.class::isInstance);
                    boolean hasDuck = location.getAnimals().stream().anyMatch(Duck.class::isInstance);
                    boolean hasGoat = location.getAnimals().stream().anyMatch(Goat.class::isInstance);
                    boolean hasHorse = location.getAnimals().stream().anyMatch(Horse.class::isInstance);
                    boolean hasMouse = location.getAnimals().stream().anyMatch(Mouse.class::isInstance);
                    boolean hasRabbit = location.getAnimals().stream().anyMatch(Rabbit.class::isInstance);
                    boolean hasSheep = location.getAnimals().stream().anyMatch(Sheep.class::isInstance);
                    if (hasBear) System.out.print("🐻");
                    else if (hasBoa) System.out.print("🐍");
                    else if (hasEagle) System.out.print("🦅");
                    else if (hasFox) System.out.print("🦊");
                    else if (hasWolf) System.out.print("🐺");
                    else if (hasBoar) System.out.print("🐗");
                    else if (hasBuffalo) System.out.print("🐃");
                    else if (hasCaterpillar) System.out.print("🐛");
                    else if (hasDeer) System.out.print("🦌");
                    else if (hasDuck) System.out.print("🦆");
                    else if (hasGoat) System.out.print("🐐");
                    else if (hasHorse) System.out.print("🐎");
                    else if (hasMouse) System.out.print("🐁");
                    else if (hasRabbit) System.out.print("🐇");
                    else if (hasSheep) System.out.print("🐑");
                }
            }
            System.out.println();
        }
        simulationCount++;
        System.out.println();
        System.out.println("Симуляция номер: " + simulationCount);
        System.out.println();
    }

    public void updateIsland() {
        Random rand = new Random();

        // Получаем все ячейки острова
        Location[][] locations = island.getLocations();

        // Обновляем координаты всех животных
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

        // Печатаем обновленное состояние острова
        printIsland();
    }

}

