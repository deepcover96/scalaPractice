package K_SortingAndSearching

import Util.Sort

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer


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

  /**
    * Sort a list of strings so that anagrams are next to each other
    * Approach:
    *   We know that anagrams must have an equal number of characters, so we must identify these
    *   We will need to do an individual letter count analysis to determine if two words are anagrams
    * @param arr The array of strings to sort
    */
  def anagramSort(arr: ArrayBuffer[String]): ArrayBuffer[String] = {
    val tempBuffer: ArrayBuffer[String] = ArrayBuffer()
    val lengthMap: mutable.HashMap[Int, ArrayBuffer[(String, mutable.HashMap[Char, Int])]] = mutable.HashMap()

    def getCharMap(index: Int): mutable.HashMap[Char, Int] = {
      if(!lengthMap.contains(arr(index).length)) {
        lengthMap += (arr(index).length -> new ArrayBuffer[(String, mutable.HashMap[Char, Int])])
      }
      val map = new mutable.HashMap[Char, Int]()
      lengthMap(arr(index).length).append((arr(index), map))

      map
    }

    def areAnagrams(word1: mutable.HashMap[Char, Int], word2: mutable.HashMap[Char, Int]): Boolean = {
      if(word1.keys.size != word2.keys.size) return false
      for (k <- word1.keys) {
        if (!word2.contains(k)) {
          return false
        }
      }

      true
    }

    def findAnagrams(words: ArrayBuffer[(String, mutable.HashMap[Char, Int])]) = {


    }

    for (i <- arr.indices) {
      val map = getCharMap(i)
      for(c <- arr(i)) {
        if(map.contains(c)) {
          map(c) += 1
        } else {
          map += (c -> 1)
        }
      }
    }

    for (l <- lengthMap.keys) {
      if(lengthMap(l).length > 1) {

      } else {
        tempBuffer.append(lengthMap(l).head._1)
      }
    }
  }
}
