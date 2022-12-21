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
    
    GreenfootImage[] idleRight = new GreenfootImage[6];
    //GreenfootImage[] idleLeft = new GreenfootImage[6];
    
    public Dino()
    {
        for(int i = 0; i < idleRight.length; i++)
        {
            idleRight[i] = new GreenfootImage("images/Dino walking/walk" + i + ".png");
            idleRight[i].scale(60,60);
        }
        setImage(idleRight[0]);
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
            setImage(idleRight[imageIndex]);
            imageIndex = (imageIndex + 1) % idleRight.length;
            timer.mark();
        }
    }
    
    /**
     * This new movement makes for more intresting gameplay
     */
    
    public void act()
    {
        move(3);
        if(Greenfoot.isKeyDown("right"))
        {
            turn(3);
        }
        if(Greenfoot.isKeyDown("left"))
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
        
        animateDino();
    }
}
