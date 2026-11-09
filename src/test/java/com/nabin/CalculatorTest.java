package com.nabin;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @ParameterizedTest
    @CsvSource({
        "100, 2, 102",
        "100, -2, 98",
        "-100, 2, -98",
        "-100, -2, -102"
    })
    void testAdd(int a, int b, int expected) {
      assertEquals(expected, calculator.add(a, b));
    }

    @ParameterizedTest
    @CsvSource({
        "100, 2, 98",
        "100, -2, 102",
        "-100, 2, -102",
        "-100, -2, -98"
    })
    void testSubtract(int a, int b, int expected) {
        assertEquals(expected, calculator.subtract(a, b));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/calculator-data.csv", numLinesToSkip = 1)
    void testMultiply(int a, int b, int expected) {
        assertEquals(expected, calculator.multiply(a, b));
    }

    @Test
    void testDivideByZero() {
        assertThrows(IllegalArgumentException.class,
            () -> calculator.divide(100, 0));
    }
}