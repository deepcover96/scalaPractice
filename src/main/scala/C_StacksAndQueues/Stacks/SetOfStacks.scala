package C_StacksAndQueues.Stacks

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

/**
  * Set of stacks functions as a single stack, but consists of a growing set of stacks
  * @param max Max stack depth for each individual stack
  */
class SetOfStacks(max: Int) {
  val setOfStacks: mutable.ListBuffer[SimpleStack] = ListBuffer()
  val MaxStackSize: Int = max match {
    case _ if max > 0  => max
    case _ => 10
  }

  setOfStacks += new SimpleStack(MaxStackSize)  // initialize with first stack

  def push(num: Int): Unit = {
    if(!setOfStacks.last.push(num)) {
      setOfStacks += new SimpleStack(MaxStackSize)
      setOfStacks.last.push(num)
    }
  }

  def pop(): Option[Int] = {
    val num = setOfStacks.last.pop()
    num match {
      case Some(n) => num
      case None =>
        if(setOfStacks.length > 1) {
          setOfStacks.remove(setOfStacks.length - 1)
          pop()
        } else {
          None
        }
    }
  }

  /**
    * Since we allow popping anywhere, the size method checks all stacks for the size
    * O(m) with m as the number of sub-stacks
    * @return the count from all the stacks combined
    */
//  def size: Int = {
//    var count: Int = 0
//
//    for(s <- setOfStacks) {
//      count += s.size
//    }
//    count
//  }



  /**
    * Pops anywhere in the structures.  We fnd the right sub-stack to access, then we pop off into a temp stack,
    * get the item we want, then push the other items back onto the sub-stack.  This will result in uneven stacks.
    * O(m * (2*n mod stackSize))
    * @param index how far to go down into the stack to get value
    * @return the number at the index requested or None if not in range
    */
  def popAt(index: Int): Option[Int] = {
    var lastCount = 0
    var stackSize = 0

    /**
      * Sets the number of items prior to the relevant stack and total stack size
      * @param index the index to pop at
      * @return the sub-stack index we find our item at
      */
    def getStackIndex(index: Int): Option[Int] = {
      var i = setOfStacks.length
      var count = 0

      while (count <= index) {
        i -= 1
        if(i < 0)
          return None
        lastCount = count
        count += setOfStacks(i).size
      }

      for (j <- 0 to i - 1) {
        stackSize += setOfStacks(j).size
      }
      stackSize += count

      Some(i)
    }

    getStackIndex(index) match {
      case Some(stackIndex) =>
        if(index >= 0 && index < stackSize) {
          val indexDepth = index - lastCount - 1
          val tempStack: SimpleStack = new SimpleStack(indexDepth + 1)
          for(i <- 0 to indexDepth) {
            val n = setOfStacks(stackIndex).pop().get
            tempStack.push(n)
          }
          val num = setOfStacks(stackIndex).pop()
          for (j <- 0 to tempStack.size - 1) {
            setOfStacks(stackIndex).push(tempStack.pop().get)
          }
          num
        } else {
          None
        }
      case None =>
        None
    }


  }
}
