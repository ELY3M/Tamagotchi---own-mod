package org.anddev.andengine.entity.modifier;

import android.util.FloatMath;
import org.anddev.andengine.entity.IEntity;
import org.anddev.andengine.entity.modifier.IEntityModifier.IEntityModifierListener;
import org.anddev.andengine.util.modifier.IModifier;
import org.anddev.andengine.util.modifier.IModifier.DeepCopyNotSupportedException;
import org.anddev.andengine.util.modifier.SequenceModifier;
import org.anddev.andengine.util.modifier.SequenceModifier.ISubSequenceModifierListener;
import org.anddev.andengine.util.modifier.ease.IEaseFunction;

public class PathModifier extends EntityModifier {
    private final Path mPath;
    private IPathModifierListener mPathModifierListener;
    private final SequenceModifier<IEntity> mSequenceModifier;

    public interface IPathModifierListener {
        void onPathFinished(PathModifier pathModifier, IEntity iEntity);

        void onPathStarted(PathModifier pathModifier, IEntity iEntity);

        void onPathWaypointFinished(PathModifier pathModifier, IEntity iEntity, int i);

        void onPathWaypointStarted(PathModifier pathModifier, IEntity iEntity, int i);
    }

    public static class Path {
        private final float[] mCoordinatesX;
        private final float[] mCoordinatesY;
        private int mIndex;
        private float mLength;
        private boolean mLengthChanged = false;

        public Path(int pLength) {
            this.mCoordinatesX = new float[pLength];
            this.mCoordinatesY = new float[pLength];
            this.mIndex = 0;
            this.mLengthChanged = false;
        }

        public Path(float[] pCoordinatesX, float[] pCoordinatesY) throws IllegalArgumentException {
            if (pCoordinatesX.length != pCoordinatesY.length) {
                throw new IllegalArgumentException("Coordinate-Arrays must have the same length.");
            }
            this.mCoordinatesX = pCoordinatesX;
            this.mCoordinatesY = pCoordinatesY;
            this.mIndex = pCoordinatesX.length;
            this.mLengthChanged = true;
        }

        public Path(Path pPath) {
            int size = pPath.getSize();
            this.mCoordinatesX = new float[size];
            this.mCoordinatesY = new float[size];
            System.arraycopy(pPath.mCoordinatesX, 0, this.mCoordinatesX, 0, size);
            System.arraycopy(pPath.mCoordinatesY, 0, this.mCoordinatesY, 0, size);
            this.mIndex = pPath.mIndex;
            this.mLengthChanged = pPath.mLengthChanged;
            this.mLength = pPath.mLength;
        }

        public Path deepCopy() {
            return new Path(this);
        }

        public Path to(float pX, float pY) {
            this.mCoordinatesX[this.mIndex] = pX;
            this.mCoordinatesY[this.mIndex] = pY;
            this.mIndex++;
            this.mLengthChanged = true;
            return this;
        }

        public float[] getCoordinatesX() {
            return this.mCoordinatesX;
        }

        public float[] getCoordinatesY() {
            return this.mCoordinatesY;
        }

        public int getSize() {
            return this.mCoordinatesX.length;
        }

        public float getLength() {
            if (this.mLengthChanged) {
                updateLength();
            }
            return this.mLength;
        }

        public float getSegmentLength(int pSegmentIndex) {
            float[] coordinatesX = this.mCoordinatesX;
            float[] coordinatesY = this.mCoordinatesY;
            int nextSegmentIndex = pSegmentIndex + 1;
            float dx = coordinatesX[pSegmentIndex] - coordinatesX[nextSegmentIndex];
            float dy = coordinatesY[pSegmentIndex] - coordinatesY[nextSegmentIndex];
            return FloatMath.sqrt((dx * dx) + (dy * dy));
        }

        private void updateLength() {
            float length = 0.0f;
            for (int i = this.mIndex - 2; i >= 0; i--) {
                length += getSegmentLength(i);
            }
            this.mLength = length;
        }
    }

    class C09131 implements ISubSequenceModifierListener<IEntity> {
        C09131() {
        }

        public void onSubSequenceStarted(IModifier<IEntity> iModifier, IEntity pEntity, int pIndex) {
            if (PathModifier.this.mPathModifierListener != null) {
                PathModifier.this.mPathModifierListener.onPathWaypointStarted(PathModifier.this, pEntity, pIndex);
            }
        }

        public void onSubSequenceFinished(IModifier<IEntity> iModifier, IEntity pEntity, int pIndex) {
            if (PathModifier.this.mPathModifierListener != null) {
                PathModifier.this.mPathModifierListener.onPathWaypointFinished(PathModifier.this, pEntity, pIndex);
            }
        }
    }

