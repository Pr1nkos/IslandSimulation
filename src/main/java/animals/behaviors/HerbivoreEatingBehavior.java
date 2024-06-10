package animals.behaviors;

import animals.Animal;
import animals.interfaces.EatingBehavior;

public class HerbivoreEatingBehavior implements EatingBehavior {
    @Override
    public void eat(Animal predator, Animal prey) {
        System.out.println(predator.getClass().getSimpleName() + " ест растения");
    }
}
