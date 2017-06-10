package ru.job4j.array;
/**
 *Reverse array.
 *@author Megger
 *@version $Id$
 *@since 0.1
 */
public class Turn {
/**
 *@param array - array.
 *@return reverse array.
 */
  public int[] back(int[] array) {
    int temp;
    for (int i = 0; i < array.length / 2; i++) {
    temp = array[array.length - 1 - i];
    array[array.length - 1 - i] = array[i];
    array[i] = temp;
    }
    return array;
  }
}
