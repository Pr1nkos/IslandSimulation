package animals;



import animals.interfaces.EatingBehavior;
import animals.interfaces.MovingBehavior;
import animals.interfaces.ReproducingBehavior;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Random;

@RequiredArgsConstructor
@Data
public abstract class Animal implements EatingBehavior, MovingBehavior, ReproducingBehavior {
    protected double weight;
    protected int maxCountPerLocation;
    protected int maxSpeed;
    protected double foodNeeded;

    protected EatingBehavior eatingBehavior;
    protected MovingBehavior movingBehavior;
    protected ReproducingBehavior reproducingBehavior;

    protected Animal(double baseWeight, int baseMaxCountPerLocation, int baseMaxSpeed, double baseFoodNeeded,
                     EatingBehavior eatingBehavior, MovingBehavior movingBehavior, ReproducingBehavior reproducingBehavior) {
        Random random = new Random();
        this.weight = baseWeight + (random.nextDouble() * 10 - 5); // Случайное отклонение ±5
        this.maxCountPerLocation = baseMaxCountPerLocation;
        this.maxSpeed = baseMaxSpeed + random.nextInt(3) - 1; // Случайное отклонение ±1
        this.foodNeeded = baseFoodNeeded + (random.nextDouble() * 2 - 1); // Случайное отклонение ±1
        this.eatingBehavior = eatingBehavior;
        this.movingBehavior = movingBehavior;
        this.reproducingBehavior = reproducingBehavior;
    }

    public void eat(Animal predator, Animal prey) {
        eatingBehavior.eat(this, prey);
    }

    public void move() {
        movingBehavior.move();
    }

    public void reproduce() {
        reproducingBehavior.reproduce();
    }
}
