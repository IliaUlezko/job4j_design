package ru.job4j.iterator;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ListUtilsTest {

    @Test
    public void whenAddBefore() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 1, 2);

        assertThat(input, is(Arrays.asList(1, 2, 3)));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddBeforeWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 3, 2);
    }

    @Test
    public void whenAddAfterLast() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2));
        ListUtils.addAfter(input, 2, 3);

        assertThat(input, is(Arrays.asList(0, 1, 2, 3)));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddAfterWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2));
        ListUtils.addAfter(input, 2, 0);
    }

    @Test
    public void whenRemoveIfTrue() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 2, 5, 1));
        ListUtils.removeIf(input, e -> e == 2);

        assertThat(input, is(Arrays.asList(0, 1, 3, 4, 5, 1)));
    }

    @Test
    public void whenRemoveIfFalse() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        ListUtils.removeIf(input, e -> e % 5 == 0);

        assertThat(input, is(Arrays.asList(1, 2, 3, 4)));
    }

    @Test
    public void whenReplaceIfNegative() {
        List<Integer> input = new ArrayList<>(Arrays.asList(-5, -4, -3, -2, -1, 0, 1, 2));
        ListUtils.replaceIf(input, e -> e < 0, -1);

        assertThat(input, is(Arrays.asList(-1, -1, -1, -1, -1, 0, 1, 2)));
    }

    @Test
    public void whenReplaceThenRemove() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4));
        ListUtils.replaceIf(input, e -> e % 2 == 0, 0);
        ListUtils.removeIf(input, e -> e == 0);

        assertThat(input, is(Arrays.asList(1, 3)));
    }

    @Test
    public void whenRemoveAll() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5));
        List<Integer> output = new ArrayList<>(Arrays.asList(0, 2, 3));
        ListUtils.removeAll(input, output);

        assertThat(input, is(Arrays.asList(1, 4, 5)));
    }
}