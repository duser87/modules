package ru.innopolis;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;


public class Main {

    public static <T, R> Function<T, R> ternaryOperator(Predicate<? super T> predicate, Function<? super T, ? extends R> ifTrue, Function<? super T, ? extends R> ifFalse){

      return  x  -> predicate.test(x) ? ifTrue.apply(x) : ifFalse.apply(x);

    };

    public static void main(String[] args) {

        Predicate<Object> prd = Objects::isNull;

        Function<Object, Integer> ifTrue = o -> 0;

        Function<CharSequence, Integer> ifFalse = CharSequence::length;

        Function<String, Integer> result = ternaryOperator(prd, ifTrue, ifFalse);

        System.out.println(result.apply("blablabla"));

    }
}