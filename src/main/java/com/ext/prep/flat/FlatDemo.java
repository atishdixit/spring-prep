package com.ext.prep.flat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatDemo {

    public static void main(String ss[]){
        stringArrayToString();
        stringSetToString();
        stringListToString();
    }

    public static void stringArrayToString(){

        String[][] data = new String[][]{{"java", "scala"}, {"python"}, {"C", "C++"}};
        Stream<String[]> temp = Arrays.stream(data);
        Stream<String> langStream = temp.flatMap(x -> Arrays.stream(x));
        langStream.forEach(System.out::println);

    }


    public static void stringSetToString(){

        List<Employee> employeeList = Employee.getEmployee();
        List<String> collect =
                employeeList.stream()
                        .map(x -> x.getLanguages())      //Stream<Set<String>>
                        .flatMap(x -> x.stream())   //Stream<String>
                        .distinct()
                        .collect(Collectors.toList());

        collect.forEach(x -> System.out.println(x));
    }


    public static void stringListToString(){

        List<List<String>> stringList = new ArrayList<>();

        List<String> jvmLanguage = new ArrayList<>();
        jvmLanguage.add("Java");
        jvmLanguage.add("Scala");

        List<String> otherLanguage = new ArrayList<>();
        otherLanguage.add("C++");
        otherLanguage.add("Ruby");

        stringList.add(jvmLanguage);
        stringList.add(otherLanguage);

        List<String> collect =
                stringList.stream()
                        .flatMap(x -> x.stream())   //Stream<String>
                        .collect(Collectors.toList());


        collect.forEach(x -> System.out.println(x));
    }

}
