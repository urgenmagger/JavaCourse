package ru.job4j.array;
/**
 *Bubble sort array.
 *@author Megger
 *@version $Id$
 *@since 0.1
 */
public class BubbleSort {
/**
 *@param array - array.
 *@return sort array.
 */
  public int[] sort(int[] array) {
    boolean flag = false;
    int temp;
    while (!flag) {
      flag = true;
      for (int i = 0; i < array.length - 1; i++) {
        if (array[i] > array[i + 1]) {
          temp = array[i];
          array[i] = array[i + 1];
          array[i + 1] = temp;
          flag = false;
        }
      }
    }
    return array;
  }
}
