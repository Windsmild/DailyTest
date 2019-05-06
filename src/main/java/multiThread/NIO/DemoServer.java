package multiThread.NIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * BIO 和 NIO 作为 Server 端，当建立了 10 个连接时，分别产生多少个线程？
 * 答案： 因为传统的 IO 也就是 BIO 是同步线程堵塞的，所以每个连接都要分配一个专用线程来处理请求，这样 10 个连接就会创建 10 个线程去处理。而 NIO 是一种同步非阻塞的 I/O 模型，它的核心技术是多路复用，可以使用一个链接上的不同通道来处理不同的请求，所以即使有 10 个连接，对于 NIO 来说，开启 1 个线程就够了。
 *
 *
 * 作者：王磊的博客
 * 链接：https://juejin.im/post/5c8aea1df265da2de33f6a09
 * 来源：掘金
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @author Stephen Cai
 * @date 2019-03-15 09:46
 */
public class DemoServer extends Thread{
    private ServerSocket serverSocket;
    public int getPort() {
        return serverSocket.getLocalPort();
    }
    @Override public void run() {
       try {
           serverSocket = new ServerSocket(0);
          while (true) {
              Socket socket = serverSocket.accept();
              RequestHandler requestHandler = new RequestHandler(socket);
              requestHandler.start();
          }
       } catch (IOException e) {
           e.printStackTrace();
       } finally {
           if (serverSocket != null) {
               try {
                   serverSocket.close();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
       }
    }

    public static void main(String[] args) throws IOException{
        DemoServer server = new DemoServer();
        server.start();
        server.run();
        try(Socket client = new Socket(InetAddress.getLocalHost(), server.getPort())) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            bufferedReader.lines().forEach(s -> System.out.println(s));
        }

    }
}

//简化实现，不做读取，直接发送字符串
class RequestHandler extends Thread {
    private Socket socket;
    RequestHandler(Socket socket) {
        this.socket = socket;
    }

    @Override public void run() {
       try (PrintWriter out = new PrintWriter(socket.getOutputStream())) {
          out.print("Hello world!");
          out.flush();
       } catch (IOException e) {
           e.printStackTrace();
       }
    }
}
