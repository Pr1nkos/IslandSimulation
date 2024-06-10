package animals.predators;

import animals.Animal;
import animals.behaviors.CarnivoreEatingBehavior;
import animals.behaviors.DefaultMovingBehavior;
import animals.behaviors.DefaultReproducingBehavior;


public class Eagle extends Animal {
    public Eagle() {
        super(6, 20, 3, 1,
                new CarnivoreEatingBehavior(),
                new DefaultMovingBehavior(),
                new DefaultReproducingBehavior());
    }
}