package myTest.netty;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author Stephen Cai
 * @date 2018-01-30 10:03
 */
public class FirstNIO {
    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream fin = new FileInputStream("readandshow.txt");
        FileChannel fc = fin.getChannel();

        FileOutputStream fout = new FileOutputStream("writesomebytes.txt");

        FileChannel fc1 = fout.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        //for (int i = 0; i < message.length; ++i) {
        //    buffer.put(message[i]);
        //}
        //buffer.flip();
    }
}
