package com.tharakadwije.rest.restfulwebservices;

import com.tharakadwije.rest.restfulwebservices.user.SomeDataService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class SomeBusinessLogicMockTest {


    @Test
    void calculateTotalSumDataService_Empty() {

        SomeBusinessLogic logic = new SomeBusinessLogic();

        SomeDataService dataServiceMock = mock(SomeDataService.class);
        when(dataServiceMock.callSomeDate()).thenReturn(new int[]{});

        logic.setSomeDataService(dataServiceMock);

        int actualValue = logic.calculateTotalSumDataService();
        int expectedValue = 0;
        assertEquals(expectedValue,actualValue);
    }

    @Test
    void calculateTotalSumDataService_OneValue() {
        SomeBusinessLogic logic = new SomeBusinessLogic();

        SomeDataService  someDataServiceMock= mock(SomeDataService.class);
        when(someDataServiceMock.callSomeDate()).thenReturn(new int[]{1});

        logic.setSomeDataService(someDataServiceMock);

        int actualValue = logic.calculateTotalSumDataService();
        int expectedValue = 1;
        assertEquals(expectedValue,actualValue);
    }

    @Test
    void calculateTotalSumDataService_Basic() {

        SomeBusinessLogic logic = new SomeBusinessLogic();
        SomeDataService someDataServiceMock =mock(SomeDataService.class);
        when(someDataServiceMock.callSomeDate()).thenReturn(new int[] {1,2,3});

        logic.setSomeDataService(someDataServiceMock);

        int actualValue = logic.calculateTotalSumDataService();
        int expectedValue = 6;
        assertEquals(expectedValue,actualValue);
    }
}