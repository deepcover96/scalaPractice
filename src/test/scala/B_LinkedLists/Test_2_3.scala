package B_LinkedLists

import B_LinkedLists.LinkedList.SingleLinkedNode
import org.scalatest.FlatSpec

import scala.collection.mutable

class Test_2_3 extends FlatSpec {
  "Given only access to a node in a singly linked list, method" should "remove that node" in {
    val node5 = new SingleLinkedNode(5)
    val node4 = new SingleLinkedNode(4, Some(node5))
    val node3 = new SingleLinkedNode(3, Some(node4))
    val node2 = new SingleLinkedNode(2, Some(node3))
    val node1 = new SingleLinkedNode(1, Some(node2))

    var success = LinkedListTools.removeSingleNode2(node5)
    assert(!success)  //doesn't work for last one
    success = LinkedListTools.removeSingleNode2(node3)
    assert(success)
    assert(node1.value == 1)
    assert(node2.value == 2)
    assert(node3.value == 4)
    assert(node4.value == 5)
    assert(node4.nextNode.isEmpty)
    success = LinkedListTools.removeSingleNode2(node3)
    assert(success)
    assert(node1.value == 1)
    assert(node2.value == 2)
    assert(node3.value == 5)
    assert(node3.nextNode.isEmpty)
    success = LinkedListTools.removeSingleNode2(node2)
    assert(success)
    assert(node1.value == 1)
    assert(node2.value == 5)
    assert(node2.nextNode.isEmpty)
    success = LinkedListTools.removeSingleNode2(node2)
    assert(!success)
    success = LinkedListTools.removeSingleNode2(node1)
    assert(success)
    assert(node1.value == 5)
    assert(node1.nextNode.isEmpty)
    success = LinkedListTools.removeSingleNode2(node1)
    assert(!success)



    val list: mutable.ListBuffer[Int] = mutable.ListBuffer(1, 2, 3, 4, 5, 6)
    success = LinkedListTools.removeSingleNode(list, 3)
    assert(success)
    assert(list.length == 5)
    assert(list.head == 1)
    assert(list(1) == 2)
    assert(list(2) == 3)
    assert(list(3) == 5)
    assert(list.last == 6)  //(1, 2, 3, 5, 6)

    success = LinkedListTools.removeSingleNode(list, 3)
    assert(success)
    assert(list.length == 4)
    assert(list.head == 1)
    assert(list(1) == 2)
    assert(list(2) == 3)
    assert(list.last == 6) //(1, 2, 3, 6)

    success = LinkedListTools.removeSingleNode(list, 1)
    assert(success)
    assert(list.length == 3)
    assert(list.head == 1)
    assert(list(1) == 3)
    assert(list.last == 6) //(1, 3, 6)

    success = LinkedListTools.removeSingleNode(list, 1)
    assert(success)
    assert(list.length == 2)
    assert(list.head == 1)
    assert(list.last == 6) //(1, 6)

    success = LinkedListTools.removeSingleNode(list, 1)
    assert(success)
    assert(list.length == 1)
    assert(list.head == 1)
    assert(list.last == 1) //(1)

    success = LinkedListTools.removeSingleNode(list, 1)
    assert(!success)
    assert(list.length == 1)
    assert(list.head == 1)
    assert(list.last == 1) //(1)

    success = LinkedListTools.removeSingleNode(list, 0)
    assert(success)
    assert(list.isEmpty)


  }
}
