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
    //GreenfootImage[] idleLeft = new GreenfootImage[6];
    
    boolean hasEgg1 = false;
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
        if(isTouching(Egg1.class))
        {
            boolean hasEgg1 = true;
            removeTouching(Egg1.class);
            MyWorld world = (MyWorld) getWorld();
            int location = getX();
            if(hasEgg1 = true && location <= 400)
            {
                world.increaseScore1();
            }
        }
    }
    
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
        //setLocation (getX(), getY() + 1);
        //int x = getX();
        //int y = getY();
        //setLocation(x,y);

        //if(Greenfoot.isKeyDown("left"))
        //{
        //    move(-2);
        //}
        //else if(Greenfoot.isKeyDown("right"))
        //{
        //    move(2);
        //}
        //else if(Greenfoot.isKeyDown("up"))
        //{
        //    getY() + 5);
        //}
        //previous moving method was too rigid
        animateDino();
    }
}
