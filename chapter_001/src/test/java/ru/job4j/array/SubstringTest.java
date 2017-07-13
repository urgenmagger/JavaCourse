package ru.job4j.array;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 *String comparison.
 * @author Megger
 * @version $Id$
 * @since 0.1
 */
public class SubstringTest {
    /**
     *Test.
     *@test comparison.
     */
    @Test

    public void boolTest() {
     Substring substr = new Substring();
       String origin = "Привет";
       String sub = "иве";
       boolean result = substr.contains(origin, sub);
       boolean expected = true;
       assertThat(result, is(expected));
}
}
