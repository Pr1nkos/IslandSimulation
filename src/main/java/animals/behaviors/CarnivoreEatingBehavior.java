package animals.behaviors;

import animals.Animal;
import animals.interfaces.EatingBehavior;

public class CarnivoreEatingBehavior implements EatingBehavior {
    @Override
    public void eat(Animal predator, Animal prey) {
        System.out.println(predator.getClass().getSimpleName() + " съедает" + prey.getClass().getSimpleName());
    }
}
