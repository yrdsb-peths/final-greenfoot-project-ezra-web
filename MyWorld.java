import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    public int score1 = 0;
    Label score1Label;
    
    public int score2 = 0;
    Label score2Label;
    
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 400, 1);
        
        Dino player1 = new Dino();
        addObject(player1, 50, 300);
        
        Player2 player2 = new Player2();
        addObject(player2, 750, 300);
        
        //Egg1 egg1 = new Egg1();
        //addObject(egg1, 770, 200);
        spawnEgg1();
        
        //Egg2 egg2 = new Egg2();
        //addObject(egg2, 30, 200);
        spawnEgg2();
        
        score1Label = new Label(0, 50);
        addObject(score1Label, 20, 20);
        
        score2Label = new Label(0, 50);
        addObject(score2Label, 750, 20);
        
        
    }
    
    public void spawnEgg1()
    {
        Egg1 egg1 = new Egg1();
        addObject(egg1, 770, 200);
    }
    
    public void spawnEgg2()
    {
        Egg2 egg2 = new Egg2();
        addObject(egg2, 30, 200);
    }
    
    public void increaseScore1()
    {
        score1++;
    }
}
