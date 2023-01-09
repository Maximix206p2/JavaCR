package com.company;

import java.util.Comparator;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class BuiltinFuncInterfaces {
    public static void main(String[] args) {
        //Predicate: на входе Integer -> на выходе boolean / Integer->boolean
        Predicate<Integer> isPositive = i -> i > 0;
        System.out.println(isPositive.test(-5)); // 5 — true; -5 — false

        Predicate<Integer> isZero = i -> i == 0;

        Predicate<Integer> isNegative = isPositive.or(isZero).negate();
        System.out.println(isNegative.test(-5)); // 5 — false; -5 — true

        //Function: на входе один объек -> на выходе другой / Person->String
        Function<Person, String> getName = Person::getName;
        System.out.println(getName.apply(new Person("Ivan", "Ihmenev")));

        //Supplier: на входе ничего -> на выходе некий объект / ()->Person
        Supplier<Person> creatPerson = Person::new;
        Person person = creatPerson.get();
        System.out.println(person);

        //Consumer: Person->()
        Consumer<Person> hello = p-> System.out.printf("Hello, %s!%n", p.getName());
        hello.accept(new Person("Ivan","Ihmenev"));

        //Comparator: берёт два объекта -> число / (o1,o2)->int
        Comparator<Person> comparator = (p1,p2)->p1.getName().compareTo(p2.getName());
        Person person1 = new Person("John", "Dio");
        Person person2 = new Person("Alice", "Krige");
        System.out.println(comparator.compare(person1,person2));

        //Optional - container
        Optional<String> empty = Optional.empty();
        if (!empty.isEmpty())
            System.out.println(empty.get());
        Optional<String> noEmpty = Optional.of("");
        System.out.println(noEmpty.isPresent());

        Optional<String> nullable = Optional.ofNullable(null); //null - false, "null" - true
        System.out.println(nullable.isPresent());
    }

    boolean isPositive(Integer i) {
        return i>0;
    }
}
