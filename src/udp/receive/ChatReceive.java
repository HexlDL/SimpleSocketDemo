package udp.receive;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ChatReceive extends Thread {
    @Override
    public void run() {
//        super.run();
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(9090);
            byte[] bytes = new byte[1024];
            DatagramPacket packet = new DatagramPacket(bytes, bytes.length);
            while (true) {
                socket.receive(packet);
                System.out.println(packet.getAddress().getHostAddress() + "说: " + new String(bytes));
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                socket.close();
            }
        }
    }
}
