package technology.walrath.cardutil.core

import org.scalatest.{FlatSpec, Matchers, BeforeAndAfter}
import Card._
import TestUtils._
import technology.walrath.cardutil.dealer.Dealer

class CardTest extends FlatSpec with Matchers with BeforeAndAfter {
  var dealer: Dealer = null
  
  before {
    dealer = new TestDealer
  }
  
  "All cards in a new deck" should "have valid card values" in {
    dealer.openDeck map(validateValue) should not contain false
  }
  
  "A card" should "be valid if the value is 1" in {
    Card.validateValue(Card(1, Suit.Spades)) should be (true)
  }
  
  it should "be valid if the value is 5" in {
    Card.validateValue(Card(5, Suit.Spades)) should be (true)
  }
  
  it should "be valid if the value is 13" in {
    Card.validateValue(Card(13, Suit.Spades)) should be (true)
  }
  
  it should "be invalid if the value is lower than lower bound" in {
    Card.validateValue(Card(-13, Suit.Spades)) should be (false)
  }
  
  it should "be invalid if the value is higher than upper bound" in {
    Card.validateValue(Card(50, Suit.Spades)) should be (false)
  }
}