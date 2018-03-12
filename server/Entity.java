package server;

/**
 * 
 * @author Brenten
 */
public class Entity {
    
    protected int health;
    
    /**
     * Constructs Entity and initializes it with 100 health
     */
    public Entity(){
        health = 100;
    }
    
    /**
     * Gives the amount of health
     * @return health
     */
    public int getHealth(){
        return health;
    }
    
    /**
     * Returns whether entity has health left and is alive
     * @return is Entity alive
     */
    public boolean isAlive(){
        return health > 0;
    }
    
    /**
     * Takes a given amount of health away from Entity
     * @param dmg amount of health to take from Entity
     */
    public void damage(int dmg){
        health -= dmg;
    }
    
    @Override
    public String toString(){
        return "_";
    }
}
