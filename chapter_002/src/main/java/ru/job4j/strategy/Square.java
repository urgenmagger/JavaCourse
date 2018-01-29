package ru.job4j.strategy;

public class Square implements Shape {
    @Override
    public String draw() {
        return pic();
    }

    @Override
    public String pic() {
        StringBuilder result = new StringBuilder();
        String lineSeparator = System.getProperty("line.separator");
        result.append("++++")
                .append(lineSeparator)
                .append("+  +")
                .append(lineSeparator)
                .append("+  +")
                .append(lineSeparator)
                .append("++++");
        return result.toString();
    }
}
