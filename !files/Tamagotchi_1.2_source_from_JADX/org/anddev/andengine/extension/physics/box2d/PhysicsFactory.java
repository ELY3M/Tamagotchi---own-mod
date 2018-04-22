package org.anddev.andengine.extension.physics.box2d;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Filter;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import java.util.List;
import org.anddev.andengine.entity.primitive.Line;
import org.anddev.andengine.entity.shape.IShape;
import org.anddev.andengine.extension.physics.box2d.util.constants.PhysicsConstants;
import org.anddev.andengine.util.MathUtils;

public class PhysicsFactory {
    public static FixtureDef createFixtureDef(float pDensity, float pElasticity, float pFriction) {
        return createFixtureDef(pDensity, pElasticity, pFriction, false);
    }

    public static FixtureDef createFixtureDef(float pDensity, float pElasticity, float pFriction, boolean pSensor) {
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.density = pDensity;
        fixtureDef.restitution = pElasticity;
        fixtureDef.friction = pFriction;
        fixtureDef.isSensor = pSensor;
        return fixtureDef;
    }

    public static FixtureDef createFixtureDef(float pDensity, float pElasticity, float pFriction, boolean pSensor, short pCategoryBits, short pMaskBits, short pGroupIndex) {
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.density = pDensity;
        fixtureDef.restitution = pElasticity;
        fixtureDef.friction = pFriction;
        fixtureDef.isSensor = pSensor;
        Filter filter = fixtureDef.filter;
        filter.categoryBits = pCategoryBits;
        filter.maskBits = pMaskBits;
        filter.groupIndex = pGroupIndex;
        return fixtureDef;
    }

    public static Body createBoxBody(PhysicsWorld pPhysicsWorld, IShape pShape, BodyType pBodyType, FixtureDef pFixtureDef) {
        return createBoxBody(pPhysicsWorld, pShape, pBodyType, pFixtureDef, PhysicsConstants.PIXEL_TO_METER_RATIO_DEFAULT);
    }

    public static Body createBoxBody(PhysicsWorld pPhysicsWorld, IShape pShape, BodyType pBodyType, FixtureDef pFixtureDef, float pPixelToMeterRatio) {
        float[] sceneCenterCoordinates = pShape.getSceneCenterCoordinates();
        return createBoxBody(pPhysicsWorld, sceneCenterCoordinates[0], sceneCenterCoordinates[1], pShape.getWidthScaled(), pShape.getHeightScaled(), pShape.getRotation(), pBodyType, pFixtureDef, pPixelToMeterRatio);
    }

    public static Body createBoxBody(PhysicsWorld pPhysicsWorld, float pCenterX, float pCenterY, float pWidth, float pHeight, float pRotation, BodyType pBodyType, FixtureDef pFixtureDef) {
        return createBoxBody(pPhysicsWorld, pCenterX, pCenterY, pWidth, pHeight, pRotation, pBodyType, pFixtureDef, PhysicsConstants.PIXEL_TO_METER_RATIO_DEFAULT);
    }

    public static Body createBoxBody(PhysicsWorld pPhysicsWorld, float pCenterX, float pCenterY, float pWidth, float pHeight, float pRotation, BodyType pBodyType, FixtureDef pFixtureDef, float pPixelToMeterRatio) {
        BodyDef boxBodyDef = new BodyDef();
        boxBodyDef.type = pBodyType;
        boxBodyDef.position.f3x = pCenterX / pPixelToMeterRatio;
        boxBodyDef.position.f4y = pCenterY / pPixelToMeterRatio;
        Body boxBody = pPhysicsWorld.createBody(boxBodyDef);
        PolygonShape boxPoly = new PolygonShape();
        boxPoly.setAsBox((0.5f * pWidth) / pPixelToMeterRatio, (0.5f * pHeight) / pPixelToMeterRatio);
        pFixtureDef.shape = boxPoly;
        boxBody.createFixture(pFixtureDef);
        boxPoly.dispose();
        boxBody.setTransform(boxBody.getWorldCenter(), MathUtils.degToRad(pRotation));
        return boxBody;
    }

    public static Body createCircleBody(PhysicsWorld pPhysicsWorld, IShape pShape, BodyType pBodyType, FixtureDef pFixtureDef) {
        return createCircleBody(pPhysicsWorld, pShape, pBodyType, pFixtureDef, PhysicsConstants.PIXEL_TO_METER_RATIO_DEFAULT);
    }

    public static Body createCircleBody(PhysicsWorld pPhysicsWorld, IShape pShape, BodyType pBodyType, FixtureDef pFixtureDef, float pPixelToMeterRatio) {
        float[] sceneCenterCoordinates = pShape.getSceneCenterCoordinates();
        return createCircleBody(pPhysicsWorld, sceneCenterCoordinates[0], sceneCenterCoordinates[1], 0.5f * pShape.getWidthScaled(), pShape.getRotation(), pBodyType, pFixtureDef, pPixelToMeterRatio);
    }

    public static Body createCircleBody(PhysicsWorld pPhysicsWorld, float pCenterX, float pCenterY, float pRadius, float pRotation, BodyType pBodyType, FixtureDef pFixtureDef) {
        return createCircleBody(pPhysicsWorld, pCenterX, pCenterY, pRadius, pRotation, pBodyType, pFixtureDef, PhysicsConstants.PIXEL_TO_METER_RATIO_DEFAULT);
    }

