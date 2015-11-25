package Employment

import org.scalatest.FlatSpec


class TestNumbersInString extends FlatSpec {
  "Function which takes a string of a series of numbers and characters" should "return sum of all numbers." in {
    assert(Util.sumOfNumbersInString("abce15def17,13bd4c") ==  49)
  }
}