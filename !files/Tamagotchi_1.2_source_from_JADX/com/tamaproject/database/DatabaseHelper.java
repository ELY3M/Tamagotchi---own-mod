package com.tamaproject.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import com.google.android.gms.plus.PlusShare;
import com.tamaproject.entity.Item;
import com.tamaproject.entity.Tamagotchi;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.anddev.andengine.entity.layer.tiled.tmx.util.constants.TMXConstants;
import org.anddev.andengine.opengl.texture.region.TextureRegion;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static String DB_NAME = "tamagotchi";
    private static String DB_PATH = "/data/data/com.tamaproject/databases/";
    private final Context context;
    private SQLiteDatabase db;

    public DatabaseHelper(Context ctx) throws IOException {
        super(ctx, DB_NAME, null, 1);
        this.context = ctx;
    }

    public static void createDatabaseIfNotExists(Context context) throws IOException {
        boolean createDb = false;
        File dbDir = new File(DB_PATH);
        File dbFile = new File(DB_PATH + DB_NAME);
        if (!dbDir.exists()) {
            dbDir.mkdir();
            createDb = true;
        } else if (!dbFile.exists()) {
            createDb = true;
        } else if (false) {
            dbFile.delete();
            createDb = true;
        }
        if (createDb) {
            System.out.println("Database not found, copying from assets...");
            InputStream myInput = context.getAssets().open(DB_NAME);
            OutputStream myOutput = new FileOutputStream(dbFile);
            byte[] buffer = new byte[1024];
            while (true) {
                int length = myInput.read(buffer);
                if (length > 0) {
                    myOutput.write(buffer, 0, length);
                } else {
                    myOutput.flush();
                    myOutput.close();
                    myInput.close();
                    return;
                }
            }
        }
    }

    public static SQLiteDatabase getStaticDb() {
        return SQLiteDatabase.openDatabase(DB_PATH + DB_NAME, null, 1);
    }

    public void openDatabase() throws SQLiteException {
        this.db = SQLiteDatabase.openDatabase(DB_PATH + DB_NAME, null, 0);
    }

    public synchronized void close() {
        if (this.db != null) {
            this.db.close();
        }
        super.close();
    }

    public void onCreate(SQLiteDatabase db) {
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public long insertTama(Tamagotchi t) {
        System.out.println("Insert Tama");
        ContentValues initialValues = new ContentValues();
        initialValues.put("_id", Integer.valueOf(t.getID()));
        initialValues.put("curHealth", Integer.valueOf(t.getCurrentHealth()));
        initialValues.put("maxHealth", Integer.valueOf(t.getMaxHealth()));
        initialValues.put("curHunger", Integer.valueOf(t.getCurrentHunger()));
        initialValues.put("maxHunger", Integer.valueOf(t.getMaxHunger()));
        initialValues.put("curXP", Integer.valueOf(t.getCurrentXP()));
        initialValues.put("maxXP", Integer.valueOf(t.getMaxXP()));
        initialValues.put("curSickness", Integer.valueOf(t.getCurrentSickness()));
        initialValues.put("maxSickness", Integer.valueOf(t.getMaxSickness()));
        initialValues.put("battleLevel", Integer.valueOf(t.getBattleLevel()));
        initialValues.put("status", Integer.valueOf(t.getStatus()));
        initialValues.put("birthday", Long.valueOf(t.getBirthday()));
        initialValues.put("equippedItem", t.getEquippedItemName());
        initialValues.put("age", Long.valueOf(t.getAge()));
        initialValues.put("money", Integer.valueOf(t.getMoney()));
        long success = this.db.insert("Tamagotchi", null, initialValues);
        if (success < 0) {
            return (long) saveTama(t);
        }
        return success;
    }

    public int saveTama(Tamagotchi t) {
        System.out.println("Save Tama");
        ContentValues args = new ContentValues();
        args.put("_id", Integer.valueOf(t.getID()));
        args.put("curHealth", Integer.valueOf(t.getCurrentHealth()));
        args.put("maxHealth", Integer.valueOf(t.getMaxHealth()));
        args.put("curHunger", Integer.valueOf(t.getCurrentHunger()));
        args.put("maxHunger", Integer.valueOf(t.getMaxHunger()));
        args.put("curXP", Integer.valueOf(t.getCurrentXP()));
        args.put("maxXP", Integer.valueOf(t.getMaxXP()));
        args.put("curSickness", Integer.valueOf(t.getCurrentSickness()));
        args.put("maxSickness", Integer.valueOf(t.getMaxSickness()));
        args.put("battleLevel", Integer.valueOf(t.getBattleLevel()));
        args.put("status", Integer.valueOf(t.getStatus()));
        args.put("birthday", Long.valueOf(t.getBirthday()));
        args.put("equippedItem", t.getEquippedItemName());
        args.put("age", Long.valueOf(t.getAge()));
        args.put("money", Integer.valueOf(t.getMoney()));
        return this.db.update("Tamagotchi", args, "_id = " + t.getID(), null);
    }

    public int saveMoney(int money, int id) {
        System.out.println("Save Money");
        ContentValues args = new ContentValues();
        args.put("money", Integer.valueOf(money));
        return this.db.update("Tamagotchi", args, "_id =" + id, null);
    }

    public int loadMoney(int id) {
        try {
            Cursor c = this.db.rawQuery("Select money from Tamagotchi where _id = " + id, null);
            if (c != null) {
                c.moveToFirst();
            }
            return c.getInt(c.getColumnIndex("money"));
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public Tamagotchi loadTama(int id, Hashtable<String, TextureRegion> table) {
        try {
            Cursor c = this.db.rawQuery("Select * from Tamagotchi where _id = " + id, null);
            if (c != null) {
                c.moveToFirst();
            }
            int curHealth = c.getInt(c.getColumnIndex("curHealth"));
            int maxHealth = c.getInt(c.getColumnIndex("maxHealth"));
            int curHunger = c.getInt(c.getColumnIndex("curHunger"));
            int maxHunger = c.getInt(c.getColumnIndex("maxHunger"));
            int curXP = c.getInt(c.getColumnIndex("curXP"));
            int maxXP = c.getInt(c.getColumnIndex("maxXP"));
            int curSickness = c.getInt(c.getColumnIndex("curSickness"));
            int maxSickness = c.getInt(c.getColumnIndex("maxSickness"));
            int battleLevel = c.getInt(c.getColumnIndex("battleLevel"));
            int status = c.getInt(c.getColumnIndex("status"));
            long birthday = c.getLong(c.getColumnIndex("birthday"));
            long age = c.getLong(c.getColumnIndex("age"));
            int money = c.getInt(c.getColumnIndex("money"));
            Item equippedItem = null;
            if ("None".equals(c.getString(c.getColumnIndex("equippedItem")))) {
                return new Tamagotchi(curHealth, maxHealth, curHunger, maxHunger, curXP, maxXP, curSickness, maxSickness, battleLevel, status, birthday, null, age, id, money);
            }
            Cursor c2 = this.db.rawQuery("Select _id, itemName, health, hunger, sickness, xp, protection, type, description FROM Items where itemName = '" + c.getString(c.getColumnIndex("equippedItem")) + "'", null);
            Cursor c3 = this.db.rawQuery("Select itemName, filename from Filenames where itemName = '" + c.getString(c.getColumnIndex("equippedItem")) + "'", null);
            if (!(c2 == null || c3 == null)) {
                c2.moveToFirst();
                c3.moveToFirst();
                String equippedItemName = c2.getString(c2.getColumnIndex("itemName"));
                int health = c2.getInt(c2.getColumnIndex("health"));
                int hunger = c2.getInt(c2.getColumnIndex("hunger"));
                int sickness = c2.getInt(c2.getColumnIndex("sickness"));
                int xp = c2.getInt(c2.getColumnIndex("xp"));
                int protection = c2.getInt(c2.getColumnIndex("protection"));
                int type = c2.getInt(c2.getColumnIndex(TMXConstants.TAG_OBJECT_ATTRIBUTE_TYPE));
                equippedItem = new Item(0.0f, 0.0f, (TextureRegion) table.get(c3.getString(c3.getColumnIndex("filename"))), equippedItemName, c2.getString(c2.getColumnIndex(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION)), health, hunger, sickness, xp, type, protection);
            }
            return new Tamagotchi(curHealth, maxHealth, curHunger, maxHunger, curXP, maxXP, curSickness, maxSickness, battleLevel, status, birthday, equippedItem, age, id, money);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public long insertBackpack(List<Item> item) {
        Map<String, Integer> table = new HashMap();
        for (int i = 0; i < item.size(); i++) {
            String name = ((Item) item.get(i)).getName();
            if (table.get(name) == null) {
                table.put(name, Integer.valueOf(1));
            } else {
                table.put(name, Integer.valueOf(((Integer) table.get(name)).intValue() + 1));
            }
        }
        return insertParseTable(table);
    }

    public long insertParseTable(Map<String, Integer> table) {
        this.db.delete("Backpack", null, null);
        ContentValues bp = new ContentValues();
        long success = 0;
        for (Entry pair : table.entrySet()) {
            bp.put("itemName", (String) pair.getKey());
            bp.put("quantity", (Integer) pair.getValue());
            success = this.db.insert("Backpack", null, bp);
            if (success < 0) {
                ContentValues args = new ContentValues();
                args.put("quantity", (Integer) pair.getValue());
                success = (long) this.db.update("Backpack", args, "itemName = '" + pair.getKey() + "'", null);
                if (success < 0) {
                    return success;
                }
                System.out.println(pair.getKey() + " saved");
            } else {
                System.out.println(pair.getKey() + " saved");
            }
        }
        return success;
    }

    public ArrayList<Item> getBackpack(Hashtable<String, TextureRegion> table) {
        System.out.println("Get Backpack");
        try {
            Cursor c = this.db.rawQuery("select * from Backpack", null);
            c.moveToFirst();
            ArrayList<Item> resultSet = new ArrayList();
            if (c.isAfterLast()) {
                return resultSet;
            }
            do {
                Cursor c2 = this.db.rawQuery("select * from Items where itemName = '" + c.getString(c.getColumnIndex("itemName")) + "'", null);
                c2.moveToFirst();
                Cursor c3 = this.db.rawQuery("select * from Filenames where itemName = '" + c2.getString(c2.getColumnIndex("itemName")) + "'", null);
                c3.moveToFirst();
                String itemName = c2.getString(c2.getColumnIndex("itemName"));
                int health = c2.getInt(c2.getColumnIndex("health"));
                int hunger = c2.getInt(c2.getColumnIndex("hunger"));
                int sickness = c2.getInt(c2.getColumnIndex("sickness"));
                int xp = c2.getInt(c2.getColumnIndex("xp"));
                int protection = c2.getInt(c2.getColumnIndex("protection"));
                int type = c2.getInt(c2.getColumnIndex(TMXConstants.TAG_OBJECT_ATTRIBUTE_TYPE));
                String description = c2.getString(c2.getColumnIndex(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION));
                TextureRegion textureRegion = (TextureRegion) table.get(c3.getString(c3.getColumnIndex("filename")));
                int quantity = c.getInt(c.getColumnIndex("quantity"));
                for (int j = 0; j < quantity; j++) {
                    System.out.println("Adding " + itemName + " to backpack");
                    resultSet.add(new Item(0.0f, 0.0f, textureRegion, itemName, description, health, hunger, sickness, xp, type, protection));
                }
            } while (c.moveToNext());
            return resultSet;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.ArrayList<com.tamaproject.entity.Item> getAllItems(java.util.Hashtable<java.lang.String, org.anddev.andengine.opengl.texture.region.TextureRegion> r20) {
        /*
        r19 = this;
        r2 = java.lang.System.out;
        r3 = "Get All Items";
        r2.println(r3);
        r0 = r19;
        r2 = r0.db;	 Catch:{ Exception -> 0x00e3 }
        r3 = "select * from Items";
        r18 = 0;
        r0 = r18;
        r14 = r2.rawQuery(r3, r0);	 Catch:{ Exception -> 0x00e3 }
        r14.moveToFirst();	 Catch:{ Exception -> 0x00e3 }
        r17 = new java.util.ArrayList;	 Catch:{ Exception -> 0x00e3 }
        r17.<init>();	 Catch:{ Exception -> 0x00e3 }
        r2 = r14.isAfterLast();	 Catch:{ Exception -> 0x00e3 }
        if (r2 != 0) goto L_0x00dd;
    L_0x0023:
        r0 = r19;
        r2 = r0.db;	 Catch:{ Exception -> 0x00de }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00de }
        r3.<init>();	 Catch:{ Exception -> 0x00de }
        r18 = "select filename from Filenames where itemName = '";
        r0 = r18;
        r3 = r3.append(r0);	 Catch:{ Exception -> 0x00de }
        r18 = "itemName";
        r0 = r18;
        r18 = r14.getColumnIndex(r0);	 Catch:{ Exception -> 0x00de }
        r0 = r18;
        r18 = r14.getString(r0);	 Catch:{ Exception -> 0x00de }
        r0 = r18;
        r3 = r3.append(r0);	 Catch:{ Exception -> 0x00de }
        r18 = "'";
        r0 = r18;
        r3 = r3.append(r0);	 Catch:{ Exception -> 0x00de }
        r3 = r3.toString();	 Catch:{ Exception -> 0x00de }
        r18 = 0;
        r0 = r18;
        r15 = r2.rawQuery(r3, r0);	 Catch:{ Exception -> 0x00de }
        r15.moveToFirst();	 Catch:{ Exception -> 0x00de }
        r2 = "itemName";
        r2 = r14.getColumnIndex(r2);	 Catch:{ Exception -> 0x00de }
        r5 = r14.getString(r2);	 Catch:{ Exception -> 0x00de }
        r2 = "health";
        r2 = r14.getColumnIndex(r2);	 Catch:{ Exception -> 0x00de }
        r7 = r14.getInt(r2);	 Catch:{ Exception -> 0x00de }
        r2 = "hunger";
        r2 = r14.getColumnIndex(r2);	 Catch:{ Exception -> 0x00de }
        r8 = r14.getInt(r2);	 Catch:{ Exception -> 0x00de }
        r2 = "sickness";
        r2 = r14.getColumnIndex(r2);	 Catch:{ Exception -> 0x00de }
        r9 = r14.getInt(r2);	 Catch:{ Exception -> 0x00de }
        r2 = "xp";
        r2 = r14.getColumnIndex(r2);	 Catch:{ Exception -> 0x00de }
        r10 = r14.getInt(r2);	 Catch:{ Exception -> 0x00de }
        r2 = "protection";
        r2 = r14.getColumnIndex(r2);	 Catch:{ Exception -> 0x00de }
        r12 = r14.getInt(r2);	 Catch:{ Exception -> 0x00de }
        r2 = "type";
        r2 = r14.getColumnIndex(r2);	 Catch:{ Exception -> 0x00de }
        r11 = r14.getInt(r2);	 Catch:{ Exception -> 0x00de }
        r2 = "description";
        r2 = r14.getColumnIndex(r2);	 Catch:{ Exception -> 0x00de }
        r6 = r14.getString(r2);	 Catch:{ Exception -> 0x00de }
        r2 = "price";
        r2 = r14.getColumnIndex(r2);	 Catch:{ Exception -> 0x00de }
        r13 = r14.getInt(r2);	 Catch:{ Exception -> 0x00de }
        r2 = "filename";
        r2 = r15.getColumnIndex(r2);	 Catch:{ Exception -> 0x00de }
        r2 = r15.getString(r2);	 Catch:{ Exception -> 0x00de }
        r0 = r20;
        r4 = r0.get(r2);	 Catch:{ Exception -> 0x00de }
        r4 = (org.anddev.andengine.opengl.texture.region.TextureRegion) r4;	 Catch:{ Exception -> 0x00de }
        r1 = new com.tamaproject.entity.Item;	 Catch:{ Exception -> 0x00de }
        r2 = 0;
        r3 = 0;
        r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);	 Catch:{ Exception -> 0x00de }
        r0 = r17;
        r0.add(r1);	 Catch:{ Exception -> 0x00de }
    L_0x00d7:
        r2 = r14.moveToNext();	 Catch:{ Exception -> 0x00e3 }
        if (r2 != 0) goto L_0x0023;
    L_0x00dd:
        return r17;
    L_0x00de:
        r16 = move-exception;
        r16.printStackTrace();	 Catch:{ Exception -> 0x00e3 }
        goto L_0x00d7;
    L_0x00e3:
        r16 = move-exception;
        r16.printStackTrace();
        r17 = new java.util.ArrayList;
        r17.<init>();
        goto L_0x00dd;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tamaproject.database.DatabaseHelper.getAllItems(java.util.Hashtable):java.util.ArrayList<com.tamaproject.entity.Item>");
    }
}
