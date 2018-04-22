package org.anddev.andengine.extension.physics.box2d.util.hull;

import com.badlogic.gdx.math.Vector2;

class Vector2Line {
    Vector2 mVertexA;
    Vector2 mVertexB;

    public Vector2Line(Vector2 pVertexA, Vector2 pVertexB) {
        this.mVertexA = pVertexA;
        this.mVertexB = pVertexB;
    }
}
