package A_ArraysAndStrings

import org.scalatest.FlatSpec

class Test_1_6 extends FlatSpec {
  "2d array representing a bitmap" should "rotated 90 degrees" in {
    val bitmap = Array.ofDim[Int](5,5)

    // 00000
    // 11111
    // 22222
    // 33333
    // 44444
    Util.populateMatrix(bitmap)

    Util.printMatrix(bitmap)
    assert(bitmap(0)(0) == 0)
    assert(bitmap(1)(0) == 0)
    assert(bitmap(2)(0) == 0)
    assert(bitmap(3)(0) == 0)
    assert(bitmap(4)(0) == 0)

    ArrayTools.rotateImage(bitmap)

    Util.printMatrix(bitmap)
    assert(bitmap(0)(0) == 4)
    assert(bitmap(1)(0) == 3)
    assert(bitmap(2)(0) == 2)
    assert(bitmap(3)(0) == 1)
    assert(bitmap(4)(0) == 0)


    val bitmap2 = Array.ofDim[Int](10,10)

    Util.populateMatrix(bitmap2)

    Util.printMatrix(bitmap2)
    ArrayTools.rotateImage(bitmap2)
    Util.printMatrix(bitmap2)
  }
}