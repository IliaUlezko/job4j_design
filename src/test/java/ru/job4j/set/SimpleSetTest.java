package ru.job4j.set;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleSetTest {

    @Test
    public void whenAddNonNull() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(1));
        assertTrue(set.contains(1));
        assertFalse(set.add(1));
    }

    @Test
    public void whenAddNull() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(null));
        assertTrue(set.contains(null));
        assertFalse(set.add(null));
    }

    @Test
    public void whenAddMultiply() {
        Set<Integer> set = new SimpleSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        Iterator<Integer> iterator = set.iterator();
        assertThat(iterator.next(), is(1));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.next(), is(3));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenConcurrentModificationException() {
        Set<Integer> set = new SimpleSet<>();
        set.add(1);
        set.add(2);
        Iterator<Integer> iterator = set.iterator();
        iterator.next();
        set.add(3);
        iterator.next();
    }

    @Test(expected = NoSuchElementException.class)
    public void whenNoSuchElementException() {
        Set<Integer> set = new SimpleSet<>();
        set.add(1);
        set.add(2);
        Iterator<Integer> iterator = set.iterator();
        iterator.next();
        iterator.next();
        iterator.next();
    }
}