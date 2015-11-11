package C_StacksAndQueues.Stacks

class StackWithMin {
  private val Max: Int = 99
  private val stack: Array[(Int, Int)] = Array.fill[(Int,Int)](Max + 1)(0,0)
  private var stackPointer: Int = -1

  def push(num: Int): Boolean = {
    val minVal: Int = stackPointer match {
      case -1 => num
      case _  =>
        if(stack(stackPointer)._2 < num) {
          stack(stackPointer)._2
        } else {
          num
        }
    }

    stackPointer += 1
    if (stackPointer > Max) {
      false
    } else {
      stack(stackPointer) = (num, minVal)
      true
    }
  }

  def pop(): Option[Int] = {
    if (stackPointer >= 0) {
      val result = stack(stackPointer)
      stackPointer -= 1
      Some(result._1)
    } else {
      None
    }
  }

  def min(): Option[Int] = {
    if(stackPointer >= 0) {
      Some(stack(stackPointer)._2)
    } else {
      None
    }
  }

  // todo: a separate stack that just tracks the min changes for stack position would be more space efficient
}