import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BrickWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level2 extends World
{
    /**
     * Constructor for objects of class BrickWorld.
     * 
     */
    public Level2()
    {    
        // Create a new world with 1200x800 cells with a cell size of 1x1 pixels.
        super(1200, 800, 1, false); 
        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    
    private final float GRAVITY = 0.0667f;
    private final GreenfootSound MUSIC = new GreenfootSound("incompetech_tribal.mp3");
    private final int SPEED = 4;
    private final float JUMP_FORCE = 5.6f;
    private final int MAX_HEALTH = 3;
    final int MAX_POWERUP = 3;
    private final Class NEXT_LEVEL = WinSplash.class;
    private void prepare()
    {
        setPaintOrder(Player.class, Platform.class, Obstacle.class, Collectable.class,
            Door.class, HUD.class);
        Door door = new Door();
        addObject(door,1177,43);
        Player player = new Player(SPEED, JUMP_FORCE, GRAVITY, 
                           MAX_HEALTH, MAX_POWERUP, NEXT_LEVEL, MUSIC);
        addObject(player,20,524);
        addObject(new Floor(), 600, 800);
        addObject(new BrickWall(), 985, 104);
        player.setLocation(20,760);
        SmBrickWall smBrickWall = new SmBrickWall();
        addObject(smBrickWall,314,386);
        removeObject(smBrickWall);
        BrickWall brickWall2 = new BrickWall();
        addObject(brickWall2,335,418);
        addObject(smBrickWall,620,249);
        SmBrickWall smBrickWall2 = new SmBrickWall();
        addObject(smBrickWall2,860,576);
        SmBrickWall smBrickWall3 = new SmBrickWall();
        addObject(smBrickWall3,1033,397);
        SmBrickWall smBrickWall4 = new SmBrickWall();
        addObject(smBrickWall4,828,302);
        smBrickWall.setLocation(600,213);
        Bomb bomb = new Bomb(GRAVITY);
        addObject(bomb,412,365);
        SmBrickWall smBrickWall5 = new SmBrickWall();
        addObject(smBrickWall5,288,268);
        SmBrickWall smBrickWall6 = new SmBrickWall();
        addObject(smBrickWall6,621,674);
    }
    
    public void act()
    {
        spawn();
    }
    
    private void spawn()
    {
        if(Math.random() < 0.03)
        {
            addObject(new AcidRain(GRAVITY), Greenfoot.getRandomNumber(1200), -30);
        }
        
        if(Math.random() < 0.0025) 
        {
            addObject(new Rock(GRAVITY), Greenfoot.getRandomNumber(1200), -30);
        }
    }
}
