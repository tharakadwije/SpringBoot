package com.tharakadwije.rest.restfulwebservices;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SomeBusinessLogicTest {

    @Test
    void calculateTotalSum_Null() {

        SomeBusinessLogic logic = new SomeBusinessLogic();

        int [] array = null;
        int actualValue = logic.calculateTotalSum(array);
        int expectedValue = 0;
        assertEquals(expectedValue,actualValue);
    }

    @Test
    void calculateTotalSum_Empty() {

        SomeBusinessLogic logic = new SomeBusinessLogic();

        int [] array = {};
        int actualValue = logic.calculateTotalSum(array);
        int expectedValue = 0;
        assertEquals(expectedValue,actualValue);
    }

    @Test
    void calculateTotalSum_OneValue() {

        SomeBusinessLogic logic = new SomeBusinessLogic();

        int [] array = {1};
        int actualValue = logic.calculateTotalSum(array);
        int expectedValue = 1;
        assertEquals(expectedValue,actualValue);
    }

    @Test
    void calculateTotalSum_Basic() {

        SomeBusinessLogic logic = new SomeBusinessLogic();

        int [] array = {1,2,3};
        int actualValue = logic.calculateTotalSum(array);
        int expectedValue = 6;
        assertEquals(expectedValue,actualValue);
    }

}