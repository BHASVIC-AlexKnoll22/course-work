import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class jab2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class jab2 extends Actor
{
    private int delay = 1;
    /**
     * Act - do whatever the jab2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
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
    
    private void jabreg1(){
        if(this.isTouching (trainning.class)){
            ((MyWorld)getWorld()).removeObject(this);
        }
    }
    public void act()
    {
       
       remove(); 
    }
}
