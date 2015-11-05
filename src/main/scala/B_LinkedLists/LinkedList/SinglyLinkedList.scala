package B_LinkedLists.LinkedList

class SinglyLinkedList {
  var headNode:Option[SingleLinkedNode] = None
  var lastNode:Option[SingleLinkedNode] = None

  def append(node:SingleLinkedNode): Unit = {
    if(lastNode.isEmpty) {
      headNode = Some(node)
      lastNode = Some(node)
    } else {
      lastNode.get.nextNode = Some(node)
    }
  }
}
