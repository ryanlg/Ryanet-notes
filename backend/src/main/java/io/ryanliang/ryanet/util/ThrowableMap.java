package io.ryanliang.ryanet.util;

import java.util.LinkedHashMap;
import java.util.NoSuchElementException;

public class ThrowableMap<K, V> extends LinkedHashMap<K, V> {

//    private Map<K, V> map;
//
//    public ThrowableMap(Map<K, V> map) {
//
//        this.map = map;
//    }

    @Override
    public V get(Object key) throws NoSuchElementException {

        if (this.containsKey(key)) {

            return super.get(key);
        } else {

            throw new NoSuchElementException("Key: " + key + " not found.");
        }
    }
}
