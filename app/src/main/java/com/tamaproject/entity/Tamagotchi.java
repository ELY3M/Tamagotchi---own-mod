package com.tamaproject.entity;

import android.util.Log;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.anddev.andengine.entity.sprite.BaseSprite;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Hours;
import org.joda.time.LocalDate;
import org.joda.time.Minutes;
import org.joda.time.Months;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.joda.time.Seconds;
import org.joda.time.Weeks;
import org.joda.time.Years;

/**
 * Tamagotchi class. Holds all of the stats for Tamagotchi.
 * 
 * @author Jonathan
 * 
 */
public class Tamagotchi
{
    String TAG = "tama Tamagotchi";
    public static final int MAX_BATTLE_LEVEL = 100;
    private int currentHealth, maxHealth;
    private int currentHunger, maxHunger;
    private int currentXP, maxXP;
    private int currentSickness, maxSickness;
    private int battleLevel;
    private int status;
    private long birthday;
    private long playtime;
    private int id;
    private Item equippedItem;
    private int money;

    private BaseSprite sprite;
    private DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

    private DateFormat getsec = new SimpleDateFormat("s");
    private DateFormat getmin = new SimpleDateFormat("m");
    private DateFormat gethour = new SimpleDateFormat("k"); //0 to 23
    private DateFormat getday = new SimpleDateFormat("dd");
    private DateFormat getmon = new SimpleDateFormat("MM");
    private DateFormat getyear = new SimpleDateFormat("yyyy");
    private Calendar calendar = Calendar.getInstance();

    public final static int ALIVE = 1, DEAD = 0, LEVEL_UP = 2;

    public Tamagotchi()
    {
	setDefault();
	this.calendar.setTimeInMillis(birthday);
    }

    public Tamagotchi(int currentHealth, int maxHealth, int currentHunger, int maxHunger,
	    int currentXP, int maxXP, int currentSickness, int maxSickness, int battleLevel,
	    int status, long birthday, Item equippedItem, long playtime, int id, int money)
    {
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
	this.playtime = playtime;
	this.id = id;
	this.setMoney(money);
    }

    /**
     * Default stats for when Tamagotchi is first born
     */
    public void setDefault()
    {
	this.currentHealth = 100;
	this.maxHealth = 100;
	this.currentHunger = 10;
	this.maxHunger = 100;
	this.currentXP = 10;
	this.maxXP = 100;
	this.currentSickness = 0;
	this.maxSickness = 100;
	this.battleLevel = 1;
	this.status = Tamagotchi.ALIVE;
	this.birthday = System.currentTimeMillis();
	this.playtime = 0;
	this.id = 1;
    this.money = 9999999;
    }

