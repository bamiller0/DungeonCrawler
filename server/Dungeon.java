package server;

import java.util.ArrayList;

/**
 * Dungeon class that controls stores and controls movement of Entities
 * @author Brenten Miller
 */
public class Dungeon {
    private Entity[] map = new Entity[20];
    
    /**
     * Constructs Dungeon and populates it with Player and Enemies
     */
    public Dungeon(){
        map[0] = new Player();
        map[4] = new Enemy();
        map[9] = new Enemy();
        map[14] = new Enemy();
    }
    
    /**
     * Returns Entity at given index in the Dungeon
     * @param i index to return from
     * @return Entity at given index
     */
    public Entity get(int i){
        return map[i];
    }
    
    /**
     * Removes Entity at given index by setting index to null
     * @param i index to set to null
     */
    public void remove(int i){
        map[i] = null;
    }
    
    /**
     * Finds and returns the index where Player is stored
     * @return index of Player
     */
    public int findPlayer(){
        for(int i=0; i<map.length; i++){
            if(map[i] instanceof Player){
                return i;
            }
        }
        return -1;
    }
    
    /**
     * Moves Entity one index to the right
     * @param i Index where Entity is currently stored
     */
    public void moveRight(int i){
        if(map[i+1]==null){
            map[i+1] = map[i];
            map[i] = null;
        }else{
            map[i].damage(50);
        }
    }
    
    /**
     * Moves Entity one index to the left
     * @param i Index where Entity is currently stored
     */
    public void moveLeft(int i){
        map[i-1] = map[i];
        map[i] = null;
    }
    
    @Override
    public String toString(){
        String out = "";
        
        for(int i=0; i<map.length; i++){
            if(map[i] instanceof Entity){
                out += map[i].toString();
            }else{
                out += "_";
            }
        }
        return out;
    }
    
}
