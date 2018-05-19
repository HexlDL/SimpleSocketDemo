package udp.send;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 测试UDP协议,发送端
 */
public class Sender {
    public static void main(String[] args) throws IOException {
        //1.建立UDP协议
        DatagramSocket socket = new DatagramSocket();
        //2.封装数据包
        String data = "This is one UDP!!!";
        byte[] bytes = data.getBytes();
        DatagramPacket datagramPacket = new DatagramPacket(bytes, data.length(), InetAddress.getLocalHost(), 9090);
        //3.调用udp服务发送数据
        socket.send(datagramPacket);
        //4.关闭资源
        socket.close();
    }
}
