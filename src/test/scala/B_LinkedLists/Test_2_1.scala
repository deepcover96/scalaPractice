package B_LinkedLists

import org.scalatest.FlatSpec
import scala.collection.mutable

class Test_2_1 extends FlatSpec {
  "Given an unsorted linked list method" should "remove duplicates" in {
    val list: mutable.ListBuffer[Int] = mutable.ListBuffer(1, 1, 1, 1, 1, 1)
    LinkedListTools.removeDuplicates(list)
    assert(list.length == 1)
    assert(list.head == 1)
    list += 2
    list += 3
    list += 4

    LinkedListTools.removeDuplicates(list)
    assert(list.length == 4)
    assert(list.head == 1)
    assert(list(1) == 2)
    assert(list(2) == 3)
    assert(list(3) == 4)
    assert(list.last == 4)
    list += 2
    list += 3
    list += 4
    list += 2
    list += 3
    list += 4

    LinkedListTools.removeDuplicates(list)
    assert(list.length == 4)
    assert(list.head == 1)
    assert(list(1) == 2)
    assert(list(2) == 3)
    assert(list(3) == 4)
    assert(list.last == 4)


    val list2: mutable.ListBuffer[Int] = mutable.ListBuffer(1, 1, 1, 1, 1, 1)
    LinkedListTools.removeDuplicates2(list2)
    assert(list2.length == 1)
    assert(list2.head == 1)
    list2 += 2
    list2 += 3
    list2 += 4

    LinkedListTools.removeDuplicates2(list2)
    assert(list2.length == 4)
    assert(list2.head == 1)
    assert(list2(1) == 2)
    assert(list2(2) == 3)
    assert(list2(3) == 4)
    assert(list2.last == 4)
    list2 += 2
    list2 += 3
    list2 += 4
    list2 += 2
    list2 += 3
    list2 += 4

    LinkedListTools.removeDuplicates2(list2)
    assert(list2.length == 4)
    assert(list2.head == 1)
    assert(list2(1) == 2)
    assert(list2(2) == 3)
    assert(list2(3) == 4)
    assert(list2.last == 4)
  }
}