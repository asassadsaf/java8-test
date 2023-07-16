package com.fkp.function_interface;

import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionInterfaceTest {

    /**
     * Predicate
     */
    @Test
    public void test1(){
        Predicate<String> predicate = (x -> x.length() > 0);
        boolean test = predicate.negate().or(x -> x.contains("a")).test("");
        boolean test1 = Predicate.isEqual(" ").test("");
        System.out.println(test);
        System.out.println(test1);
    }

    /**
     * Supplier
     */
    @Test
    public void test2(){
        Supplier<String> supplier = () -> "a" + "aaa";
        String s = supplier.get();
        System.out.println(s);
    }

    /**
     * Consumer
     */
    @Test
    public void test3(){
        Consumer<String> consumer = System.out::println;
        consumer.andThen(x -> System.out.println(Arrays.toString(x.getBytes(StandardCharsets.UTF_8)))).accept("abcd");
    }

    /**
     * Function
     */
    @Test
    public void test4(){
        Function<String, Integer> function = Integer::parseInt;
        Integer apply = function.apply("12");
        System.out.println(apply);
        Integer apply1 = function.andThen(x -> x + 12).apply("12");
        System.out.println(apply1);
        Integer apply2 = function.compose(String::valueOf).apply(12L);
        System.out.println(apply2);
        Integer apply3 = function.andThen(Function.identity()).apply("12");
        System.out.println(apply3);

    }



}
