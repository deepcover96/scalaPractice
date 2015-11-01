package A_ArraysAndStrings

import org.scalatest.FlatSpec


class Test_1_4 extends FlatSpec {
  "spaces in strings" should "be encoded to %20" in {
    assert(ArrayTools.encodeSpaces("a b") == "a%20b")
    assert(ArrayTools.encodeSpaces("a b c d e f g") == "a%20b%20c%20d%20e%20f%20g")
  }
}
