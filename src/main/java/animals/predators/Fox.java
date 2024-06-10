package animals.predators;

import animals.Animal;
import animals.behaviors.CarnivoreEatingBehavior;
import animals.behaviors.DefaultMovingBehavior;
import animals.behaviors.DefaultReproducingBehavior;

public class Fox extends Animal {
    public Fox() {
        super(8, 30, 2, 2,
                new CarnivoreEatingBehavior(),
                new DefaultMovingBehavior(),
                new DefaultReproducingBehavior());
    }
}
