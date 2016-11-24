package checkout

class Checkout {
  def checkout(cart: List[String]): Int = {
    cart.map(priceOfItem).sum
  }

  private def priceOfItem(item: String): Int = item match {
    case "apple" => 60
    case "orange" => 25
    case _ => throw new IllegalArgumentException(s"Item not stocked: $item")
  }
}
