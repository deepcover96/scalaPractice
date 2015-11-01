package A_ArraysAndStrings

import org.scalatest.FlatSpec

class Test_1_3 extends FlatSpec {
  "strings that are permutations of one another should return true" should "return true" in {
    assert(ArrayTools.isPermutation("foo", "foo"))
    assert(ArrayTools.isPermutation("oofoo", "foooo"))
    assert(!ArrayTools.isPermutation("foo", "fooo"))
    assert(!ArrayTools.isPermutation("foo", "bar"))
    assert(!ArrayTools.isPermutation("abc", "123"))
    assert(ArrayTools.isPermutation("1-4-5-2-3-6", "1-6-5-2-3-4"))
  }
}
