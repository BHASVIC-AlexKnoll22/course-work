import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class punch here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class punch extends Actor
{
    
    private int delay = 60;
    private int delayk=10;
    private punch2 punch2;
    public trainning trainning;
    private int speed = 8;
    
    
    // this function detects if the fireball has touched a the opponent and if so it will damage 
    private void rangereg(){
        if(this.isTouching (player2.class)){
             ((MyWorld)getWorld()).getPlayer2().damage(7);
             ((MyWorld)getWorld()).removeObject(this);     
        }
    }
    //
    private void remove(){
        ((MyWorld)getWorld()).removeObject(this);
    }
    //
    public void act()
    {
        
        int xcoord = getX();

        
     
        move(speed);
        rangereg();
        
        if(delay > 0){
            delay = delay - 1;
        }
        else{
            if (delay<=1){
                setImage("projectiledone.png");
              
                speed = 10;
                move(speed);
            }
        }
        
        if (xcoord>990 || xcoord<10){
            World MyWorld = getWorld();
            ((MyWorld)getWorld()).removeObject(this);
        }
        
        
    }
    
    
}
