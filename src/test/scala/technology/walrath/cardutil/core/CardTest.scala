package technology.walrath.cardutil.core

import org.scalatest.{FlatSpec, Matchers}
import Dealer._
import Card._
import technology.walrath.cardutil.dealer.Dealer

class CardTest extends FlatSpec with Matchers {
  "All cards in a new deck" should "have valid card values" in {
    newDeck map(validateValue) should not contain false
  }
}