package technology.walrath.cardutil.dealer

import technology.walrath.cardutil.core.Card

object BasicKlondikeDealer extends Dealer {
  def deal(hands: Int, limit: Int): (Seq[Card], Array[Seq[Card]]) = {
    (Seq(), Array(Seq()))
  }
}