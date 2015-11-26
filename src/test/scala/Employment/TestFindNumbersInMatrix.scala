package Employment

import org.scalatest.FlatSpec


class TestFindNumbersInMatrix extends FlatSpec {
  "When given a matrix of character, method" should "find all numbers and return locations in a list" in {
    val matrix: Array[Array[Char]] = Array(Array('a','b','c','d'), Array('a','1','c','d'), Array('a','b','2','d'), Array('a','b','c','d'))

    val coordinates: List[(Int, Int)] = Util.findNumbersInMatrix(matrix)

    assert(coordinates.length == 2)
    assert(coordinates.head._1 == 1)
    assert(coordinates.head._2 == 1)
    assert(coordinates(1)._1 == 2)
    assert(coordinates(1)._2 == 2)
  }
}
