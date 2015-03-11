package technology.walrath.cardutil.dealer

import org.scalatest.{FlatSpec, Matchers, BeforeAndAfter}

class SpiderSolitaireDealerTest extends FlatSpec with Matchers with BeforeAndAfter {
  
  var dealer: SpiderSolitaireDealer = null
  
  before {
    dealer = new SpiderSolitaireDealer()
  }
  
  "A Spider dealer deal" should "be a basic round of spider solitaire" in {
    val (deck, stacks) = dealer.deal()
    
    deck should have length 50
    stacks should have length 10
    stacks(0) should have length 6
    stacks(1) should have length 6
    stacks(2) should have length 6
    stacks(3) should have length 6
    stacks(4) should have length 5
    stacks(5) should have length 5
    stacks(6) should have length 5
    stacks(7) should have length 5
    stacks(8) should have length 5
    stacks(9) should have length 5
  }
}