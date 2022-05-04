package ru.job4j.generics;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class RoleStoreTest {

    @Test
    public void whenAddAndFindThenRoleNameIsMaria() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Maria"));
        Role result = store.findById("1");
        assertThat(result.getName(), is("Maria"));
    }

    @Test
    public void whenReplaceThenRoleNameIsIvan() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Maria"));
        store.replace("1", new Role("1", "Ivan"));
        Role result = store.findById("1");
        assertThat(result.getName(), is("Ivan"));
    }

    @Test
    public void whenDeleteRoleThenRoleIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Maria"));
        store.delete("1");
        Role result = store.findById("1");
        assertNull(result);
    }

    @Test
    public void whenAddAndFindRoleNameIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Maria"));
        Role result = store.findById("2");
        assertNull(result);
    }
}