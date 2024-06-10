package animals.herbivores;

import animals.Animal;
import animals.behaviors.DefaultMovingBehavior;
import animals.behaviors.DefaultReproducingBehavior;
import animals.behaviors.HerbivoreEatingBehavior;

public class Duck extends Animal {
    public Duck() {
        super(1, 200, 4, 0.15,
                new HerbivoreEatingBehavior(),
                new DefaultMovingBehavior(),
                new DefaultReproducingBehavior());
    }
}
