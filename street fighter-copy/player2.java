import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class player2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class player2 extends Actor
{
    
    
    public boolean alive;
    
    // this is my delay variebale that control how fast you hare able to repeat moves
    private int delayjab;
    private int delaykick;
    private int delayrange;
    
    // this controls the gravity acting on the player
    public static final int GRAVITY = 2 ;
    
    // this group of variable act as the forces on the player. one limits the jumps and the other two are variables given the the axis speeds
    protected int xSpeed = 0;
    public int ySpeed = 0;
    private int jump;
    
    // this is used to the create the attacks from the world once the button has been pressed
    private punch2 punch2;
    private kick2 kick2;
    private jab2 jab2;
    
    //this is used to shift through the different walk sprites to make the animations 
    private int counter = 0;
    //-----------------------------------------------------------------------------
    
    public int health2 = 100;
    
    public void removeprojectile(){
        
        ((MyWorld)getWorld()).removeObject(punch2);
        
    }
    private void walk(){
        if((Greenfoot.isKeyDown("right"))||(Greenfoot.isKeyDown("left"))){
            switch(counter){
                case 0:
                    setImage("p2idle.png");
                    counter=1;
                    break;
                case 1:
                    setImage("p2walk1.png");
                    counter=2;
                    break;
                case 2:
                    setImage("p2walk2.png");
                    counter=3;
                    break;
                case 3:
                    setImage("p2walk3.png");
                    counter=4;
                    break;
                
                    
            }
        }
        
    }
    public void damage(int d){
        health2 = health2 -d;
    }
    
    private void stuck(){
        if(isTouching(floor.class)){
            
            setLocation(getX(),getY()-1);
            jump = 2;
            
            
        }
    }
    private void gravity(){
        
        setLocation(getX(),getY()+ySpeed);
        
        
        
    }
    private void jump(){
        if(Greenfoot.isKeyDown("up")&&(jump>=2)){
            ySpeed=-15;
            jump = jump-1;
            
        }
        
    }

    private void falling(){
        if(!isTouching(floor.class)){
            ySpeed++;
            if (ySpeed >= 3){
                setImage("p2fall.png");
            }
            if(ySpeed<1){
                setImage("p2jump.png"); 
            }
            
        }
        else{
            ySpeed=0;
            
            setImage("p2idle.png");
        }
    }
    
    private void range(){
        //the if else statement creates the delay so the attack cant be spammed
        if(delayrange > 0){
            delayrange = delayrange - 1;
            setImage("p2range.png");
        }
        else{
            if (Greenfoot.isKeyDown("/")){
                //creates the attack object
                World MyWorld=getWorld();
                this.punch2 = new punch2();
                MyWorld.addObject(punch2,getX(),getY());
                delayrange =50;
                    
            }
        }
    }
    private void jab(){
        //the if else statement creates the delay so the attack cant be spammed
        if(delayjab > 0){
            delayjab = delayjab - 1;
            
            setImage("p2punch.png");
        }
        else{
            if (Greenfoot.isKeyDown(",")){
                //creates the attack object
                World MyWorld=getWorld();
                this.jab2 = new jab2();
                MyWorld.addObject(jab2,getX()-60,getY());
                delayjab =30;
                
            }
        }
    }
    private void kick(){
        //the if else statement creates the delay so the attack cant be spammed
        
        if(delaykick > 0){
            delaykick = delaykick - 1;
            setImage("p2kick.png");
        }
        else{
            if (Greenfoot.isKeyDown(".")){
                //creates the attack object
                World MyWorld=getWorld();
                this.kick2 = new kick2();
                MyWorld.addObject(kick2,getX()-20,getY());
                delaykick =30;
                
            }
        }
    }
    
    
   
  
    public void act()
    {
        
        walk();
        stuck();
        jump();
        falling();
        gravity();
        
        //these are the functions that will run the attacks 
        range();
        jab();
        kick();
   
        if (Greenfoot.isKeyDown("right"))
        {
            move(5);
        }
        if (Greenfoot.isKeyDown("left"))
        {
            move(-5);
        }
    }
}
    
    
