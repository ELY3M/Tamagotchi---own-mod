package com.tamaproject.entity;

import android.util.Log;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.anddev.andengine.entity.sprite.BaseSprite;

public class Tamagotchi {
    public static final int ALIVE = 1;
    public static final int DEAD = 0;
    public static final int LEVEL_UP = 2;
    public static final int MAX_BATTLE_LEVEL = 100;
    public static final int MAX_LEVEL = 1030000000;
    String TAG = "Tamagotchi";
    private long age;
    private int battleLevel;
    private long birthday;
    private Calendar calendar = Calendar.getInstance();
    private int currentHealth;
    private int currentHunger;
    private int currentSickness;
    private int currentXP;
    private Item equippedItem;
    private DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
    private int id;
    private int maxHealth;
    private int maxHunger;
    private int maxSickness;
    private int maxXP;
    private int money;
    private BaseSprite sprite;
    private int status;

    public Tamagotchi() {
        setDefault();
        this.calendar.setTimeInMillis(this.birthday);
    }

    public Tamagotchi(int currentHealth, int maxHealth, int currentHunger, int maxHunger, int currentXP, int maxXP, int currentSickness, int maxSickness, int battleLevel, int status, long birthday, Item equippedItem, long age, int id, int money) {
        this.currentHealth = currentHealth;
        this.maxHealth = maxHealth;
        this.currentHunger = currentHunger;
        this.maxHunger = maxHunger;
        this.currentXP = currentXP;
        this.maxXP = maxXP;
        this.currentSickness = currentSickness;
        this.maxSickness = maxSickness;
        this.battleLevel = battleLevel;
        this.status = status;
        this.birthday = birthday;
        this.equippedItem = equippedItem;
        this.calendar.setTimeInMillis(birthday);
        this.age = age;
        this.id = id;
        setMoney(money);
    }

    public void setDefault() {
        this.currentHealth = 100;
        this.maxHealth = 100;
        this.currentHunger = 100;
        this.maxHunger = 100;
        this.currentXP = 10;
        this.maxXP = 100;
        this.currentSickness = 0;
        this.maxSickness = 100;
        this.battleLevel = 1;
        this.status = 1;
        this.birthday = System.currentTimeMillis();
        this.age = 0;
        this.id = 1;
        this.money = 9999999;
    }

    public Tamagotchi(int currentHealth, int maxHealth, int currentHunger, int maxHunger, int currentXP, int maxXP, int currentSickness, int maxSickness, int battleLevel, int status) {
        this.currentHealth = currentHealth;
        this.maxHealth = maxHealth;
        this.currentHunger = currentHunger;
        this.maxHunger = maxHunger;
        this.currentXP = currentXP;
        this.maxXP = maxXP;
        this.currentSickness = currentSickness;
        this.maxSickness = maxSickness;
        this.battleLevel = battleLevel;
        this.status = status;
    }

    public int applyItem(Item item) {
        this.currentHealth += item.getHealth();
        this.currentHunger += item.getHunger();
        this.currentSickness += item.getSickness();
        this.currentXP += item.getXp();
        return checkStats();
    }

    public Item equipItem(Item item) {
        if (this.equippedItem != null) {
            Item oldItem = this.equippedItem;
            this.equippedItem = item;
            return oldItem;
        }
        this.equippedItem = item;
        return null;
    }

    public int checkStats() {
        if (this.currentHealth > this.maxHealth) {
            this.currentHealth = this.maxHealth;
        } else if (this.currentHealth < 0) {
            this.currentHealth = 0;
        }
        if (this.currentHunger > this.maxHunger) {
            this.currentHunger = this.maxHunger;
        } else if (this.currentHunger < 0) {
            this.currentHunger = 0;
        }
        if (this.currentSickness < 0) {
            this.currentSickness = 0;
        } else if (this.currentSickness > this.maxSickness) {
            this.currentSickness = this.maxSickness;
        }
        if (isDead()) {
            return 0;
        }
        if (levelUp()) {
            return 2;
        }
        return 1;
    }

