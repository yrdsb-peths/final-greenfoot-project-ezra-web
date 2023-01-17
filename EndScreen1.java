import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EndScreen1 here.
 * 
 * @author Ezra Kung
 * @version Final Game Jan 18 
 */
public class EndScreen1 extends World
{

    Label p1Wins = new Label ("Player 1 Wins", 50);
    /**
     * Constructor for objects of class EndScreen1.
     * 
     */
    
    GreenfootSound celebration = new GreenfootSound("tada-fanfare-a-6313.mp3");
    public EndScreen1()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(400, 224, 1); 
        addObject(p1Wins, 200, 150);
        celebration.play();
    }
    
}
