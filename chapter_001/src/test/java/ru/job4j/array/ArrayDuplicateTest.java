package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 *Bubble sort test.
 *@author Megger
 *@version $Id$
 *@since 0.1
 */
public class ArrayDuplicateTest {
    /**
     *Test.
     *@sort array test.
     */
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        //напишите здесь тест, проверяющий удаление дубликатов строк из массива строк.
         ArrayDublicate rm = new ArrayDublicate();
         String[] array = {"Привет", "Мир", "Привет", "Супер", "Мир"};
         String[] resultArray = rm.remove(array);
         String[] expectArray = {"Привет", "Мир", "Супер"};
         assertThat(resultArray, is(expectArray));
    }
}
