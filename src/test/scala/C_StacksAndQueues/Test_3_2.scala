package C_StacksAndQueues

import C_StacksAndQueues.Stacks.{StackWithMin2, StackWithMin}
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


    val stack2: StackWithMin2 = new StackWithMin2

    
    stack2.push(10)
    stack2.push(20)
    stack2.push(110)
    stack2.push(3)
    stack2.push(11111)

    assert(stack2.min().get == 3)
    assert(stack2.pop().get == 11111)
    assert(stack2.min().get == 3)
    assert(stack2.pop().get == 3)
    assert(stack2.min().get == 10)
    assert(stack2.pop().get == 110)
    assert(stack2.min().get == 10)
    assert(stack2.pop().get == 20)
    assert(stack2.min().get == 10)
    assert(stack2.pop().get == 10)
    assert(stack2.pop().isEmpty)
    assert(stack2.min().isEmpty)
  }
}
