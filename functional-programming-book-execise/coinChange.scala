object Solution {
  def coinChange(coins: Array[Int], amount: Int): Int = {
    val dp = Array.fill(amount + 1)(Int.MaxValue)
    dp(0) = 0 

    for (coin <- coins) {
      for (j <- coin to amount) {
        if (dp(j - coin) != Int.MaxValue) {
          dp(j) = math.min(dp(j), dp(j - coin) + 1)
        }
      }
    }

    if (dp(amount) == Int.MaxValue) -1 else dp(amount)
  }

  def main(args: Array[String]): Unit = {
    val coins = Array(1, 2, 5)
    val amount = 11
    println(coinChange(coins, amount)) 
  }
}
