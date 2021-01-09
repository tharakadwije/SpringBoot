package com.tharakadwije.rest.restfulwebservices;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SomeBusinessLogicTest {

    @Test
    void calculateTotalSumBasic() {

        SomeBusinessLogic logic = new SomeBusinessLogic();

        int [] array = {1,2,3};
        int actualValue = logic.calculateTotalSum(array);
        int expectedValue = 6;
        assertEquals(expectedValue,actualValue);
    }
}