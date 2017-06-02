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
    for (int i = 1; i <= h; i++) {
      for (int j = 1; j <= w; j++) {
        //draw the left side
          if ((j + i) <= h && j < h) {
             sb.append(" ");
          } else if ((j + i) > h && j < h) {
             sb.append("^");
          }
        //draw the right side
          if ((j - i) >= h && j > h) {
             sb.append(" ");
          } else if ((j - i) < h && j > h) {
             sb.append("^");
          }
          //draw the center
           if (j == h) {
             sb.append("^");
          }
      }
           sb.append(System.getProperty("line.separator"));
    }
   return sb.toString();
  }
}
