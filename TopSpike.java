import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class TopSpike extends Actor {
    
    public TopSpike() {
        GreenfootImage spike = new GreenfootImage("thief.png");
        
        //maak plaatje klein
        spike.scale(22, 22);
        
        //maak een groot plaatje
        getImage().clear();
        getImage().scale(308, 22);
        
        //zet kleine plaatjes in het grote plaatje
        for (int i = 0; i < 14; i++) {
            getImage().drawImage(spike, 22*i, 0);
        }
    }
    
}
