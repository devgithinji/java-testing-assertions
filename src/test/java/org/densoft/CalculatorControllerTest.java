package org.densoft;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class CalculatorControllerTest implements Controller {



    @BeforeEach
    void beforeEach() {
        System.out.println("Before each nested test context");
    }

    @AfterEach
    void afterEach() {
        System.out.println("After each nested test context");
    }

    @Nested
    class AdditionTests {

        @BeforeEach
        void beforeEach() {
            System.out.println("Before each AdditionTest");
        }

        @AfterEach
        void afterEach() {
            System.out.println("After each AdditionTest");
        }

        @Test
        void testPositiveNumbers() {
            System.out.println("Testing addition of positive numbers");
            // Test addition of positive numbers
        }

        @Test
        void testNegativeNumbers() {
            System.out.println("Testing addition of negative numbers");
            // Test addition of negative numbers
        }
    }

    @Nested
    class SubtractionTests {

        @BeforeEach
        void beforeEach() {
            System.out.println("Before each SubtractionTest");
        }

        @AfterEach
        void afterEach() {
            System.out.println("After each SubtractionTest");
        }

        @Test
        void testPositiveNumbers() {
            System.out.println("Testing subtraction of positive numbers");
            // Test subtraction of positive numbers
        }

        @Test
        void testNegativeNumbers() {
            System.out.println("Testing subtraction of negative numbers");
            // Test subtraction of negative numbers
        }
    }
}
