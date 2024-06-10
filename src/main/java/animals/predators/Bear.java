package animals.predators;

import animals.Animal;
import animals.behaviors.CarnivoreEatingBehavior;
import animals.behaviors.DefaultMovingBehavior;
import animals.behaviors.DefaultReproducingBehavior;

public class Bear extends Animal {
    public Bear() {
        super(500, 5, 2, 80,
                new CarnivoreEatingBehavior(),
                new DefaultMovingBehavior(),
                new DefaultReproducingBehavior());
    }
}