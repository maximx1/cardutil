package technology.walrath.cardutil.dealer

import technology.walrath.cardutil.core.{Card, Suit}
import technology.walrath.cardutil.testing.TestSpec

class PokerDealerTest extends TestSpec {
  
  var dealer: PokerDealer = null
  
  before{
    this.dealer = new PokerDealer()
  }
  
  "A dealer" should "be able to deal a texas hold 'em hand by default" in {
    val (deck, hands) = dealer.deal()
    deck should have length 42
    hands should have length 5
    hands filter(_.size == 2) should have length 5
  }
  
  it should "not have duplicates cards in the hands and deck" in {
    val (deck, hands) = dealer.deal()
    (hands.flatten ++ deck).toSet.size should be (52)
  }
  
  it should "return 26 hands with 2 cards each when asked to give 50 hands at 2 cards apiece" in {
    val (deck, hands) = dealer.deal(50, 2)
    deck should have length 0
    hands should have length 26
    hands.filter(_.size == 2) should have length 26
  }
  
  it should "return one hand with 52 cards when asked to return a limit greater than 52" in {
    val (deck, hands) = dealer.deal(10, 60)
    deck should have length 0
    hands should have length 1
  }
  
  it should "return 52 hands with 1 card each when asked to return 52 hands with a limit of one" in {
    val (deck, hands) = dealer.deal(52, 1)
    deck should have length 0
    hands should have length 52
    hands.filter(_.size == 1) should have length 52
  }
  
  it should "return an uneven number of cards if limit and hands isn't evenly divisible and uses the entire deck" in {
    val (deck, hands) = dealer.deal(18, 3)
    deck should have length 0
    hands should have length 18
    hands.filter(_.size == 3) should have length 17
  }
}