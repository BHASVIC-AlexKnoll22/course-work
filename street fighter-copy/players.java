import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class players here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class players extends Actor
{
    
    // this is my delay variebale that control how fast you hare able to repeat moves
    private int delayjab;
    private int delaykick;
    private int delayrange;
    
    // this controls the gravity acting on the player
    public static final int GRAVITY = 2 ;
    
    // this group of variable act as the forces on the player. one limits the jumps and the other two are variables given the the axis speeds
    protected int xSpeed = 0;
    public int ySpeed = 0;
    int jumps=2;
    
    // this is used to the create the attacks from the world once the button has been pressed
    private punch punch;
    private kick kick;
    private jab jab;
    
    //this is used to shift through the different walk sprites to make the animations 
    private int counter = 0;
    //-----------------------------------------------------------------------------
    //stage1.2
    //-----------------------------------------------------------------------------
    
    public int health1 = 100;
    
    private void walk(){
        if((Greenfoot.isKeyDown("d"))||(Greenfoot.isKeyDown("a"))){
            switch(counter){
                case 0:
                    setImage("stickidle1.png");
                    counter=1;
                    break;
                case 1:
                    setImage("stickwalk1.png");
                    counter=2;
                    break;
                case 2:
                    setImage("stickwalk2.png");
                    counter=3;
                    break;
                case 3:
                    setImage("stickwalk3.png");
                    counter=4;
                    break;
                case 4:
                    setImage("stickwalk4.png");
                    counter=0;
                    break;
                    
            }
        }
    }
    public void damage(int d){
        health1 = health1 -d;
    }
    
    private void stuck(){
        if(isTouching(floor.class)){
            jumps=2;
            setLocation(getX(),getY()-1);
        
            
            
        }
    }
    private void gravity(){
        
        setLocation(getX(),getY()+ySpeed);
        
        
        
    }
    private void jump(){
        if(Greenfoot.isKeyDown("space")&&(jumps>=0)){
            ySpeed=-15;
            
        }
        jumps=jumps-1;
    }

    private void falling(){
        if(!isTouching(floor.class)){
            ySpeed++;
            if (ySpeed >= 3){
                setImage("stickfall.png");
            }
            if(ySpeed<1){
                setImage("stickjump.png"); 
            }
            
        }
        else{
            ySpeed=0;
            jumps=2;
            setImage("stickidle1.png");
        }
    }
    
    private void range(){
            //the if else statement creates the delay so the attack cant be spammed
            if(delayrange > 0){
                delayrange = delayrange - 1;
                setImage("stickrange.png");
            }
            else{
                if (Greenfoot.isKeyDown("c")){
                    //creates the attack object
                    World MyWorld=getWorld();
                    this.punch = new punch();
                    MyWorld.addObject(punch,getX(),getY());
            
                    delayrange =50;
                    
                }
            }
        
    }
    private void jab(){
        //the if else statement creates the delay so the attack cant be spammed
        if(delayjab > 0){
            delayjab = delayjab - 1;
            setImage("stickpunch.png");
        }
        
        else{
            if (Greenfoot.isKeyDown("v")){
                //creates the attack object
                World MyWorld=getWorld();
                this.jab = new jab();
                MyWorld.addObject(jab,getX()+60,getY());
                
                delayjab =30;
                
            }
        }
    }
    
    private void kick(){
        //the if else statement creates the delay so the attack cant be spammed
        if(delaykick > 0){
            delaykick = delaykick - 1;
            setImage("stickkick.png");
        }
        else{
            if (Greenfoot.isKeyDown("x")){
                //creates the attack object
                World MyWorld=getWorld();
                this.kick = new kick();
                MyWorld.addObject(kick,getX()+40,getY());
                
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
        range();
        jab();
        kick();
        
       
        
        
        
        
       
            
            
            
            
            
        if (Greenfoot.isKeyDown("d"))
        {
            move(5);
        }
        if (Greenfoot.isKeyDown("a"))
        {
            move(-5);
        }
        
        
        
     
        
       
        
    
        
    }
}
    
    
