package H_ObjectOrientedDesign.DeckOfCards

import H_ObjectOrientedDesign.DeckOfCards.Rank.Rank
import H_ObjectOrientedDesign.DeckOfCards.Suit.Suit


class Card(suit: Suit, rank: Rank) {
  def getRank = rank
  def getSuit = suit
}