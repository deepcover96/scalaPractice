package Employment

import C_StacksAndQueues.Stacks.SimpleStack


class QueueUsingTwoStacks {
  val leftStack: SimpleStack = new SimpleStack(100000)
  val rightStack: SimpleStack = new SimpleStack(100000)

  var leftStackActive: Boolean = true
  var isEnqueue: Boolean = false

  private def swap(): Unit = {
    def swapThem(s1: SimpleStack, s2: SimpleStack) = {
      var end = false
      while (!end) {
        val n = s1.pop()
        if(n.isDefined) {
          s2.push(n.get)
        } else {
          end = true
        }
      }
    }

    if(leftStackActive) {
      swapThem(leftStack, rightStack)
    } else {
      swapThem(rightStack, leftStack)
    }

    leftStackActive = !leftStackActive
  }

  def enqueue(num: Int): Boolean = {
    if(!isEnqueue) {
      swap()
      isEnqueue = true
    }

    if(leftStackActive) {
      leftStack.push(num)
    } else {
      rightStack.push(num)
    }
  }

  def dequeue(): Option[Int] = {
    if(isEnqueue) {
      swap()
      isEnqueue = false
    }

    if(leftStackActive) {
      leftStack.pop()
    } else {
      rightStack.pop()
    }

  }
}
