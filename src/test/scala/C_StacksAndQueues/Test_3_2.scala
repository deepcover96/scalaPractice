package C_StacksAndQueues

import C_StacksAndQueues.Stacks.StackWithMin
import org.scalatest.FlatSpec


class Test_3_2 extends FlatSpec {
  "Using your stack implementation push() pop() and min()" should "operate in O(1)" in {
    val stack: StackWithMin = new StackWithMin

    stack.push(10)
    stack.push(20)
    stack.push(110)
    stack.push(3)
    stack.push(11111)

    assert(stack.min().get == 3)
    assert(stack.pop().get == 11111)
    assert(stack.min().get == 3)
    assert(stack.pop().get == 3)
    assert(stack.min().get == 10)
    assert(stack.pop().get == 110)
    assert(stack.min().get == 10)
    assert(stack.pop().get == 20)
    assert(stack.min().get == 10)
    assert(stack.pop().get == 10)
    assert(stack.pop().isEmpty)
    assert(stack.min().isEmpty)
  }
}
