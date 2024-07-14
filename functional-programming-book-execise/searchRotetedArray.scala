object Solution {
    def search(a: Array[Int], target: Int): Int = {
        def binarySearch(start: Int, end: Int): Int = {
      if (start > end) {
        -1
      } else {
        val mid = (start + end) / 2

        if (a(mid) == target) {
          mid
        } else if (a(mid) >= a(start)) {
          if (target >= a(start) && target <= a(mid)) {
            binarySearch(start, mid - 1)
          } else {
            binarySearch(mid + 1, end)
          }
        } else {
          if (target >= a(mid + 1) && target <= a(end)) {
            binarySearch(mid + 1, end)
          } else {
            binarySearch(start, mid - 1)
          }
        }
      }
    }

        val n = a.length

        if (n == 1) {
          if (target == a(0)) {
            0
          } else {
            -1
          }
        } else {
          binarySearch(0, n - 1)
        }
    }
}