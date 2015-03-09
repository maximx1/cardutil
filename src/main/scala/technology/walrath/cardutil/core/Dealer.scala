package technology.walrath.cardutil.core

import Suit._

object Dealer {
  def shuffle: Seq[Card] = {
    Seq()
  }
  
  def newDeck: Seq[Card] = {
    for(x <- Suit.values.toList; y <- 1 to 13) yield Card(y, x)
  }
}

object Main {
  def main(args: Array[String]) {
    Dealer.newDeck.foreach { x => { println(x.value + " of " + x.suit) } }
  }
}