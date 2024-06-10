package animals.herbivores;

import animals.Animal;
import animals.behaviors.DefaultMovingBehavior;
import animals.behaviors.DefaultReproducingBehavior;
import animals.behaviors.HerbivoreEatingBehavior;


public class Sheep extends Animal {
    public Sheep() {
        super(70, 140, 3, 15,
                new HerbivoreEatingBehavior(),
                new DefaultMovingBehavior(),
                new DefaultReproducingBehavior());
    }
}