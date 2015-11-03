package B_LinkedLists

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
}
