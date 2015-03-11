package technology.walrath.cardutil.dealer

import scala.util.Random
import technology.walrath.cardutil.core.Card
import technology.walrath.cardutil.core.Suit
import technology.walrath.cardutil.dealer.decks.{StandardDeck, AbstractDeck}

abstract trait Dealer extends AbstractDeck {
  def shuffle(deck: Seq[Card]): Seq[Card] = Random.shuffle(deck)
  def deal(hands: Int, limit: Int): (Seq[Card], Array[Seq[Card]])
}