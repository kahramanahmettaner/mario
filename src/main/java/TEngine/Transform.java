package TEngine;

import components.Component;
import editor.TImGui;
import org.joml.Vector2f;

public class Transform extends Component {
    
    public Vector2f position, scale;
    public float rotation = 0.0f;
    public int zIndex;

    public Transform() {
        init(new Vector2f(), new Vector2f());
    }

    public Transform(Vector2f position) {
        init(position, new Vector2f());
    }

    public Transform(Vector2f position, Vector2f scale) {
        init(position, scale);
    }

    public void init(Vector2f position, Vector2f scale) {
        this.position = position;
        this.scale = scale;
        this.zIndex = 0;
    }

    public Transform copy() {
        return new Transform(new Vector2f(this.position), new Vector2f(this.scale));
    }

    public void copy(Transform to) {
        to.position.set(this.position);
        to.scale.set(this.scale);
    }

    @Override
    public void imgui() {
        gameObject.name = TImGui.inputText("Name: ", gameObject.name);
        TImGui.drawVec2Control("Position", this.position);
        TImGui.drawVec2Control("Scale", this.scale, 32.0f);
        this.rotation = TImGui.dragFloat("Rotation", this.rotation);
        this.zIndex = TImGui.dragInt("Z-Index", this.zIndex);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(o instanceof Transform)) return false;

        Transform t = (Transform)o;
        return t.position.equals(this.position) && t.scale.equals(this.scale) && t.rotation == this.rotation && t.zIndex == this.zIndex;
    }
}