    public Tamagotchi(int currentHealth, int maxHealth, int currentHunger, int maxHunger,
	    int currentXP, int maxXP, int currentSickness, int maxSickness, int battleLevel,
	    int status)
    {
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

    /**
     * Applies item to Tamagotchi
     * 
     * @param item
     *            Item to be applied
     * @return DEAD, ALIVE, or LEVEL_UP
     */
    public int applyItem(Item item)
    {
	this.currentHealth += item.getHealth();
	this.currentHunger += item.getHunger();
	this.currentSickness += item.getSickness();
	this.currentXP += item.getXp();

	return checkStats();
    }

    /**
     * Equips an item to Tamagotchi and returns the previously equipped item.
     * 
     * @param item
     *            Item to be equipped.
     * @return Previously equipped item, null if nothing was equipped.
     */
    public Item equipItem(Item item)
    {
	if (equippedItem != null)
	{
	    Item oldItem = equippedItem;
	    equippedItem = item;
	    return oldItem;
	}
	else
	{
	    equippedItem = item;
	    return null;
	}
    }

    /**
     * Checks the stats of Tamagotchi
     * 
     * @return Tamagotchi.DEAD, LEVEL_UP, or ALIVE
     */
    public int checkStats()
    {
	if (this.currentHealth > this.maxHealth)
	{
	    this.currentHealth = this.maxHealth;
	}
	else if (this.currentHealth < 0)
	{
	    this.currentHealth = 0;
	}

	if (this.currentHunger < 0)
	{
	    this.currentHunger = 0;
	}
	else if (this.currentHunger > this.maxHunger)
	{
	    this.currentHunger = this.maxHunger;
	}

	if (this.currentSickness < 0)
	{
	    this.currentSickness = 0;
	}
	else if (this.currentSickness > this.maxSickness)
	{
	    this.currentSickness = this.maxSickness;
	}

	// check if tama is dead
	if (isDead())
	    return Tamagotchi.DEAD;

	// check if tama leveled up

	if (levelUp())
	    return Tamagotchi.LEVEL_UP;

	return Tamagotchi.ALIVE;

    }

    /**
     * Checks to see if Tamagotchi is dead
     * 
     * @return true if dead, false if alive
     */
    public boolean isDead()
    {
	if (status == Tamagotchi.DEAD)
	{
	    return true;
	}
	else if (currentHealth <= 0)
	{
	    status = Tamagotchi.DEAD;
	    return true;
	}

	return false;
    }

    /**
     * Checks to see if Tamagotchi has gained a level
     * 
     * @return true if gained a level, false if not
     */
    private boolean levelUp()
    {
	boolean leveled = false;
	while (this.currentXP > this.maxXP)
	{
	    this.battleLevel++;

	    this.currentXP = this.currentXP - this.maxXP;
	    this.maxXP *= 2;

	    this.maxHealth += this.maxHealth / 2;
	    this.currentHealth = this.maxHealth;

	    this.maxHunger += this.maxHunger / 4;

	    this.maxSickness += this.maxSickness / 4;
	    leveled = true;
	}
	return leveled;
    }


    private String getAge()
    {



        String setsecond = getsec.format(calendar.getTime());
        String setmin = getmin.format(calendar.getTime());
        String sethour = gethour.format(calendar.getTime());
        String setday = getday.format(calendar.getTime());
        String setmonth = getmon.format(calendar.getTime());
        String setyear = getyear.format(calendar.getTime());

        LocalDate birthdate = new LocalDate(Integer.parseInt(setyear), Integer.parseInt(setmonth), Integer.parseInt(setday));  //Birth date
        //LocalDate birthtime = new LocalDate(Integer.parseInt(sethour), Integer.parseInt(setmin), Integer.parseInt(setsecond)); //Birth time
        LocalDate now = new LocalDate();                    //Today's date
        Period getdate = new Period(birthdate, now, PeriodType.yearMonthDay());
        //Period gettime = new Period(birthtime, now, PeriodType.dayTime());
        //Now access the values as below

        //int seconds = gettime.getSeconds();
        //int minutes = gettime.getMinutes();
        //int hours = gettime.getHours();
        int days = getdate.getDays();
        int months = getdate.getMonths();
        int years = getdate.getYears();




        /*
        DateTime birthdate = new DateTime(Long.valueOf(birthday));
        DateTime now = new DateTime();
        Period period = new Period(birthdate, now);
        DateTime calc = birthdate.plus(period);
        Seconds seconds = Seconds.secondsBetween(birthdate, now);
        Minutes minutes = Minutes.minutesBetween(birthdate, now);
        Hours hours = Hours.hoursBetween(birthdate, now);
        Days days = Days.daysBetween(birthdate, now);
        Weeks weeks = Weeks.weeksBetween(birthdate, now);
        Months months = Months.monthsBetween(birthdate, now);
        Years years = Years.yearsBetween(birthdate, now);
        */

        //String myage = years +" Years, " + months + " Months, " + days + " Days, " + hours + " Hours, " + minutes + " Minutes, " + seconds + " Seconds";

        String myage = years +" Years, " + months + " Months, " + days + " Days";

        //Log.i(TAG, "my birthday is "+birthday+" formatted: "+getFormattedBirthday());
        //Log.i(TAG, myage);
        return myage;

    }

    /**
     * 
     * @return The tama's playtime in milliseconds
     */
    public long getPlaytime()
    {
        return playtime;
    }


    public long addToPlaytime(long time) {

        long totalplaytime = (playtime += time);
        Log.i(TAG, "addToPlaytime: playtime: "+playtime+ " newplaytime: "+totalplaytime);
        return totalplaytime;

    }

    public String totalplaytime() {

        int years = (int) ((playtime / (1000*60*60*24*7*52*12)));
        int months = (int) (playtime / (1000*60*60*24*7*52) % 12);
        int weeks = (int) ((playtime / (1000*60*60*24*7)) % 52);
        int days = (int) ((playtime / (1000*60*60*24)) % 7);
        int hours = (int) ((playtime / (1000*60*60)) % 24);
        int minutes = (int) ((playtime / (1000*60)) % 60);
        int seconds = (int) (playtime / 1000) % 60;

        String playtime = years +" Years, " + months + " Months, " + weeks + " Weeks, " + days + " Days, " + hours + " Hours, " + minutes + " Minutes, " + seconds + " Seconds";
        //String playtime = days + " days, " + hours + " hours, " + minutes + " minutes, " + seconds + " seconds";
        //Log.i(TAG, playtime);
        return playtime;
    }

    public int getBattleLevel()
    {
	return battleLevel;
    }

    public int getStatus()
    {
	return status;
    }

    public long getBirthday()
    {
	return birthday;
    }

    public String getFormattedBirthday()
    {
	return formatter.format(calendar.getTime());
    }

    public void setBirthday(long birthday)
    {
	    Log.i(TAG, "setBirthday: "+birthday);
        this.birthday = birthday;
    }

    public int getID()
    {
	return id;
    }

    public Item getEquippedItem()
    {
	return equippedItem;
    }

    public String getEquippedItemName()
    {
	if (equippedItem == null)
	    return "None";
	else
	    return equippedItem.getName();
    }

    public BaseSprite getSprite()
    {
	return sprite;
    }

    public void setEquippedItem(Item equippedItem)
    {
	this.equippedItem = equippedItem;
    }

    public void setSprite(BaseSprite sprite)
    {
	this.sprite = sprite;
    }

    public int getCurrentHealth()
    {
	return currentHealth;
    }

    public int getMaxHealth()
    {
	return maxHealth;
    }

    public int getCurrentHunger()
    {
	return currentHunger;
    }

    public int getMaxHunger()
    {
	return maxHunger;
    }

    public int getCurrentXP()
    {
	return currentXP;
    }

    public int getMaxXP()
    {
	return maxXP;
    }

    public int getCurrentSickness()
    {
	return currentSickness;
    }

    public int getMaxSickness()
    {
	return maxSickness;
    }

    public void setCurrentHealth(int currentHealth)
    {
	this.currentHealth = currentHealth;
    }

    public void setMaxHealth(int maxHealth)
    {
	this.maxHealth = maxHealth;
    }

    public void setCurrentHunger(int currentHunger)
    {
	this.currentHunger = currentHunger;
    }

    public void setMaxHunger(int maxHunger)
    {
	this.maxHunger = maxHunger;
    }

    public void setCurrentXP(int currentXP)
    {
	this.currentXP = currentXP;
    }

    public void setMaxXP(int maxXP)
    {
	this.maxXP = maxXP;
    }

    public void setCurrentSickness(int currentSickness)
    {
	this.currentSickness = currentSickness;
    }

    public void setMaxSickness(int maxSickness)
    {
	this.maxSickness = maxSickness;
    }

    public String getStats()
    {
	String s = "Total Playtime: "+totalplaytime()+"\nAge: " + getAge() + "\nHealth: " + currentHealth + "/" + maxHealth + "\nSickness: " + currentSickness + "/" + maxSickness + "\nHunger: " + currentHunger + "/" + maxHunger + "\nExperience: " + currentXP + "/" + maxXP + "\nBattle Level: " + battleLevel + "\nBirthday: " + getFormattedBirthday() + "\nMoney: $" + money;
	if (equippedItem != null)
	    s += "\n \nEquipped Item: \n" + equippedItem.getInfo();
	return s;
    }

    public void setBattleLevel(int battleLevel)
    {
	this.battleLevel = battleLevel;
    }

    public void setStatus(int status)
    {
	this.status = status;
    }

    public int getMoney()
    {
	return money;
    }

    public void setMoney(int money)
    {
	this.money = money;
    }
}
