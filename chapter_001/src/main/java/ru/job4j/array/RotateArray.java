package ru.job4j.array;

/**
 *Rotate array by 90 degrees.
 *@author Megger
 *@version $Id$
 *@since 0.1
 */
public class RotateArray {
/**
 *@param array - array.
 *@return rotate array.
 */
  public int[][] rotate(int[][] array) {
    int temp;
    int length = array.length - 1;
    for (int i = 0; i <= length / 2; i++) {
      for (int j = i; j < length - i; j++) {
        temp = array[i][j];
        array[i][j] = array[length - j][i];
        array[length - j][i] = array[length - i][length - j];
        array[length - i][length - j] = array[j][length - i];
        array[j][length - i] = temp;
      }
    }
    return array;
  }
}
