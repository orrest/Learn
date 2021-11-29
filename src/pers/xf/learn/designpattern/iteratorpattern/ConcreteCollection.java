package pers.xf.learn.designpattern.iteratorpattern;

import java.util.ArrayList;
import java.util.List;

public class ConcreteCollection<E> implements ICollection<E> {
    private final List<E> list = new ArrayList<E>();

    @Override
    public boolean add(E element) {
        return list.add(element);
    }

    @Override
    public boolean remove(E element) {
        return list.remove(element);
    }

    @Override
    public Iterator<E> iterator() {
        return new ConcreteIterator<E>(list);
    }
}
