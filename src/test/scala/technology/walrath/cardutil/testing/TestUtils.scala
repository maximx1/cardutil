package technology.walrath.cardutil.testing

import technology.walrath.cardutil.dealer.Dealer
import technology.walrath.cardutil.dealer.decks.StandardDeck
import technology.walrath.cardutil.core.Card

object TestUtils {
  class TestDealer extends Dealer with StandardDeck {
    def deal(hands: Int, limit: Int): (Seq[Card], Array[Seq[Card]]) = (Seq(), Array())
  }
}