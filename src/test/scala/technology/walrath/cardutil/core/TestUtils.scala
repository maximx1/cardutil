package technology.walrath.cardutil.core

import technology.walrath.cardutil.dealer.Dealer
import technology.walrath.cardutil.dealer.decks.StandardDeck

object TestUtils {
  class TestDealer extends Dealer with StandardDeck {
    def deal(hands: Int, limit: Int): (Seq[Card], Array[Seq[Card]]) = (Seq(), Array())
  }
}