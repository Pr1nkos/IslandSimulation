package animals.herbivores;

import animals.Animal;
import animals.behaviors.DefaultMovingBehavior;
import animals.behaviors.DefaultReproducingBehavior;
import animals.behaviors.HerbivoreEatingBehavior;

public class Goat extends Animal {
    public Goat() {
        super(60, 140, 3, 10,
                new HerbivoreEatingBehavior(),
                new DefaultMovingBehavior(),
                new DefaultReproducingBehavior());
    }
}