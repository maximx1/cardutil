package technology.walrath.cardutil.dealer

import scala.util.Random
import technology.walrath.cardutil.core.Card
import technology.walrath.cardutil.core.Suit
import technology.walrath.cardutil.dealer.decks.{StandardDeck, AbstractDeck}

abstract trait Dealer extends AbstractDeck with StandardDeck {
  def shuffle(deck: Seq[Card]): Seq[Card] = Random.shuffle(deck)
  def deal(hands: Int, limit: Int): (Seq[Card], Array[Seq[Card]])
}

object Dealer extends Dealer {
  
  /**
   * Default dealer will deal Texas Hold'em hands
   */
  def deal(hands: Int = 5, limit: Int = 2): (Seq[Card], Array[Seq[Card]]) = {
    val splitPiles = shuffle (openDeck) grouped limit
    val dealtHands = splitPiles.take(hands).toArray
    val leftover = splitPiles.flatten.toSeq
    (leftover, dealtHands)
  }
}