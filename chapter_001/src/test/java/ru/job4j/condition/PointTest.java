package ru.job4j.condition;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Point test.
 * @author Megger
 * @version $Id$
 * @since 0.1
 */
public class PointTest {
    /**
     *Test.
     *@test Point.
     */
    @Test

    public void boolTest() {
      Point point = new Point(2, 6);
        boolean result = point.is(2, 2);
        boolean expected = true;
        assertThat(result, is(expected));
}
}
