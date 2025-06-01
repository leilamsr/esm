package datastructures.interfaces;

public interface LinkedList<T> extends List<T> {
    void addFirst(T element);
    void addLast(T element);
    T removeFirst();
    T removeLast();
    T getFirst();
    T getLast();
    void clear();
}
