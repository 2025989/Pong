import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Spike extends MoveUp {
    
    public Spike() {
        GreenfootImage spike = new GreenfootImage("thief.png");
        
        //maak klein plaatje
        spike.scale(22, 22);
        
        //maak groot plaatje
        getImage().clear();
        getImage().scale(66, 22);
        
        //zet kleine plaatjes in groot plaatje
        for (int i = 0; i < 3; i++) {
            getImage().drawImage(spike, 22*i, 0);
        }
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
