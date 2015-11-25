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
    * Reverses a string in-place.
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

  /**
    * Find numbers in string and sum the number. Example String "abce15def17,13bd4c"
    * Assumption: contiguous digits comprise 1 number
    * @param str String containing numbers and characters
    * @return Sum of all numbers
    */
  def sumOfNumbersInString(str: String): Int = {
    val LowerLimit: Int = 47
    val UpperLimit: Int = 58
    val num: mutable.StringBuilder = new mutable.StringBuilder()
    var sum: Int = 0

    def isNumeral(c: Char): Boolean = {
      if(c.toInt >= LowerLimit && c.toInt <= UpperLimit) {
        true
      } else {
        false
      }
    }

    for(c <- str) {
      if(isNumeral(c)) {
        num += c
      } else {
        if(num.nonEmpty) {
          sum += num.toInt
          num.clear()
        }
      }
    }

    sum
  }
}