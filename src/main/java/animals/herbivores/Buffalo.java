package animals.herbivores;

import animals.Animal;
import animals.behaviors.DefaultMovingBehavior;
import animals.behaviors.DefaultReproducingBehavior;
import animals.behaviors.HerbivoreEatingBehavior;

public class Buffalo extends Animal {
    public Buffalo() {
        super(700, 10, 3, 100,
                new HerbivoreEatingBehavior(),
                new DefaultMovingBehavior(),
                new DefaultReproducingBehavior());
    }
}