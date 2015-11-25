package C_StacksAndQueues.Stacks

import scala.collection.mutable

class SimpleStack(depth: Int) {
  val arr: mutable.ArrayBuffer[Int] = mutable.ArrayBuffer.fill[Int](depth)(0)
  var stackPointer = -1

  def push(num: Int): Boolean = {
    if(depth == stackPointer) {
      false
    } else {
      stackPointer += 1
      arr(stackPointer) = num
      true
    }
  }

  def pop(): Option[Int] = {
    if(stackPointer < 0) {
      None
    } else {
      val num = Some(arr(stackPointer))
      stackPointer -= 1
      num
    }
  }
}
