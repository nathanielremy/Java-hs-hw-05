package space.harbour.java.hw2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.awt.desktop.SystemSleepEvent;
import java.util.HashMap;

import static org.junit.Assert.*;

public class MyHashMapTest {

    MyHashMap<Integer, Integer> myHashMap;

    @Before
    public void setUp() throws Exception {
        myHashMap = new MyHashMap<Integer, Integer>();
        myHashMap.put(20, 30);
        myHashMap.put(22, 33);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void size() {
        assertTrue(100 == myHashMap.size());
        assertFalse(101 == myHashMap.size());
    }

    @Test
    public void isEmpty() {
        myHashMap.clear();
        assertTrue(true == myHashMap.isEmpty());

        myHashMap.put(10, 20);
        assertFalse(true == myHashMap.isEmpty());
    }

    @Test
    public void containsKey() {
        myHashMap.clear();
        myHashMap.put(11, 22);
        assertTrue(myHashMap.containsKey(11));

        myHashMap.remove(11);
        assertFalse(myHashMap.containsKey(11));
    }

    @Test
    public void containsValue() {
        myHashMap.clear();
        myHashMap.put(9, 10);
        assertTrue(myHashMap.containsValue(10));

        myHashMap.remove(9);
        assertFalse(myHashMap.containsValue(10));
    }

    @Test
    public void get() {
        myHashMap.clear();
        myHashMap.put(10, 20);
        myHashMap.put(11, 22);

        assertTrue(myHashMap.get(10) == 20);
        assertTrue(myHashMap.get(11) == 22);

        myHashMap.remove(10);
        myHashMap.remove(11);

        assertFalse(myHashMap.get(10) == 20);
        assertFalse(myHashMap.get(11) == 22);
    }

    @Test
    public void put() {
        myHashMap.clear();
        myHashMap.put(11, 33);

        assertTrue(myHashMap.containsKey(11));
        assertTrue(myHashMap.containsValue(33));

        myHashMap.remove(11);
        assertFalse(myHashMap.containsValue(33));
        assertFalse(myHashMap.containsKey(11));
    }

    @Test
    public void remove() {
        myHashMap.clear();
        myHashMap.put(21, 43);
        myHashMap.put(22, 44);
        myHashMap.remove(22);

        assertFalse(myHashMap.containsKey(22));
        assertTrue(myHashMap.containsValue(44) == false);
    }

    @Test
    public void putAll() {
    }

    @Test
    public void clear() {
        myHashMap.clear();
        assertEquals(100, myHashMap.size());

        for(int i = 0; i < myHashMap.elements.length; i++) {
            int index = myHashMap.getHash(i);
            assertTrue(myHashMap.elements[index] == null);
        }
    }

    @Test
    public void keySet() {
    }

    @Test
    public void values() {
    }

    @Test
    public void entrySet() {
    }
}