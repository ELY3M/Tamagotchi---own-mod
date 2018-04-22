package com.badlogic.gdx.physics.box2d;

public class JointDef {
    public Body bodyA = null;
    public Body bodyB = null;
    public boolean collideConnected = false;
    public JointType type = JointType.Unknown;

    public enum JointType {
        Unknown(0),
        RevoluteJoint(1),
        PrismaticJoint(2),
        DistanceJoint(3),
        PulleyJoint(4),
        MouseJoint(5),
        GearJoint(6),
        LineJoint(7),
        WeldJoint(8),
        FrictionJoint(9);
        
        public static JointType[] valueTypes;
        private int value;

        static {
            valueTypes = new JointType[]{Unknown, RevoluteJoint, PrismaticJoint, DistanceJoint, PulleyJoint, MouseJoint, GearJoint, LineJoint, WeldJoint, FrictionJoint};
        }

        private JointType(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }
}
