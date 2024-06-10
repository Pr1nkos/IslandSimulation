package animals.herbivores;

import animals.Animal;
import animals.behaviors.DefaultMovingBehavior;
import animals.behaviors.DefaultReproducingBehavior;
import animals.behaviors.HerbivoreEatingBehavior;

public class Mouse extends Animal {
    public Mouse() {
        super(0.05, 500, 1, 0.01,
                new HerbivoreEatingBehavior(),
                new DefaultMovingBehavior(),
                new DefaultReproducingBehavior());
    }
}