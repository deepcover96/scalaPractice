package Employment

import org.scalatest.FlatSpec


class TestFindDuplicates extends FlatSpec {
  "When given an array of integers, method" should "find all duplicates and return the total number of distinct values" in {
    val arr: Array[Int] = Array[Int](1,2,3,4,5,7,111,1,1,1,7,7,7,3,3)
    assert(Util.findDuplicateNumbersInArray(arr) == 7)
  }
}
