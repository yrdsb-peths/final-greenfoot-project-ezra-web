import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EndScreen2 here.
 * End Screen if player 2 wins
 * @author Ezra Kung
 * @version Final Game Jan 18 
 */
public class EndScreen2 extends World
{

    Label p2Wins = new Label ("Player 2 Wins", 50);
    /**
     * Constructor for objects of class EndScreen2.
     * 
     */
    //added celebration sound effect when you win
    GreenfootSound celebration = new GreenfootSound("tada-fanfare-a-6313.mp3");
    public EndScreen2()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(400, 224, 1); 
        addObject(p2Wins, 200, 150);
        celebration.play();
    }
    
}
