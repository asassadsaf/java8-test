package com.fkp.optional;

import org.junit.Test;

import java.util.Optional;

public class OptionalTest {

    /**
     * 创建optional,get,isPresent,ifPresent,filter,map，flatMap,orElse,orElseGet,orElseThrow
     */
    @Test
    public void test2(){
        //0.创建optional
        //空的optional，null的容器
        Optional<Object> emptyOptional = Optional.empty();
        //非空的optional，具体值的容器，不能传入null
        Optional<String> ofOptional = Optional.of("fkp");
        //可能为null也可能为某个值的容器，在一个变量可能为null也可能不为null时使用
        Optional<Object> ofNullableOptional = Optional.ofNullable(null);
        Optional<String> ofNullableOptional2 = Optional.ofNullable("abc");

        //1.get方法，如果容器内是null，会抛出NoSuchElementException异常，若容器内有值则返回该对象
        //NoSuchElementException
//        Object o = emptyOptional.get();
        String s = ofOptional.get();
        //NoSuchElementException
//        Object o1 = ofNullableOptional.get();
        String s1 = ofNullableOptional2.get();
        System.out.println(s);
        System.out.println(s1);
        System.out.println("----------------------------------------------------------");

        //2.isPresent方法，判断该容器内是否有值，即不是null，若是null返回false，否则返回true
        boolean present = emptyOptional.isPresent();
        boolean present1 = ofOptional.isPresent();
        boolean present2 = ofNullableOptional.isPresent();
        boolean present3 = ofNullableOptional2.isPresent();
        System.out.println(present);
        System.out.println(present1);
        System.out.println(present2);
        System.out.println(present3);
        System.out.println("----------------------------------------------------------");

        //3.ifPresent方法，如果容器中有值则传递给Consumer使用，否则不进行操作
        System.out.println("emptyOptional.ifPresent: ");
        emptyOptional.ifPresent(System.out::println);
        System.out.println("ofOptional.ifPresent: ");
        ofOptional.ifPresent(System.out::println);
        System.out.println("ofNullableOptional.ifPresent: ");
        ofNullableOptional.ifPresent(System.out::println);
        System.out.println("ofNullableOptional2.ifPresent: ");
        ofNullableOptional2.ifPresent(System.out::println);
        System.out.println("----------------------------------------------------------");

        //4.filter方法，如果容器中有值且符合断言则返回这个值的容器，否则返回空容器
        boolean f = ofOptional.filter(x -> x.contains("f")).isPresent();
        boolean f1 = ofNullableOptional2.filter(x -> x.contains("f")).isPresent();
        System.out.println(f);
        System.out.println(f1);
        System.out.println("----------------------------------------------------------");

        //5.map方法，如果存在值，将其作为Function函数的输入，输出若不为null则返回包装返回值的容器对象，若不存在值活Function函数的输出为null，则返回空的容器
        //容器内有值且Function函数输出不为null
        Optional<Integer> integer = ofOptional.map(String::length);
        integer.ifPresent(System.out::println);
        //容器内有值但Function函数输出为null
        Optional<Integer> integer2 = ofOptional.map(x -> null);
        System.out.println(integer2.isPresent());
        //容器内没有值
        Optional<String> s2 = emptyOptional.map(x -> "hello");
        System.out.println(s2.isPresent());
        System.out.println("----------------------------------------------------------");

        //6.flatMap方法，与map方法类似，只是返回值是Function函数的输出，不自动包装Optional，因为Function的输出就是Optional包装对象
        Optional<Integer> flatMap = ofOptional.flatMap(x -> Optional.of(x.length()));
        flatMap.ifPresent(System.out::println);
        System.out.println("----------------------------------------------------------");

        //7.orElse方法，如果容器有值则返回值否则返回方法入参作为默认值
        String s3 = ofOptional.orElse("hello");
        Object hello = emptyOptional.orElse("hello");
        System.out.println(s3);
        System.out.println(hello);
        System.out.println("----------------------------------------------------------");

        //8.orElseGet方法，如果容器有值返回值，否则返回Supplier生产的值
        String s4 = ofOptional.orElseGet(() -> "hello");
        Object hello2 = emptyOptional.orElseGet(() -> "hello");
        System.out.println(s4);
        System.out.println(hello2);
        System.out.println("----------------------------------------------------------");

        //9.orElseThrow，如果容器有值返回值，否则抛出Supplier生产的异常
        String s5 = ofOptional.orElseThrow(RuntimeException::new);
        System.out.println(s5);
        //抛出RuntimeException
        Object hello3 = emptyOptional.orElseThrow(RuntimeException::new);
        System.out.println(hello3);
    }
}