    class C10492 implements IEntityModifierListener {
        C10492() {
        }

        public void onModifierStarted(IModifier<IEntity> iModifier, IEntity pEntity) {
            PathModifier.this.onModifierStarted(pEntity);
            if (PathModifier.this.mPathModifierListener != null) {
                PathModifier.this.mPathModifierListener.onPathStarted(PathModifier.this, pEntity);
            }
        }

        public void onModifierFinished(IModifier<IEntity> iModifier, IEntity pEntity) {
            PathModifier.this.onModifierFinished(pEntity);
            if (PathModifier.this.mPathModifierListener != null) {
                PathModifier.this.mPathModifierListener.onPathFinished(PathModifier.this, pEntity);
            }
        }
    }

    public PathModifier(float pDuration, Path pPath) {
        this(pDuration, pPath, null, null, IEaseFunction.DEFAULT);
    }

    public PathModifier(float pDuration, Path pPath, IEaseFunction pEaseFunction) {
        this(pDuration, pPath, null, null, pEaseFunction);
    }

    public PathModifier(float pDuration, Path pPath, IEntityModifierListener pEntityModiferListener) {
        this(pDuration, pPath, pEntityModiferListener, null, IEaseFunction.DEFAULT);
    }

    public PathModifier(float pDuration, Path pPath, IPathModifierListener pPathModifierListener) {
        this(pDuration, pPath, null, pPathModifierListener, IEaseFunction.DEFAULT);
    }

    public PathModifier(float pDuration, Path pPath, IPathModifierListener pPathModifierListener, IEaseFunction pEaseFunction) {
        this(pDuration, pPath, null, pPathModifierListener, pEaseFunction);
    }

    public PathModifier(float pDuration, Path pPath, IEntityModifierListener pEntityModiferListener, IEaseFunction pEaseFunction) {
        this(pDuration, pPath, pEntityModiferListener, null, pEaseFunction);
    }

    public PathModifier(float pDuration, Path pPath, IEntityModifierListener pEntityModiferListener, IPathModifierListener pPathModifierListener) throws IllegalArgumentException {
        this(pDuration, pPath, pEntityModiferListener, pPathModifierListener, IEaseFunction.DEFAULT);
    }

    public PathModifier(float pDuration, Path pPath, IEntityModifierListener pEntityModiferListener, IPathModifierListener pPathModifierListener, IEaseFunction pEaseFunction) throws IllegalArgumentException {
        super(pEntityModiferListener);
        int pathSize = pPath.getSize();
        if (pathSize < 2) {
            throw new IllegalArgumentException("Path needs at least 2 waypoints!");
        }
        this.mPath = pPath;
        this.mPathModifierListener = pPathModifierListener;
        MoveModifier[] moveModifiers = new MoveModifier[(pathSize - 1)];
        float[] coordinatesX = pPath.getCoordinatesX();
        float[] coordinatesY = pPath.getCoordinatesY();
        float velocity = pPath.getLength() / pDuration;
        int modifierCount = moveModifiers.length;
        for (int i = 0; i < modifierCount; i++) {
            moveModifiers[i] = new MoveModifier(pPath.getSegmentLength(i) / velocity, coordinatesX[i], coordinatesX[i + 1], coordinatesY[i], coordinatesY[i + 1], null, pEaseFunction);
        }
        this.mSequenceModifier = new SequenceModifier(new C09131(), new C10492(), moveModifiers);
    }

    protected PathModifier(PathModifier pPathModifier) throws DeepCopyNotSupportedException {
        this.mPath = pPathModifier.mPath.deepCopy();
        this.mSequenceModifier = pPathModifier.mSequenceModifier.deepCopy();
    }

    public PathModifier deepCopy() throws DeepCopyNotSupportedException {
        return new PathModifier(this);
    }

    public Path getPath() {
        return this.mPath;
    }

    public boolean isFinished() {
        return this.mSequenceModifier.isFinished();
    }

    public float getSecondsElapsed() {
        return this.mSequenceModifier.getSecondsElapsed();
    }

    public float getDuration() {
        return this.mSequenceModifier.getDuration();
    }

    public IPathModifierListener getPathModifierListener() {
        return this.mPathModifierListener;
    }

    public void setPathModifierListener(IPathModifierListener pPathModifierListener) {
        this.mPathModifierListener = pPathModifierListener;
    }

    public void reset() {
        this.mSequenceModifier.reset();
    }

    public float onUpdate(float pSecondsElapsed, IEntity pEntity) {
        return this.mSequenceModifier.onUpdate(pSecondsElapsed, pEntity);
    }
}
