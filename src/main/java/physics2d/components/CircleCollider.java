package physics2d.components;

import components.Component;

public class CircleCollider extends Component {
    private float radius = 1f;

    public float radius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }
}
