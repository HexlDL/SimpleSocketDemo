package tcp;

import java.io.*;
import java.net.Socket;

/**
 * 客户端
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8088);
        OutputStream os = socket.getOutputStream();//得到个输出流
        BufferedWriter buffWriter = new BufferedWriter(new OutputStreamWriter(os));//将字节流转换成字符流
        PrintWriter pw = new PrintWriter(buffWriter);//将输出流包装成打印流
        pw.println("服务端你好: 何旭龙");//向服务端发送的信息
        pw.flush();//刷新缓冲区
        buffWriter.flush();//刷新字符流
        socket.shutdownOutput();//关闭输出流

        /*
         * 获取服务端的消息
         */
        InputStream is = socket.getInputStream();
        BufferedReader buffReader = new BufferedReader(new InputStreamReader(is));
        String line = "";
        if ((line = buffReader.readLine()) != null) {
            System.out.println("服务端的消息内容为:  "+ line);
        }

        //关闭流
        socket.shutdownInput();
        os.close();
        pw.close();
        buffWriter.close();
        is.close();
        buffReader.close();

    }
}
