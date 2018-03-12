import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;


/**
 * Client for Dungeon Crawler
 * @author Brenten Miller
 */
public class GameClient{
    
    public static void main(String[] args){
        InetAddress ip;
        int port;
        Scanner console = new Scanner(System.in);
        
        try {
            System.out.println("Enter IP address of server");
            ip = InetAddress.getByName(console.next());
            System.out.println("Enter port of server");
            port = console.nextInt();
            
            DatagramSocket socket = new DatagramSocket();
            
            DatagramPacket start = new DatagramPacket(new byte[1], 1, ip, port);
            socket.send(start);
            
            
            byte[] buffer = new byte[512];
            DatagramPacket response = new DatagramPacket(buffer, buffer.length);
            socket.receive(response);
            
            String output = new String(buffer, 0, response.getLength());
                
            System.out.println(output);
            System.out.println();
            System.out.println("[1] Move Left");
            System.out.println("[2] Move Right");
            System.out.println("[3] Attack");
                
            while(true){
                
                
                Integer message = console.nextInt();
                byte[] msg = {message.byteValue()};
                DatagramPacket request = new DatagramPacket(msg, msg.length, ip, port);
                socket.send(request);
                
                buffer = new byte[512];
                response = new DatagramPacket(buffer, buffer.length);
                socket.receive(response);
                
                output = new String(buffer, 0, response.getLength());
                
                System.out.println(output);
                System.out.println();
				System.out.println();
				System.out.println();
            }
        } catch (SocketException ex) {
        } catch (UnknownHostException ex) {
        } catch (IOException ex) {
        }
    }
    
}
