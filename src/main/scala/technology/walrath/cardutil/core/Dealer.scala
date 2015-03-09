package technology.walrath.cardutil.core

import Suit._

object Dealer {
  def shuffle: Seq[Card] = {
    Seq()
  }
  
  def newDeck: Seq[Card] = {
    Suit.values.flatMap { x => {1 to 13 map(Card(_, x))} }.toSeq
  }
}

object Main {
  def main(args: Array[String]) {
    println(Dealer.newDeck.size)
    Dealer.newDeck.foreach { x => { println(x.value + " of " + x.suit) } }
  }
}