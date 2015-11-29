package H_ObjectOrientedDesign

import H_ObjectOrientedDesign.DeckOfCards.BlackJack
import org.scalatest.FlatSpec


class Test_8_1 extends FlatSpec {
  val blackJackGame = new BlackJack(3, 2, true)

  blackJackGame.newGame()
}
