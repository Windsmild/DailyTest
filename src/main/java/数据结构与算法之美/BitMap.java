package 数据结构与算法之美;

/**
 * 布隆过滤器
 * @author Stephen Cai
 * @date 2019-04-06 20:25
 */
// Java 中 char 类型占 16bit，也即是 2个字节
public class BitMap {
    private char[] bytes;
    private int nbits;

    public BitMap(int nbits) {
        this.nbits = nbits;
        this.bytes = new char[nbits/16 +1];
    }
    public void  set(int k) {
        if (k > nbits) return;
        int byteIndex = k / 16;
        int bitIndex = k % 16;
        bytes[byteIndex] |= (1<< bitIndex);
    }
    public  boolean get(int k) {
        if (k > nbits) return false;
        int byteIndex = k/16;
        int bitIndex = k % 16;
        return (bytes[byteIndex] & (1 <<bitIndex)) != 0;
    }
}
