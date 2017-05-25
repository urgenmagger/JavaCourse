package ru.job4j.condition;
/**
 * Triangle area calculate.
 * @author Megger
 * @version $Id$
 * @since 0.1
 */
public class Triangle {
/**
 * Private.
 */
  private Point a;
/**
 * Private.
 */
  private Point b;
/**
 * Private.
 */
  private Point c;
/**
 *Triangle constructor.
 * @author Megger
 * @param a - for a.
 * @param b - for b.
 * @param c - for c.
 */
  public Triangle(Point a, Point b, Point c) {
    this.a = a;
    this.b = b;
    this.c = c;
  }
/**
 * Triangle method.
 * @return result formula.
 */
  public double area() {
//calculate the triangle area
    double ax = this.a.getX();
    double ay = this.a.getY();
    double bx = this.b.getX();
    double by = this.b.getY();
    double cx = this.c.getX();
    double cy = this.c.getY();
    return Math.abs((ax * (by - cy) + bx * (cy - ay) + cx * (ay - by))) / 2;
  }
}

