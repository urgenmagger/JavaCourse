package ru.job4j.max;
/**
 *Max.
 *@author Megger
 *@version $Id$
 *@since 0.1
 */
public class Max {
/**
 *@param first - first.
 *@param second - second.
 *@return max number.
 */
    public int max(int first, int second) {
       return first > second ? first : second;
    }
/**
 *@param first - first.
 *@param second - second.
 *@param third - third.
 *@return The larger of the three numbers.
 */
    public int max(int first, int second, int third) {
     return max(third, max(first, second));
    }
}
