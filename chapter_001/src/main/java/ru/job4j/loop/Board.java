package ru.job4j.loop;
/**
 *Chess board.
 *@author Megger
 *@version $Id$
 *@since 0.1
 */
public class Board {
/**
 *@param width - width board.
 *@param height - height board.
 *@return board in string format.
 */
  public String paint(int width, int height) {
    StringBuilder sb = new StringBuilder();
    String newLine = System.getProperty("line.separator");
    for (int i = 1; i <= height; i++) {
      for (int j = 1; j <= width; j++) {
          if ((j + i) % 2 == 0) {
             sb.append("x");
          } else {
             sb.append(" ");
          }
      }
           sb.append(newLine);
    }
   return sb.toString();
  }
}
