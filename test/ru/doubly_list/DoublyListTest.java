package ru.doubly_list;

import org.junit.*;
import static org.junit.jupiter.api.Assertions.*;

public class DoublyListTest {
    DoublyList testList = new DoublyList();
    int first = 0;
    int last;

    @Before
    public void setUp() {
        testList.add(10);
        testList.add(9);
    }

    @Test
    public void testSize() {
        assertEquals(2, testList.size());
    }

    @Test
    public void testIsEmpty() {
        assertEquals(false, testList.isEmpty());
    }

    @Test
    public void testContains() {
        assertEquals(true, testList.contains(10));
        assertEquals(false, testList.contains(11));
    }

    @Test
    public void testAdd01() {
        last = testList.size() - 1;
        assertEquals(9, testList.get(last));
    }

    @Test
    public void testSet() {
        testList.add(11);
        last = testList.size() - 1;
        assertEquals(11, testList.get(last));
        testList.set(last, 8);
        assertEquals(8, testList.get(last));
    }

    @Test
    public void testAdd02() {
        testList.add(0, 11);
        assertEquals(11, testList.get(first));
    }

    @Test
    public void testRemove() {
        testList.remove(first);
        assertEquals(9, testList.get(first));
    }
}

