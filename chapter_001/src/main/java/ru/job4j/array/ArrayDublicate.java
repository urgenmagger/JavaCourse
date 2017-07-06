package ru.job4j.array;
import java.util.Arrays;
/**
 * Remove dublicates.
 *@author Megger
 *@version $Id$
 *@since 0.1
 */
public class ArrayDublicate {
/**
 *@param array - array.
 *@return array without duplicates.
 */
  public String[] remove(String[] array) {
    int counter = array.length;
    for (int i = 0; i < counter; i++) {
      for (int j = i + 1; j < counter; j++) {
        if (array[i] == array[j]) {
          for (int k = j; k < counter - 1; k++) {
            array[k] = array[k + 1];
          }
          counter--;
        }
      }
    }
     return Arrays.copyOf(array, counter);
  }
}
