package pers.xf.learn.designpattern.iteratorpattern;

public interface ICollection<E> {
    boolean add(E element);
    boolean remove(E element);
    Iterator<E> iterator();
}
