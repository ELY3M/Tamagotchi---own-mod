package org.anddev.andengine.extension.physics.box2d;

import com.badlogic.gdx.physics.box2d.Body;
import java.util.ArrayList;
import org.anddev.andengine.engine.handler.IUpdateHandler;
import org.anddev.andengine.entity.shape.IShape;

public class PhysicsConnectorManager extends ArrayList<PhysicsConnector> implements IUpdateHandler {
    private static final long serialVersionUID = 412969510084261799L;

    PhysicsConnectorManager() {
    }

    public void onUpdate(float pSecondsElapsed) {
        for (int i = size() - 1; i >= 0; i--) {
            ((PhysicsConnector) get(i)).onUpdate(pSecondsElapsed);
        }
    }

    public void reset() {
        for (int i = size() - 1; i >= 0; i--) {
            ((PhysicsConnector) get(i)).reset();
        }
    }

    public Body findBodyByShape(IShape pShape) {
        for (int i = size() - 1; i >= 0; i--) {
            PhysicsConnector physicsConnector = (PhysicsConnector) get(i);
            if (physicsConnector.mShape == pShape) {
                return physicsConnector.mBody;
            }
        }
        return null;
    }

    public PhysicsConnector findPhysicsConnectorByShape(IShape pShape) {
        for (int i = size() - 1; i >= 0; i--) {
            PhysicsConnector physicsConnector = (PhysicsConnector) get(i);
            if (physicsConnector.mShape == pShape) {
                return physicsConnector;
            }
        }
        return null;
    }
}
