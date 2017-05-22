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
      Triangle triangle = new Triangle();
      double result = triangle.area(15, 15, 15, 30, 30, 15);
      double except = 112.5;
      assertThat(result, closeTo(except, 0));
    }

}
