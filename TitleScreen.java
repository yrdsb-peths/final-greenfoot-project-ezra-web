import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * Title screen to help show instructions and game movement
 * 
 * @author Ezra
 * @version Jan 18 Final Game
 */
public class TitleScreen extends World
{
    //Making instructions and labels for controls
    
    Label title = new Label ("Egg Thieves", 75);
    Label p2 = new Label ("P2 controls <-- = Turn Down || --> = Turn Up", 30);
    Label start = new Label ("Press <<Space>> to Start", 50);
    Label p1 = new Label ("P1 controls A = Turn Up || D = Turn Down", 30);
    Label instructions = new Label ("Capture Other Player's Egg", 30);
    Label instructions2 = new Label ("Come Back To Your Side To Score", 30);
    Label instructions3 = new Label ("Don't Get Caught", 30);
    Label numberOfPlayers = new Label ("2 PLAYERS", 45);
    
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 494, 1); 
        
        addObject (title, 200, 50);
        title.setFillColor(Color.RED);
        //Adding color to text
        addObject (p2, 242, 475);
        p2.setFillColor(Color.CYAN);
        
        addObject (start, 400, 390);
        start.setFillColor(Color.WHITE);
        
        addObject (p1, 230, 440);
        p1.setFillColor(Color.YELLOW);
        
        addObject (numberOfPlayers, 700, 475);
        
        addObject (instructions, 170, 140);
        instructions.setFillColor(Color.ORANGE);
        
        addObject (instructions2, 210, 170);
        instructions2.setFillColor(Color.ORANGE);
        
        addObject (instructions3, 118, 200);
        instructions3.setFillColor(Color.ORANGE);
        
        testMoves();
    }
    
    //adds Player 1 just to test the movement
    public void testMoves()
    {
        Dino test = new Dino();
        addObject (test, 80, 300);
    }
    
    
    public void act()
    {
        if (Greenfoot.isKeyDown("space"))
        {
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
        }
    }
    
}
