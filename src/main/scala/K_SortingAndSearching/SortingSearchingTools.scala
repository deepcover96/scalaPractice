package K_SortingAndSearching

import Util.Sort
import scala.collection.mutable.ListBuffer

import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable


object SortingSearchingTools {

  /**
    * 1.1a Given 2 sorted arrays, merge the first into the second
    * to have the second result in one sorted array of all values
    * With n being the length of all elements from both arrays, n1 the size of elements in arr1
    * Using quick-sort: average O(n log n) for sort + n for copy.
    * @param arr1 First array
    * @param arr2 Second array, which will result in all values stored sorted
    */
  def mergeTwoSortedArraysOld(arr1: ArrayBuffer[Int], arr2: ArrayBuffer[Int]): Unit = {
    if(arr1.isEmpty) return
    if(arr2.isEmpty) {
      arr2 ++= arr1
      return
    }

    arr2 ++= arr1
    Sort.quickSort(arr2)
  }


  /**
    * 11.1 This one is more efficient
    * Given 2 sorted arrays, merge the first into the second
    * to have the second result in one sorted array of all values
    * Iterating through both arrays backwards and placing largest elements in the back of the second array.
    * We can do this since second array has the extra space already.
    * O(n) with n being the total number of elements in both arrays
    * @param arr1 First array
    * @param arr2 Second array, which will result in all values stored sorted
    */
  def mergeTwoSortedArrays(arr1: ArrayBuffer[Int], arr2: ArrayBuffer[Int]): Unit = {
    if(arr1.isEmpty) return
    if(arr2.isEmpty) {
      arr2 ++= arr1
      return
    }
    val extra: ArrayBuffer[Int] = ArrayBuffer.fill(arr1.length)(0)

    var left: Boolean = true
    var leftIndex = arr1.length - 1
    var rightIndex = arr2.length - 1
    arr2 ++= extra

    var totalIndex = arr2.length - 1

    if(arr1.last > arr2(rightIndex)) left = true

    while (totalIndex >= 0) {
      if(left) {
        arr2(totalIndex) = arr1(leftIndex)
        leftIndex -= 1
      } else {
        arr2(totalIndex) = arr2(rightIndex)
        rightIndex -= 1
      }

      // first check if one array is complete, if not, next check which one has the lesser value
      if(leftIndex < 0) {
        left = false
      } else if (rightIndex < 0) {
        left = true
      } else {
        if (arr1(leftIndex) > arr2(rightIndex)) {
          left = true
        } else {
          left = false
        }
      }

      totalIndex -= 1
    }
  }

  private def lessThanChar(c1: Char, c2: Char): Boolean = {
    if (c1 < c2) {
      true
    } else {
      false
    }
  }
  private def greaterThanChar(c1: Char, c2: Char): Boolean = {
    if (c1 > c2) {
      true
    } else {
      false
    }
  }

  /**
    * Sort a list of strings so that anagrams are next to each other
    * Approach:
    *   Sort the letters of each word.
    *   Then quick-sort everything.
    *   We have to keep the original word unaltered
    *   We create comparison functions for the generic version of quick-sort
    * @param arr The array of strings to sort
    */
  def anagramSortA(arr: ArrayBuffer[String]): Unit = {
    val tempBuffer: ArrayBuffer[(String, String)] = ArrayBuffer()


    def lessThanWord(w1: (String, String), w2: (String, String)): Boolean = {
      if (w1._2 < w2._2) {
        true
      } else {
        false
      }
    }
    def greaterThanWord(w1: (String, String), w2: (String, String)): Boolean = {
      if (w1._2 > w2._2) {
        true
      } else {
        false
      }
    }

    def sortLetters(word: String): String = {
      val charBuffer: ArrayBuffer[Char] = ArrayBuffer()
      for (l <- word) {
        charBuffer += l
      }

      Util.Sort.quickSort(charBuffer, lessThanChar, greaterThanChar)
      charBuffer.mkString("")
    }

    for (word <- arr) {
      tempBuffer.append((word, sortLetters(word)))
    }

    Util.Sort.quickSort(tempBuffer, lessThanWord, greaterThanWord)

    for (i <- tempBuffer.indices) {
      arr(i) = tempBuffer(i)._1
    }
  }


  /**
    * Sort a list of strings so that anagrams are next to each other
    * Approach:
    *   Keep a hash table of the anagrams with a list of the words that match
    *   Use the sorted string as the key
    * @param arr The array of strings to sort
    */
  def anagramSort(arr: ArrayBuffer[String]): Unit = {
    val map: mutable.HashMap[String, ListBuffer[String]] = mutable.HashMap()

    def sortLetters(word: String): String = {
      val charBuffer: ArrayBuffer[Char] = ArrayBuffer()
      for (l <- word) {
        charBuffer += l
      }

      Util.Sort.quickSort(charBuffer, lessThanChar, greaterThanChar)
      charBuffer.mkString("")
    }

    for (w <- arr) {
      val sortedWord = sortLetters(w)
      if(!map.contains(sortedWord)) {
        map += (sortedWord -> new ListBuffer[String])
      }
      map(sortedWord).append(w)
    }

    var index = 0

    for(k <- map.keys) {
      for(w <- map(k)) {
        arr(index) = w
        index += 1
      }
    }

  }
}
