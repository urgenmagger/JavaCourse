package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 *array rotate test.
 *@author Megger
 *@version $Id$
 *@since 0.1
 */
public class RotateArrayTest {
    /**
     *Test.
     *@test rotate 2x2
     */
    @Test
    public void whenRotateTwoRowTwoColArrayThenRotatedArray() {
        //напишите здесь тест, проверяющий поворот массива размером 2 на 2.
        RotateArray rotation = new RotateArray();
        int[][] array = {{1, 2}, {3, 4}};
        int[][] resultArray = rotation.rotate(array);
        int[][] expectArray = {{3, 1}, {4, 2}};
        assertThat(resultArray, is(expectArray));
    }
    /**
     *Test.
     *@test rotate 3x3
     */
    @Test
    public void whenRotateThreeRowThreeColArrayThenRotatedArray() {
        //напишите здесь тест, проверяющий поворот массива размером 3 на 3.
        RotateArray rotation = new RotateArray();
        int[][] array = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] resultArray = rotation.rotate(array);
        int[][] expectArray = {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
        assertThat(resultArray, is(expectArray));
    }
}


