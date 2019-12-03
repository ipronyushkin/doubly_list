package ru.doubly_list;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

class Node<E>{
    Node previous;
    Node next;
    E element;

    Node(){
        previous = null;
        next = null;
        element = null;
    }
}

public class DoublyList<E> implements List{
    private Node headNode = new Node();
    private Node tailNode = new Node();

    DoublyList(){
        headNode.next = tailNode;
        tailNode.previous = headNode;
    }

    public int size() {
        int counter = 0;
        Node n = headNode;
        while (n.element != null) {
            counter++;
            if (n.next != null) { n = n.next; }
            else { break; }
        }
        return counter;
    }

    public boolean isEmpty() {
        if (headNode.element == null) { return true; }
        else { return false; }
    }

    public boolean contains(Object o) {
        boolean res = false;
        Node n = headNode;
        while (n.element != null) {
            if (o.equals(n.element)) {
                res = true;
                break;
            }
            else {
                if (n.next != null) { n = n.next; }
                else { break; }
            }
        }
        return res;
    }

    @Override
    public Iterator iterator() throws UnsupportedOperationException{
        throw new UnsupportedOperationException();
    }

    @Override
    public Object[] toArray() throws  UnsupportedOperationException{
        throw new UnsupportedOperationException();
    }

    @Override
    public Object[] toArray(Object[] a) throws UnsupportedOperationException{
        throw new UnsupportedOperationException();
    }

    public boolean add(Object o) throws NullPointerException, IllegalArgumentException{
        boolean res = true;
        try {
            if (headNode.element != null) {
                if (tailNode.element != null) {
                    Node tmp = tailNode;
                    tailNode = new Node();
                    tailNode.previous = tmp;
                    tailNode.element = o;
                    tmp.next = tailNode;
                } else { tailNode.element = o; }
            } else { headNode.element = o; }
        } catch (NullPointerException e) {
            res = false;
        } catch (IllegalArgumentException e) {
            res = false;
        } finally {
            return res;
        }
    }

    @Override
    public boolean remove(Object o) throws UnsupportedOperationException{
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection c) throws  UnsupportedOperationException{
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection c) throws UnsupportedOperationException{
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() throws UnsupportedOperationException{
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection c) throws UnsupportedOperationException{
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection c) throws UnsupportedOperationException{
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection c) throws UnsupportedOperationException{
        throw new UnsupportedOperationException();
    }

    private Node getNode(int index) {
        int counter = 0;
        Node n = headNode;
        while (n.element != null) {
            if (counter == index) { break; }
            else {
                counter++;
                if (n.next != null) { n = n.next; }
                else { break; }
            }
        }
        return n;
    }

    public Object get(int index){
        return getNode(index).element;
    }

    public Object set(int index, Object element) {
        Node n = getNode(index);
        n.element = element;
        return n.element;
    }

    public void add(int index, Object element) {
        Node n = getNode(index);
        Node new_n = new Node();
        new_n.element = element;
        if (index != 0){
            new_n.previous = n;
            new_n.next = n.next;
            (n.next).previous = new_n;
            n.next = new_n;
        } else{
            if (headNode.element != null) {
                Node tmp = headNode;
                headNode = new Node();
                headNode.element = element;
                headNode.next = tmp;
                tmp.previous = headNode;
            } else{
                headNode.element = element;
            }
        }
    }

    public Object remove(int index) {
        Node n = getNode(index);
        Node tmp = n;
        if (!n.equals(headNode) && !n.equals(tailNode)){
            (n.previous).next = n.next;
            (n.next).previous = n.previous;
        } else {
            if (n.equals(headNode)) {
                headNode = headNode.next;
                headNode.previous = null;
            } else {
                tailNode = tailNode.previous;
                tailNode.next = null;
            }
        }
        return tmp.element;
    }

    @Override
    public int indexOf(Object o) throws UnsupportedOperationException{
        throw new UnsupportedOperationException();
    }

    @Override
    public int lastIndexOf(Object o) throws UnsupportedOperationException{
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator listIterator() throws UnsupportedOperationException{
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator listIterator(int index) throws UnsupportedOperationException{
        throw new UnsupportedOperationException();
    }

    @Override
    public List subList(int fromIndex, int toIndex) throws UnsupportedOperationException{
        throw new UnsupportedOperationException();
    }

    public void printList(){
        Node n = headNode;
        while(n.element != null){
            System.out.println(n.element);
            if (n.next != null) { n = n.next; }
            else { break; }
        }
    }
}

