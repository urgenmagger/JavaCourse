package ru.job4j.list;

import java.util.List;

public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = list.size() / rows;
        if (list.size() % rows != 0) {
            cells++;
        }
        int rowsCount = 0;
        int cellCount = 0;
        int[][] array = new int[rows][cells];
        for (Integer cell : list) {
            if (cellCount < cells) {
                array[rowsCount][cellCount] = cell;
                cellCount++;
            } else {
                cellCount = 0;
                rowsCount++;
                array[rowsCount][cellCount] = cell;
                cellCount++;
            }
        }
        return array;
    }
}

