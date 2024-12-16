package org.example

import org.junit.jupiter.api.Test
import static org.junit.jupiter.api.Assertions.*

class DemoLibraryTest {

    @Test
    void testGreet() {
        // Arrange
        String name = "Jenkins"

        // Act
        String result = DemoLibrary.greet(name)

        // Assert
        assertEquals("Hello, Jenkins!", result)
    }

    @Test
    void testAddNumbers() {
        // Arrange
        int a = 5
        int b = 10

        // Act
        int result = DemoLibrary.addNumbers(a, b)

        // Assert
        assertEquals(15, result)
    }
}