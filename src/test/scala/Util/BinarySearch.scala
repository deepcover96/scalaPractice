package Util

import org.scalatest.FlatSpec


class BinarySearch extends FlatSpec {
  "Given a sorted array" should "find value in O(log n)" in {
    val list: List[Int] = List[Int](2, 4, 6, 8, 10, 12)
    assert(Util.Search.binarySearch(list, 6).get == 2)


    val list2: List[Int] = List[Int](1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    assert(Util.Search.binarySearch(list2, 4).get == 3)

    assert(Util.Search.binarySearch(list2, 100).isEmpty)


    assert(Util.Search.binarySearchRecursive(list, 6).get == 2)
    assert(Util.Search.binarySearchRecursive(list2, 4).get == 3)
    assert(Util.Search.binarySearchRecursive(list2, 100).isEmpty)
  }
}
