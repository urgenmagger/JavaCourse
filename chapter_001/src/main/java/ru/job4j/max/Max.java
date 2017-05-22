package ru.job4j.max;
/**
 *Max.
 * @author Megger
 * @version $Id$
 * @since 0.1
 */
public class Max {
/**
 * @param first - firest.
 * @param second - second.
 *@return max number.
 */
    public int max(int first, int second) {
     int result = first > second ? first : second;
     return result;
    }
}
