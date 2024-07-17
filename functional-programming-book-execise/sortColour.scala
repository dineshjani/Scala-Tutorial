object Solution {
    def sortColors(nums: Array[Int]): List[Int] = {
           def swap(list: List[Int], i: Int, j: Int): List[Int] = {
      list.updated(i, list(j)).updated(j, list(i))
    }

            def sortColorsRec(colors: List[Int], low: Int, mid: Int, high: Int): List[Int] = {
              if (mid > high) colors
              else {
                colors(mid) match {
                  case 0 =>
                    val swapped = swap(colors, low, mid)
                    sortColorsRec(swapped, low + 1, mid + 1, high)
                  case 2 =>
                    val swapped = swap(colors, mid, high)
                    sortColorsRec(swapped, low, mid, high - 1)
                  case 1 =>
                    sortColorsRec(colors, low, mid + 1, high)
                }
              }
            }

          sortColorsRec(nums.toList, 0, 0, nums.length - 1)
    }
}