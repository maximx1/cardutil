package technology.walrath.cardutil.dealer

import technology.walrath.cardutil.core.Card

object BasicKlondikeDealer extends Dealer {
  def deal(hands: Int = 7, limit: Int = 7): (Seq[Card], Array[Seq[Card]]) = {
    val cards = shuffle(newDeck).toIterator
    val piles = for(i <- 1 to 7) yield cards.take(i).toSeq
    (cards.take(24).toSeq, piles.toArray)
  }
}