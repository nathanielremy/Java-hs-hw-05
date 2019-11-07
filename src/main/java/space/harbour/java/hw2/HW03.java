package space.harbour.java.hw2;

import java.util.Collection;
import java.util.Map;
import java.util.Set;


public class HW03 {
    public static void main(String[] args) {
        MyHashMap<Integer, Integer> myMap = new MyHashMap<Integer, Integer>(200, 30);
        myMap.put(20, 30);
        myMap.put(22, 33);
    }
}

abstract class MyHashMap<K, V> implements Map<K, V> {

    KeyValPair<K, V> elements[] = new KeyValPair[100];

    private int getHash(K key) {
        int hash = key.hashCode();
        return hash % 100;
    }

    @Override
    public int size() {
        return elements.length;
    }

    @Override
    public boolean isEmpty() {
        return elements.length == 0;
    }

    @Override
    public boolean containsKey(K key) {
        int index = getHash(key);
        return (elements[index] == null);
    }

    @Override
    public boolean containsValue(V value) {

        return true;
    }

    @Override
    public V get(K key) {
        int index = getHash(key);
        return elements[index].value;
    }

    public void put(K key, V value) {
        int index = getHash(key);
        storeValue(index, key, value);
    }

    @Override
    public void remove(K key) {
        int index = getHash(key);
        KeyValPair<K, V> list = elements[index];

        if (list == null) {
            return;
        }

        if(list.getKey().equals(key)){
            if (list.next == null){
                elements[index] = null;
                return;
            }
        }
        KeyValPair<K, V> prev = null;
        do {
            if(list.key.equals(key)) {
                if (prev == null) {
                    list = list.getNext();
                } else {
                    prev.next = list.getNext();
                }

                break;
            }
            list = list.next;
        }  while(list != null);

        elements[index] = list;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> map) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }


    private V getMatchValue(KeyValPair<K, V> list, K key) {
        while (list != null) {
            if (list.getKey().equals(key)) {
                return list.getValue();
            }

            list = list.next;
        }
        return null;
    }

    private void storeValue(int index, K key, V value) {
        KeyValPair<K, V> list = elements[index];

        // if list is empty , enter as first element
        if (list == null) {
            elements[index] = new KeyValPair<K, V>(key, value);
        } else {
            boolean done = false;
            // traverse through list , if a key is found ,replace the value or add it at the end of the list
            while(list.next != null) {
                if (list.getKey().equals(key)) {
                    list.setValue(value);
                    done = true;
                    break;
                }
                list = list.next;
            }
            // add at the end of the list
            if (!done)
                list.next = new KeyValPair<K, V>(key, value);
        }
    }

    public static void main(String args[]) {
    }
}


class KeyValPair<K, V> {
    K key;
    V value;
    KeyValPair<K, V> next = null;

    public KeyValPair<K, V> getNext() {
        return next;
    }

    public void setNext(KeyValPair<K, V> next) {
        this.next = next;
    }

    public KeyValPair(K key, V value) {
        super();
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
