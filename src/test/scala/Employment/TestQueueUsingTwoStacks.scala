package Employment

import C_StacksAndQueues.Stacks.SimpleStack
import org.scalatest.FlatSpec



class TestQueueUsingTwoStacks extends FlatSpec {
  "A queue implemented using two stacks" should "behave like a queue" in {

    val stack: SimpleStack = new SimpleStack(10)
    assert(stack.push(1))
    assert(stack.push(2))
    assert(stack.push(3))
    assert(stack.push(4))
    assert(stack.push(5))

    assert(stack.pop().contains(5))
    assert(stack.pop().contains(4))
    assert(stack.pop().contains(3))
    assert(stack.pop().contains(2))
    assert(stack.pop().contains(1))


    val queue: QueueUsingTwoStacks = new QueueUsingTwoStacks


    assert(queue.enqueue(1))
    assert(queue.enqueue(2))
    assert(queue.enqueue(3))
    assert(queue.enqueue(4))
    assert(queue.enqueue(5))

    assert(queue.dequeue().contains(1))
    assert(queue.dequeue().contains(2))
    assert(queue.dequeue().contains(3))
    assert(queue.dequeue().contains(4))
    assert(queue.dequeue().contains(5))

    assert(queue.enqueue(6))
    assert(queue.dequeue().contains(6))
    assert(queue.enqueue(7))
    assert(queue.enqueue(3))
    assert(queue.dequeue().contains(7))
    assert(queue.dequeue().contains(3))
    assert(queue.enqueue(8))
    assert(queue.enqueue(5))
    assert(queue.dequeue().contains(8))
    assert(queue.dequeue().contains(5))
    assert(queue.dequeue().isEmpty)



  }
}
