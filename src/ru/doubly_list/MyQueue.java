package ru.doubly_list;

import java.util.*;

public class MyQueue<E> extends DoublyList{

    public Object remove() throws NoSuchElementException {
        try{
            return remove(0);
        } catch (NoSuchElementException err) {
            throw new NoSuchElementException();
        }
    }

    public Object poll() {
        return remove(0);
    }

    public Object element() throws NoSuchElementException{
        try{
            return get(0);
        } catch (NoSuchElementException err) {
            throw new NoSuchElementException();
        }
    }

    public Object peek() {
        return get(0);
    }
}

