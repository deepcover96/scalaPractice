package H_ObjectOrientedDesign.DeckOfCards

import scala.io.StdIn

class BlackJack(games: Int, hitCount: Int = 0, test: Boolean = false) {
  private val deck: Deck = new Deck()
  private val dealer: Hand = new Hand(true)
  private val player: Hand = new Hand()
  private var gameCount = games


  def newGame(): Unit = {
    dealer.clear()
    player.clear()

    deck.shuffle()

    dealer.take(deck.dealCard())
    dealer.take(deck.dealCard())

    player.take(deck.dealCard())
    val score = player.take(deck.dealCard())

    println()
    println("========")
    play(score, hitCount)
  }

  def showScore(): Unit = {
    println("-")
    println("Dealer: " + dealer.show())
    println("You: " + player.show())
  }

  private def play(handScore: Int, hitCount: Int): Unit = {
    var playing = true
    var score = handScore

    // For testing purposes, a set number of hits
    var i = hitCount

    while(playing) {
      showScore()
      val answer = test match {
        case true =>
          if (i > 0) {
            i -= 1
            "h"
          } else {
            "s"
          }
        case false => StdIn.readLine("Hit or Stay (S/h): ")
      }
      if(answer == "h") {
        score = player.take(deck.dealCard())
        if(score >= 21) {
          playing = false
          showScore()
        }
      } else {
        playing = false
      }
    }

    gameOver(score)
  }

  private def dealerPlays(playerScore: Int): Int = {
    var dealerScore = dealer.cardScore()

    while(dealerScore < playerScore && dealerScore < 21) {
      dealerScore = dealer.take(deck.dealCard())
    }

    dealerScore
  }

  private def gameOver(score: Int): Unit = {
    println("------------")

    if(score > 21) {
      println("You busted: " + score)
    } else {
      val dealerScore = dealerPlays(score)

      dealerScore match {
        case _ if dealerScore > 21 => println("Dealer Busts, YOU WIN!!")
        case _ if dealerScore == score => println("Push")
        case _ if dealerScore < score => println("YOU WIN!!")
        case _ if dealerScore > score => println("Dealer wins")
      }
    }

    println("Dealer: " + dealer.showAll())
    println("You: " + player.show())
    gameCount -= 1

    if(gameCount > 0) {
      newGame()
    }
  }

}
