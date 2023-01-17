import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Dino here.
 * Player 1 uses controls A and D
 * collect egg on other side and bring them back to your side to score
 * score 3 points to win the game
 * start on the left side of the screeen
 * @author Ezra Kung
 * @version Final game
 */


public class Dino extends Actor
{
    /**
     * Act  - do whatever the Dino wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    GreenfootImage[] walking = new GreenfootImage[6];
    //keeps track you got the egg
    int hasEgg = 0;
    
    //keeps track of score
    int count = 0;
    
    //default speed
    int speed = 2;
    
    GreenfootSound takeEgg = new GreenfootSound("dinosaur-5-86564.mp3");
    //count if scores 3 times player 1 wins


    //Add all of the images for the animation
    public Dino()
    {
        for(int i = 0; i < walking.length; i++)
        {
            walking[i] = new GreenfootImage("images/Dino walking/walk" + i + ".png");
            walking[i].scale(60,60);
        }
        setImage(walking[0]);
    }
    
    /**
     * Animating the dinosaur
     * Adding a simple timer to fix speed of animation
     */
    int imageIndex = 0;
    private SimpleTimer timer = new SimpleTimer();
    public void animateDino()
    {
        if(timer.millisElapsed() > 140)
        {
            setImage(walking[imageIndex]);
            imageIndex = (imageIndex + 1) % walking.length;
            timer.mark();
        }
    }
    
    // stealing the egg and bring it back to your side to score
    //resets speed
    public void stealEgg()
    {
        Actor gotEgg1 = getOneIntersectingObject(Egg1.class);
        if(isTouching(Egg1.class))
        {
            getWorld().removeObject(gotEgg1);
            hasEgg += 1;
            speed = 2;
        }
        
        //you score if you have the egg and is on the left side
        if(getX() <= 400 && hasEgg == 1)
        {
            MyWorld world = (MyWorld) getWorld();
            world.increaseScore();
            hasEgg --;
            count ++;
            speed = 2;
            takeEgg.play();
        }
    }

    //if you get tagged you spawn back at (30, 300)
    //resets speed
    public void tagged()
    {
        Actor gotCaught = getOneIntersectingObject(Player2.class);
        if(isTouching(Player2.class) && getX() >= 400)
        {
            int x = 30;
            int y = 300;
            setLocation(x,y);
            hasEgg = 0;
            MyWorld world = (MyWorld) getWorld();
            world.spawnEgg1();
            speed = 2;
        }
    }
    
    //collect shoe item to increase speed by 1
    //can stack
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
    
    /**
     * This new movement makes for more intresting gameplay
     * Player is constantly moving control which direction it turns
     */
    
    public void act()
    {
        move(speed);
        if(Greenfoot.isKeyDown("d"))
        {
            turn(3);
        }
        if(Greenfoot.isKeyDown("a"))
        {
            turn(-3);
        }

        animateDino();
        stealEgg();
        tagged();
        speed();
        
        if(count == 3)
        {
            MyWorld world = (MyWorld) getWorld();
            world.gameOver();
        }
    }
}
