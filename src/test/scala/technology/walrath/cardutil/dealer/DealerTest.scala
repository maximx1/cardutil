package technology.walrath.cardutil.dealer

import org.scalatest.{FlatSpec, Matchers}
import Dealer._
import technology.walrath.cardutil.core.{Card, Suit}

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
  
  "A dealer" should "be able to deal a texas hold 'em hand by default" in {
    val (deck, hands) = deal()
    deck should have length 42
    hands should have length 5
    hands filter(_.size == 2) should have length 5
  }
  
  it should "not have duplicates cards in the hands and deck" in {
    val (deck, hands) = deal()
    (hands.flatten ++ deck).toSet.size should be (52)
  }
  
  it should "return 26 hands with 2 cards each when asked to give 50 hands at 2 cards apiece" in {
    val (deck, hands) = deal(50, 2)
    deck should have length 0
    hands should have length 26
    hands.filter(_.size == 2) should have length 26
  }
  
  it should "return one hand with 52 cards when asked to return a limit greater than 52" in {
    val (deck, hands) = deal(10, 60)
    deck should have length 0
    hands should have length 1
  }
  
  it should "return 52 hands with 1 card each when asked to return 52 hands with a limit of one" in {
    val (deck, hands) = deal(52, 1)
    deck should have length 0
    hands should have length 52
    hands.filter(_.size == 1) should have length 52
  }
  
  it should "return an uneven number of cards if limit and hands isn't evenly divisible and uses the entire deck" in {
    val (deck, hands) = deal(18, 3)
    deck should have length 0
    hands should have length 18
    hands.filter(_.size == 3) should have length 17
  }
}