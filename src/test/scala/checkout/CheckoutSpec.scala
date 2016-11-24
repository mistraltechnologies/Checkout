package checkout

import org.scalatest._

class CheckoutSpec extends WordSpec {

  "Checking out a shopping cart" when {
    "empty" should {
      "have total zero" in {
        assert(new Checkout().checkout(Nil) == 0)
      }
    }
  }
}
