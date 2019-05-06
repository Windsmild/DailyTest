package multiThread.NIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Stephen Cai
 * @date 2019-03-15 09:58
 */
public class NIOServer extends Thread{
    @Override public void run() {
        try (Selector selector = Selector.open();ServerSocketChannel serverSocket = ServerSocketChannel.open()){
           serverSocket.bind(new InetSocketAddress(InetAddress.getLocalHost(), 8888));
           serverSocket.configureBlocking(false);
           serverSocket.register(selector, SelectionKey.OP_ACCEPT);
           while (true) {
               selector.select();// 阻塞等待就绪的 Channel，这是关键点之一
               Set<SelectionKey> selectionKeys = selector.selectedKeys();
               Iterator<SelectionKey> iter = selectionKeys.iterator();
               while (iter.hasNext()) {
                   SelectionKey key = iter.next();
                   sayHelloWorld((ServerSocketChannel) key.channel());
                   iter.remove();
               }
           }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void sayHelloWorld(ServerSocketChannel server) throws IOException {
        try (SocketChannel client = server.accept()){
            client.write(Charset.defaultCharset().encode("Hello world!"));

        }
    }
    public static void main(String[] args) throws IOException{
        DemoServer server = new DemoServer();
        server.run();
        try(Socket client = new Socket(InetAddress.getLocalHost(), server.getPort())) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            bufferedReader.lines().forEach(s -> System.out.println(s));
        }

    }
}

