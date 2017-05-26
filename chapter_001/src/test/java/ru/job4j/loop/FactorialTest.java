package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 *Factorial test.
 *@author Megger
 *@version $Id$
 *@since 0.1
 */
public class FactorialTest {
    /**
     *Test.
     *@Factorial 5.
     */
    @Test
    public void whenCalculateFactorialForFiveThenOneHundreedTwenty() {
   //напишите здесь тест, проверяющий, что факториал для числа 5 равен 120.
        Factorial factorial = new Factorial();
        int result = factorial.calc(5);
        int expected = 120;
        assertThat(result, is(expected));
    }
    /**
     *Test.
     *@Factorial 0 = 1;
     */
    @Test
    public void whenCalculateFactorialForZeroThenOne() {
  //напишите здесь тест, проверяющий, что факториал для числа 0 равен 1.
        Factorial factorial = new Factorial();
        int result = factorial.calc(0);
        int expected = 1;
        assertThat(result, is(expected));
    }
}


