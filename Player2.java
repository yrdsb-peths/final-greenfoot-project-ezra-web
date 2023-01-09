import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player2 extends Actor
{
    /**
     * Act - do whatever the Player2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    GreenfootImage[] walk = new GreenfootImage[6];
    
    public void act() 
    {
        move(-3);
        if(Greenfoot.isKeyDown("right"))
        {
            turn(3);
        }
        if(Greenfoot.isKeyDown("left"))
        {
            turn(-3);
        }
        animateMuchkin();
    }    
    
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
    
    public Player2()
    {
        for(int i = 0; i < walk.length; i++)
        {
            walk[i] = new GreenfootImage("images/player walking/Muchkin" + i + ".png");
            walk[i].mirrorHorizontally();
            walk[i].scale(55,55);
        }
    }
    
}
