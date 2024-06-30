object Solution {
    def maxProfit(prices: Array[Int]): Int = {
    def recur(price: List[Int], minVal: Int, maxProfit: Int): Int = {
      price match {
        case Nil => maxProfit
        case head :: tail =>
          if (head > minVal) {
            recur(tail, minVal, Math.max(maxProfit, head - minVal))
          } else {
            recur(tail, head, maxProfit)
          }
      }
    }
    recur(prices.tail.toList, prices.head, 0)
        
    }
}


//2nd approach using foldleft  => logic will think onlt that till that what will be acc and return acc
object Solution {
  def maxProfit(prices: Array[Int]): Int = {
    if (prices.isEmpty) return 0

    // Initialize foldLeft with (minPrice, maxProfit)
    val (_, maxProfit) = prices.tail.foldLeft((prices.head, 0)) {
      case ((minPrice, maxProfit), price) =>
        // Calculate the new minimum price
        val newMinPrice = Math.min(minPrice, price)
        // Calculate the new maximum profit
        val newMaxProfit = Math.max(maxProfit, price - minPrice)
        // Return the updated (minPrice, maxProfit)
        (newMinPrice, newMaxProfit)
    }

    maxProfit
  }

  def main(args: Array[String]): Unit = {
    val prices = Array(7, 1, 5, 3, 6, 4)
    println(maxProfit(prices))  // Output: 5
  }
}
