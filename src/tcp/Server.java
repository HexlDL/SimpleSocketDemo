package tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8088);
        System.out.println("服务端已启动,等待连接...");
        //侦听并接受到此套接字的连接,返回一个Socket对象
        Socket socket = serverSocket.accept();
        /*
         * 根据输入输出流和客户端连接
         */
        InputStream is = socket.getInputStream();//得到一个输入流,接收客户端的消息
        BufferedReader buffReader = new BufferedReader(new InputStreamReader(is));//将字节流包装成字符流
        String line = "";
        while ((line = buffReader.readLine()) != null) {
            System.out.println("已收到客户端连接");
            System.out.println("你好,服务端已收到消息,内容为:  " + line + "   连接地址: " + socket.getLocalAddress() + "  端口号:  " + socket.getPort());
        }
        socket.shutdownInput();

        /*
         * 向客户端发送消息
         */
        OutputStream os = socket.getOutputStream();//获取输出流
        PrintWriter pw = new PrintWriter(os);//将输出流包装成打印流
        pw.println("Hello Client Server Roger that Msg");//发送到客户端的消息
        pw.flush();
        socket.shutdownOutput();

        //关闭流
        is.close();
        pw.close();
        os.close();
        buffReader.close();
    }
}
