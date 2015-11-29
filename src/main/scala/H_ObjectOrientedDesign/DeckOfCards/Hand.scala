package H_ObjectOrientedDesign.DeckOfCards

import scala.collection.mutable

class Hand(dealer: Boolean = false) {
  private val cards: mutable.ListBuffer[Card] = mutable.ListBuffer()

  def cardScore(): Int = {
    var score = 0
    var aces = 0
    for (c <- cards) {
      c.getRank match {
        case Rank.Ace => aces += 1
        case Rank.Jack => score += 10
        case Rank.Queen => score += 10
        case Rank.King => score += 10
        case _ => score += c.getRank.id
      }
    }

    score += aces

    for (a <- 0 to aces) {
      if(score + 10 <= 21) {
        score += 10
      }
    }

    score
  }

  def take(card: Card): Int = {
    cards += card
    cardScore()
  }

  def clear(): Unit = {
    cards.clear()
  }

  def showAll(): String = {
    val displayCards: StringBuffer = new StringBuffer()

    for (c <- cards) {
      displayCards.append("[")
      displayCards.append(c.getRank.id)
      displayCards.append("] ")
    }

    displayCards.toString
  }

  def show(): String = {
    if (dealer) {
      if(cards.nonEmpty) {
        val str = "[" + cards.head.getRank.id + "] [?]"
        str
      } else {
        ""
      }
    } else {
      showAll()
    }
  }

}
