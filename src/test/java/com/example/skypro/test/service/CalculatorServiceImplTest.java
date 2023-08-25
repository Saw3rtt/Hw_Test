package com.example.skypro.test.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

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

    @ParameterizedTest
    @MethodSource("dataForDivide")
    void divide__returnDouble(int num1, int num2, double expectedResult) {
        var result = underTest.divide(num1, num2);
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> dataForDivide() {
        return Stream.of(
                Arguments.of(6, 3, 2),
                Arguments.of(7, 2, 3.5)
        );
    }

    @ParameterizedTest
    @MethodSource("dataForPlus")
    void plus__returnInt(int num1, int num2, int expectedResult) {
        var result = underTest.plus(num1, num2);
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> dataForPlus() {
        return Stream.of(
                Arguments.of(6, 3, 9),
                Arguments.of(7, 2, 9)
        );
    }

    @ParameterizedTest
    @MethodSource("dataForPlusMaxAndMinValue")
    void plus__returnIntMaxAndMinValue(int value) {
        var result = underTest.plus(value, value);
        assertEquals(value + value, result);
    }

    private static Stream<Arguments> dataForPlusMaxAndMinValue() {
        return Stream.of(
                Arguments.of(Integer.MAX_VALUE),
                Arguments.of(Integer.MIN_VALUE)

        );
    }

    @ParameterizedTest
    @MethodSource("dataForMinus")
    void minus__returnInt(int num1, int num2, int expectedResult) {
        var result = underTest.minus(num1, num2);
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> dataForMinus() {
        return Stream.of(
                Arguments.of(6, 3, 3),
                Arguments.of(7, 2, 5)
        );
    }

    @ParameterizedTest
    @MethodSource("dataForMinusMaxAndMinValue")
    void minus__returnIntMaxAndMinValue(int value) {
        var result = underTest.minus(value, value);
        assertEquals(value - value, result);
    }

    private static Stream<Arguments> dataForMinusMaxAndMinValue() {
        return Stream.of(
                Arguments.of(Integer.MAX_VALUE),
                Arguments.of(Integer.MIN_VALUE)
        );
    }

    @ParameterizedTest
    @MethodSource("dataForMultiply")
    void multiply__returnInt(int num1, int num2, int expectedResult) {
        var result = underTest.multiply(num1, num2);
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> dataForMultiply() {
        return Stream.of(
                Arguments.of(5, 6, 30),
                Arguments.of(7, 9, 63)
        );
    }

    @ParameterizedTest
    @MethodSource("dataForMultiplyMaxAndMinValue")
    void multiply__returnIntMaxAndMinValue(int value) {
        var result = underTest.multiply(value, value);
        assertEquals(value * value, result);
    }

    private static Stream<Arguments> dataForMultiplyMaxAndMinValue() {
        return Stream.of(
                Arguments.of(Integer.MAX_VALUE),
                Arguments.of(Integer.MIN_VALUE)
        );

    }

    @ParameterizedTest
    @MethodSource("provideWelcomeMessages")
    public void welcome__returnString(String expectedWelcomeMessage) {
        String result = underTest.welcome();

        assertEquals(expectedWelcomeMessage, result);
    }


    private static Stream<String> provideWelcomeMessages() {
        return Stream.of(
                "Добро пожаловать в калькулятор");

    }
}