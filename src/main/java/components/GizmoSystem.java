package components;

import TEngine.KeyListener;
import TEngine.Window;
import org.lwjgl.system.CallbackI;

import static org.lwjgl.glfw.GLFW.GLFW_KEY_E;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_R;

public class GizmoSystem extends Component {
    private static final int TRANSLATE_GIZMO = 0;
    private static final int SCALE_GIZMO = 1;

    private Spritesheet gizmos;
    private int usingGizmo = TRANSLATE_GIZMO;

    public GizmoSystem(Spritesheet gizmoSprites) {
        gizmos = gizmoSprites;
    }

    @Override
    public void start() {
        gameObject.addComponent(new TranslateGizmo(gizmos.getSprite(1), Window.getImGuiLayer().getPropertiesWindow()));
        gameObject.addComponent(new ScaleGizmo(gizmos.getSprite(2), Window.getImGuiLayer().getPropertiesWindow()));
    }

    @Override
    public void update(float dt) {
        if (usingGizmo == TRANSLATE_GIZMO) {
            gameObject.getComponent(TranslateGizmo.class).setUsing();
            gameObject.getComponent(ScaleGizmo.class).setNotUsing();
        } else if (usingGizmo == SCALE_GIZMO) {
            gameObject.getComponent(ScaleGizmo.class).setUsing();
            gameObject.getComponent(TranslateGizmo.class).setNotUsing();
        }

        if (KeyListener.isKeyPressed(GLFW_KEY_E)) {
            usingGizmo = TRANSLATE_GIZMO;
        } else if (KeyListener.isKeyPressed(GLFW_KEY_R)) {
            usingGizmo = SCALE_GIZMO;
        }

    }
}
