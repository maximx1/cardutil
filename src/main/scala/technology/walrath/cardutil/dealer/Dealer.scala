package technology.walrath.cardutil.dealer

import scala.util.Random
import technology.walrath.cardutil.core.Card
import technology.walrath.cardutil.core.Suit

trait Dealer {
  def shuffle(deck: Seq[Card]): Seq[Card] = Random.shuffle(deck)
  
  def newDeck: Seq[Card] = {
    for(x <- Suit.values.toList; y <- 1 to 13) yield Card(y, x)
  }
  
  def deal(hands: Int, limit: Int): (Seq[Card], Array[Seq[Card]])
}

object Dealer extends Dealer {
  
  /**
   * Default dealer will deal Texas Hold'em hands
   */
  def deal(hands: Int = 5, limit: Int = 2): (Seq[Card], Array[Seq[Card]]) = {
    val splitPiles = shuffle (newDeck) grouped limit
    val dealtHands = splitPiles.take(hands).toArray
    val leftover = splitPiles.flatten.toSeq
    (leftover, dealtHands)
  }
}