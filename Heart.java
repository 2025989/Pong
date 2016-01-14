import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Heart extends MoveUp {
    
    public Heart() {
        getImage().scale(12, 12);
    }
    
    public void act() {
        //beweeg naar boven
        moveUp();
        
        //verwijder object als het boven is
        if (getY() < 5) {
            getWorld().removeObject(this);
        }
    }
    
}
