package org.example.homework4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class TriangleTest {

    @Test
    @Tag("positiveTest")
    void positiveTest() throws MyException {
        Triangle triangle = new Triangle();
        Assertions.assertEquals(6,triangle.triangleArea(3,4, 5));
    }

    @Test
    @Tag("negativeTest")
    void impossibleTriangle() throws MyException {
        Triangle triangle = new Triangle();
        Assertions.assertThrows(MyException.class,()-> triangle.triangleArea(3,6, 99));
    }

    @Test
    @Tag("negativeTest")
    void lessNull() throws MyException {
        Triangle triangle = new Triangle();
        Assertions.assertThrows(MyException.class,()-> triangle.triangleArea(-3,4, 5));
    }

    @Test
    @Tag("negativeTest")
    void equalNull() throws MyException {
        Triangle triangle = new Triangle();
        Assertions.assertThrows(MyException.class,()-> triangle.triangleArea(0,4, 5));
    }

}
