package datastructures.interfaces;

public interface Collection<T> {
    boolean add(Object o);
    boolean remove(Object o);
    boolean contains(Object o);
    int size();
    boolean isEmpty();
}
