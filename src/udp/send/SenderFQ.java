package udp.send;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class SenderFQ {

    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();
        //封装数据包
        byte buf[] = getFQData("Hi FQ!").getBytes();
        DatagramPacket packet = new DatagramPacket(buf, buf.length, InetAddress.getLocalHost(), 2425);
        //发送数据
        socket.send(packet);
        //关闭资源
        socket.close();
    }

    /**
     * 任何网络通讯软件都会有自己的处理数据格式，不符合格式就当垃圾数据处理
     * feiQ处理数据格式：
     * version:time:sender:ip:flag:content
     * 版本号：时间：发送人：IP地址：标识符（32）：真正的内容；
     *
     * @return
     */
    private static String getFQData(String msg) {
        return "1.0:" +
                System.currentTimeMillis() + ":" +
                "何旭龙:" +
                "192.168.2.76:" +
                "32:" +
                msg;
    }
}