    public boolean isDead() {
        if (this.status == 0) {
            return true;
        }
        if (this.currentHealth > 0) {
            return false;
        }
        this.status = 0;
        return true;
    }

    private boolean levelUp() {
        boolean leveled = false;
        while (this.currentXP > this.maxXP) {
            if (this.battleLevel <= MAX_LEVEL) {
                this.battleLevel++;
                Log.i(this.TAG, "battlelevel: " + this.battleLevel);
            }
            if (this.maxXP <= MAX_LEVEL) {
                this.currentXP -= this.maxXP;
                this.maxXP *= 2;
                Log.i(this.TAG, "xp level: " + this.maxXP);
            }
            this.maxHealth += this.maxHealth / 2;
            this.currentHealth = this.maxHealth;
            Log.i(this.TAG, "maxHealth: " + this.maxHealth);
            this.maxHunger += this.maxHunger / 4;
            Log.i(this.TAG, "maxHunger: " + this.maxHunger);
            this.maxSickness += this.maxSickness / 4;
            Log.i(this.TAG, "maxSickness: " + this.maxSickness);
            leveled = true;
        }
        return leveled;
    }

    public long getAge() {
        return this.age / 86400000;
    }

    public void addToAge(long time) {
        this.age += time;
    }

    public int getBattleLevel() {
        return this.battleLevel;
    }

    public int getStatus() {
        return this.status;
    }

    public long getBirthday() {
        return this.birthday;
    }

    public String getFormattedBirthday() {
        return this.formatter.format(this.calendar.getTime());
    }

    public void setBirthday(long birthday) {
        this.birthday = birthday;
    }

    public int getID() {
        return this.id;
    }

    public Item getEquippedItem() {
        return this.equippedItem;
    }

    public String getEquippedItemName() {
        if (this.equippedItem == null) {
            return "None";
        }
        return this.equippedItem.getName();
    }

    public BaseSprite getSprite() {
        return this.sprite;
    }

    public void setEquippedItem(Item equippedItem) {
        this.equippedItem = equippedItem;
    }

    public void setSprite(BaseSprite sprite) {
        this.sprite = sprite;
    }

    public int getCurrentHealth() {
        return this.currentHealth;
    }

    public int getMaxHealth() {
        return this.maxHealth;
    }

    public int getCurrentHunger() {
        return this.currentHunger;
    }

    public int getMaxHunger() {
        return this.maxHunger;
    }

    public int getCurrentXP() {
        return this.currentXP;
    }

    public int getMaxXP() {
        return this.maxXP;
    }

    public int getCurrentSickness() {
        return this.currentSickness;
    }

    public int getMaxSickness() {
        return this.maxSickness;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public void setCurrentHunger(int currentHunger) {
        this.currentHunger = currentHunger;
    }

    public void setMaxHunger(int maxHunger) {
        this.maxHunger = maxHunger;
    }

    public void setCurrentXP(int currentXP) {
        this.currentXP = currentXP;
    }

    public void setMaxXP(int maxXP) {
        this.maxXP = maxXP;
    }

    public void setCurrentSickness(int currentSickness) {
        this.currentSickness = currentSickness;
    }

    public void setMaxSickness(int maxSickness) {
        this.maxSickness = maxSickness;
    }

    public String getStats() {
        String s = "Age: " + getAge() + " days old \nHealth: " + this.currentHealth + "/" + this.maxHealth + "\nSickness: " + this.currentSickness + "/" + this.maxSickness + "\nHunger: " + this.currentHunger + "/" + this.maxHunger + "\nExperience: " + this.currentXP + "/" + this.maxXP + "\nBattle Level: " + this.battleLevel + "\nBirthday: " + getFormattedBirthday() + "\nMoney: $" + this.money;
        if (this.equippedItem != null) {
            return s + "\n \nEquipped Item: \n" + this.equippedItem.getInfo();
        }
        return s;
    }

    public void setBattleLevel(int battleLevel) {
        this.battleLevel = battleLevel;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getMoney() {
        return this.money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
