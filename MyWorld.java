import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * The actual world with all the methods, 
 * decorated like a soccer field
 * @author Ezra Kung
 * @version Jan 18 Final game
 */
public class MyWorld extends World
{
    public int score = 0;
    Label scoreLabel;
    
    public int score2 = 0;
    Label score2Label;
    
    public int point = 0;
    
    GreenfootSound celebration = new GreenfootSound("tada-fanfare-a-6313.mp3");
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 400, 1);
        
        Dino player1 = new Dino();
        addObject(player1, 50, 350);
        
        Player2 player2 = new Player2();
        addObject(player2, 750, 50);
        
        //Egg1 egg1 = new Egg1();
        //addObject(egg1, 770, 200);
        spawnEgg1();
        
        //Egg2 egg2 = new Egg2();
        //addObject(egg2, 30, 200);
        spawnEgg2();
        
        scoreLabel = new Label(0, 50);
        addObject(scoreLabel, 20, 20);
        
        score2Label = new Label(0, 50);
        addObject(score2Label, 750, 20);
        
        powerUp();
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
    
    
    public void powerUp()
    {
        PowerUp shoe = new PowerUp();
        int x = Greenfoot.getRandomNumber(800);
        int y = Greenfoot.getRandomNumber(400);
        addObject(shoe, x, y);
    }
    
    public void gameOver()
    {
        if(score == 3)
        {
            EndScreen1 endScreen1 = new EndScreen1();
            Greenfoot.setWorld(endScreen1);
        }
    }


    
    public void gameOverPlayer2()
    {
        if(score2 == 3)
        {
            EndScreen2 endScreen2 = new EndScreen2();
            Greenfoot.setWorld(endScreen2);
        }
    }
    
    
    public void increaseScore()
    {
        score++;
        scoreLabel.setValue(score);
        spawnEgg1();
    }
    
    public void increaseScore2()
    {
        score2++;
        score2Label.setValue(score2);
        spawnEgg2();
    }
}
