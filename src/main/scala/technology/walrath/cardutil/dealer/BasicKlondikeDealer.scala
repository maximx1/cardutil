package technology.walrath.cardutil.dealer

import technology.walrath.cardutil.core.Card

object BasicKlondikeDealer extends Dealer {
  def deal(hands: Int = 7, limit: Int = 7): (Seq[Card], Array[Seq[Card]]) = {
    val cards = shuffle(newDeck)
    val triangleNumbers = Stream.from(0).map(n => n * (n + 1) / 2)
    val piles = triangleNumbers.zip(Stream from 1).take(7).map(x => cards.drop(x._1).take(x._2)).toArray
    (cards.drop(piles.map(_.size).sum).take(cards.size).toSeq, piles)
  }
}