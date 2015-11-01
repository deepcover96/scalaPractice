package A_ArraysAndStrings

import org.scalatest.FlatSpec

class Test_1_7 extends FlatSpec {
  "Matrix with cells with 0" should "have entire row and column zeroized" in {
    val bitmap: Array[Array[Int]] = Array.ofDim[Int](5,9)
    Util.populateMatrix(bitmap, 1)
    bitmap(1)(1) = 0
    bitmap(3)(5) = 0
    Util.printMatrix(bitmap)


    ArrayTools.zeroize(bitmap)
    Util.printMatrix(bitmap)
  }
}