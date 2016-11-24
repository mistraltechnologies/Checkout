package checkout

import org.scalatest._

class CheckoutSpec extends WordSpec {

  "Checking out a shopping cart" when {
    "empty" should {
      "have total zero" in {
        assert(new Checkout().checkout(Nil) == 0)
      }
    }

    "contains invalid item" should {
      "throw exception" in {
        assertThrows[IllegalArgumentException] {
          new Checkout().checkout(List("invalidItem"))
        }
      }
    }

    "contains an apple" should {
      "should cost 60 pence" in {
        assert(new Checkout().checkout(List("apple")) == 60)
      }
    }

    "contains an orange" should {
      "should cost 25 pence" in {
        assert(new Checkout().checkout(List("orange")) == 25)
      }
    }
  }
}
