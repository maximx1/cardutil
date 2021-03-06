package technology.walrath.cardutil.dealer

import technology.walrath.cardutil.core.Card
import technology.walrath.cardutil.dealer.decks.StandardDeck

class BasicKlondikeDealer extends Dealer with StandardDeck {
  def deal(hands: Int = 7, limit: Int = 7): (Seq[Card], Array[Seq[Card]]) = {
    val cards = shuffle(openDeck)
    val triangleNumbers = Stream.from(0).map(n => n * (n + 1) / 2)
    val piles = triangleNumbers.zip(Stream from 1).take(7).map(x => cards.drop(x._1).take(x._2)).toArray
    (cards.drop(piles.map(_.size).sum).take(cards.size).toSeq, piles)
  }
}