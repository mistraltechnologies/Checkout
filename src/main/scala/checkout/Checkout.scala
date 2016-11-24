package checkout

class Checkout {
  def checkout(cart: List[String]): Int = {
    val subtotal = cart.map(priceOfItem).sum
    val appleOfferDiscount = appleOffer(cart)
    subtotal - appleOfferDiscount
  }

  private def priceOfItem(item: String): Int = item match {
    case "apple" => 60
    case "orange" => 25
    case _ => throw new IllegalArgumentException(s"Item not stocked: $item")
  }

  private def appleOffer(cart: List[String]): Int = {
    cart.count(item => item == "apple") / 2 * priceOfItem("apple")
  }
}
