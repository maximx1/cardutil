package technology.walrath.cardutil.dealer

import scala.util.Random
import technology.walrath.cardutil.core.Card
import technology.walrath.cardutil.core.Suit

object Dealer {
  def shuffle(deck: Seq[Card]): Seq[Card] = Random.shuffle(deck)
  
  def newDeck: Seq[Card] = {
    for(x <- Suit.values.toList; y <- 1 to 13) yield Card(y, x)
  }
}