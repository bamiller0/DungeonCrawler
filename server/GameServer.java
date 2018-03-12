package server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * Plays the game
 * @author Brenten Miller
 */
public class GameServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Dungeon dun = new Dungeon();
		int port = 50000;
        try {
            System.out.println(InetAddress.getLocalHost());
            DatagramSocket socket = new DatagramSocket(port);
			System.out.println(port);
            
            byte[] buffer = new byte[10];
            DatagramPacket request = new DatagramPacket(buffer, buffer.length);
            socket.receive(request);
            
            InetAddress ip = request.getAddress();
			port = request.getPort();
            
            DatagramPacket response = new DatagramPacket(dun.toString().getBytes(), dun.toString().getBytes().length, ip, port);
            socket.send(response);
            
            while(dun.get(dun.findPlayer()).isAlive()&&dun.findPlayer()!=19){
                
                buffer = new byte[10];
                request = new DatagramPacket(buffer, buffer.length);
                socket.receive(request);
                int i = buffer[0];
                
                switch (i) {
                    case 1:
						if(dun.findPlayer()!=0){
							dun.moveLeft(dun.findPlayer());
							break;
						}
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
                if(dun.findPlayer()!=19 && dun.get(dun.findPlayer()).isAlive()){    
                    response = new DatagramPacket(dun.toString().getBytes(), dun.toString().getBytes().length, ip, port);
                    socket.send(response);
                }else if(dun.get(dun.findPlayer()).isAlive()){
                    String message = dun + "\nYOU WIN!";
                    response = new DatagramPacket(message.getBytes(), message.getBytes().length, ip, port);
                    socket.send(response);
                }
                if(!dun.get(dun.findPlayer()).isAlive()){
                    String message = dun + "\nYOU DIED!";
                    response = new DatagramPacket(message.getBytes(), message.getBytes().length, ip, port);
                    socket.send(response);
                }
            }
            socket.close();
        } catch (SocketException ex) {
        } catch (IOException ex) {
        }
    }
    
}
