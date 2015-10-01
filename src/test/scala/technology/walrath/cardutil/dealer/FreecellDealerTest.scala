package technology.walrath.cardutil.dealer
import technology.walrath.cardutil.testing.TestSpec


class FreecellDealerTest extends TestSpec {
  "A freecell dealer deal" should "result in first 4 piles of 7 and last 4 piles of 6" in {
    val (_, stacks) = new FreecellDealer().deal()
    stacks.take(4).filter(_.size == 7) should have length 4
    stacks.takeRight(4).filter(_.size == 6) should have length 4
  }
  
  it should "have 8 stacks" in {
    val (_, stacks) = new FreecellDealer().deal()
    stacks should have length 8
  }
}