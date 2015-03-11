package technology.walrath.cardutil.dealer

import technology.walrath.cardutil.core.Card
import technology.walrath.cardutil.dealer.decks.DoubleStandardDeck

class SpiderSolitaireDealer extends Dealer with DoubleStandardDeck {
  def deal(hands: Int = 10, limit: Int = 6): (Seq[Card], Array[Seq[Card]]) = {
    val (deck, largerStacks) = subDeal(shuffle (openDeck), 4, 6)
    val (leftover, smallerStacks) = subDeal(deck, 6, 5)
    (leftover, largerStacks ++ smallerStacks)
  }
  
  private def subDeal(deck: Seq[Card], hands: Int, limit: Int): (Seq[Card], Array[Seq[Card]]) = {
    val splitPiles = deck grouped limit
    val dealtHands = splitPiles.take(hands).toArray
    val leftover = splitPiles.flatten.toSeq
    (leftover, dealtHands)
  }
}