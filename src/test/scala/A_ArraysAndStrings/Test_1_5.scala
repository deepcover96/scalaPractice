package A_ArraysAndStrings

import org.scalatest.FlatSpec

class Test_1_5 extends FlatSpec {
  "strings with repeated characters" should "be compressed" in {
    assert(ArrayTools.basicCompression("aabb") == "aabb")
    assert(ArrayTools.basicCompression("helooooooooooo!!!!!") == "h1e1l1o11!5")
  }
}
