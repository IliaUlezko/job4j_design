package ru.job4j.assertj;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class BoxTest {

    @Test
    void whenUnknownBoxGetName() {
        Box box = new Box(10, 10);
        String result = box.whatsThis();
        assertThat(result).isNotNull()
                .isEqualTo("Unknown object");
    }

    @Test
    void whenUnknownBoxGetArea() {
        Box box = new Box(10, 10);
        assertThat(box.getArea()).isEqualTo(0);
    }

    @Test
    void whenUnknownBoxNotExist() {
        Box box = new Box(0, 0);
        assertThat(box.isExist()).isEqualTo(false);
    }

    @Test
    void whenSphereGetName() {
        Box box = new Box(0, 1);
        String result = box.whatsThis();
        assertThat(result).isNotNull()
                .startsWithIgnoringCase("sp")
                .endsWith("re")
                .isEqualTo("Sphere");
    }

    @Test
    void whenSphereGetNumberOfVertices() {
        Box box = new Box(0, 1);
        assertThat(box.getNumberOfVertices()).isEqualTo(0);
    }

    @Test
    void whenTetrahedronGetName() {
        Box box = new Box(4, 4);
        assertThat(box.whatsThis()).isEqualTo("Tetrahedron");
    }

    @Test
    void whenTetrahedronIsExist() {
        Box box = new Box(4, 4);
        assertThat(box.isExist()).isEqualTo(true);
    }

    @Test
    void whenTetrahedronGetNumberOfVertices() {
        Box box = new Box(4, 4);
        assertThat(box.getNumberOfVertices()).isEqualTo(4);
    }

    @Test
    void whenTetrahedronGetArea() {
        Box box = new Box(4, 4);
        assertThat(box.getArea()).isGreaterThan(27.71d)
                .isLessThan(27.72d);
    }

    @Test
    void whenCubeGetName() {
        Box box = new Box(8, 6);
        assertThat(box.whatsThis()).isNotNull()
                .isNotEmpty()
                .isEqualTo("Cube");
    }

    @Test
    void whenCubeGetNumberOfVertices() {
        Box box = new Box(8, 6);
        int result = box.getNumberOfVertices();
        assertThat(result).isEqualTo(8);
    }

    @Test
    void whenCubeGetArea() {
        Box box = new Box(8, 6);
        assertThat(box.getArea()).isEqualTo(
                216d, withPrecision(0.1d));
    }

    @Test
    void whenCubeIsExist() {
        Box box = new Box(8, 6);
        assertThat(box.isExist()).isEqualTo(true);
    }
}