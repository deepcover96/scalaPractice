package A_ArraysAndStrings

import org.scalatest.FlatSpec

class Test_1_1 extends FlatSpec {
  "Strings with with every character being unique" should "return true" in {
    assert(ArrayTools.containsAllUniqueCharacters("A"))
    assert(!ArrayTools.containsAllUniqueCharacters("automobile"))
    assert(ArrayTools.containsAllUniqueCharacters("ABCDEFGHIJKLMNOP1234567890"))
    assert(!ArrayTools.containsAllUniqueCharacters("FOO"))
    assert(ArrayTools.containsAllUniqueCharacters("brave"))

    assert(ArrayTools.containsAllUniqueCharactersBitwise("A"))
    assert(!ArrayTools.containsAllUniqueCharactersBitwise("automobile"))
    assert(!ArrayTools.containsAllUniqueCharactersBitwise("FOO"))
    assert(ArrayTools.containsAllUniqueCharactersBitwise("brave"))
  }
}
