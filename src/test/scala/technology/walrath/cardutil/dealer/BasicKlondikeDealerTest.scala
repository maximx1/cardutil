package technology.walrath.cardutil.dealer

import org.scalatest.{FlatSpec, Matchers}
//import BasicKlondikeDealer._

class BasicKlondikeDealerTest extends FlatSpec with Matchers {
  "A klondike dealer deal" should "be a basic round of solitaire" in {
    val (deck, stacks) = BasicKlondikeDealer.deal()
    deck should have length 24
    stacks should have length 7
    stacks(0) should have length 1
    stacks(1) should have length 2
    stacks(2) should have length 3
    stacks(3) should have length 4
    stacks(4) should have length 5
    stacks(5) should have length 6
    stacks(6) should have length 7
  }
  
  it should "not have any duplicates between the deck and the stacks." in {
    val (deck, stacks) = BasicKlondikeDealer.deal()
    (stacks.flatten ++ deck).toSet.size should be (52)
  }
}