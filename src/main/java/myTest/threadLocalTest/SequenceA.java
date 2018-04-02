package myTest.threadLocalTest;

/**
 * Created by Stephen Cai on 2017-11-19 22:06.
 */
public class SequenceA implements Sequence {

    private  int number = 0;

    @Override public int getNumber() {
        number = number + 1;
        return number;
    }

    public static void main(String[] args) {
        Sequence sequence = new SequenceA();

        ClientThread thread1 = new ClientThread(sequence);
        ClientThread thread2 = new ClientThread(sequence);
        ClientThread thread3 = new ClientThread(sequence);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}