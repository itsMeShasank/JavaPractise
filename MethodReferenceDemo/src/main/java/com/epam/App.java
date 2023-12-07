package com.epam;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Hello world!
 *
 */
public class App 
{

    public static int add(int a, int b) {
        return a + b;
    }
    public int subtract(int a, int b) {
        return a - b;
    }
    public int multiplication(int a,int b) {
        return a * b;
    }

    public int division(int a,int b) {
        return a / b;
    }

    public static void main( String[] args ) {

        //static method reference
        BiFunction<Integer, Integer, Integer> function = App::add;
        System.out.println(function.apply(1, 1));

        BiFunction<Integer,Integer,Integer> biFunction = Integer::sum;
        System.out.println(biFunction.apply(2,2));

        BiFunction<Integer,Integer,Integer> compareFunction = Integer::compare;
        System.out.println(compareFunction.apply(2,3));


        //reference to instance method from class type
        Function<String, String> stringFunction = String::toUpperCase;
        System.out.println(stringFunction.apply("sasi"));

        BiFunction<String,String,Integer> stringComparingFunction = String::compareTo;
        System.out.println(stringComparingFunction.apply("apple","ant"));

        Function<String,Boolean> checkingEmptyFunction = String::isEmpty;
        System.out.println(checkingEmptyFunction.apply(""));

        Function<String,Integer> checkingLengthFunction = String::length;
        System.out.println(checkingLengthFunction.apply("sasi"));



        //reference to instance method from instance
        App app = new App();
        BiFunction<Integer,Integer,Integer> multiplicationFunction = app::multiplication;
        System.out.println(multiplicationFunction.apply(2,2));

        BiFunction<Integer,Integer,Integer> subtractFunction = app::subtract;
        System.out.println(subtractFunction.apply(2,2));

        BiFunction<Integer,Integer,Integer> divisionFunction = app::division;
        System.out.println(divisionFunction.apply(2,2));


        //constructor reference
        Supplier<App> studentSupplier = App::new;
        System.out.println(studentSupplier.get().getClass());

    }
}