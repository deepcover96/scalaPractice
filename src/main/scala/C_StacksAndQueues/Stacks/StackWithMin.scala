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
}

// with a separate stack that just tracks the min changes for stack position would be more space efficient
class StackWithMin2 {
  private val Max: Int = 99
  private val stack: Array[Int] = Array.fill[Int](Max + 1)(0)
  private val minStack: Array[(Int, Int)] = Array.fill[(Int,Int)](Max + 1)(0,0)
  private var stackPointer: Int = -1
  private var minStackPointer: Int = -1

  def push(num: Int): Boolean = {
    min() match {
      case None => pushMin(num, stackPointer + 1)
      case Some(m) =>
        if(num < m) {
          pushMin(num, stackPointer + 1)
        }
    }

    stackPointer += 1
    if (stackPointer > Max) {
      false
    } else {
      stack(stackPointer) = num
      true
    }
  }

  def pop(): Option[Int] = {
    if (stackPointer >= 0) {
      val result = stack(stackPointer)
      popMin(stackPointer)
      stackPointer -= 1
      Some(result)
    } else {
      None
    }
  }

  def min(): Option[Int] = {
    if(minStackPointer >= 0) {
      Some(minStack(minStackPointer)._1)
    } else {
      None
    }
  }

  private def pushMin(num:Int, index: Int): Boolean = {
    if (minStackPointer > Max) {
      false
    } else {
      minStackPointer += 1
      minStack(minStackPointer) = (num, index)
      true
    }
  }

  private def popMin(index: Int): Unit = {
    if(minStackPointer >= 0) {
      if(minStack(minStackPointer)._2 == index) {
        minStackPointer -= 1
      }
    }
  }

  // todo: a separate stack that just tracks the min changes for stack position would be more space efficient
}