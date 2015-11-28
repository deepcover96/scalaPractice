package C_StacksAndQueues

import C_StacksAndQueues.Stacks.SetOfStacks
import org.scalatest.FlatSpec


class Test_3_3 extends FlatSpec {
  "Implementation of a set of stacks" should "perform like a single stack" in {
    val setOfStacks: SetOfStacks = new SetOfStacks(5)

    setOfStacks.push(1)
    setOfStacks.push(2)
    setOfStacks.push(3)
    setOfStacks.push(4)
    setOfStacks.push(5)
    assert(setOfStacks.pop().contains(5))
    assert(setOfStacks.pop().contains(4))
    assert(setOfStacks.pop().contains(3))
    assert(setOfStacks.pop().contains(2))
    assert(setOfStacks.pop().contains(1))
    assert(setOfStacks.pop().isEmpty)

    setOfStacks.push(11)
    setOfStacks.push(12)
    setOfStacks.push(13)
    setOfStacks.push(14)
    setOfStacks.push(15)
    setOfStacks.push(21)
    setOfStacks.push(22)
    setOfStacks.push(23)
    setOfStacks.push(24)
    setOfStacks.push(25)
    setOfStacks.push(31)
    setOfStacks.push(32)
    setOfStacks.push(33)
    setOfStacks.push(34)
    setOfStacks.push(35)
    assert(setOfStacks.pop().contains(35))
    assert(setOfStacks.pop().contains(34))
    assert(setOfStacks.pop().contains(33))
    assert(setOfStacks.pop().contains(32))
    assert(setOfStacks.pop().contains(31))
    assert(setOfStacks.pop().contains(25))
    assert(setOfStacks.pop().contains(24))
    assert(setOfStacks.pop().contains(23))
    assert(setOfStacks.pop().contains(22))
    assert(setOfStacks.pop().contains(21))
    assert(setOfStacks.pop().contains(15))
    assert(setOfStacks.pop().contains(14))
    assert(setOfStacks.pop().contains(13))
    assert(setOfStacks.pop().contains(12))
    assert(setOfStacks.pop().contains(11))
    assert(setOfStacks.pop().isEmpty)


    setOfStacks.push(11) // 11th
    setOfStacks.push(12) // 12th
    setOfStacks.push(13) // 15th
    setOfStacks.push(14) // popped 1st
    setOfStacks.push(15) // 14th
    setOfStacks.push(21) // popped 5th
    setOfStacks.push(22) // popped 4th
    setOfStacks.push(23) // popped 2nd
    setOfStacks.push(24) // popped 6th
    setOfStacks.push(25) // popped 7th
    setOfStacks.push(31) // 13th
    setOfStacks.push(32) // 10th
    setOfStacks.push(33) // 9th
    setOfStacks.push(34) // popped 3rd
    setOfStacks.push(35) // 8th
    assert(setOfStacks.popAt(11).contains(14))
    assert(setOfStacks.popAt(7).contains(23))
    assert(setOfStacks.popAt(1).contains(34))
    assert(setOfStacks.popAt(6).contains(22))
    assert(setOfStacks.popAt(6).contains(21))
    assert(setOfStacks.popAt(5).contains(24))
    assert(setOfStacks.popAt(4).contains(25))

    assert(setOfStacks.pop().contains(35))
    assert(setOfStacks.pop().contains(33))
    assert(setOfStacks.pop().contains(32))

    assert(setOfStacks.popAt(4).contains(11))
    assert(setOfStacks.popAt(4).isEmpty)
    assert(setOfStacks.popAt(3).contains(12))

    assert(setOfStacks.pop().contains(31))
    assert(setOfStacks.pop().contains(15))
    assert(setOfStacks.pop().contains(13))
    assert(setOfStacks.pop().isEmpty)

  }
}
