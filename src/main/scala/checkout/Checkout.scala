package checkout

class Checkout {
  def checkout(cart: List[String]): Int = {
    cart match {
      case head :: _ => priceOfItem(head)
      case Nil => 0
    }
  }

  private def priceOfItem(item: String): Int = item match {
    case "apple" => 60
    case "orange" => 25
    case _ => throw new IllegalArgumentException(s"Item not stocked: $item")
  }
}
