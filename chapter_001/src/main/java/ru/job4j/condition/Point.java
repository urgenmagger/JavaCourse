package ru.job4j.condition;
/**
 * Point test.
 * @author Megger
 * @version $Id$
 * @since 0.1
 */
public class Point {
/**
 * Private.
 */
   private int x;
/**
 * Private.
 */
   private int y;
/**
 * Point constructor.
 * @param x - for x.
 * @param y - for y.
 */
   public  Point(int x, int y) {
      this.x = x;
      this.y = y;
  }
/**
 * Point return x.
 * @return x.
 */
  public int getX() {
      return this.x;
  }
/**
 * Point return y.
 * @return y.
 */
  public int getY() {
     return this.y;
  }
/**
 * Point description.
 * @return bollean.
 * @param a - for a.
 * @param b - for b.
 */
  public boolean is(int a, int b) {
    return  this.y == a * this.x + b;
  }
}
