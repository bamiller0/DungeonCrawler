/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon.crawler.cosc331;

import java.util.Scanner;

/**
 * Plays the game
 * @author Brenten Miller
 */
public class DungeonCrawlerCOSC331 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Dungeon dun = new Dungeon();
        Scanner input = new Scanner(System.in);
        
        System.out.println("Health: " + dun.get(dun.findPlayer()).getHealth());
        System.out.println(dun);
        
        while(dun.get(dun.findPlayer()).isAlive()&&dun.findPlayer()!=19){
            
            System.out.println("[1] Move Left");
            System.out.println("[2] Move Right");
            System.out.println("[3] Attack");
            
            switch (input.nextInt()) {
                case 1:
                    dun.moveLeft(dun.findPlayer());
                    break;
                case 2:
                    dun.moveRight(dun.findPlayer());
                    break;
                case 3:
                    dun.remove(dun.findPlayer()+1);
                    break;
                default:
                    break;
            }
            
            System.out.println("\n\n\nHealth: " + dun.get(dun.findPlayer()).getHealth());
            System.out.println(dun);
        }
        if(dun.get(dun.findPlayer()).isAlive()){
            System.out.println("YOU WIN!");
        }else{
            System.out.println("YOU DIED");
        }
    }
    
}
