package Employment

import scala.collection.mutable

/*
 * Created by Wilfredo Ruiz on 11/19/15.
 * wil.ruiz@gmail.com
 * (602)-721-2985
 */

/*
 * Coding Example 2.
 */
object Util {
  /**
    * Reverses a string in-place in O(n/2) time.
    * @param str The string to reverse
    * @return The string reversed
    */
  def reverseStringRecursive(str: String): String = {

    // convert String to Character Array
    val arr: mutable.ArrayBuffer[Char] = mutable.ArrayBuffer()
    arr ++= str.toCharArray()

    /**
      * Recursive function that swaps characters from beginning and end of array resulting in reversed word
      * Function is tail-recursive, so the function stack never exceeds 1
      * We will assume no extra null terminator character
      * @param f Front of array index
      * @param b Back of array index
      */
    def swap(f: Int, b: Int): Unit = {
      if(f >= b) return

      val temp: Char = arr(f)
      arr(f) = arr(b)
      arr(b) = temp

      swap(f + 1, b - 1)
    }

    // Start swapping characters starting with the front and back of arrays, proceed inwards
    swap(0, arr.length - 1)

    // return the array of characters as a string
    arr.mkString
  }
}
