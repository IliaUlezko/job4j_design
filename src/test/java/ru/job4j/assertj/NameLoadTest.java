package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class NameLoadTest {

    @Test
    void whenArrayIsEmpty() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(() -> nameLoad.parse(new String[] {}))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void whenCheckExceptionMessage() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(() -> nameLoad.parse(new String[]{}))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Names array is empty");
    }

    @Test
    void whenIncorrectString() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(() -> nameLoad.parse(
                new String[] {"din=don", "ping=pong", "meowmeow"}))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("does not contain");

    }

    @Test
    void whenStringHasNoKey() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(() -> nameLoad.parse(
                new String[] {"din=don", "ping=pong", "=meow"}))
                .isInstanceOf(IllegalArgumentException.class)
                .message()
                .isNotEmpty();
    }

    @Test
    void whenStringHasNoValue() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(() -> nameLoad.parse(
                new String[] {"din=don", "ping=pong", "meow="}))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("does not contain a value");
    }

    @Test
    void whenMapIsEmpty() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::getMap)
                .isInstanceOf(IllegalStateException.class)
                .message()
                .isNotEmpty();
    }
}