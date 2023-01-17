import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PowerUp here.
 * randonmly spawns a shoe that if collected will increase speed by 1
 * @author Ezra Kung
 * @version Final Game
 */
public class PowerUp extends Actor
{
    /**
     * Act - do whatever the PowerUp wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void act() 
    {
        int x = getX();
        int y = getY();
        setLocation(x,y);
    }    
}
