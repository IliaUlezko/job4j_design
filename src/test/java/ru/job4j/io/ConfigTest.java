package ru.job4j.io;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ConfigTest {

    @Test
    public void whenPairWithoutComment() {
        String path = "./data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("keyName"),
                is("value"));
    }

    @Test
    public void whenPairWithComment() {
        String path = "./data/pair_with_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("exampleKey"),
                is("value"));
    }

    @Test
    public void whenPairNotFound() {
        String path = "./data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("key"),
                is("Value not found!"));
    }

    @Test
    public void whenOnlyComments() {
        String path = "./data/only_comments.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("keyName"),
                is("Value not found!"));
    }

    @Test
    public void whenUnusualKeysAndValues() {
        String path = "./data/pair_with_unusual_key_value.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("key"),
                is("value="));
        assertThat(config.value("keyTwo"),
                is("=value"));
        assertThat(config.value("keyThree"),
                is("=value="));
    }
}
