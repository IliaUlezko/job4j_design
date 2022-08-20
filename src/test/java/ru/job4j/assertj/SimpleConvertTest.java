package ru.job4j.assertj;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleConvertTest {

    @Test
    void checkArray() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray(
                "first", "second", "three", "four", "five"
        );
        assertThat(array).hasSize(5)
                .contains("second")
                .contains("first", Index.atIndex(0))
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("first", Index.atIndex(1));
    }

    @Test
    void checkList() {
        SimpleConvert simpleConvert = new SimpleConvert();
        List<String> result = simpleConvert.toList(
                "first", "second", "three", "four", "five"
        );
        assertThat(result).hasSize(5)
                .containsAnyOf("second", "ten", "first")
                .containsExactly("first", "second", "three", "four", "five")
                .element(3).isNotNull()
                .isEqualTo("four");
    }

    @Test
    void checkSet() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Set<String> result = simpleConvert.toSet(
                "first", "second", "first", "four"
        );
        assertThat(result).isNotEmpty()
                .hasSize(3)
                .contains("first")
                .containsOnly("second", "four", "first");
    }

    @Test
    void checkMap() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Map<String, Integer> map = simpleConvert.toMap(
                "max", "min", "double", "string"
        );
        assertThat(map).isNotEmpty()
                .hasSize(4)
                .containsKey("double")
                .containsValue(2)
                .doesNotContainValue(7)
                .containsEntry("string", 3);
    }
}