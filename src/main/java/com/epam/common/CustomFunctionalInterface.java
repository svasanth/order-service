package com.epam.common;

@FunctionalInterface
public interface CustomFunctionalInterface {
    int square(int a);

    default void defaultMethod(){

    }

    static void staticMethod() {

    }
}
