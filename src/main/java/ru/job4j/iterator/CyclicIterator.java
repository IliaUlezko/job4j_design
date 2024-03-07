package ru.job4j.iterator;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class CyclicIterator<T> implements Iterator<T> {

    private List<T> list;
    private int index;

    public CyclicIterator(List<T> list) {
        this.list = list;
        index = 0;
    }

    @Override
    public boolean hasNext() {
        if (index == list.size()) {
            index = 0;
        }
        return index < list.size();
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return list.get(index++);
    }
}
