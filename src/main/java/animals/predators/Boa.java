package animals.predators;

import animals.Animal;
import animals.behaviors.CarnivoreEatingBehavior;
import animals.behaviors.DefaultMovingBehavior;
import animals.behaviors.DefaultReproducingBehavior;

public class Boa extends Animal {
    public Boa() {
        super(15, 30, 1, 3,
                new CarnivoreEatingBehavior(),
                new DefaultMovingBehavior(),
                new DefaultReproducingBehavior());
    }
}
