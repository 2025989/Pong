import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MoveUp extends Actor {
    
    public static int speed;
    public static boolean isGameOver;
    
    public void moveUp() {
        //beweeg naar boven
        if (!isGameOver) {
            setLocation(getX(), getY()-speed);
        }
    }
    
}
