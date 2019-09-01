package com.lz.boot;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description TODO
 * @author li zhe
 * @createTime 2019-08-24 12:45
 */
public class Test {

    public static void main(String[] args) {

        Stream<String> language = Stream.of("java", "python", "C++","php","java");
        List<String> listResult = language.collect(Collectors.toList());
        listResult.forEach(System.out::println);


        System.out.println(Stream.of("aeter", "anna", "pike").allMatch(s -> s.startsWith("a")));


    }
}
