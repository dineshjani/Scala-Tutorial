object Solution {
    def addBinary(a: String, b: String): String = {
                def recur(list1: List[Char], list2: List[Char], carry: Int, sum: String): String = {
            (list1, list2) match {
                case (Nil, Nil) if carry == 1 => carry.toString ++ sum
                case (Nil, Nil) => sum
                case (h1 :: t1, Nil) =>
                    val newSum = (h1.asDigit + carry) % 2
                    val newCarry = (h1.asDigit + carry) / 2
                    recur(t1, Nil, newCarry, newSum.toString + sum)
                case (Nil, h2 :: t2) =>
                    val newSum = (h2.asDigit + carry) % 2
                    val newCarry = (h2.asDigit + carry) / 2
                    recur(Nil, t2, newCarry, newSum.toString + sum)
                case (h1 :: t1, h2 :: t2) =>
                    val newSum = (h1.asDigit + h2.asDigit + carry) % 2
                    val newCarry = (h1.asDigit + h2.asDigit + carry) / 2
                    recur(t1, t2, newCarry, newSum.toString + sum)
            }
        }

                 recur(a.toList.reverse, b.toList.reverse, 0, "")
    }
}