package Employment

import org.scalatest.FlatSpec

/*
 * Created by Wilfredo Ruiz on 11/19/15.
 * wil.ruiz@gmail.com
 * (602)-721-2985
 */

class TestReverseString extends FlatSpec {
  "Recursive function" should "Reverse a string." in {
    assert(Util.reverseStringRecursive("") == "")
    assert(Util.reverseStringRecursive("a") == "a")
    assert(Util.reverseStringRecursive("it") == "ti")
    assert(Util.reverseStringRecursive("foo") == "oof")
    assert(Util.reverseStringRecursive("abc") == "cba")
    assert(Util.reverseStringRecursive("dad") == "dad")
    assert(Util.reverseStringRecursive("accoutrements") == "stnemertuocca")
    assert(Util.reverseStringRecursive("luminescent") == "tnecsenimul")
    assert(Util.reverseStringRecursive("magnanimous") == "suominangam")
    assert(Util.reverseStringRecursive("unencumbered") == "derebmucnenu")
    assert(Util.reverseStringRecursive("parsimonious") == "suoinomisrap")
  }
}
