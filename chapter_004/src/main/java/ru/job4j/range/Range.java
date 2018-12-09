package ru.job4j.range;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Range {
    List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> result = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            result.add(func.apply((double) i));
        }
        return result;
    }

    List<Double> linear(int start, int end, double k, double b) {
        return diapason(start, end, (n) -> n * k + b);
    }

    List<Double> quadratic(int start, int end, double a, double b, double c) {
        return diapason(start, end, (n) -> a * Math.pow(n, 2) + (n * b) + c);
    }

    List<Double> logarithm(int start, int end) {
        return diapason(start, end, (n) -> Math.log(n));
    }

}
