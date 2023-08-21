package com.example.skypro.test.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceImplTest {
    CalculatorService underTest = new CalculatorServiceImpl();

    @Test
    void welcome__returnWelcomeString() {
        String result = underTest.welcome();
        assertEquals("Добро пожаловать в калькулятор", result);
    }

    @Test
    void plus_num1MinusNum2_resultNumber() {
        int result = underTest.minus(4, 2);
        assertEquals(2, result);
    }

    @Test
    void plus_num1MinusNum2_resultNumber2() {
        int result = underTest.minus(20, 2);
        assertEquals(18, result);
    }

    @Test
    void plus_num1PlusNum2_resultNumber() {
        int result = underTest.plus(4, 2);
        assertEquals(6, result);
    }

    @Test
    void plus_num1PlusNum2_resultNumber2() {
        int result = underTest.plus(7, 2);
        assertEquals(9, result);
    }

    @Test
    void multiply_num1MultiplyNum2_resultNumber() {
        int result = underTest.multiply(4, 2);
        assertEquals(8, result);
    }

    @Test
    void multiply_num1MultiplyNum2_resultNumber2() {
        int result = underTest.multiply(4, 3);
        assertEquals(12, result);
    }

    @Test
    void divide_num1DividedNu2mWithoutFraction_wholeNumber() {
        double result = underTest.divide(4, 2);
        assertEquals(2, result);
    }

    @Test
    void divide_num1DividedNum2WithFraction_wholeNumberWithFraction() {
        double result = underTest.divide(5, 2);
        assertEquals(2.5, result);
    }

    @Test
    void divide_num2Is0_throwIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> underTest.divide(1, 0));
    }

}