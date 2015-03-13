package technology.walrath.cardutil.dealer.decks

import technology.walrath.cardutil.core.{Card, Suit}
import technology.walrath.cardutil.testing.TestSpec

object StandardDeckTestMock extends StandardDeck { } //Just a sample impl to test the trait

class StandardDeckTest extends TestSpec {
  "Open Deck" should "return a fresh new deck in 'bicycle' order" in {
    val freshDeck = StandardDeckTestMock.openDeck
    freshDeck(0) should be (Card(1, Suit.Spades))
    freshDeck(12) should be (Card(13, Suit.Spades))
    freshDeck(13) should be (Card(1, Suit.Clubs))
    freshDeck(25) should be (Card(13, Suit.Clubs))
    freshDeck(26) should be (Card(1, Suit.Hearts))
    freshDeck(38) should be (Card(13, Suit.Hearts))
    freshDeck(39) should be (Card(1, Suit.Diamonds))
    freshDeck(51) should be (Card(13, Suit.Diamonds))
  }
  
  it should "return 52 cards" in {
    StandardDeckTestMock.openDeck should have length 52
  }
}