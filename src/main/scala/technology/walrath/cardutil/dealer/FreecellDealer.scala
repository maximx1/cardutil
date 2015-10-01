package technology.walrath.cardutil.dealer

import technology.walrath.cardutil.dealer.decks.StandardDeck
import technology.walrath.cardutil.core.Card

class FreecellDealer extends Dealer with StandardDeck {
  def deal(hands: Int = 8, limit: Int = 7): (Seq[Card], Array[Seq[Card]]) = {
    val deck = shuffle(openDeck)
    val leftSize = hands / 2 * limit
    val rightSize = deck.size - leftSize
    (Seq.empty, (deck.take(leftSize).grouped(limit) ++ deck.takeRight(rightSize).grouped(limit - 1)).toArray)
  }
}