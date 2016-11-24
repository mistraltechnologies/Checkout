package checkout

class Checkout {
  def checkout(cart: List[String]): Int = {
    cart.map(priceOfItem)
    0
  }

  private def priceOfItem(item: String) = item match {
    case "apple" => 0
    case _ => throw new IllegalArgumentException(s"Item not stocked: $item")
  }
}
