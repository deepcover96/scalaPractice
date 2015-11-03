package A_ArraysAndStrings

import org.scalatest.FlatSpec
import scala.collection.mutable

class Test_1_2 extends FlatSpec {
  "Reverse a string passed in as an array" should "reverse string taking into account null termonator" in {
    val arr: mutable.ArrayBuffer[Char] = mutable.ArrayBuffer[Char]('f', 'o', 'o', 'b', 'a', 'r', '\u0000')
    val str: String = ArrayTools.reverseString(arr)


    val arr2: mutable.ArrayBuffer[Char] = mutable.ArrayBuffer[Char]('f','\u0000')
    val str2: String = ArrayTools.reverseString(arr2)


    val arr3: mutable.ArrayBuffer[Char] = mutable.ArrayBuffer[Char]('a','s','\u0000')
    val str3: String = ArrayTools.reverseString(arr3)

    assert(str.equals("raboof"))
    assert(str2.equals("f"))
    assert(str3.equals("sa"))
  }
}
