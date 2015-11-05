package B_LinkedLists

import B_LinkedLists.LinkedList.SingleLinkedNode

import scala.collection.mutable

object LinkedListTools {

  /**
    * 2.1 Given a linked list, removes all duplicate nodes
    * O(n)
    * @param linkedList the link list to modify
    */
  def removeDuplicates(linkedList: mutable.ListBuffer[Int]): Unit = {
    val map: mutable.Map[Int, Int] = mutable.Map()
    var index = 0

    while(index < linkedList.length) {
      val key = linkedList(index)
      if(map.contains(key)) {
        linkedList.remove(index)
      } else {
        map += (key -> key)
        index += 1
      }
    }
  }

  /**
    * 2.1 Given a linked list, removes all duplicate nodes
    * Temporary buffer disallowed here
    * O(n2)
    * @param linkedList the link list to modify
    */
  def removeDuplicates2(linkedList: mutable.ListBuffer[Int]): Unit = {
    var index = 0

    def removeOthers(num: Int, start: Int): Unit = {
      var i = start
      while(i < linkedList.length) {
        if(linkedList(i) == num) {
          linkedList.remove(i)
        } else {
          i += 1
        }
      }
    }

    while(index < linkedList.length) {
      val key = linkedList(index)
      removeOthers(key, index + 1)
      index += 1
    }
  }

  /**
    * Gets kth element from the end
    * O(n)
    * Note: if we were using a real-singly-linked list, we can have 2 pointers
    * move the first one k nodes, then move them together till the first one gets
    * to the end.  The first one will land on the correct location.
    * @param linkedList list to iterate through
    * @param k The kth element from the end
    * @return
    */
  def getFromEnd(linkedList: mutable.ListBuffer[Int], k: Int): Option[Int] = {
    if(k <= 0) return None
    val arr: Array[Int] = new Array[Int](k+1)
    var index: Int = 0
    var flipped: Boolean = false

    for(i <- linkedList.indices) {
      arr(index) = linkedList(i)
      index += 1
      if(index > k) {
        index = 0
        flipped = true
      }
    }

    if(!flipped) {
      None
    } else {
      Some(arr(index))
    }

  }

  /**
    * Remove a node from a singly-linked list.  The solution is to copy the entire remainder of the list back one
    * place over the deleted node.  This is O(n-k), with k bing the place of the deleted node.  In scala we are using
    * a list buffer so we will simulate this by traversing the list and copying index values back one place, then
    * finally removing the lat item.
    * @param linkedList the list to modify
    * @param k the node that needs to be removed
    * @return true if successful, false if error (k too big or too small
    */
  def removeSingleNode(linkedList: mutable.ListBuffer[Int], k: Int): Boolean = {
    if(k >= linkedList.length) return false //the equivalent in linked list will be getting to end before kth index
    if(k < 0) return false
    val stop = linkedList.length - 2

    if(stop > 0) {
      for(i <- k to stop) {
        linkedList(i) = linkedList(i + 1)
      }
    }
    linkedList.remove(linkedList.length - 1)
    true
  }

  /**
    * Remove a node from a singly-linked list.  The solution is to copy the entire remainder of the list back one
    * place over the deleted node.  This is O(n-k), with k bing the place of the deleted node.
    * I use my own defined linked list node class
    * @param node the node that needs to be removed
    * @return
    */
  def removeSingleNode2(node: SingleLinkedNode): Boolean = {
    if(node.nextNode.isEmpty) return false  //we can't remove ourselves because we don't have access to previous node

    def copyNext(n: SingleLinkedNode, prev: SingleLinkedNode): Boolean = {
      if(n.nextNode.isDefined) {
        n.value = n.nextNode.get.value
        copyNext(n.nextNode.get, n)
      } else {
        //remove the current node, which is the last node
        prev.nextNode = None
        true
      }
    }
    node.value = node.nextNode.get.value
    copyNext(node.nextNode.get, node)
  }
}
