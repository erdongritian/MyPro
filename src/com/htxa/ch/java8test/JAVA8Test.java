package com.htxa.ch.java8test;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * Created by chenh on 2017/3/2.
 */
public class JAVA8Test {

    public static void main(String[] args) {
//        test1();
        test12();
    }

    public static void test1(){
        Formula formula=new Formula() {
            @Override
            public double calculate(int a) {
                return sqrt(a*2);
            }
        };
        formula.calculate(4);
        formula.sqrt(3);
    }

    public static void test2(){
        List<String> names= Arrays.asList("peter","anna","mike","xenia");
//        Collections.sort(names, new Comparator<String>() {
//            @Override
//            public int compare(String a, String b) {
//                return b.compareTo(a);
//            }
//        });
//        Collections.sort(names,(a,b) -> b.c);
        Collections.sort(names, (a,b) -> b.compareTo(a));
        names.forEach(System.out::println);
    }
    public static void test3(){
//        Converter<String,Integer> converter=(from)->Integer.valueOf(from);
        Converter<String,Integer> converter=Integer::valueOf;
        Integer converted=converter.convert("3");
        System.out.println(converted);
    }

    public static void test4(){
//        Something something=new Something();
        Converter<String,String> converter=Something::startWith;
        String result=converter.convert("asd");
        System.out.println("result:"+result);

    }
    static class Something{
        static String startWith(String s){
            return s.toUpperCase();
        }
    }

    public static void test5(){
        int num=1;
        Converter<Integer,String> stringConverter=(from)->String.valueOf(from+num);
//        num=3  //会报错，num 含为final类型
        stringConverter.convert(4);
    }

    public static void test6(){
        Formula formula=a -> Double.parseDouble(String.valueOf(a));
    }

    public static void test7(){
        Predicate<String> predicate= (s) -> s.length()>0 ;
        predicate.test("foo");
        predicate.negate().test("foo");
        Predicate nonNull= Objects::nonNull;

        Predicate<String> isEmpty=String::isEmpty;

        System.out.println("####："+isEmpty.test("ddd"));

//        predicate.test("foo").
    }

    public static void test8(){
        Function<String,Integer> toInteger=Integer::valueOf;
        Function<String,String> backToString=toInteger.andThen(String::valueOf);
        backToString.apply("123");

    }

    public static void test9(){
        Optional optional=Optional.of("bam");
        optional.isPresent();
        optional.get();
        optional.orElse("fallback");
        optional.ifPresent(s-> System.out.println());
    }

    public static void test10(){
//        Supplier personSupplier=Person::new;
        Consumer<Person> greeter=p-> System.out.println(p.firstName);
        System.out.println("#####");
        greeter.accept(new Person("J","dd"));
    }

    public static void test11(){
        List<String> list=Arrays.asList("aaa","ddd","dcd","lojg");
        list.stream().filter(s->s.startsWith("a")).forEach(System.out::println);
    }

    public static void test12(){
        List<String> list=Arrays.asList("aaa","ndd","dcd","lojg");
        list.stream().sorted().forEach(System.out::println);
        list.forEach(System.out::println);
    }

    public static void test13(){
        List<String> list=Arrays.asList("aaa","ndd","dcd","lojg");
        list.stream().map(String::toUpperCase)
                .sorted((a,b)->b.compareTo(a)).forEach(System.out::println);
    }

    public static void test14(){
        List<String> list=Arrays.asList("aaa","ndd","dcd","lojg");
        list.stream().anyMatch(s -> s.startsWith("a"));
    }

    public static void test15(){
        Map<Integer,String> map=new HashMap<>();
        map.forEach((id,val)-> System.out.println(val));
    }

    public static void test16(){
        List<String> list=new ArrayList();
        list.stream().filter(str->str.contains("java")).collect(Collectors.toList());

        List<Person> list1=new ArrayList<>();
        list1.stream().collect(Collectors.groupingBy(Person::getFirstName));

    }
}
