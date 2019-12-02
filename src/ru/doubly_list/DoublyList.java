package ru.doubly_list;

import java.util.List;

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

public class DoublyList<E> {
    public Node headNode = new Node();
    public Node tailNode = new Node();

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

    public boolean add(Object o){
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

    public Node getNode(int index) {
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

    public void printList(){
        Node n = headNode;
        while(n.element != null){
            System.out.println(n.element);
            if (n.next != null) { n = n.next; }
            else { break; }
        }
    }
}

