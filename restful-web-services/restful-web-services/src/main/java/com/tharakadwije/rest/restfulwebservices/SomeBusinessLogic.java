package com.tharakadwije.rest.restfulwebservices;

public class SomeBusinessLogic {

    public int calculateTotalSum(int [] intArray){
        int sum=0;
        for(int i : intArray){
            sum+=i;
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

