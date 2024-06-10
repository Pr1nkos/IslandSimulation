package animals.behaviors;

import animals.interfaces.MovingBehavior;

public class DefaultMovingBehavior implements MovingBehavior {
    @Override
    public void move() {
        System.out.println("Животное двигается");
    }
}
