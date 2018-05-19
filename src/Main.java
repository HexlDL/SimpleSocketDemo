import udp.receive.ChatReceive;
import udp.send.ChatSender;

public class Main {

    public static void main(String[] args) {
        ChatReceive receive = new ChatReceive();
        ChatSender sender = new ChatSender();
        receive.start();
        sender.start();
    }
}
