package com.day03p05;

import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        TreeSet<Person> personSet = new TreeSet<>();

        
        personSet.add(new Person(1, "Alice", 22, 1500.0));
        personSet.add(new Person(2, "Bob", 28, 2500.0));
        personSet.add(new Person(3, "Charlie", 35, 3000.0));
        personSet.add(new Person(4, "David", 19, 1200.0));
        personSet.add(new Person(5, "John", 32, 1999.0));
        personSet.add(new Person(6, "Tom", 42, 3999.0));

        
        for (Person person : personSet) {
            if (person.getAge() > 25) {
                System.out.println(person);
            }
        }
    }
}
