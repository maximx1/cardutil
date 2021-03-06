package technology.walrath.cardutil.dealer

import technology.walrath.cardutil.testing.TestUtils._
import technology.walrath.cardutil.core.{Card,Suit}
import technology.walrath.cardutil.testing.TestSpec

object DealerTest extends TestSpec {
  
  var dealer: Dealer = null
  
  before {
    dealer = new TestDealer
  }
  
  "A shuffle of a new deck" should "muck up the order so that it's not 'bicycle' order" in {
    
    val shuffledDeck = dealer.shuffle (dealer.openDeck)
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