import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class trainning here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class trainning extends Actor
{
    private punch punch;
    private int health = 100;
    /**
     * Act - do whatever the trainning wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private void jabreg(){
        if(this.isTouching (jab.class)){
            health = health-5;
            
            
        }
    }
    private void rangereg(){
        if(this.isTouching (punch.class)){
            health = health-20;
            
            
            
            
        }
    }
     private void kickreg(){
        if(this.isTouching (kick.class)){
            health = health-10;
            
            
            
            
        }
    }
    public void act()
    {
        jabreg();
        rangereg();
        if(health <= 0){
            ((MyWorld)getWorld()).removeObject(this);
        }
    }
    
    public void damage(int d){
        health = health - d;
    }
}
