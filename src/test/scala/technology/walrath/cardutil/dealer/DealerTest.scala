package technology.walrath.cardutil.dealer

import org.scalatest.{FlatSpec, Matchers}
import Dealer._
import technology.walrath.cardutil.core.Suit

class DealerTest extends FlatSpec with Matchers {
  "New Deck" should "return a fresh new deck in 'bicycle' order" in {
    val freshDeck = newDeck
    newDeck(0) should be (Card(1, Suit.Spades))
    newDeck(12) should be (Card(13, Suit.Spades))
    newDeck(13) should be (Card(1, Suit.Clubs))
    newDeck(25) should be (Card(13, Suit.Clubs))
    newDeck(26) should be (Card(1, Suit.Hearts))
    newDeck(38) should be (Card(13, Suit.Hearts))
    newDeck(39) should be (Card(1, Suit.Diamonds))
    newDeck(51) should be (Card(13, Suit.Diamonds))
  }
  
  it should "return 52 cards" in {
    newDeck should have length 52
  }
  
  "A shuffle of a new deck" should "muck up the order so that it's not 'bicycle' order" in {
    val shuffledDeck = shuffle (newDeck)
    assert(
      shuffledDeck(0) != (Card(1, Suit.Spades)) ||
      shuffledDeck(12) != (Card(13, Suit.Spades)) ||
      shuffledDeck(13) != (Card(1, Suit.Clubs)) ||
      shuffledDeck(25) != (Card(13, Suit.Clubs)) ||
      shuffledDeck(26) != (Card(1, Suit.Hearts)) ||
      shuffledDeck(38) != (Card(13, Suit.Hearts)) ||
      shuffledDeck(39) != (Card(1, Suit.Diamonds)) ||
      shuffledDeck(51) != (Card(13, Suit.Diamonds))
    )
  }
}