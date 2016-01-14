import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Platform extends MoveUp {
    
    public void act() {
        //beweeg naar boven
        moveUp();
        
        //verwijder object als het boven is
        if (getY() < 5) {
            getWorld().removeObject(this);
        }
    }
    
}
