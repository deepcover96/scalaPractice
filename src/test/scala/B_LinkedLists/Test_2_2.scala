package B_LinkedLists

import org.scalatest.FlatSpec
import scala.collection.mutable

class Test_2_2 extends FlatSpec {
  "Given an singly linked list, method" should "return kth to last element" in {
    val list: mutable.ListBuffer[Int] = mutable.ListBuffer(1, 1, 1, 300, 200, 100)
    assert(LinkedListTools.getFromEnd(list, 0).get == 100)
    assert(LinkedListTools.getFromEnd(list, 1).get == 200)
    assert(LinkedListTools.getFromEnd(list, 2).get == 300)
    assert(LinkedListTools.getFromEnd(list, 100).isEmpty)
  }
}
