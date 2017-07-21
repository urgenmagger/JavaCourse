package ru.job4j.array;
/**
 *String comparison.
 *@author Megger
 *@version $Id$
 *@since 0.1
 */
public class Substring {
/**
 *@return boolean result.
 *@param origin - origin string.
 *@param sub - substring.
 */
  boolean contains(String origin, String sub) {
     char[] str = origin.toCharArray();
     char[] strsub = sub.toCharArray();
     boolean result = false;
     for (int i = 0; i <= str.length - 1; i++) {
      if (strsub[0] == str[i]) {
        for (int j = 0; j <= strsub.length - 1; j++) {
          if (strsub[j] == str[j + i]) {
              result = true;
          } else {
            result = false;
          }
        }
     }
    }
    return result;
  }
 }
