import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Dino here.
 * Player 1
 * on the left side of the screeen
 * @author (your name) 
 * @version (a version number or a date)
 */


public class Dino extends Actor
{
    /**
     * Act  - do whatever the Dino wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    GreenfootImage[] walking = new GreenfootImage[6];
    
    int hasEgg = 0;
    //public int score1 = 0;
    //Label score1Label;

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
     * the porportions looks like its walking towards the screen
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
    
    public void stealEgg()
    {
        Actor gotEgg1 = getOneIntersectingObject(Egg1.class);
        if(isTouching(Egg1.class))
        {
            getWorld().removeObject(gotEgg1);
            hasEgg += 1;
        }
        
        if(getX() <= 400 && hasEgg == 1)
        {
            world.increaseScore();
        }
    }

    
    //public void score1()
    //{
    //    int location = getX();
    //    
    //    if( hasEgg = 1 && getX() <= 400)
    //    {
    //        score1++;
    //    }
    //}
    
    /**
     * This new movement makes for more intresting gameplay
     */
    
    public void act()
    {
        move(3);
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
        

    }
}
