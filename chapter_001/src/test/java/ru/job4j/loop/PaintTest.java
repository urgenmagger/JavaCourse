package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 *pyramid test.
 *@author Megger
 *@version $Id$
 *@since 0.1
 */

public class PaintTest {
    /**
     *Test.
     *@pyramid height 1.
     */
    @Test
    public void whenPiramidWithHeightTwoThenStringWithTwoRows() {
        Paint paint = new Paint();
        String result = paint.pyramid(2);
        String expected = String.format(" ^ %s^^^", System.getProperty("line.separator"));
        assertThat(result, is(expected));
    }
    /**
     *Test.
     *@pyramid height 3.
     */
    @Test
    public void whenPiramidWithHeightThreeThenStringWithThreeRows() {
       //напишите здесь тест, проверяющий формирование пирамиды для высоты 3.
        Paint paint = new Paint();
        String result = paint.pyramid(3);
        String expected = String.format(" ^ %s^^^%s^^^^^", System.getProperty("line.separator"));
        assertThat(result, is(expected));
    }
}


