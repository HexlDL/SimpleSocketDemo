package udp.send;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ChatSender extends Thread {
    @Override
    public void run() {
//        super.run();
        DatagramSocket socket = null;
        BufferedReader reader = null;
        try {
            socket = new DatagramSocket();
            //键盘录入
            reader = new BufferedReader(new InputStreamReader(System.in));
            DatagramPacket packet = null;
            String line = null;
            while ((line = reader.readLine()) != null) {//群聊地址(局域网前面3位.255)
                packet = new DatagramPacket(line.getBytes(),line.getBytes().length,InetAddress.getByName("192.168.2.255"),9090);
                socket.send(packet);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
