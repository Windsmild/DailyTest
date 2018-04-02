package myTest;

import java.io.*;

/**
 * Created by Stephen Cai on 2017-09-03 13:02.
 */
public class FileTest {
	public static void main(String[] args) throws IOException {
//		File file = new File("./" + "test.txt");
//		file.createNewFile();
//		BufferedWriter out = new BufferedWriter(new FileWriter(file));
//		out.write("员工手机号,员工卡号,员工状态\r\n"); // \r\n即为换行
//		out.write("111,111,111\r\n");
//		out.write("111,111,111\r\n");
//		out.write("111,111,111\r\n");
//		out.flush(); // 把缓存区内容压入文件
//		out.close(); // 最后记得关闭文件

		PipedOutputStream outputStream = new PipedOutputStream();
//			file.createNewFile(); // 创建新文件
//			BufferedWriter out = new BufferedWriter(new FileWriter(file));
		PipedInputStream inputStream = new PipedInputStream();
		outputStream.connect(inputStream);
		outputStream.write("员工手机号,员工卡号,员工状态\r\n".getBytes()); // \r\n即为换行
		outputStream.write("11,11,11\r\n".getBytes()); // \r\n即为换行
		outputStream.write("11,11,11\r\n".getBytes()); // \r\n即为换行
		byte[] buf = new byte[1024];
		int len = inputStream.read(buf);  //read阻塞
		String s= new String(buf,0,len);
		System.out.println(s);
		outputStream.close();
	}
}
