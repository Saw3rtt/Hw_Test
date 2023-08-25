package com.example.skypro.test.service;

import org.springframework.stereotype.Service;

@Service
public interface CalculatorService {
    String welcome();

    int plus(int num1, int num2);

    int minus(int num1, int num2);

    int multiply(int num1, int num2);

    double divide(double num1, double num2);
}
