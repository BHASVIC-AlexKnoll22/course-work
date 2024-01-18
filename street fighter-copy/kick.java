import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class kick here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class kick extends Actor
{
    private int delay = 1;
    private void remove(){
        if(delay > 0){
            delay = delay - 1;
        }
        else{
            if (delay<=1){
                ((MyWorld)getWorld()).removeObject(this);
                
                
                
                
            }
        }
        
    }
    private void kickreg(){
        if(this.isTouching (player2.class)){
             ((MyWorld)getWorld()).getPlayer2().damage(7);
             ((MyWorld)getWorld()).removeObject(this);     
        }
    }
    /**
     * Act - do whatever the kick wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void act()
    {
        kickreg();
        remove();
        
        
    }
}
