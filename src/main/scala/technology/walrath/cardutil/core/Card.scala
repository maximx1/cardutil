package technology.walrath.cardutil.core

object Suit extends Enumeration {
  val Spades, Clubs, Hearts, Diamonds = Value
}

import Suit._

case class Card(value: Int, suit: Suit.Value)

object Card {
  def validateValue(card: Card): Boolean = { card.value > 0 && card.value < 14 }
}