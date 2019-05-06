package leetcode;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * @author Stephen Cai
 * @date 2019-05-05 10:09
 */
public class MyPriorityQueue<E> extends AbstractQueue<E> implements java.io.Serializable {
    private static final long serialVersionUID = -12412342345391243L;
    private static final int   DEFAULT_INITIAL_CAPACITY =11;

    transient Object[] queue;
    private  int size = 0;
    //private final Comparable<? super E> comparator;


    @Override public Iterator<E> iterator() {
        return null;
    }

    @Override public void forEach(Consumer<? super E> action) {

    }

    @Override public boolean removeIf(Predicate<? super E> filter) {
        return false;
    }

    @Override public Spliterator<E> spliterator() {
        return null;
    }

    @Override public Stream<E> stream() {
        return null;
    }

    @Override public Stream<E> parallelStream() {
        return null;
    }

    @Override public int size() {
        return 0;
    }

    @Override public boolean offer(E e) {
        return false;
    }

    @Override public E poll() {
        return null;
    }

    @Override public E peek() {
        return null;
    }
}
