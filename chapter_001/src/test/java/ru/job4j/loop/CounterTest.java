package ru.job4j.loop;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 *Counter test.
 *@author Megger
 *@version $Id$
 *@since 0.1
 */
public class CounterTest {
    /**
     *Test.
     *@sum of even numbers.
     */
    @Test
    public void whenSumEvenNumbersFromOneToTenThenThirty() {
        //напишите здесь тест, проверяющий, что сумма чётных чисел от 1 до 10 при вызове метода counter.add будет равна 30.
        Counter counter = new Counter();
        int result = counter.add(1, 10);
        int expected = 30;
        assertThat(result, is(expected));
    }
}


