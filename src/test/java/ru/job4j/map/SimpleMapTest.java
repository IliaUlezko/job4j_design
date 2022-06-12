package ru.job4j.map;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleMapTest {

    @Test
    public void whenPutMultiply() {
        SimpleMap<String, String> map = new SimpleMap<>();
        assertTrue(map.put("1", "First"));
        assertTrue(map.put("2", "Second"));
        assertTrue(map.put("3", "Third"));
    }

    @Test
    public void whenPutThenGet() {
        SimpleMap<String, String> map = new SimpleMap<>();
        map.put("1", "Tree");
        String result = "Tree";
        assertThat(result, is(map.get("1")));
    }

    @Test
    public void whenPutEqualsKeys() {
        SimpleMap<String, String> map = new SimpleMap<>();
        assertTrue(map.put("1", "First"));
        assertTrue(map.put("2", "Second"));
        assertFalse(map.put("2", "Third"));
    }

    @Test
    public void whenGetNull() {
        SimpleMap<String, String> map = new SimpleMap<>();
        map.put("1", "First");
        assertNull(map.get("0"));
    }

    @Test
    public void whenPutThenRemove() {
        SimpleMap<String, String> map = new SimpleMap<>();
        map.put("1", "First");
        map.put("2", "Second");
        map.put("3", "Third");
        assertTrue(map.remove("1"));
    }

    @Test
    public void whenRemoveFalse() {
        SimpleMap<String, String> map = new SimpleMap<>();
        map.put("1", "First");
        map.put("2", "Second");
        assertFalse(map.remove("3"));
    }

    @Test
    public void whenIteratorHasNext() {
        SimpleMap<String, String> map = new SimpleMap<>();
        map.put("1", "First");
        map.put("2", "Second");
        Iterator<String> iterator = map.iterator();
        assertThat(iterator.next(), is("1"));
        assertThat(iterator.next(), is("2"));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenConcurrentModException() {
        SimpleMap<String, String> map = new SimpleMap<>();
        map.put("1", "First");
        map.put("2", "Second");
        Iterator<String> iterator = map.iterator();
        map.put("3", "Third");
        iterator.next();
    }

    @Test(expected = NoSuchElementException.class)
    public void whenNoSuchElemException() {
        SimpleMap<String, String> map = new SimpleMap<>();
        Iterator<String> iterator = map.iterator();
        iterator.next();
    }
}