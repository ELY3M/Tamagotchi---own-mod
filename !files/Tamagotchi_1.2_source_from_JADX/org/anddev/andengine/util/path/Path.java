package org.anddev.andengine.util.path;

import java.util.ArrayList;

public class Path {
    private final ArrayList<Step> mSteps = new ArrayList();

    public class Step {
        private final int mTileColumn;
        private final int mTileRow;

        public Step(int pTileColumn, int pTileRow) {
            this.mTileColumn = pTileColumn;
            this.mTileRow = pTileRow;
        }

        public int getTileColumn() {
            return this.mTileColumn;
        }

        public int getTileRow() {
            return this.mTileRow;
        }

        public int hashCode() {
            return this.mTileColumn << (this.mTileRow + 16);
        }

        public boolean equals(Object pOther) {
            if (this == pOther) {
                return true;
            }
            if (pOther == null) {
                return false;
            }
            if (getClass() != pOther.getClass()) {
                return false;
            }
            Step other = (Step) pOther;
            if (this.mTileColumn != other.mTileColumn) {
                return false;
            }
            if (this.mTileRow != other.mTileRow) {
                return false;
            }
            return true;
        }
    }

    public int getLength() {
        return this.mSteps.size();
    }

    public Step getStep(int pIndex) {
        return (Step) this.mSteps.get(pIndex);
    }

    public Direction getDirectionToPreviousStep(int pIndex) {
        if (pIndex == 0) {
            return null;
        }
        return Direction.fromDelta(getTileColumn(pIndex - 1) - getTileColumn(pIndex), getTileRow(pIndex - 1) - getTileRow(pIndex));
    }

    public Direction getDirectionToNextStep(int pIndex) {
        if (pIndex == getLength() - 1) {
            return null;
        }
        return Direction.fromDelta(getTileColumn(pIndex + 1) - getTileColumn(pIndex), getTileRow(pIndex + 1) - getTileRow(pIndex));
    }

    public int getTileColumn(int pIndex) {
        return getStep(pIndex).getTileColumn();
    }

    public int getTileRow(int pIndex) {
        return getStep(pIndex).getTileRow();
    }

    public void append(int pTileColumn, int pTileRow) {
        append(new Step(pTileColumn, pTileRow));
    }

    public void append(Step pStep) {
        this.mSteps.add(pStep);
    }

    public void prepend(int pTileColumn, int pTileRow) {
        prepend(new Step(pTileColumn, pTileRow));
    }

    public void prepend(Step pStep) {
        this.mSteps.add(0, pStep);
    }

    public boolean contains(int pTileColumn, int pTileRow) {
        ArrayList<Step> steps = this.mSteps;
        for (int i = steps.size() - 1; i >= 0; i--) {
            Step step = (Step) steps.get(i);
            if (step.getTileColumn() == pTileColumn && step.getTileRow() == pTileRow) {
                return true;
            }
        }
        return false;
    }

    public int getFromTileRow() {
        return getTileRow(0);
    }

    public int getFromTileColumn() {
        return getTileColumn(0);
    }

    public int getToTileRow() {
        return getTileRow(this.mSteps.size() - 1);
    }

    public int getToTileColumn() {
        return getTileColumn(this.mSteps.size() - 1);
    }
}
