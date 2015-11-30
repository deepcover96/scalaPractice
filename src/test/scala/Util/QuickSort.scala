package Util

import org.scalatest.FlatSpec
import scala.collection.mutable

class QuickSort extends FlatSpec {
  "Given an unsorted array, sort method" should "return array sorted" in {
    val arr: mutable.ArrayBuffer[Int] = mutable.ArrayBuffer(21,38,52,19,30,53,19,55,16,21)
    val arr2: mutable.ArrayBuffer[Int] = mutable.ArrayBuffer(2,1,4)
    Util.Sort.quickSort(arr)
    Util.Sort.quickSort(arr2)

    println(arr.mkString(","))
    assert(arr.mkString(",") == "16,19,19,21,21,30,38,52,53,55")


    println(arr2.mkString(","))
    assert(arr2.mkString(",") == "1,2,4")
  }

}
