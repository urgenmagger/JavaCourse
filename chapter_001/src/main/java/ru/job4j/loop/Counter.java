package ru.job4j.loop;
/**
 *Caunter.
 *@author Megger
 *@version $Id$
 *@since 0.1
 */
public class Counter {
/**
 *@param start - beginning of the counter.
 *@param finish - end of the counter.
 *@return sum of even numbers.
 */
  public int add(int start, int finish) {
    int result = 0;
    for (int i = start; i <= finish; i++) {
      if (i % 2 == 0) {
        result += i;
      }
    }
    return result;
  }
}
