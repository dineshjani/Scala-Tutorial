object Solution {
    def binarySearch(nums: Array[Int], target: Int): Int = {
        def search(low: Int, high: Int): Int = {
            if (low > high) {
                -1 // target not found
            } else {
                val mid = (low + high) / 2
                if (nums(mid) == target) {
                    mid
                } else if (nums(mid) > target) {
                    search(low, mid - 1)
                } else {
                    search(mid + 1, high)
                }
            }
        }
        
        search(0, nums.length - 1)
    }

    def main(args: Array[String]): Unit = {
        val nums = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        val target = 5
        val result = binarySearch(nums, target)
        println(s"Index of target $target: $result")
    }
}
