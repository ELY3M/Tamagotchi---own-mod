package org.anddev.andengine.opengl.buffer;

import java.util.ArrayList;
import java.util.HashSet;
import javax.microedition.khronos.opengles.GL11;

public class BufferObjectManager {
    private static BufferObjectManager mActiveInstance = null;
    private static final ArrayList<BufferObject> mBufferObjectsLoaded = new ArrayList();
    private static final HashSet<BufferObject> mBufferObjectsManaged = new HashSet();
    private static final ArrayList<BufferObject> mBufferObjectsToBeLoaded = new ArrayList();
    private static final ArrayList<BufferObject> mBufferObjectsToBeUnloaded = new ArrayList();

    public static BufferObjectManager getActiveInstance() {
        return mActiveInstance;
    }

    public static void setActiveInstance(BufferObjectManager pActiveInstance) {
        mActiveInstance = pActiveInstance;
    }

    public synchronized void clear() {
        mBufferObjectsToBeLoaded.clear();
        mBufferObjectsLoaded.clear();
        mBufferObjectsManaged.clear();
    }

    public synchronized void loadBufferObject(BufferObject pBufferObject) {
        if (pBufferObject != null) {
            if (mBufferObjectsManaged.contains(pBufferObject)) {
                mBufferObjectsToBeUnloaded.remove(pBufferObject);
            } else {
                mBufferObjectsManaged.add(pBufferObject);
                mBufferObjectsToBeLoaded.add(pBufferObject);
            }
        }
    }

    public synchronized void unloadBufferObject(BufferObject pBufferObject) {
        if (pBufferObject != null) {
            if (mBufferObjectsManaged.contains(pBufferObject)) {
                if (mBufferObjectsLoaded.contains(pBufferObject)) {
                    mBufferObjectsToBeUnloaded.add(pBufferObject);
                } else if (mBufferObjectsToBeLoaded.remove(pBufferObject)) {
                    mBufferObjectsManaged.remove(pBufferObject);
                }
            }
        }
    }

    public void loadBufferObjects(BufferObject... pBufferObjects) {
        for (int i = pBufferObjects.length - 1; i >= 0; i--) {
            loadBufferObject(pBufferObjects[i]);
        }
    }

    public void unloadBufferObjects(BufferObject... pBufferObjects) {
        for (int i = pBufferObjects.length - 1; i >= 0; i--) {
            unloadBufferObject(pBufferObjects[i]);
        }
    }

    public synchronized void reloadBufferObjects() {
        ArrayList<BufferObject> loadedBufferObjects = mBufferObjectsLoaded;
        for (int i = loadedBufferObjects.size() - 1; i >= 0; i--) {
            ((BufferObject) loadedBufferObjects.get(i)).setLoadedToHardware(false);
        }
        mBufferObjectsToBeLoaded.addAll(loadedBufferObjects);
        loadedBufferObjects.clear();
    }

    public synchronized void updateBufferObjects(GL11 pGL11) {
        int i;
        HashSet<BufferObject> bufferObjectsManaged = mBufferObjectsManaged;
        ArrayList<BufferObject> bufferObjectsLoaded = mBufferObjectsLoaded;
        ArrayList<BufferObject> bufferObjectsToBeLoaded = mBufferObjectsToBeLoaded;
        ArrayList<BufferObject> bufferObjectsToBeUnloaded = mBufferObjectsToBeUnloaded;
        int bufferObjectToBeLoadedCount = bufferObjectsToBeLoaded.size();
        if (bufferObjectToBeLoadedCount > 0) {
            for (i = bufferObjectToBeLoadedCount - 1; i >= 0; i--) {
                BufferObject bufferObjectToBeLoaded = (BufferObject) bufferObjectsToBeLoaded.get(i);
                if (!bufferObjectToBeLoaded.isLoadedToHardware()) {
                    bufferObjectToBeLoaded.loadToHardware(pGL11);
                    bufferObjectToBeLoaded.setHardwareBufferNeedsUpdate();
                }
                bufferObjectsLoaded.add(bufferObjectToBeLoaded);
            }
            bufferObjectsToBeLoaded.clear();
        }
        int bufferObjectsToBeUnloadedCount = bufferObjectsToBeUnloaded.size();
        if (bufferObjectsToBeUnloadedCount > 0) {
            for (i = bufferObjectsToBeUnloadedCount - 1; i >= 0; i--) {
                BufferObject bufferObjectToBeUnloaded = (BufferObject) bufferObjectsToBeUnloaded.remove(i);
                if (bufferObjectToBeUnloaded.isLoadedToHardware()) {
                    bufferObjectToBeUnloaded.unloadFromHardware(pGL11);
                }
                bufferObjectsLoaded.remove(bufferObjectToBeUnloaded);
                bufferObjectsManaged.remove(bufferObjectToBeUnloaded);
            }
        }
    }
}
