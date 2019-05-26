package com.davegreen;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
        Player dave = new Player("Dave", 10, 15);
        System.out.println(dave.toString());
        saveObject(dave);
//
        dave.setHitPoints(8);
        System.out.println(dave);
        dave.setWeapon("FearMonger");
        System.out.println(dave);
        saveObject(dave);
        System.out.println(dave);
        loadObject(dave);
        System.out.println(dave);
        
//        ISaveable werewolf = new Monster("Werewolf", 20, 40);
//
//        //werewolf.getStrength();             // This will never work because although we the programmer KNOW that behind the ISaveable type is a Monster object the compiler just
//                                            // sees the ISaveable type and so goes looking there for a getStrength() method which of course the ISaveable interface does not have
//                                            // such a method, in order to make such code work we would need to cast the ISaveable type werewolf Monster object as a Monster type
//                                            // this could be done as follows if we wished to print out the werewolf strength for example:
//
//        System.out.println("The werewolfs strength is " + ((Monster) werewolf).getStrength());
//
//        System.out.println(werewolf);
//        saveObject(werewolf);
    }
    
    public static List<String> readValues()
    {
        List<String> values = new ArrayList<>();
        
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        int index = 0;
    
        System.out.println("Choose\n" +
                "1 to enter a string\n" +
                "0 to quit");
        
        while(!quit)
        {
            System.out.println("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch(choice)
            {
                case 0:
                    quit = true;
                    break;
                case 1:
                    System.out.println("Enter a string: ");
                    String stringInput = scanner.nextLine();
                    values.add(stringInput);
                    index ++;
                    break;
            }
        }
    
        return values;
    }
    
    public static void saveObject(ISaveable objectToSave)
    {
        for(int i = 0; i < objectToSave.write().size(); i ++)
        {
            System.out.println("Loop " + i);
            System.out.println("Saving " + objectToSave.write().get(i) + " to storage device");
        }
    }
    
    public static void loadObject(ISaveable objectToLoad)
    {
        List<String> values = readValues();
        objectToLoad.read(values);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
