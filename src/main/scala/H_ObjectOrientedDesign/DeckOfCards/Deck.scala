package H_ObjectOrientedDesign.DeckOfCards

import scala.collection.mutable
import scala.util.Random

class Deck {
  private val deck: mutable.ListBuffer[Card] = mutable.ListBuffer()

  def initDeck(): mutable.ListBuffer[Card] = {
    deck.clear()
    for(s <- Suit.values) {
      for (r <- Rank.values) {
        deck += new Card(s, r)
      }
    }

    shuffleCards(deck)
  }



  private def shuffleCards(deckToShuffle: mutable.ListBuffer[Card]): mutable.ListBuffer[Card] = {
    val unShuffledCards: mutable.ListBuffer[Card] = mutable.ListBuffer()
    val r = new Random()


    for(c <- deckToShuffle) {
      unShuffledCards += c
    }
    deckToShuffle.clear()

    for(i <- unShuffledCards.indices) {

      val index = unShuffledCards.length match {
        case _ if unShuffledCards.length > 1 =>
          r.nextInt(unShuffledCards.length - 1)
        case _ => 0
      }
      deckToShuffle += unShuffledCards.remove(index)
    }

    deckToShuffle
  }

  def shuffle(): Unit = {
    initDeck()
    shuffleCards(deck)
  }

  def dealCard(): Card = {
    deck.remove(0)
  }

}
