object Solution {
    def climbStairs(n: Int): Int = {
    (2 to n)
    .foldLeft((1, 1)) { case (x,y) => (x._2, x._1 + x._2) }
    ._2
    }
}

object Solution {
    def climbStairs(n: Int): Int = {
(2 to n).foldLeft((1, 1))((tuple, _) => (tuple._2, tuple._1 + tuple._2))._2
    }
}