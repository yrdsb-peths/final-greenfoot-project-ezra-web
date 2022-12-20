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
     * Act - do whatever the Dino wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    GreenfootImage[] idleRight = new GreenfootImage[8];
    //GreenfootImage[] idleLeft = new GreenfootImage[6];
    
    public Dino()
    {
        for(int i = 0; i < idleRight.length; i++)
        {
            idleRight[i] = new GreenfootImage("images/dino_walking/walk" + i);
            idleRight[i].scale(50, 50);
        }
        setImage(idleRight[0]);
    }
    
    public void act()
    {
        if(Greenfoot.isKeyDown("left"))
        {
            move(-2);
        }
        else if(Greenfoot.isKeyDown("right"))
        {
            move(2);
        }
    }
}
