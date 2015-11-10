package C_StacksAndQueues.Stacks

import scala.collection.mutable

class ThreeStackArray {
  val arr: mutable.ArrayBuffer[Int] = new mutable.ArrayBuffer(9)
  arr.append(-1, -1, -1, -1, -1, -1, -1, -1, -1)
  val stackPointers: mutable.ArrayBuffer[Int] = new mutable.ArrayBuffer(3)
  val Max: Int = 2
  stackPointers.append(-1, -1, -1)


  def push(stack: Int, num: Int): Boolean = {
    val s = stack - 1
    if (s < 0 || stack > Max ) {
      return false
    }
    if (stackPointers(s) < Max) {
      stackPointers(s) += 1
      arr(stackPointers(s)) = num
      true
    } else {
      false
    }
  }

  def pop(stack: Int): Option[Int] = {
    val s = stack - 1
    if (s < 0 || s > Max + 1) {
      return None
    }
    if (stackPointers(s) >= 0) {
      val num = arr(stackPointers(s))
      stackPointers(s) -= 1
      Some(num)
    } else {
      None
    }
  }
}
