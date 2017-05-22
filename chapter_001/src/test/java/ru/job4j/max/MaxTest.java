package ru.job4j.max;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * max.
 * @author Megger
 * @version $Id$
 * @since 0.1
 */
public class MaxTest {
    /**
     *Test.
     *@test max.
     */
    @Test
    public void ternal() {
     Max tern = new Max();
        int tester = tern.max(5, 1);
        int expected = 5;
        assertThat(tester, is(expected));
    }
}
