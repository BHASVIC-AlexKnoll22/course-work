import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class MyWorld extends World
{
    protected int floorcoord = 0;
    private players player1;
    private trainning trainning1;
    private player2 player2;
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        
    
        super(1000, 700, 1);
        player1 = new players();
        player2 = new player2();
        trainning1 = new trainning();
        
        addObject(player1,106,600);
        addObject(player2,900,600);
        
        
        addObject(new floor(),190,694);
        addObject(new floor(),574,694);
        addObject(new floor(),958,694);
        }
        
    public void removePunch(){
        
    }
    
    public players getPlayer1(){
        return player1;
    }
    public player2 getPlayer2(){
        return player2;
    }
    
    public trainning getTrainning(){
        return trainning1;
    }
    
    
    
}
