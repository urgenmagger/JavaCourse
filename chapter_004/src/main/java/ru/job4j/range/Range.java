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

    List<Double> linear(int start, int end) {
        return diapason(start, end, (n) -> n);
    }

    List<Double> quadratic(int start, int end) {
        return diapason(start, end, (n) -> Math.pow(n, 2));
    }

    List<Double> logarithm(int start, int end) {
        return diapason(start, end, (n) -> Math.log(n));
    }

}
