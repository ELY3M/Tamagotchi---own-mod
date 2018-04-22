package org.anddev.andengine.level;

import java.util.HashMap;
import org.anddev.andengine.level.LevelLoader.IEntityLoader;
import org.anddev.andengine.level.util.constants.LevelConstants;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class LevelParser extends DefaultHandler implements LevelConstants {
    private final IEntityLoader mDefaultEntityLoader;
    private final HashMap<String, IEntityLoader> mEntityLoaders;

    public LevelParser(IEntityLoader pDefaultEntityLoader, HashMap<String, IEntityLoader> pEntityLoaders) {
        this.mDefaultEntityLoader = pDefaultEntityLoader;
        this.mEntityLoaders = pEntityLoaders;
    }

    public void startElement(String pUri, String pLocalName, String pQualifiedName, Attributes pAttributes) throws SAXException {
        IEntityLoader entityLoader = (IEntityLoader) this.mEntityLoaders.get(pLocalName);
        if (entityLoader != null) {
            entityLoader.onLoadEntity(pLocalName, pAttributes);
        } else if (this.mDefaultEntityLoader != null) {
            this.mDefaultEntityLoader.onLoadEntity(pLocalName, pAttributes);
        } else {
            throw new IllegalArgumentException("Unexpected tag: '" + pLocalName + "'.");
        }
    }
}
