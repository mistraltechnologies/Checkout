package checkout

import org.scalatest._

class CheckoutSpec extends WordSpec {

  "Checking out a shopping cart" when {
    "empty" should {
      "have total zero" in {
        assert(Checkout(Nil) == 0)
      }
    }

    "contains invalid item" should {
      "throw exception" in {
        assertThrows[IllegalArgumentException] {
          Checkout(List("invalidItem"))
        }
      }
    }

    "contains an apple" should {
      "should cost 60 pence" in {
        assert(Checkout(List("apple")) == 60)
      }
    }

    "contains an orange" should {
      "should cost 25 pence" in {
        assert(Checkout(List("orange")) == 25)
      }
    }

    "contains a mix of items" should {
      "should calculate correct total" in {
        assert(Checkout(List("orange", "apple")) == 85)
      }
    }

    "contains multiple apples" should {
      "apply bogof offer" in {
        assert(Checkout(List("apple", "apple")) == 60)
        assert(Checkout(List("apple", "apple", "apple")) == 120)
        assert(Checkout(List("apple", "apple", "apple", "apple")) == 120)
      }
    }

    "contains multiple oranges" should {
      "apply three for two offer" in {
        assert(Checkout(List("orange", "orange")) == 50)
        assert(Checkout(List("orange", "orange", "orange")) == 50)
        assert(Checkout(List("orange", "orange", "orange", "orange")) == 75)
        assert(Checkout(List("orange", "orange", "orange", "orange", "orange", "orange")) == 100)
      }
    }
  }
}
