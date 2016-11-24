package checkout

class Checkout {
  def checkout(cart: List[String]): Int = {
    val subtotal = cart.map(priceOfItem).sum
    val appleOfferDiscount = appleOffer(cart)
    val orangeOfferDiscount = orangeOffer(cart)
    subtotal - (appleOfferDiscount + orangeOfferDiscount)
  }

  private def priceOfItem(item: String): Int = item match {
    case "apple" => 60
    case "orange" => 25
    case _ => throw new IllegalArgumentException(s"Item not stocked: $item")
  }

  private def appleOffer(cart: List[String]): Int = {
    cart.count(item => item == "apple") / 2 * priceOfItem("apple")
  }

  private def orangeOffer(cart: List[String]): Int = {
    cart.count(item => item == "orange") / 3 * priceOfItem("orange")
  }
}
