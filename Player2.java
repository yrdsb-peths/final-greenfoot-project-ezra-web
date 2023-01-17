import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player2 here.
 * second player of capture the flag, uses controls <-- and -->
 *  * collect egg on other side and bring them back to your side to score
 * score 3 points to win the game
 * @author Ezra Kung 
 * @version Final Game
 */
public class Player2 extends Actor
{
    /**
     * Act - do whatever the Player2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
   //keeps track you got the egg
    int hasEgg = 0;
    
    //keeps track of score
    int count = 0;
    
    //default speed
    int speed = 2;
    
    //Plays Dinosaure noise when you score
    GreenfootSound touchDown = new GreenfootSound("dinosaur-2-86565.mp3");
    
    GreenfootImage[] walk = new GreenfootImage[6];
    
    //all methods for Player 2 added
    //control P2 with arrow keys to turn up or down
    public void act() 
    {
        move(- + speed);
        if(Greenfoot.isKeyDown("right"))
        {
            turn(3);
        }
        if(Greenfoot.isKeyDown("left"))
        {
            turn(-3);
        }
        animateMuchkin();
        stealEgg();
        tagged();
        speed();
        if(count == 3)
        {
            MyWorld world = (MyWorld) getWorld();
            world.gameOverPlayer2();
        }
        
    }    
    
    //Animating the dinosaur all images appear for same amount of time
    int imageIndex = 0;
    private SimpleTimer timer = new SimpleTimer();
    public void animateMuchkin()
    {
        if(timer.millisElapsed() > 140)
        {
            setImage(walk[imageIndex]);
            imageIndex = (imageIndex + 1) % walk.length;
            timer.mark();
        }
    }
    
    //creates walking animation
    public Player2()
    {
        for(int i = 0; i < walk.length; i++)
        {
            walk[i] = new GreenfootImage("images/player walking/Muchkin" + i + ".png");
            walk[i].mirrorHorizontally();
            walk[i].scale(54,54);
            // 55, 55 past
        }
    }
    
    //Catch teh shoe to increase speed, does stack
    //reset speed to 2 after any interaction
    public void speed()
    {
        Actor gotSpeed = getOneIntersectingObject(PowerUp.class);
        if(isTouching(PowerUp.class))
        {
            speed ++;
            MyWorld world = (MyWorld) getWorld();
            getWorld().removeObject(gotSpeed);
            world.powerUp();
        }
    }
    
    //collects the egg and you score if you have the egg and is on the right half of screen
    public void stealEgg()
    {
        Actor gotEgg2 = getOneIntersectingObject(Egg2.class);
        if(isTouching(Egg2.class))
        {
            getWorld().removeObject(gotEgg2);
            hasEgg += 1;
            speed = 2;
        }
        
        if(getX() >= 400 && hasEgg == 1)
        {
            MyWorld world = (MyWorld) getWorld();
            world.increaseScore2();
            hasEgg --;
            count ++;
            touchDown.play();
            speed = 2;
        }
    }

    //resets egg spawn, your spawn at (750, 300) and speed if you get caught
    public void tagged()
    {
        Actor gotCaught = getOneIntersectingObject(Dino.class);
        if(isTouching(Dino.class) && getX() <= 400)
        {
            int x = 750;
            int y = 300;
            setLocation(x,y);
            hasEgg = 0;
            MyWorld world = (MyWorld) getWorld();
            world.spawnEgg2();
            speed = 2;
        }
    }
}
