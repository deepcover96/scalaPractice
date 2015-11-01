package A_ArraysAndStrings


import org.scalatest.FlatSpec

class Test_1_8 extends FlatSpec {
  "strings that are rotations of the original string should return true" should "return true" in {
    assert(ArrayTools.isSubstring("foo", "oof"))
    assert(ArrayTools.isSubstring("oofoo", "foooo"))
    assert(!ArrayTools.isSubstring("foo", "fooo"))
    assert(!ArrayTools.isSubstring("foo", "bar"))
    assert(!ArrayTools.isSubstring("abc", "123"))
    assert(!ArrayTools.isSubstring("waterbottle", "terbottleswa"))
    assert(ArrayTools.isSubstring("waterbottle", "waterbottle"))
    assert(ArrayTools.isSubstring("waterbottle", "terbottlewa"))
  }
}