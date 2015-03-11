package technology.walrath.cardutil.dealer

import technology.walrath.cardutil.core.Card
import technology.walrath.cardutil.dealer.decks.StandardDeck

class PokerDealer extends Dealer with StandardDeck {
  def deal(hands: Int = 5, limit: Int = 2): (Seq[Card], Array[Seq[Card]]) = {
    val splitPiles = shuffle (openDeck) grouped limit
    val dealtHands = splitPiles.take(hands).toArray
    val leftover = splitPiles.flatten.toSeq
    (leftover, dealtHands)
  }
}