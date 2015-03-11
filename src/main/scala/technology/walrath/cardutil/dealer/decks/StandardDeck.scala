package technology.walrath.cardutil.dealer.decks

import technology.walrath.cardutil.core.Card
import technology.walrath.cardutil.core.Suit

trait StandardDeck extends AbstractDeck {
  def openDeck: Seq[Card] = {
    for(x <- Suit.values.toList; y <- 1 to 13) yield Card(y, x)
  }
}