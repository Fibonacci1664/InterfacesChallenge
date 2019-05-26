package com.davegreen;

import java.util.ArrayList;
import java.util.List;

public class Player implements ISaveable
{
    private String name;
    private int hitPoints;
    private int strength;
    private String weapon;
    
    public Player(String name, int hitPoints, int strength)
    {
        this.name = name;
        this.hitPoints = hitPoints;
        this.strength = strength;
        this.weapon = "Sword";
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public int getHitPoints()
    {
        return hitPoints;
    }
    
    public void setHitPoints(int hitPoints)
    {
        this.hitPoints = hitPoints;
    }
    
    public int getStrength()
    {
        return strength;
    }
    
    public void setStrength(int strength)
    {
        this.strength = strength;
    }
    
    public String getWeapon()
    {
        return weapon;
    }
    
    public void setWeapon(String weapon)
    {
        this.weapon = weapon;
    }
    
    @Override
    public String toString()                                  // toString takes the fields and writes them as a string plus whatever the actual value of that particular field is.
    {
        return "Player{" +
                "name = '" + name + '\'' +
                ", hitPoints = " + hitPoints +
                ", strength = " + strength +
                ", weapon = '" + weapon + '\'' +
                '}';
    }
    
    @Override
    public List<String> write()                             // Here we are overriding the interfaces write method because we HAVE TO.
    {
        List<String> values = new ArrayList<>();
        
        values.add(0, this.name);                       // Here we add the fields to the List<String> arraylist, and then finish by returning "values".
        values.add(1, "" + this.hitPoints);     // The use of double quotes "" is a quick way to cast the int values of hitPoints and strength to a String, which we
        values.add(2, "" + this.strength);      // have to do as the arrayList "values" is of type List<String> and so it would not accept any int values.
        values.add(3, this.weapon);
        
        return values;
    }
    
    @Override
    public void read(List<String> savedValues)
    {
        if(savedValues != null && savedValues.size() > 0)               // != null means that an instance of the object DOES exist, greater than zero means that something HAS
        {                                                               // been added to the arraylist.
            this.name = savedValues.get(0);
            this.hitPoints = Integer.parseInt(savedValues.get(1));      // Here we are setting the fields to whatever the values are at the particular elements, if we are parsing
            this.strength = Integer.parseInt(savedValues.get(2));       // it is because we have saved something as a STRING and we now what to use that same thing as an INT.
            this.weapon = savedValues.get(3);
        }
    
    }
}