    public static Body createCircleBody(PhysicsWorld pPhysicsWorld, float pCenterX, float pCenterY, float pRadius, float pRotation, BodyType pBodyType, FixtureDef pFixtureDef, float pPixelToMeterRatio) {
        BodyDef circleBodyDef = new BodyDef();
        circleBodyDef.type = pBodyType;
        circleBodyDef.position.f3x = pCenterX / pPixelToMeterRatio;
        circleBodyDef.position.f4y = pCenterY / pPixelToMeterRatio;
        circleBodyDef.angle = MathUtils.degToRad(pRotation);
        Body circleBody = pPhysicsWorld.createBody(circleBodyDef);
        CircleShape circlePoly = new CircleShape();
        pFixtureDef.shape = circlePoly;
        circlePoly.setRadius(pRadius / pPixelToMeterRatio);
        circleBody.createFixture(pFixtureDef);
        circlePoly.dispose();
        return circleBody;
    }

    public static Body createLineBody(PhysicsWorld pPhysicsWorld, Line pLine, FixtureDef pFixtureDef) {
        return createLineBody(pPhysicsWorld, pLine, pFixtureDef, PhysicsConstants.PIXEL_TO_METER_RATIO_DEFAULT);
    }

    public static Body createLineBody(PhysicsWorld pPhysicsWorld, Line pLine, FixtureDef pFixtureDef, float pPixelToMeterRatio) {
        BodyDef lineBodyDef = new BodyDef();
        lineBodyDef.type = BodyType.StaticBody;
        Body boxBody = pPhysicsWorld.createBody(lineBodyDef);
        PolygonShape linePoly = new PolygonShape();
        linePoly.setAsEdge(new Vector2(pLine.getX1() / pPixelToMeterRatio, pLine.getY1() / pPixelToMeterRatio), new Vector2(pLine.getX2() / pPixelToMeterRatio, pLine.getY2() / pPixelToMeterRatio));
        pFixtureDef.shape = linePoly;
        boxBody.createFixture(pFixtureDef);
        linePoly.dispose();
        return boxBody;
    }

    public static Body createPolygonBody(PhysicsWorld pPhysicsWorld, IShape pShape, Vector2[] pVertices, BodyType pBodyType, FixtureDef pFixtureDef) {
        return createPolygonBody(pPhysicsWorld, pShape, pVertices, pBodyType, pFixtureDef, PhysicsConstants.PIXEL_TO_METER_RATIO_DEFAULT);
    }

    public static Body createPolygonBody(PhysicsWorld pPhysicsWorld, IShape pShape, Vector2[] pVertices, BodyType pBodyType, FixtureDef pFixtureDef, float pPixelToMeterRatio) {
        BodyDef boxBodyDef = new BodyDef();
        boxBodyDef.type = pBodyType;
        float[] sceneCenterCoordinates = pShape.getSceneCenterCoordinates();
        boxBodyDef.position.f3x = sceneCenterCoordinates[0] / pPixelToMeterRatio;
        boxBodyDef.position.f4y = sceneCenterCoordinates[1] / pPixelToMeterRatio;
        Body boxBody = pPhysicsWorld.createBody(boxBodyDef);
        PolygonShape boxPoly = new PolygonShape();
        boxPoly.set(pVertices);
        pFixtureDef.shape = boxPoly;
        boxBody.createFixture(pFixtureDef);
        boxPoly.dispose();
        return boxBody;
    }

    public static Body createTrianglulatedBody(PhysicsWorld pPhysicsWorld, IShape pShape, List<Vector2> pTriangleVertices, BodyType pBodyType, FixtureDef pFixtureDef) {
        return createTrianglulatedBody(pPhysicsWorld, pShape, pTriangleVertices, pBodyType, pFixtureDef, PhysicsConstants.PIXEL_TO_METER_RATIO_DEFAULT);
    }

    public static Body createTrianglulatedBody(PhysicsWorld pPhysicsWorld, IShape pShape, List<Vector2> pTriangleVertices, BodyType pBodyType, FixtureDef pFixtureDef, float pPixelToMeterRatio) {
        Vector2[] TMP_TRIANGLE = new Vector2[3];
        BodyDef boxBodyDef = new BodyDef();
        boxBodyDef.type = pBodyType;
        float[] sceneCenterCoordinates = pShape.getSceneCenterCoordinates();
        boxBodyDef.position.f3x = sceneCenterCoordinates[0] / pPixelToMeterRatio;
        boxBodyDef.position.f4y = sceneCenterCoordinates[1] / pPixelToMeterRatio;
        Body boxBody = pPhysicsWorld.createBody(boxBodyDef);
        int vertexCount = pTriangleVertices.size();
        int i = 0;
        while (i < vertexCount) {
            PolygonShape boxPoly = new PolygonShape();
            int i2 = i + 1;
            TMP_TRIANGLE[2] = (Vector2) pTriangleVertices.get(i);
            i = i2 + 1;
            TMP_TRIANGLE[1] = (Vector2) pTriangleVertices.get(i2);
            i2 = i + 1;
            TMP_TRIANGLE[0] = (Vector2) pTriangleVertices.get(i);
            boxPoly.set(TMP_TRIANGLE);
            pFixtureDef.shape = boxPoly;
            boxBody.createFixture(pFixtureDef);
            boxPoly.dispose();
            i = i2;
        }
        return boxBody;
    }
}
