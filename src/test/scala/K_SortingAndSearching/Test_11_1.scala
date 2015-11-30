package K_SortingAndSearching

import org.scalatest.FlatSpec

import scala.collection.mutable.ArrayBuffer



class Test_11_1 extends FlatSpec {
  "Calling array merging function, when given 2 sorted arrays" should "result in second array containing all elements sorted." in {
    val arr1: ArrayBuffer[Int] = ArrayBuffer[Int](0, 2, 4, 6, 8, 100)
    val arr2: ArrayBuffer[Int] = ArrayBuffer[Int](1, 3, 5, 7, 9, 11, 12, 13, 14, 50, 51, 59, 99)

    SortingSearchingTools.mergeTwoSortedArrays(arr1, arr2)
    assert(arr2.length == 19)

    var last: Int = arr2.head

    for(v <- arr2) {
      assert(v >= last)
      last = v
      print(v + " ")
    }
  }
}
