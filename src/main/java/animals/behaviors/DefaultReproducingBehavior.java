package animals.behaviors;

import animals.interfaces.ReproducingBehavior;

public class DefaultReproducingBehavior implements ReproducingBehavior {
    @Override
    public void reproduce() {
        System.out.println("Животное размножается");
    }
}
