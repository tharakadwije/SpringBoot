package com.tharakadwije.rest.restfulwebservices;

import com.tharakadwije.rest.restfulwebservices.user.SomeDataService;
import org.springframework.beans.factory.annotation.Autowired;

public class SomeBusinessLogic {

    SomeDataService someDataService;

    public void setSomeDataService(SomeDataService someDataService) {
        this.someDataService = someDataService;
    }

    public int calculateTotalSum(int [] intArray){
        int sum=0;
        if(intArray!=null) {
            for (int i : intArray) {
                sum += i;
            }
        }
        return sum;
    }

    public int calculateTotalSumDataService(){
        int sum=0;
        if(someDataService.callSomeDate()!=null) {
            for (int i : someDataService.callSomeDate()) {
                sum += i;
            }
        }
        return sum;
    }

//    public static void main(String[] args) {
//
//        SomeBusinessLogic logic = new SomeBusinessLogic();
//
//        int [] array = {1,2,3};
//        int actualValue = logic.calculateTotalSum(array);
//        int expectedValue = 6;
//    }
}

