package technology.walrath.cardutil.core

object Suit extends Enumeration {
  val Spades, Clubs, Hearts, Diamonds = Value
}

import Suit._

case class Card(value: Int, suit: Suit.Value)

object Card {
  def validateValue(value: Int): Boolean = { value > 0 && value < 14 }
}