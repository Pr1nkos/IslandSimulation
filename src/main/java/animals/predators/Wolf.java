package animals.predators;
import animals.Animal;
import animals.behaviors.CarnivoreEatingBehavior;
import animals.behaviors.DefaultMovingBehavior;
import animals.behaviors.DefaultReproducingBehavior;

public class Wolf extends Animal {
    public Wolf() {
        super(50, 30, 3, 8,
                new CarnivoreEatingBehavior(),
                new DefaultMovingBehavior(),
                new DefaultReproducingBehavior());
    }
}