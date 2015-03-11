package technology.walrath.cardutil.dealer.decks

import technology.walrath.cardutil.core.Card

abstract trait AbstractDeck {
  def openDeck: Seq[Card]
}