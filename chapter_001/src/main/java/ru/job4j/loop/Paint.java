package ru.job4j.loop;
/**
 *Drawing a pyramid.
 *@author Megger
 *@version $Id$
 *@since 0.1
 */
public class Paint {
/**
 *@param h - height of the pyramid.
 *@return a pyramid in a pseudograph.
 */
  public String pyramid(int h) {
    StringBuilder sb = new StringBuilder();
    int w = (h + h) - 1;
    for (int i = 0; i < h; i++) {
      for (int j = 1; j <= w; j++) {
          if (j >= h - i && j <= h + i) {
             sb.append("^");
          } else {
             sb.append(" ");
          }
      }
           sb.append(System.getProperty("line.separator"));
    }
   return sb.toString();
  }
}
