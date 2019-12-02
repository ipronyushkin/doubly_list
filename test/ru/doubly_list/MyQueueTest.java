package ru.doubly_list;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class MyQueueTest {
    MyQueue testQueue = new MyQueue();

    @Test
    public void testIsEmpty() {
        assertEquals(true, testQueue.isEmpty());
    }

    @Test
    public void testRemove() throws NoSuchElementException {
        try{
            testQueue.remove();
        } catch (NoSuchElementException err){
            throw new NoSuchElementException();
        }
    }

    @Test
    public void testPoll() {
        testQueue.add(10);
        testQueue.add(9);
        testQueue.poll();
        assertEquals(9, testQueue.peek());
    }

    @Test
    public void testElement() throws NoSuchElementException {
        try{
            testQueue.element();
        } catch (NoSuchElementException err) {
            throw new NoSuchElementException();
        }
    }

    @Test
    public void testPeek() {
        testQueue.add(10);
        testQueue.add(9);
        assertEquals(10, testQueue.peek());
    }
}

