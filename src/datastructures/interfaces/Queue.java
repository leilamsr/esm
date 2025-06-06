package datastructures.interfaces;

import java.util.NoSuchElementException;

public interface Queue<T> {
    boolean add(T t);
    boolean offer(T t);
    T remove();
    T poll();
    T element();
    T peek();
    boolean isEmpty();
    int size();
}
