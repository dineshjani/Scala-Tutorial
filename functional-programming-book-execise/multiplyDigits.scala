object StringMultiplier {

  def multiply(num1: String, num2: String): String = {
    if (num1 == "0" || num2 == "0") return "0"

    def multiplySingleDigit(digit: Char, num: String, zeroPadding: Int): String = {
      val carry = 0
      val digitVal = digit.asDigit

      val result = num.reverse.foldLeft((carry, List.fill(zeroPadding)('0'))) {
        case ((carry, acc), n) =>
          val product = (n.asDigit * digitVal) + carry
          val newCarry = product / 10
          val remainder = product % 10
          (newCarry, remainder.toString.head :: acc)
      }

      (result._1.toString + result._2.mkString).dropWhile(_ == '0')
    }

    def addStrings(num1: String, num2: String): String = {
      val (larger, smaller) = if (num1.length >= num2.length) (num1, num2) else (num2, num1)
      val zeroPadding = larger.length - smaller.length
      val paddedSmaller = List.fill(zeroPadding)('0').mkString + smaller

      val result = larger.reverse.zip(paddedSmaller.reverse).foldLeft((0, List.empty[Char])) {
        case ((carry, acc), (n1, n2)) =>
          val sum = n1.asDigit + n2.asDigit + carry
          val newCarry = sum / 10
          val remainder = sum % 10
          (newCarry, remainder.toString.head :: acc)
      }

      (result._1.toString + result._2.mkString).dropWhile(_ == '0')
    }

    val products = num2.reverse.zipWithIndex.map { case (digit, idx) =>
      multiplySingleDigit(digit, num1, idx)
    }

    products.reduce(addStrings)
  }

  def main(args: Array[String]): Unit = {
    val num1 = "123"
    val num2 = "456"
    val result = multiply(num1, num2)
    println(s"The product of $num1 and $num2 is: $result")
  }
}
