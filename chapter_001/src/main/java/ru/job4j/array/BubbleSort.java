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
     int temp;
      for (int i = array.length - 1; i >= 0; i--) {
        for (int j = 0; j < i; j++) {
          if (array[j] > array[j + 1]) {
            temp = array[j];
            array[j] = array[j + 1];
            array[j + 1] = temp;
          }
        }
      }
    return array;
    }
 }
