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
    /**
     *Test.
     *@test comparison "Привее".
     */
    @Test

    public void boolTestDoubleChar() {
     Substring substr = new Substring();
       String origin = "Привет";
       String sub = "Привее";
       boolean result = substr.contains(origin, sub);
       boolean expected = false;
       assertThat(result, is(expected));
}
    /**
     *Test.
     *@test comparison "оаио".
     */
    @Test

    public void boolTestLeftChar() {
     Substring substr = new Substring();
       String origin = "Привет";
       String sub = "оаио";
       boolean result = substr.contains(origin, sub);
       boolean expected = false;
       assertThat(result, is(expected));
}
    /**
     *Test.
     *@test comparison "ои".
     */
    @Test

    public void boolTestLeftChars() {
     Substring substr = new Substring();
       String origin = "Привет";
       String sub = "ои";
       boolean result = substr.contains(origin, sub);
       boolean expected = false;
       assertThat(result, is(expected));
}
}
