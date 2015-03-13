package technology.walrath.cardutil.dealer.decks

import technology.walrath.cardutil.core.{Card, Suit}
import technology.walrath.cardutil.testing.TestSpec

object DoubleStandardDeckTestMock extends DoubleStandardDeck { } //Just a sample impl to test the trait

class DoubleStandardDeckTest extends TestSpec {
  "Open Deck" should "return a fresh new deck in 'bicycle' order twice" in {
    val freshDeck = DoubleStandardDeckTestMock.openDeck
    freshDeck(0) should be (Card(1, Suit.Spades))
    freshDeck(12) should be (Card(13, Suit.Spades))
    freshDeck(13) should be (Card(1, Suit.Clubs))
    freshDeck(25) should be (Card(13, Suit.Clubs))
    freshDeck(26) should be (Card(1, Suit.Hearts))
    freshDeck(38) should be (Card(13, Suit.Hearts))
    freshDeck(39) should be (Card(1, Suit.Diamonds))
    freshDeck(51) should be (Card(13, Suit.Diamonds))
    
    freshDeck(52) should be (Card(1, Suit.Spades))
    freshDeck(64) should be (Card(13, Suit.Spades))
    freshDeck(65) should be (Card(1, Suit.Clubs))
    freshDeck(77) should be (Card(13, Suit.Clubs))
    freshDeck(78) should be (Card(1, Suit.Hearts))
    freshDeck(90) should be (Card(13, Suit.Hearts))
    freshDeck(91) should be (Card(1, Suit.Diamonds))
    freshDeck(103) should be (Card(13, Suit.Diamonds))
  }
  
  it should "return 104 cards" in {
    DoubleStandardDeckTestMock.openDeck should have length 104
  }
}