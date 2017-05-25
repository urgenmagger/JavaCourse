package ru.job4j.condition;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.number.IsCloseTo.closeTo;
/**
 * Triangle test.
 * @author Megger
 * @version $Id$
 * @since 0.1
 */
public class TriangleTest {
    /**
     *Test.
     *@test triangle area.
     */
    @Test
    public void triangleTest() {
      Point a = new Point(15, 15);
      Point b = new Point(15, 30);
      Point c = new Point(30, 15);
      Triangle testArea = new Triangle(a, b, c);
        double result = testArea.area();
        double except = 112.5;
        assertThat(result, closeTo(except, 0.01));
    }

}
