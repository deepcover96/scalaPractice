package B_LinkedLists.LinkedList


class SingleLinkedNode (num: Int = 0, node: Option[SingleLinkedNode] = None) {
  var nextNode: Option[SingleLinkedNode] = node
  var value = num
}
