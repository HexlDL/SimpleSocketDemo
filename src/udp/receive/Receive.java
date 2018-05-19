package udp.receive;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 测试udp协议 接收端
 */
public class Receive {
    public static void main(String[] args) throws IOException {
        //1.建立UDP协议,监听端口9090
        DatagramSocket socket = new DatagramSocket(9090);
        //2.准备一个空数据包
        byte[] bytes = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);
        //3.调用UDP服务接收数据
        socket.receive(datagramPacket);
        System.out.println("接收到的数据:   "+ new String(bytes));
        //4.关闭资源
        socket.close();
    }
}
