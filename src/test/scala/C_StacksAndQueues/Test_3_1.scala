package C_StacksAndQueues

import C_StacksAndQueues.Stacks.ThreeStackArray
import org.scalatest.FlatSpec


class Test_3_1 extends FlatSpec {
  "Given a single array" should "be able to use three stacks" in {
    val arr: ThreeStackArray = new ThreeStackArray

    assert(arr.push(1, 100))
    assert(arr.push(1, 200))
    assert(arr.push(1, 300))
    assert(!arr.push(1, 900))
    assert(arr.pop(1).get == 300)
    assert(arr.pop(1).get == 200)
    assert(arr.pop(1).get == 100)
    assert(arr.pop(1).isEmpty)
  }
}
