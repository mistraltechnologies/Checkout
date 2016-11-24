package checkout

import org.scalatest._

class CheckoutSpec extends WordSpec {
  val orange = "orange"
  val apple = "apple"

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

    "contains an " + apple should {
      "should cost 60 pence" in {
        assert(Checkout(List(apple)) == 60)
      }
    }

    "contains an " + orange should {
      "should cost 25 pence" in {
        assert(Checkout(List(orange)) == 25)
      }
    }

    "contains a mix of items" should {
      "should calculate correct total" in {
        assert(Checkout(List(orange, apple)) == 85)
      }
    }

    "contains multiple apples" should {
      "apply bogof offer" in {
        assert(Checkout(List.fill(2)(apple)) == 60)
        assert(Checkout(List.fill(3)(apple)) == 120)
        assert(Checkout(List.fill(4)(apple)) == 120)
      }
    }

    "contains multiple oranges" should {
      "apply three for two offer" in {
        assert(Checkout(List.fill(2)(orange)) == 50)
        assert(Checkout(List.fill(3)(orange)) == 50)
        assert(Checkout(List.fill(4)(orange)) == 75)
        assert(Checkout(List.fill(6)(orange)) == 100)
      }
    }

    "contains mix of apples and oranges" should {
      "apply both offers" in {
        val cart = List.fill(6)(List(orange, apple)).flatten
        val expected = (4 * 25) + (3 * 60)
        assert(Checkout(cart) == expected)
      }
    }
  }
}
