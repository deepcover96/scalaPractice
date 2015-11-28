package C_StacksAndQueues.Stacks

import scala.collection.mutable

class SimpleStack(depth: Int) {
  private val arr: mutable.ArrayBuffer[Int] = mutable.ArrayBuffer.fill[Int](depth)(0)
  private var stackPointer: Int = -1
  private val MaxDepthIndex: Int = depth -1

  def push(num: Int): Boolean = {
    if(stackPointer < MaxDepthIndex) {
      stackPointer += 1
      arr(stackPointer) = num
      true
    } else {
      false
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

  def size: Int = {
    stackPointer + 1
  }
}
