package Util

import org.scalatest.FlatSpec
import scala.collection.mutable

class QuickSort extends FlatSpec {
  "Given an unsorted array, sort method" should "return array sorted" in {
    val arr: mutable.ArrayBuffer[Int] = mutable.ArrayBuffer(21,38,52,19,30,53,19,55,16,21)
    Util.Sort.quickSort(arr)
    println(arr.mkString(","))
    assert(arr.mkString(",") == "16,19,19,21,21,30,38,52,53,55")
  }

}
