import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class punch2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class punch2 extends Actor
{
    
    private int delay = 60;
    private int delayk = 60;
    private punch punch;
    public trainning trainning;
    
    private void rangereg(){
        if(this.isTouching (players.class)){
             ((MyWorld)getWorld()).getPlayer1().damage(7);
             ((MyWorld)getWorld()).removeObject(this);
            
            
            
            
        }
    }
    private void rangeregrange(){
        delayk = 10;
        
    }
    private void remove(){
        ((MyWorld)getWorld()).removeObject(this);
    }
    
    
        public void act()
        {
            
            int xcoord = getX();
        
            int speed = -8;
     
            move(speed);
            rangereg();
            rangeregrange();
            if(delay > 0){
                delay = delay - 1;
            }
            else{
                if (delay<=1){
                    setImage("p2projectile2.png");
                  
                    speed = -10;
                    move(speed);
                }
            }
        
            if (xcoord>990 || xcoord<10){
                World MyWorld = getWorld();
                ((MyWorld)getWorld()).removeObject(this);
            }
        
        
    }
    
    
}
