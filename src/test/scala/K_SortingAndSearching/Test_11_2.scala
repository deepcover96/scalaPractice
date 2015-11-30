package K_SortingAndSearching

import org.scalatest.FlatSpec

import scala.collection.mutable.ArrayBuffer


class Test_11_2 extends FlatSpec {
  "Calling anagram sorting function" should "return sorted array with anagrams next to each other." in {
    val arr: ArrayBuffer[String] = ArrayBuffer()
    arr.append("bad", "bad credit", "car", "dab", "rac", "debit card")

    SortingSearchingTools.anagramSort(arr)

    for(w <- arr) {
      print(w + " ")
    }


  }
}
