package technology.walrath.cardutil.dealer.decks

import technology.walrath.cardutil.core.Card
import technology.walrath.cardutil.core.Suit

trait DoubleStandardDeck extends AbstractDeck with StandardDeck {
  override def openDeck: Seq[Card] = super.openDeck ++ super.openDeck
}